package com.example.todonotes.infraestructure.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * Sets of utilities used to manage JWT tokens.
 * 
 * More information see: https://github.com/jwtk/jjwt
 */
@Component
public class JwtTokenUtility implements Serializable {

	public static final long JWT_TOKEN_VALIDITY = 2*60*60;

	/**
	 * Get from the application.properties file the attribute jwt.secret.
	 */
	@Value("${jwt.secret}")
	private String secret;

	/**
	 * Get the Key from the secret key string. 
	 * @return object of Key type with the SecretKey to be used with a Jwt token.
	 */
	private Key getSecretKey() {
		// INFO : To know more see https://github.com/jwtk/jjwt#creating-safe-keys and https://github.com/jwtk/jjwt#secretkey-formats
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
	}
	
	/**
	 * Get the set of claims from a JWT token.
	 * @param token to be processed.
	 * @return Set of claims.
	 */
	private Claims getAllClaimsFromToken(String token) {

		Jws<Claims> jws;
		Key key = getSecretKey();

		jws = Jwts
			.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);	
			
		return jws.getBody();
	}

	/**
	 * Check if the JWT token is expired.
	 * @param token to be checked.
	 * @return true, if the JWT token is expired, otherwise, false is returned.
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * Check for a JWT token if the expiration should be ignored.
	 * @param token to be checked.
	 * @return true, if the expiration should be ignored, otherwise, false is returned.
	 */
	private Boolean ignoreTokenExpiration(String token) {
		return false;
	}

	/**
	 * Build a JWT token from the infomation supplied.
	 * @param claims set of claims for the JWT token.
	 * @param subject for the JWT token.
	 * @return a string with the JWT token generated.
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		Key key = getSecretKey();

		return Jwts
			.builder()
			.setClaims(claims)
			.setSubject(subject)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000))
			.signWith(key)
			.compact();
	}

	/**
	 * Get the userName field from a JWT token.
	 * @param token to be processed.
	 * @return userName.
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Get the IssuedAtDate field from a JWT token.
	 * @param token to be processed.
	 * @return IssuedAtDate.
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	/**
	 * Get the ExpirationDate field from a JWT token.
	 * @param token to be processed.
	 * @return ExpirationDate.
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Generic method for getting a specific field from a JWT token.
	 * @param <T> type of object to be returned.
	 * @param token JWT token to be processed.
	 * @param claimsResolver function to call to get the specific field.
	 * @return data returned from the claimsResolver function.
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Generate a JWT token based on an UserDetails object.
	 * @param userDetails to be processed to generate the JWT token.
	 * @return string JWT token.
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	/**
	 * Check if a JWT token can be refreshed.
	 * @param token to be processed.
	 * @return true, the JWT token can be refreshed, otherwise, false is returned.
	 */
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	/**
	 * Validate if a JWT token is valid.
	 * @param token to be processed.
	 * @param userDetails is the user data used in the validation.
	 * @return true, the JWT token is valid, otherwise, false is returned.
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
