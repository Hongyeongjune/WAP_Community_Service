package com.example.demo.modules.security;

import com.example.demo.commons.enums.MemberRole;
import com.example.demo.commons.errors.ErrorCode;
import com.example.demo.commons.errors.exception.InvalidJwtAuthenticationException;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class JwtTokenProvider {

    private final String secretKey;

    public JwtTokenProvider(String secretKey) {
        this.secretKey = encodeSecretKey(secretKey);
    }

    /**
     * secretKey 를 Base64로 인코딩 하는 작업
     */
    private String encodeSecretKey(String secretKey) {
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, Set<MemberRole> roles) {

        /**
         * claims : JWT payload 에 저장되는 정보단위
         * Subject : Token 제목
         * IssuedAt : Token 발급 시간
         * Expiration : Token 만료 시간
         * signWith : 사용할 암호화 알고리즘과 서명에 들어갈 secretKey 값 세팅
         */
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.UTC)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

    }

    /**
     * JWT 토큰에서 인증 정보 조회
     * UserDetailsService의 loadUserByUsername을 사용하지 않은 이유는 매번 DB조회를 하지 않게 하기 위함.
     * UserDetails를 사용하기 위해 password를 설정해주었다.
     */
    public Authentication getAuthentication(String token) {

        UserDetails userDetails = User.builder()
                .username(getUsername(token))
                .password("")
                .authorities(getUserRoles(token))
                .build();

        return new UsernamePasswordAuthenticationToken(userDetails, "", getUserRoles(token));
    }

    /**
     * 사용자 아이디
     */
    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * 사용자 역할
     */
    public Collection<SimpleGrantedAuthority> getUserRoles(String token) {
        List list = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .get("roles", List.class);

        Collection<SimpleGrantedAuthority> roles = new HashSet<>();
        for (Object o : list) {
            roles.add(new SimpleGrantedAuthority("ROLE_" + o));
        }

        return roles;
    }

    public boolean hasRole(String token, MemberRole role) {
        List list = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .get("roles", List.class);

        for (Object o : list) {
            if(o.toString().equals(role.name()))
                return true;
        }
        return false;
    }

    public Optional<String> resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return Optional.of(bearerToken.substring(7));
        }

        return Optional.empty();
    }

    public String resolveToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }

        return "";
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException e) {
            throw new InvalidJwtAuthenticationException(ErrorCode.EXPIRED_TOKEN);
        } catch (IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException(ErrorCode.INVALID_TOKEN);
        }
    }
}
