package com.whatever.ofi.requestDto;

import com.whatever.ofi.domain.Board;
import lombok.Getter;

@Getter
public class BoardRequest {
    private Long coordinator_id;
    private String style;
    private int like_count;
    private String season;
    private String situation;
    private String content;
    private String image_url;

    public Board toEntity() {
        return Board.builder()
                .style(style)
                .situation(situation)
                .content(content)
                .image_url(image_url)
                .like_count(like_count)
                .season(season)
                .build();
    }
}
