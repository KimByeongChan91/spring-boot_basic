package com.example.starbucks.model;

import jakarta.persistence.*;
import lombok.*;

// new Coffee()
@AllArgsConstructor  // new Coffee(id,name,price)
@NoArgsConstructor
@Data
@RequiredArgsConstructor // new Coffee(name,price) by NonNull
@Entity // 디비랑 연결
@Table
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
//    @Column(name = "Name") 컬럼명 연결
    private  String name;
    @NonNull
    private  int price;



}
