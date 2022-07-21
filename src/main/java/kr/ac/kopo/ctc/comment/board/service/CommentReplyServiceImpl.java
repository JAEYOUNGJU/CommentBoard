package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;
import kr.ac.kopo.ctc.comment.board.repository.CommentReplyRepository;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
	@Autowired
	CommentReplyRepository commentReplyRepository;

	public CommentReplyServiceImpl(CommentReplyRepository commentReplyRepository) {
		this.commentReplyRepository = commentReplyRepository;
	}

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
}
