package com.example.demo.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* @Controller: 웹 페이지를 만들어서 화면에 보여주기
* @RestController: 필요한 데이터를 직접 전달하기
* @ResponseBody: 데이터를 돌려주는 역할
*
*
* */



@RestController // controller + responsebody
public class RestControllerTest {

    @GetMapping("/coffee")
    public Coffee rest(){
        //db조회해서 coffee 바인딩해서 보내주기 해야함. collection 묶어서 보냄
        return new Coffee("아메리카노",3000);
    }

}
