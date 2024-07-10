package com.example.demo.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// MVC -> 뷰 템플릿을 돌려줌
@Controller
public class BaseController {
    // 변수 + 함수

    @GetMapping("/aaa") //app.get
    @ResponseBody
    public String base() {
        return "안녕하세요 피싱 사이트입니다";
    }

    @GetMapping("/bbb")
    @ResponseBody
    public String base2(){
        return "<h1 style='color:skyblue'>OTT 사이트 입니다.</h1>";
    }

}


