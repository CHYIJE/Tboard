package com.tenco.blog.board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.blog.board.Service.BoardService;
import com.tenco.blog.board.repository.interfaces.Model.Board;

@Controller
public class BoardController {

	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 메인 페이지에서 전체 게시글을 보여주는 메소드
	@GetMapping({ "/main-page", "/index" })
	public String main(Model model) {
		List<Board> boardList = boardService.readAllBoards(); // 전체 게시글 조회
		model.addAttribute("boardList", boardList); // 모델에 게시글 리스트 추가
		return "main"; // 메인 페이지 뷰로 이동
	}


	// 게시글 작성 폼으로 이동하는 메소드
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	// 게시글 저장하는 메소드
	@PostMapping("/board/save")
	public String save(
			@RequestParam("writer") String writer,
			@RequestParam("title") String title,
			@RequestParam("content") String content) {
		boardService.createBoard(writer, title, content); // 게시글 저장
		return "redirect:/index"; // 저장 후 메인 페이지로 리다이렉트
	}
	// 게시글 수정 이동
	@GetMapping("/board/updatefrom/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		Board board = boardService.readBoardById(id); // 게시글 조회
		model.addAttribute("board", board); // 모델에 게시글 추가
		return "board/updateForm"; // 수정 폼으로 이동
	}

	// 게시글 수정하는 메소드
	@PostMapping("/board/updatefrom/{id}")
	public String update(@PathVariable("id") Integer id, 
						@RequestParam("title") String title,
						@RequestParam("content") String content) {
		boardService.updateBoard(id, title, content); // 게시글 수정
		return "redirect:/index"; // 수정 후 메인 페이지로 리다이렉트
	}

	// 게시글 삭제하는 메소드
	@PostMapping("/board/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		boardService.deleteBoard(id); // 게시글 삭제
		return "redirect:/index"; // 삭제 후 메인 페이지로 리다이렉트
	}
}
