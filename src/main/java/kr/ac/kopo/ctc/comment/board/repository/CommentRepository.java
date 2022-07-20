package kr.ac.kopo.ctc.comment.board.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.comment.board.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
	// selectOne
	List<Comment> findOneById(Long id); // id 반환

	// insert , update -> save로 처리! (JpaSpecificationExecutor가 처리하기 때문에 코드 추가할 필요 없음)

}