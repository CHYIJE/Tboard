package com.tenco.blog.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.blog.board.repository.interfaces.Model.Board;

@Mapper
public interface BoardRepository {
	public int insert(@Param("writer")String writer, @Param("title")String title, @Param("content")String content);

	public int updateBoard(@Param("id")Integer id,@Param("title")String title, @Param("content")String content);

	public int deleteById(Integer id);
	
	public List<Board> findAll();
	
	public Board findById(Integer id);
}
