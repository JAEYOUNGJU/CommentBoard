package kr.ac.kopo.ctc.comment.board.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import kr.ac.kopo.ctc.comment.board.domain.Comment;

public interface CommentService {

	List<Comment> findAll();

	List<Comment> findOneById(Long id);

	List<Comment> searchWriter(String writer);

	List<Comment> conditionKeywordSearch(String condition,String keyword);
	
	//page
	//cPage : 현재페이지, countPerPage : 한 페이지당 출력할 데이터 개수, pageSize : 노출되는 페이지 번호 개수 

	   Pagination makePagination(int cPage, int countPerPage, int pageSize, int totalCount);
	   
	   List<Comment> findByIdGreaterThanOrderByIdDesc(int cPage);
}
