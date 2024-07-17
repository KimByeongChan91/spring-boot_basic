package com.example.starbucks.token;


import com.example.starbucks.model.UserCustom;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.Keys;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


//token
@Component
public class JwtUtil {

    private  static final String SECRET_KEY = "UmmIsStillAliveUmmIsStillAliveUmmIsStillAlive";
    private  static final SecretKey Key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));  // 문자열을 키타입으로 바꾼다


    //        System.currentTimeMillis() : 지금의 시간을 알려주는 코드

    //token 발급하는 코드
    public static String generateToken(UserCustom userCustom){
        return Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis()))  // 발급시간
                .expiration(new Date(System.currentTimeMillis() + 1000 * 5))  // 발급 기한시간
                .subject(userCustom.getUserId())
                .claim("userId", userCustom.getUserId())
                .signWith(key)
                .compact();
    }

    public static boolean validToken (String token){
        try {
            Jwts
                    .parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public static Claim extractToken(String token){
        return Jwts
                .parser() //해석할게
                .verifyWith(key) //키줄게
                .build() //빌드할게
                .parseSignedClaims(token) //토큰을 줄테니까 claim 해석할게
                .getPayload(); // payload 줄게
    }


}
