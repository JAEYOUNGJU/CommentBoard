package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Long>, JpaSpecificationExecutor<CommentReply>  {
	// selectOne
	List<CommentReply> findOneById(Long id);

	// selectOne
	List<CommentReply> findAllByCommentId(Long id);

}
