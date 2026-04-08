package com.example.demo.controller.dto;

import com.example.demo.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public class Boarddto {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String updatePass;
    private String boardTitle;
    private String boardContents;
    private int  boardHits;
    private String  boardCreatedAt;

    private String dateFormat(LocalDateTime date){
        if(date == null)
            return null;
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static Boarddto toBoardDTO(BoardEntity boardEntity){
        Boarddto boardDTO = new Boarddto();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedAt(boardDTO.dateFormat(boardEntity.getCreatedAt()));
return boardDTO;
    }
}

