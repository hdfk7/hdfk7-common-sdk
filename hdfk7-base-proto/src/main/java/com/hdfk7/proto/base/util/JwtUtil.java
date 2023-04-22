package com.hdfk7.proto.base.util;

import com.fasterxml.jackson.core.type.TypeReference;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Map;

public class JwtUtil {
    private final static String SECRET = "hm_fs439fdsfalfs$^&";

    public static String generateToken(Object obj) {
        Map<String, Object> map = JsonUtil.toObject(obj, new TypeReference<Map<String, Object>>() {
        });
        if (map == null) return null;
        return generateToken(map);
    }

    public static String generateToken(Map<String, Object> m) {
        m.put("timestamp", System.currentTimeMillis());
        JwtBuilder jwtBuilder = Jwts.builder()
                .addClaims(m)
                .signWith(SignatureAlgorithm.HS256, generalKey())
                .setExpiration(null);
        return jwtBuilder.compact();
    }

    private static SecretKey generalKey() {
        byte[] encodeKey = Base64.getMimeDecoder().decode(SECRET);
        return new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
    }

    public static Claims validateJWT(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(jwtToken).getBody();
    }

    public static <T> T get(String jwtToken, String key, Class<T> c) {
        Claims claims = validateJWT(jwtToken);
        return claims.get(key, c);
    }
}
