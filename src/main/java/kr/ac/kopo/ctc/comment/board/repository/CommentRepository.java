package kr.ac.kopo.ctc.comment.board.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.comment.board.domain.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
	// selectOne
	Optional<Comment> findOneById(int id); // id 반환

	// selectAll
	List<Comment> findAll();

	// search
	List<Comment> findByTitle(String title);

	// page
	Optional<Comment> findById(int id);

	// search + page
	List<Comment> findByTitle(String title, PageRequest pageRequest);

	// delete
	@Transactional // 모든 작업들이 성공적으로 완료되어야 작업 묶음의 결과를 적용하고, 어떤 작업에서 오류 발생했을 시 이전의 작업들이 성공적이더라도
	// 없었던 일처럼 되돌아가는것 -> 모든 작업들이 성공해야만 최종적으로 데이터베이스에 반영하도록 함
	void deleteById(Integer id);

	void findByTitleContaining(String string, PageRequest pageRequest);
}
