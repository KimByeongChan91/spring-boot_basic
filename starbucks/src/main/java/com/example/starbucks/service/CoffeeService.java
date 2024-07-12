package com.example.starbucks.service;


import com.example.starbucks.model.Coffee;
import com.example.starbucks.status.ResultStatus;

import java.util.List;
import java.util.Optional;

//service = 계약[약속]
public interface CoffeeService {
    List<Coffee> getAllCoffee();
    List<Coffee> getCoffeesByName(String name);

    List<Coffee> getCoffeeByPrice(int min, int max);

    ResultStatus addCoffee(Coffee coffee);

    Optional<Coffee> getCoffeeById(Integer id); // 있을수도 있고 없을수도 있으니 optional씀




}
