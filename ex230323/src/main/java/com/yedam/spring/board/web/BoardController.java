package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;

	// 전체조회 : URI - getBoardList, RETURN - board/boardList
	@GetMapping("getBoardList")
	//페이지를 반환할 것이기 때문에 String
	public String getBoardList(Model model) {
		//같이 딸려오는 데이터가 없어서 모델만 쓰면 된다. 모델에 데이터를 담아서 전달
		//스프링에서 리퀘스트와 리스폰스릉 묶어준 클래스가 model
		//addAttribute는 모델에 데이터를 보낼 때 사용
		//boardList는 내가 정한 이름
		model.addAttribute("boardList", boardService.getBoardList());
		//views 밑에 board폴더에 boardList.jsp파일로 간다는 의미(new others로 jsp 검색해서 만들기)
		return "board/boardList";
	}	

	// 단건조회 : URI - getBoardInfo, RETURN - board/boardInfo
	@GetMapping("getBoardInfo")
	public String getEmpInfo(BoardVO boardVO, Model model) {
		//전체조회와 달리 조건이 필요하기 때문에 VO객체를 쓰기 위해 BoardVO boardVO를 써야 된다.
		//getBoardInfo가 정보를 조회하는 메소드
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm(Model model) {
		//등록을 누르자마자 글번호가 생기는데 그것을 이용해야 해서 model을 쓴다.
		model.addAttribute("boardInfo", boardService.getBoardNo());
		//model.addAttribute("bno", boardService.getBoardNo().getBno());
		return "board/boardInsert";
	}
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		//컨트롤러 호출할 때 redirect. 경로를 호출하는 것.
		return "redirect:getBoardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate, RETURN - 단건조회 다시 호출
	@PostMapping("boardUpdate")
	public String boardUpdateProcess(BoardVO boardVO) {
		boardService.updateBoardInfo(boardVO);
		return "redirect:getBoardInfo?bno="+boardVO.getBno();
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam int bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:getBoardList";
	}
}
