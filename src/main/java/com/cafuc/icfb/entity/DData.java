package com.cafuc.icfb.entity;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class DData {
    private int id;
    @NonNull
    private int captureId;
    @NonNull
    private int internalNumber;
    @NonNull
    private String url;
}
