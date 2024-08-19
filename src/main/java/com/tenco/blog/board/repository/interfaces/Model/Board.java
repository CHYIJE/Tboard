package com.tenco.blog.board.repository.interfaces.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Board {
	
	private int id;
	private String title;
	private String content;
	private String writer;
	private Timestamp createdAt;
}
