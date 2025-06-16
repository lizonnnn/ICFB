package com.cafuc.icfb.entity;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    private int id;  //id
    @NonNull
    private String buildName;   //建筑物名
    @NonNull
    private String introduction;   //建筑物介绍
}
