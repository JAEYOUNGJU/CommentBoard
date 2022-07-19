package kr.ac.kopo.ctc.comment.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;
import kr.ac.kopo.ctc.comment.board.service.CommentServiceImpl;

@Controller
@RequestMapping(value = "/comment") // 공통적인 URL은 class에 @RequestMapping으로 설정
public class CommentController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;
	// 보여주기 용
	@RequestMapping(value = "/index")
	public String index(Model model) {

		List<Comment> comments = commentServiceImpl.findAll(); //첫화면(전체 목록 보기)
		model.addAttribute("comments", comments);
		return "index";
	}
	// 변수 1개? 정도 받아와서 보여주기, 댓글 묶음이나 게시글 하나 
	@RequestMapping(value = "/selectOne/{id}")
	public String commentView(Model model, @PathVariable("id") int id) { //특정 글 상세보기
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "selectOne";
	}
	
	@RequestMapping(value = "/insertForm")
	public String commentInsertform(Model model, @PathVariable("id") int id) { //사용자 입력화면
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "insertForm";
	}
	// 추측, 데이터 넣을때 쓸 것 
	@RequestMapping(value = "/insertForm/requestBody")
	public String commentInsert(Model model, @RequestBody Comment comment) { //사용자 입력데이터 동작처리
		commentServiceImpl.commentSave(comment);
		model.addAttribute("itemsml 이름", "보낼 값");
		return "받는jsp파일이름";
	}
	
	@RequestMapping(value = "/update/{id}")
	public String commentUpdate(Model model, @PathVariable("id") int id) { //사용자 수정화면
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "update";
	}
	
	@RequestMapping(value = "/updateDB/{id}")
	public String commentUpdateDB(Model model, @PathVariable("id") int id) { //사용자 수정데이터 동작처리
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "updateDB";
	}
	
	@RequestMapping(value = "/reInsert/{id}")
	public String commentReInsert(Model model, @PathVariable("id") int id) { //댓글 입력화면
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "reInsert";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String commentDelete(Model model, @PathVariable("id") int id) { //게시글 삭제화면
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "delete";
	}

}