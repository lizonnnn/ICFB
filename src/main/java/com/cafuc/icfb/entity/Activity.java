package com.cafuc.icfb.entity;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private int id;
    @NonNull
    private String buildingId;
    @NonNull
    private String AcquisitionName;
    @NonNull
    private String time;
}
