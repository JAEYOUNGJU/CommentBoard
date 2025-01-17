package kr.ac.kopo.ctc.comment.board.web;

import java.awt.print.Pageable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.repository.CommentReplyRepository;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;
import kr.ac.kopo.ctc.comment.board.service.CommentReplyServiceImpl;
import kr.ac.kopo.ctc.comment.board.service.CommentService;
import kr.ac.kopo.ctc.comment.board.service.CommentServiceImpl;

@Controller
@RequestMapping(value = "/comment") // 공통적인 URL은 class에 @RequestMapping으로 설정
public class CommentController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	CommentReplyRepository commentReplyRepository;
	@Autowired
	private CommentReplyServiceImpl commentReplyServiceImpl;

	@Autowired
	private CommentService commentService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// 게시판 첫 화면
	@RequestMapping(value = "/index")
	public String index(Model model, @RequestParam(value = "title", required = false) String keyword) {
		Integer cPage = 0;
		
		if (keyword != null) { // 검색어가 있는 경우			
			model.addAttribute("comments", commentServiceImpl.findByTitleContainingOrderByIdDesc(keyword, cPage));
			model.addAttribute("keyword", keyword);
			model.addAttribute("searchpagination", commentServiceImpl.makePagination(cPage, keyword));
		}

		if (keyword == null) { // 검색어가 없는 경우
			model.addAttribute("comments", commentServiceImpl.findByIdGreaterThanOrderByIdDesc(cPage));
			model.addAttribute("keyword", "");
			model.addAttribute("searchpagination", commentServiceImpl.makePagination(cPage, keyword));
			System.out.println("공백");
		}

		return "index";
	}

	// BoardItem search - 검색어가 있는 경우
	@RequestMapping(value = "/index/{cPage}/{keyword}")
	public String search(Model model, @PathVariable(value = "cPage") Integer cPage,
			@PathVariable(value = "keyword") String keyword) {

		model.addAttribute("searchpagination", commentServiceImpl.makePagination(cPage, keyword));
		model.addAttribute("comments", commentService.findByTitleContainingOrderByIdDesc(keyword, cPage));
		model.addAttribute("keyword", keyword);

		return "index";
	}

	// BoardItem search - 검색어가 없는 경우
	@RequestMapping(value = "/index/{cPage}")
	public String searchDefault(Model model, @PathVariable(value = "cPage") Integer cPage) {

		model.addAttribute("searchpagination", commentServiceImpl.makePagination(cPage, ""));
		model.addAttribute("comments", commentService.findByIdGreaterThanOrderByIdDesc(cPage));
		return "index";
	}


	// 변수 1개 정도 받아와서 보여주기, 댓글 묶음이나 게시글 하나
	@RequestMapping(value = "/selectOne/{id}")
	public String commentView(Model model, @PathVariable("id") Long id) { // controller에서 parameter 받는 방법:@pathVariable
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id)); // Model : 해당 데이터를 가지고 view까지 이동
		model.addAttribute("selectReply", commentReplyServiceImpl.showAllByReplyId(id));
		return "selectOne";
	}

	@RequestMapping(value = "/insertForm")
	public String commentInsertForm() { // 사용자 입력화면
		return "insertForm";
	}

	@RequestMapping(value = "/insert")
	public String commentInsert(Comment comment) { // 사용자가 입력한 데이터 동작 처리
		comment.setDate(new Date());
		commentRepository.save(comment);
		return "redirect:/comment/index";
	}

	@RequestMapping(value = "/updateForm/{id}") // 사용자가 수정하는 화면
	public String commentUpdateForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("selectOne", commentServiceImpl.findOneById(id));
		return "updateForm";
	}

	@RequestMapping(value = "/updateForm/update/{id}")
	public String commentUpdate(Comment comment) { // 사용자가 수정한 부분 동작 처리
		comment.setDate(new Date());
		commentRepository.save(comment);
		return "redirect:/comment/index";
	}

	@RequestMapping(value = "/delete/{id}")
	public String commentDelete(@PathVariable Long id) { // 게시글 삭제
		commentRepository.deleteById(id);
		return "redirect:/comment/index";
	}

}