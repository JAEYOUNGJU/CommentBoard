package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;

//CommentService에 작성한 메서드를 구현하기 위해 CommentServiceImpl 클래스 생성

@Service
public class CommentServiceImpl implements CommentService { // 해당 클래스가 CommentService 인터페이스를 구현한다는 의미
	@Autowired
	CommentRepository commentRepository;

	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findOneById(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.findOneById(id);
	}

}
