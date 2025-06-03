package com.cafuc.dsdr.entity;

import lombok.*;

@Getter
@Setter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private int id;  //id
    @NonNull
    private String username;   //姓名
    @NonNull
    private String password;   //密码
    private String email;

}

