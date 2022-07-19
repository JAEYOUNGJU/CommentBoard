package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Integer> {

	List<CommentReply> findById(int id);
}
