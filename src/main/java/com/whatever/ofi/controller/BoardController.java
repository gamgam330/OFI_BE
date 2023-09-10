package com.whatever.ofi.controller;

import com.whatever.ofi.dto.BoardImageRequest;
import com.whatever.ofi.dto.BoardRequest;
import com.whatever.ofi.repository.BoardRepository;
import com.whatever.ofi.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public String createBoard(@RequestBody BoardRequest dto) {
        boardService.join(dto);
        return "success";
    }

    @PostMapping("/image")
    public String addImage(@RequestBody BoardImageRequest dto) {
        boardService.insertImage(dto);
        return "success";
    }
}
