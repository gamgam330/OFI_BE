package com.whatever.ofi.service;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.domain.BoardImage;
import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.requestDto.BoardImageRequest;
import com.whatever.ofi.requestDto.BoardRequest;
import com.whatever.ofi.repository.BoardImageRepository;
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

    private final BoardImageRepository boardImageRepository;

    private final CoordinatorRepository coordinatorRepository;

    @Transactional
    public void join(BoardRequest dto) {
        Board board = dto.toEntity();
        Coordinator coordinator = coordinatorRepository.findOne(dto.getCoordinator_id());

        coordinator.addBoard(board);
        boardRepository.save(board);
    }

    @Transactional
    public void insertImage(BoardImageRequest dto) {
        Board board = boardRepository.findOne(dto.getBoard_id());

        for(String url : dto.getImage_url()) {
            BoardImage boardImage = new BoardImage(url);
            board.addUrl(boardImage);
            boardImageRepository.save(boardImage);
        }
    }
}
