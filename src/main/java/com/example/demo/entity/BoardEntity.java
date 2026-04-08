package com.example.demo.entity;

import com.example.demo.controller.dto.Boarddto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "qwer")
public class BoardEntity extends BoardTimeEntity{
    private static BoardEntity boardEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String boardWriter;
    @Column
    private String boardPass;
    @Column
    private String boardContents;
    @Column
    private String boardTitle;
    @Column
    private int boardHits;

public static BoardEntity toSaveEntity(Boarddto boarddto){
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.boardWriter = boarddto.getBoardWriter();
    boardEntity.boardPass = boarddto.getBoardPass();
    boardEntity.boardTitle = boarddto.getBoardTitle();
    boardEntity.boardContents = boarddto.getBoardContents();
    boardEntity.boardHits = 0;
    return boardEntity;
}
public void update(Boarddto boarddto){
 this.boardTitle = boarddto.getBoardTitle();
 this.boardContents = boarddto.getBoardContents();
}
}
