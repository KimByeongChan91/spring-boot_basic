package com.example.starbucks;

// Rest API 개발
// 클리아인터 -> 서버에 요청
// Controller[경로 지정]
// Repository[DB에서 데이터 가져오는 역할]


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


// <엔터티, 키객체>
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

    List<Coffee> findByName(String name);

    @Query("select c from Coffee c where c.price between :min and :max")
    List<Coffee> findByPrice(@Param("min") int min, @Param("max") int max);

}
