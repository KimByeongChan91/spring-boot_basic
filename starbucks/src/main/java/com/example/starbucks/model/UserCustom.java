package com.example.starbucks.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor  // new Coffee(id,name,price)
@NoArgsConstructor
@Data
@RequiredArgsConstructor // new Coffee(name,price) by NonNull
@Entity // 디비랑 연결
@Table(name = "user")
public class UserCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "user_id")
    private String userId;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "nickname")
    private String nickname;


}
