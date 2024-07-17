package com.example.starbucks.controller;

import com.example.starbucks.dto.ApiResponse;
import com.example.starbucks.model.UserCustom;
import com.example.starbucks.repository.UserRepository;
import com.example.starbucks.service.UserDetailServiceImpl;
import com.example.starbucks.service.UserService;
import com.example.starbucks.status.ResponseStatus;
import com.example.starbucks.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    UserRepository userRepository;

    // 패스워드 암호화
    @Autowired
    private PasswordEncoder passwordEncoder;


    // Post 할때는 보통 RequestBody
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> registerUser(@RequestBody UserCustom userCustom) {

        // 비밀번호 암호화 코드
        userCustom.setPassword(passwordEncoder.encode(userCustom.getPassword()));

        // 저장
        userService.saveUser(userCustom);

        ApiResponse apiResponse = new ApiResponse(ResponseStatus.SUCCESS, "성공", null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody UserCustom userCustom) {
        // id와 pw를 체크해주는 security 라이브러리 활용해야함
        try {
            // userDetail에서 제공한 클래스임
            // db에서 쉽게 해당 id 가져오는 역할함
            UserDetails userDetails = userDetailService.loadUserByUsername(userCustom.getUserId());

            // 가져온 id가 null 이거나 post로 보낸 비번이랑 일치하지 않으면 if 실행
            if (userDetails == null || !passwordEncoder.matches(userCustom.getPassword(), userDetails.getPassword())) {
                throw new BadCredentialsException("그런 아이디 없거나 비번이 이상함");
            }




            //성공
            // 토큰 발급
            String token = JwtUtil.generateToken(userCustom);

            // response header
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "bearer" + token); // 헤더에 토큰을 같이 넣어 보냄

            // response body
            ApiResponse apiResponse = new ApiResponse(ResponseStatus.SUCCESS, "로그인 성공했음", null);
            return ResponseEntity.ok().headers(httpHeaders).body(apiResponse);

        } catch (UsernameNotFoundException | BadCredentialsException e) {
            System.out.println("그런 아이디 없음");

            ApiResponse apiResponse = new ApiResponse(ResponseStatus.UNAUTHORIZED, "로그인 실패함", null);
            return ResponseEntity.ok(apiResponse);
        }
    }


}
