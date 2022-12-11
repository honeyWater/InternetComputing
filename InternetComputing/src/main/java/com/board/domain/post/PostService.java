package com.board.domain.post;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.board.common.dto.SearchDto;
import com.board.paging.Pagination;
import com.board.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostMapper postMapper;

	/**
	 * 게시글 저장
	 * 
	 * @param params - 게시글 정보
	 * @return Generated PK
	 */
	@Transactional
	public Long savePost(final PostRequest params) throws Exception {
		postMapper.save(params);
		return params.getId();
	}

	/**
	 * 게시글 상세정보 조회
	 * 
	 * @param id - PK
	 * @return 게시글 상세 정보
	 */
	public PostResponse findPostById(final Long id) throws Exception {
		return postMapper.findById(id);
	}

	/**
	 * 게시글 수정
	 * 
	 * @param params - 게시글 정보
	 * @return PK
	 */
	@Transactional
	public Long updatePost(final PostRequest params) throws Exception {
		postMapper.update(params);
		return params.getId();
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param id - PK
	 * @return PK
	 */
	public Long deletePost(final Long id) throws Exception {
		postMapper.deleteById(id);
		return id;
	}

	/**
	 * 게시글 리스트 조회
	 * 
	 * @param params - search conditions
	 * @return list & pagination information
	 */
	public PagingResponse<PostResponse> findAllPost(final SearchDto params) throws Exception {

		int count = postMapper.count(params);
		if (count < 1) {
			return new PagingResponse<>(Collections.emptyList(), null);
		}

		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);

		List<PostResponse> list = postMapper.findAll(params);
		return new PagingResponse<>(list, pagination);
	}

}
