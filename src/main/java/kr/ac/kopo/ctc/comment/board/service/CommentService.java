package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;

import kr.ac.kopo.ctc.comment.board.domain.Comment;

public interface CommentService {

	List<Comment> findAll();

	List<Comment> findOneById(Long id);

	List<Comment> searchWriter(String writer);

	List<Comment> conditionKeywordSearch(String condition,String keyword);
}
