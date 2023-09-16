package com.whatever.ofi.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Getter
@Setter
public class UserMainPageRes {

    private String nickname; // profile

    private String profile_image; // profile

    private String board_image; // board

    private int total_like; // profile

    private int request_count; // profile

//    private List<String> styles; // coordinator_style
//
//    public void setStyles(List<String> styles) {
//        this.styles = styles;
//    }
}
