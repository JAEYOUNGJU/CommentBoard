package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
	//JpaRepository에서 메서드명의 By 이후는 SQL의 where 조건 절에 대응됨
	
	// selectOne
	List<Comment> findOneById(Long id); // id 반환

	// insert , update -> save로 처리! (JpaSpecificationExecutor가 처리하기 때문에 코드 추가할 필요 없음)
	
	//search
	//By 이후에 Containing을 붙이면 Like 검색이 가능함. 즉, %{title}%이 가능함
	List<Comment> findByTitleContaining(String title);
	
	List<Comment> findByWriterContaining(String writer);
	
	
	//page
	Page<Comment> findAll(Pageable pageable);

	//page 출력하기
	Page<Comment> findByIdGreaterThanOrderByIdDesc(Long minId, Pageable pageableCondition);
	
}