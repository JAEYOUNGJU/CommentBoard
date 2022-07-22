package kr.ac.kopo.ctc.comment.board.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;
import kr.ac.kopo.ctc.comment.board.repository.CommentReplyRepository;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	CommentReplyRepository commentReplyRepository;

	@Override
	public List<CommentReply> findAll() {
		return commentReplyRepository.findAll();
	}

	@Override
	public List<CommentReply> findOneById(Long id) {
		return commentReplyRepository.findOneById(id);
	}

	@Override
	public List<CommentReply> showAllByReplyId(Long id) {
		return commentReplyRepository.findAllByCommentId(id);
	}

	@Override
	public void deleteById(Long id) {
		commentReplyRepository.deleteById(id);

	}

	@Override
	public CommentReply save(CommentReply commentReply) {
		Date date = new Date();
		
		commentReply.setDate(date);
		
		return commentReplyRepository.save(commentReply);
	}



}
