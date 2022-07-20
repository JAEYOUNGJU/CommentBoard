package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.domain.CommentReply;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Long> {
	// selectOne
	List<CommentReply> findOneById(Long id); // id 반환
	
//	Optional<CommentReply> findById(Long id);
}
