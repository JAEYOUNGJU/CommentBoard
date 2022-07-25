package kr.ac.kopo.ctc.comment.board.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;

//CommentService에 작성한 메서드를 구현하기 위해 CommentServiceImpl 클래스 생성

@Service
public class CommentServiceImpl implements CommentService { // 해당 클래스가 CommentService 인터페이스를 구현한다는 의미
	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findOneById(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.findOneById(id);
	}

	// Repository에서 검색결과를 받아 비즈니스 로직을 실행하는 메서드
	@Transactional
	public List<Comment> searchTitle(String title) {
		List<Comment> postList = commentRepository.findByTitleContaining(title);

		return postList;
	}

	@Transactional
	public List<Comment> searchWriter(String writer) {
		List<Comment> postList = commentRepository.findByWriterContaining(writer);
		return postList;
	}

	@Override
	public List<Comment> conditionKeywordSearch(String condition, String keyword) {
		List<Comment> searchList;
		if(condition.equals("writer")) {
			System.out.println(condition);
			searchList = searchWriter(keyword); //writer
		} else {
			searchList = searchTitle(keyword);
		}
		
		return searchList;
	}
	
	@Override
	   public Pagination makePagination(int cPage, int countPerPage, int pageSize, int totalCount) {
	      Pagination pagination = new Pagination(); 

		
	      // 총페이지 계산
	      int totalPage = (int) Math.ceil(totalCount / (double) countPerPage);
	      if (totalPage != Math.ceil(totalCount / (double) countPerPage)) {
	         totalPage++;
	      }
	      
	      // 현재페이지에 불가능한 값을 넣었을 경우 처리
	      if (cPage > totalPage) {
	         cPage = totalPage;
	      }
	      if (cPage < 1) {
	         cPage = 1;
	      }
	      
	      //페이지 묶음의 시작과 끝 페이지
	      int startPage;
	      
	      if (cPage % pageSize == 0) {
	         startPage = ((cPage - 1) / pageSize) * pageSize + 1;
	      } else {
	         startPage = (cPage / pageSize) * pageSize + 1;
	      }
	      int lastPage = startPage + pageSize - 1;
	      
	      
	      // 만약 끝 값이 총 페이지보다 크다면 총페이지만 나오도록
	      
	      if (lastPage > totalPage) {
	         lastPage = totalPage;
	      }
	      
	      // 이전 페이지열 계산
	      int pPage;
	      if (startPage == 1) {
	         pPage = 1;
	      } else {
	         pPage = startPage - 1;
	      }
	      
	      
	      // 다음 페이지열 계산
	      int nPage;
	      if (lastPage == totalPage) {
	         nPage = totalPage;
	      } else {
	         nPage = lastPage + 1;
	      }
	      
	      //ppPage : 제일 처음 페이지 
	      int ppPage = 1;
	      
	      //nnPage : 제일 마지막 페이지
	      int nnPage = (int)Math.ceil((double)totalCount / pageSize);

		
	      pagination.setPpPage(ppPage-1);
	      pagination.setpPage(pPage-1);
	      pagination.setnPage(nPage-1);
	      pagination.setNnPage(nnPage-1);
	      pagination.setcPage(cPage);
	      pagination.setStartPage(startPage);
	      pagination.setLastPage(lastPage);
	      pagination.setTotalPage(totalPage);
	      pagination.setcPage(cPage);
	      pagination.setCountPerpage(countPerPage);
	      pagination.setTotalCount(totalCount);
	      pagination.setPageSize(pageSize);

		
		return pagination;
	
	}
	
	  @Override
	   public List<Comment> findByIdGreaterThanOrderByIdDesc(int cPage) {
	      final Long minId = 0L;
	      final int countPerPage = 10;
	      
	      //첫 페이지, 기준 id
	      Pageable pageableCondition = PageRequest.of(cPage, countPerPage);
	      
	      
	      //Pagination pageCondition = makePagination()
	      List<Comment> commentPage = commentRepository.findByIdGreaterThanOrderByIdDesc(minId, pageableCondition).toList();
	      
	      return commentPage;
	   }

	public long getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}