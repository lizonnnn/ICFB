package com.cafuc.icfb.entity;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;  //id
    @NonNull
    private String username;   //姓名
    @NonNull
    private String password;   //密码
    @NonNull
    private String email;

}

