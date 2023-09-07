package com.whatever.ofi.service;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.domain.BoardImage;
import com.whatever.ofi.dto.BoardImageRequest;
import com.whatever.ofi.dto.BoardRequest;
import com.whatever.ofi.repository.BoardRepository;
import com.whatever.ofi.repository.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    private final CoordinatorRepository coordinatorRepository;

    @Transactional
    public void join(BoardRequest dto) {
        Board board = dto.toEntity();
        board.setCoordinator(coordinatorRepository.findOne(dto.getCoordinator_id()));
        boardRepository.save(board);
    }

    public void insertImage(BoardImageRequest dto) {
        Board board = boardRepository.findOne(dto.getBoard_id());

        for(String url : dto.getImage_url()) {
        }
    }
}
