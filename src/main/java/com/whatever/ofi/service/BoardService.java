package com.whatever.ofi.service;

import com.whatever.ofi.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    @Transactional
    public void join(Board board) {

    }
}
