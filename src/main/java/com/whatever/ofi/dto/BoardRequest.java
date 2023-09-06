package com.whatever.ofi.dto;

import lombok.Getter;

@Getter
public class BoardRequest {
    private String style;
    private int like_count;
    private String season;
    private String situation;
    private String content;
    private String image_url;
}
