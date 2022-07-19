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

public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment>{
	// selectOne
	List<Comment> findOneById(int id); // id 반환

	//insert ㅓㅂ데이트 - save로 처리! 땅땅! 안짜도 됨
	
	
	
	
}