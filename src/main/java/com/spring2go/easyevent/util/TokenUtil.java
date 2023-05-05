package com.spring2go.easyevent.util;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-03 9:26 AM
 * @desc:
 * @modifier:
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenUtil {

  static long MILLI_SECONDS_IN_HOUR = 1 * 60 * 60 * 1000;
  static String ISSUER = dotenv.get("ISSUER");
  static String USER_ID = "userId";
  static String KEY = dotenv.get("KEY");
  static Algorithm algorithm = Algorithm.HMAC256(KEY);

  public static String signToken(Integer userId, int expirationInHour) {
    Dotenv dotenv = Dotenv.configure().load();

    String token = JWT.create()
            .withIssuer(ISSUER)
            .withClaim("userId", userId)
            .withExpiresAt(new Date(System.currentTimeMillis() + expirationInHour * MILLI_SECONDS_IN_HOUR ))
            .sign(algorithm);
    return token;
  }

  public static Integer verifyToken(String token) {
    JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer(ISSUER)
            .build();
    DecodedJWT jwt = verifier.verify(token);
    Integer userId = jwt.getClaim(USER_ID).asInt();
    return userId;
  }

}
