package com.yedam.spring.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper	boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getBoardNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardInfo(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
