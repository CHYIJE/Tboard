package com.tenco.blog.board.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.blog.board.repository.interfaces.BoardRepository;
import com.tenco.blog.board.repository.interfaces.Model.Board;

import jakarta.transaction.Transactional;

@Service
public class BoardService {
	private final BoardRepository boardRepository;

	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	/**
	 * 게시글 생성
	 * 
	 * @param dto
	 */
	@Transactional
	public void createBoard(String writer, String title,String content) {
		try {
			boardRepository.insert(writer, title, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 게시글 수정
	 * @param dto
	 * @return
	 */
	@Transactional
	public void updateBoard(Integer id, String title, String content) {
		try {
			boardRepository.updateBoard(id, title, content);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 수정 중 오류 발생", e);
		}
	}
	
	/**
	 * 게시글 삭제
	 * @param id
	 * @return
	 */
	@Transactional
	public void deleteBoard(Integer id) {
		
		try {
			boardRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 게시글 전체
	 * @return
	 */
	public List<Board> readAllBoards() {
		List<Board> boardListEntity = null;
		try {
			boardListEntity = boardRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardListEntity;
	}
	
	/**
	 * 아이디 기준 조회
	 * @param id
	 * @return
	 */
	public Board readBoardById(Integer id) {
        try {
            return boardRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 조회 중 오류 발생", e);
        }
    }

}
