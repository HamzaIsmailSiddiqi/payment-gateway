package com.zap.wallet.token.service.util;

import com.zap.wallet.token.service.encryption.RSAEncryptionUtil;
import com.zap.wallet.token.service.exception.JwtTokenIncorrectStructureException;
import com.zap.wallet.token.service.exception.JwtTokenMalformedException;
import com.zap.wallet.token.service.config.JwtConfig;
import com.zap.wallet.token.service.exception.JwtTokenMissingException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

	private final JwtConfig config;

	public JwtTokenUtil(JwtConfig config) {
		this.config = config;
	}

	public String generateToken(String id) {
		Claims claims = Jwts.claims().setSubject(id);
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + config.getValidity() * 1000 * 60;
		Date exp = new Date(expMillis);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, config.getSecret()).compact();
	}

	public void validateToken(final String header, final String tokenType) throws Exception, JwtTokenMalformedException, JwtTokenMissingException {
		try {
			String[] parts = header.split(" ");
			if (parts.length != 2 || !"Bearer".equals(parts[0])) {
				throw new JwtTokenIncorrectStructureException("Incorrect Authentication Structure");
			}
			String token = RSAEncryptionUtil.decrypt(parts[1], tokenType);
			Jwts.parser().setSigningKey(config.getSecret()).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException("JWT claims string is empty.");
		}
	}
}
