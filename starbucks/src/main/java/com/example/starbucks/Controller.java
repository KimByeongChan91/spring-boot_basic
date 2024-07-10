package com.example.starbucks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// http: request & response
// request: 메소드[get/post/put/delete/...]

// controller[경로 잡아주기]
// repository[데이터 가져오기]

@RestController
public class Controller {
    @Autowired
    private CoffeeRepository coffeeRepository;


    @GetMapping("/all")
    public List<Coffee> makeCoffee(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/coffee")
    public List<Coffee> getCoffee(@RequestParam String name){
        System.out.println(name);
         return coffeeRepository.findByName(name);
    }

    @GetMapping("/coffeePrice")
    public List<Coffee> getCoffeeByPrice(@RequestParam int min, @RequestParam int max){
        return coffeeRepository.findByPrice(min, max);
    }





    @GetMapping("/Coffee") //app.get
    public String base() {
        return "커피사이트 입니다";
    }

//    @GetMapping("/latte") //app.get
//    public String addLatte(){
//        coffeeRepository.save(new Coffee("아메리카노",2000));
//        return "성공";
//
//    }
//
//    @GetMapping("/milk")
//    public String AddCoffee1(){
//        coffeeRepository.save(new Coffee("커피우유", 3500));
//            return "커피우유 추가 성공!";
//
//    }
//
//    @PostMapping("/add")
//    public String addCoffee(@RequestBody Coffee coffee){
//        System.out.println(coffee);
//        coffeeRepository.save(coffee);
//        return "성고옹";
//    }


}


