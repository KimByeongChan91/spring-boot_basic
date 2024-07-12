package com.example.starbucks.service;

import com.example.starbucks.model.Coffee;
import com.example.starbucks.repository.CoffeeRepository;
import com.example.starbucks.status.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }



    @Override
    public List<Coffee> getCoffeesByName(String name) {
        return  coffeeRepository.findByName(name);
    }

    @Override
    public List<Coffee> getCoffeeByPrice(int min, int max) {
        return coffeeRepository.findByPrice(min, max);
    }

    @Override
    public ResultStatus addCoffee(Coffee coffee) {
       if(coffee.getName() == null || coffee.getName().isEmpty()){
           return ResultStatus.FAIL;
       }
       if(coffee.getPrice() < 0){
           return ResultStatus.FAIL;
       }
       coffeeRepository.save(coffee);
           return ResultStatus.SUCCESS;


    }

    @Override
    public Optional<Coffee> getCoffeeById(Integer id) {
        return coffeeRepository.findById(id);

//        Optional<Coffee> coffee = coffeeRepository.findById(id);
//        return coffee;
//        위 return 코드와 같음


    }
}
