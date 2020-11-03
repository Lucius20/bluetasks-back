package pierobon.paiva.lucilio.bluetasks.infrastructure.web.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class SecurityConstants {
	
	public static final long EXPIRATION_TIME = 86400000;
	
	public static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	public static final String TOKEN_PREFIX = "Bearer ";

}
