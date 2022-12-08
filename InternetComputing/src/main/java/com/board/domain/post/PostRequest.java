package com.board.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

	private Long id;			// PK
	private String title;		// 게시글 제목
	private String content;		// 게시글 내용
	private String writer;		// 작성자
	private Boolean notice_yn;	// 공지글 여부
}
