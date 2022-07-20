package kr.ac.kopo.ctc.comment.board.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	@Autowired
	CommentRepository commentRepository;
	
   @InitBinder
   protected void initBinder(WebDataBinder binder) { 
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
   }
	// 보여주기 용
	@RequestMapping(value = "/index")
	public String index(Model model) {

		List<Comment> comments = commentServiceImpl.findAll(); //첫화면(전체 목록 보기)
		model.addAttribute("comments", comments);
		return "index";
	}
	// 변수 1개? 정도 받아와서 보여주기, 댓글 묶음이나 게시글 하나 
	@RequestMapping(value = "/selectOne/{id}")//특정 글 상세보기
	public String commentView(Model model, @PathVariable("id") Long id) { //controller에서 parameter 받는 방법:@pathVariable 
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id)); //Model : 해당 데이터를 가지고 view까지 이동
		return "selectOne";
	}

	@RequestMapping(value = "/insertForm")
	public String commentInsertForm() { //사용자 입력화면
		return "insertForm";
	}

	@RequestMapping(value = "/insert")
	public String commentInsert(Comment comment) { //사용자 입력화면
		comment.setDate(new Date());
		commentRepository.save(comment);
		return "redirect:/comment/index";
	}
	
	@RequestMapping(value = "/updateForm/{id}")
	public String commentUpdateForm(Model model, @PathVariable("id") Long id) { // 특정 글 상세보기
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "updateForm";
	}
	
	
	@RequestMapping(value = "/updateForm/update/{id}")
	public String commentUpdate(Comment comment) { //사용자 입력화면
		comment.setDate(new Date());
		commentRepository.save(comment);
		return "redirect:/comment/index";
	}
	
	@RequestMapping(value = "/reInsert/{id}")
	public String commentReInsert(Model model, @PathVariable("id") Long id) { //댓글 입력화면
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "reInsert";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String commentDelete(@PathVariable Long id) { //게시글 삭제
		commentRepository.deleteById(id);
		return "redirect:/comment/index";
	}

}