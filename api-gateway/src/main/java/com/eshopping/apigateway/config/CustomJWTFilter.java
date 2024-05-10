package com.eshopping.apigateway.config;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
@Slf4j
public class CustomJWTFilter extends AbstractGatewayFilterFactory<CustomJWTFilter.Config> {

    private final static String ENC_KEY = "59be370adb2961ab4f0a4c71d622df9fd3750a897fb6aba4e8d7e883abcc0f0d";

    private final List<String> unsecuredurl  = List.of("/auth/**");

    public CustomJWTFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            log.info("Gateway filter called ");
            if (unsecuredurl.stream().noneMatch(s -> s.equals(exchange.getRequest()))) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {

                   boolean isValid  = isTokenValid(authHeader);

                   if(!isValid) {
                       throw  new Exception("Un authorize access");
                   }

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }


    public static class Config {

    }

    public boolean isTokenValid(String token) {
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public <T> T getClaim(String token , Function<Claims, T> extract){
        Claims claims = extractAllClaims(token);
        return extract.apply(claims);
    }

    public Claims extractAllClaims(String token) {

        SecretKey secretKey = Keys.hmacShaKeyFor(ENC_KEY.getBytes());

        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();


    }
}
