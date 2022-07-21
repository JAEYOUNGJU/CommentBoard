package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;


import kr.ac.kopo.ctc.comment.board.domain.CommentReply;



public interface CommentReplyService {
	List<CommentReply> findAll();

	List<CommentReply> findOneById(Long id);

	List<CommentReply> showAllByReplyId(Long id);
	
   //delete reply2
   void deleteById(Long id);
	   
}
