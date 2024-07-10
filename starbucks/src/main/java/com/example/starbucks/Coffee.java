package com.example.starbucks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

// new Coffee()
@AllArgsConstructor  // new Coffee(id,name,price)
@NoArgsConstructor
@Data
@RequiredArgsConstructor // new Coffee(name,price) by NonNull
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private  String name;
    @NonNull
    private  int price;



}
