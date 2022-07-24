package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;



public interface CommentReplyService {

	List<CommentReply> findAll();

	List<CommentReply> findOneById(Long id);

	List<CommentReply> showAllByReplyId(Long id);
	
	CommentReply save(CommentReply commentReply);

   //댓글 삭제
   void deleteById(Long id);

void updateReply(CommentReply commentReply);
	   
}
