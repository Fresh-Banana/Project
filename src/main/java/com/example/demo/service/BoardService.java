package com.example.demo.service;

import com.example.demo.controller.Repository.BoardRepository;
import com.example.demo.controller.dto.Boarddto;
import com.example.demo.entity.BoardEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Boarddto boarddto) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boarddto);
        boardRepository.save(boardEntity);
    }

    public List<Boarddto> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<Boarddto> boarddtoList = new ArrayList<>();
        for (BoardEntity boardEntity : boardEntityList) {
            boarddtoList.add(Boarddto.toBoardDTO(boardEntity));


        }
        return boarddtoList;
    }
    @Transactional
    public void updateHits(Long id){
        boardRepository.updateHits(id);
    }
    public Boarddto findById(Long id){
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
    if(optionalBoardEntity.isPresent()) {
        BoardEntity boardEntity = optionalBoardEntity.get();
        return Boarddto.toBoardDTO(boardEntity);
    }
    else{
        return null;
    }

    }
public void delete(Long id){
        boardRepository.deleteById(id);
}
@Transactional
public void update(Boarddto boarddto){
        BoardEntity boardEntity = boardRepository.findById(boarddto.getId()).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글을 찾을 수 없습니다"));
        if(boardEntity.getBoardPass().equals(boarddto.getBoardPass())){
            boardEntity.update(boarddto);
        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다/");

        }
}
    }

