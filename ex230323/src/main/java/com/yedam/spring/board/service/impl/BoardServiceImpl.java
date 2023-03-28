package com.yedam.spring.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper	boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		//전체조회
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		//단건조회
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public BoardVO getBoardNo() {
		// 등록하고자 하는 글번호
		return boardMapper.getBoardNo();
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		// 등록
		int result = boardMapper.insertBoard(boardVO);

		if (result == 1) {
			return boardVO.getBno();
		} else {
			return 0;
		}
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		// 수정
		int result = boardMapper.updateBoard(boardVO);

		if (result == 1) {
			return boardVO.getBno();
		} else {
			return 0;
		}
	}

	@Override
	public int deleteBoardInfo(int boardNo) {
		// 삭제
		int result = boardMapper.deleteBoard(boardNo);

		if (result == 1) {
			return boardNo;
		} else {
			return 0;
		}
	}

}

