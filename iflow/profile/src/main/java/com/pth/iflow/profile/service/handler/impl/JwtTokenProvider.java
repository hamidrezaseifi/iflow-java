package com.pth.iflow.profile.service.handler.impl;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.pth.iflow.common.moduls.security.IJwtTokenProvider;
import com.pth.iflow.common.moduls.security.InvalidJwtAuthenticationException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider implements IJwtTokenProvider {

  @Value("${jwt.token.secretKey}")
  private String secretKey;

  // validity in milliseconds
  @Value("${jwt.token.validityInMs}")
  private long validityInMs; // 1h

  @Autowired
  PasswordEncoder passwordEncoder;

  private String secretKeyEncoded;

  @PostConstruct
  protected void init() {

    this.secretKeyEncoded = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
  }

  /*
   * (non-Javadoc)
   *
   * @see moduls.security.IJwtTokenProvider#createToken(java.lang.String, java.util.Set)
   */
  @Override
  public String createToken(final String username, final Set<Integer> roles) {

    final Claims claims = Jwts.claims().setSubject(username);
    claims.put("roles", roles);

    final Date now = new Date();
    final Date validity = new Date(now.getTime() + this.validityInMs);

    return Jwts
        .builder()//
        .setClaims(claims)//
        .setIssuedAt(now)//
        .setExpiration(validity)//
        .setIssuedAt(new Date(now.getTime()))
        .signWith(SignatureAlgorithm.HS256, this.secretKeyEncoded)//
        .compact();
  }

  /*
   * (non-Javadoc)
   *
   * @see moduls.security.IJwtTokenProvider#getAuthentication(java.lang.String)
   */
  @Override
  public UsernamePasswordAuthenticationToken getAuthentication(final String token) {

    final String userName = this.getUsername(token);
    final List<String> roles = this.getRoles(token);
    final String[] roleArr = new String[roles.size()];
    roles.toArray(roleArr);

    UserBuilder builder = null;

    builder = org.springframework.security.core.userdetails.User.withUsername(userName);
    builder.password(userName);
    builder.roles(roleArr);

    final UserDetails userDetails = builder.build();

    final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
        "");
    usernamePasswordAuthenticationToken.setDetails(token);

    return usernamePasswordAuthenticationToken;
  }

  /*
   * (non-Javadoc)
   *
   * @see moduls.security.IJwtTokenProvider#getUsername(java.lang.String)
   */
  @Override
  public String getUsername(final String token) {

    return Jwts.parser().setSigningKey(this.secretKeyEncoded).parseClaimsJws(token).getBody().getSubject();
  }

  @SuppressWarnings("unchecked")
  public List<String> getRoles(final String token) {

    final Object oRoles = Jwts.parser().setSigningKey(this.secretKeyEncoded).parseClaimsJws(token).getBody().get("roles");
    return (List<String>) oRoles;
  }

  public String resolveToken(final HttpServletRequest req) {

    final String bearerToken = req.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }

  @Override
  public boolean validateToken(final String token) {

    try {
      final Jws<Claims> claims = Jwts.parser().setSigningKey(this.secretKeyEncoded).parseClaimsJws(token);

      if (claims.getBody().getExpiration().before(new Date())) {
        return false;
      }

      return true;
    }
    catch (JwtException | IllegalArgumentException e) {
      throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see moduls.security.IJwtTokenProvider#getTokenExpireDate(java.lang.String)
   */
  @Override
  public Date getTokenExpireDate(final String token) {

    return Jwts.parser().setSigningKey(this.secretKeyEncoded).parseClaimsJws(token).getBody().getExpiration();
  }

  /*
   * (non-Javadoc)
   *
   * @see moduls.security.IJwtTokenProvider#getTokenIssuedDate(java.lang.String)
   */
  @Override
  public Date getTokenIssuedDate(final String token) {

    return Jwts.parser().setSigningKey(this.secretKeyEncoded).parseClaimsJws(token).getBody().getIssuedAt();
  }

  public String getSecretKey() {

    return this.secretKey;
  }

  public void setSecretKey(final String secretKey) {

    this.secretKey = secretKey;
  }

  public long getValidityInMs() {

    return this.validityInMs;
  }

  public void setValidityInMs(final long validityInMs) {

    this.validityInMs = validityInMs;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

}
