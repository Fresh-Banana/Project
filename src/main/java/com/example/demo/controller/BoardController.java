package com.example.demo.controller;

import com.example.demo.controller.dto.Boarddto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(Boarddto boarddto) {
        System.out.println(boarddto);

        boardService.save(boarddto);

        return "redirect:/board/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<Boarddto> boarddtoList = boardService.findAll();
        model.addAttribute("boardList", boarddtoList);
        return "List";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id,Model model) {
        boardService.updateHits(id);
        Boarddto boarddto = boardService.findById(id);
    model.addAttribute("board",boarddto);
    return "detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id ,Model model){
    Boarddto boarddto = boardService.findById(id);
    model.addAttribute("board",boarddto);
    return "update";
    }
    @PostMapping("/update")
    public String update(Boarddto boarddto, RedirectAttributes redirectAttributes){
        try{
            boardService.update(boarddto);
            return "redirect:/board/"+boarddto.getId();

        }catch (IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
            return "redirect:/board/update"+boarddto.getId();
        }
    }
}