package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Long> {

	Optional<CommentReply> findById(Long id);
}
