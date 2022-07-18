package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo.ctc.comment.board.domain.CommentGroup;

public interface CommentGroupRepository extends JpaRepository<CommentGroup, Integer> {

	List<CommentGroup> findById(int id);
}
