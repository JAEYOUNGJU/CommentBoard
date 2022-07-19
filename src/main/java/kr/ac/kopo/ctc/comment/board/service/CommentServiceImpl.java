package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findOneById(int id) {
		// TODO Auto-generated method stub
		return commentRepository.findOneById(id);
	}

	@Override
	public void commentSave(Comment comment) {
		commentRepository.save(comment);
		
	}

}
