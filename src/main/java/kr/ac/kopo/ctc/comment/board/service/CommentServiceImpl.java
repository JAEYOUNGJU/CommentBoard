package kr.ac.kopo.ctc.comment.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	//검색
	// Repository에서 검색결과를 받아 비즈니스 로직을 실행하는 메서드
	@Transactional
	public List<Comment> searchTitle(String titleKeyword) {
		final int countPerPage = 10;

		// (첫 페이지, 몇개 보여줄건지)
		Pageable pageableCondition = PageRequest.of(0, countPerPage);
		
		List<Comment> postList = commentRepository.findByTitleContaining(titleKeyword, pageableCondition);
		return postList;
	}

	@Transactional
	public List<Comment> searchWriter(String writerKeyword) {
		final int countPerPage = 10;

		// (첫 페이지, 몇개 보여줄건지)
		Pageable pageableCondition = PageRequest.of(0, countPerPage);
		
		List<Comment> postList = commentRepository.findByWriterContaining(writerKeyword, pageableCondition);
		return postList;
	}

	@Override
	public List<Comment> conditionKeywordSearch(String condition, String keyword) {

		List<Comment> searchList;
		
		if (condition.equals("writer")) {
			searchList = searchWriter(keyword); // writer
		} else {
			searchList = searchTitle(keyword);
		}

		return searchList;
	}


	      @Override
	      public Pagination makePagination(int cPage, String keyWord) {
	         Pagination pagination = new Pagination(); 
	         final int countPerPage = 10;
	         final int pageSize = 10;
	         int totalCount = 0;
	         
	         if(keyWord == null) { //검색어가 없을 때
	            totalCount = (int) commentRepository.count();
	         } else {   //검색어가 있을 때
	            totalCount = (int) commentRepository.countByTitleContaining(keyWord);
	            cPage++;
	         }
	      
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
	      List<Comment> commentsPage = commentRepository.findByIdGreaterThanOrderByIdDesc(minId, pageableCondition).toList();
	      
	      return commentsPage;
	   }

	   @Override
	   public List<Comment> findByTitleContainingOrderByIdDesc(String containedWord, Integer currentPage) {
	      final Integer articleNumber = 10;
	      
	      System.out.println(containedWord + "소비스");
	      
	      // 첫페이지, 기준 id
	      org.springframework.data.domain.Pageable pageableCondition = PageRequest.of(currentPage, articleNumber);
	      
	      List<Comment> articleSearchPage = commentRepository.findByTitleContainingOrderByIdDesc(containedWord , pageableCondition).toList();
	      
	      return  articleSearchPage;
	   }

	@Override
	public List<Comment> findByTitleContainingOrderByIdDesc(String keyword, int cPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getListCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getKeywordCount(String condition, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	}
