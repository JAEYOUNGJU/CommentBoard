package kr.ac.kopo.ctc.comment.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.repository.CommentRepository;
import kr.ac.kopo.ctc.comment.board.service.CommentServiceImpl;

@Controller
@RequestMapping(value = "/comment") // 공통적인 URL은 class에 @RequestMapping으로 설정
public class CommentController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<Comment> comments = commentServiceImpl.findAll();
		model.addAttribute("comments", comments);
		return "index";
	}
	
	@RequestMapping(value = "/reInsert/{id}")
	public String commentReInsert(Model model, @PathVariable("id") int id) {
		model.addAttribute("selectOne", commentServiceImpl.findAllById(id));
		return "reInsert";
	}
	@RequestMapping(value = "/update/{id}")
	public String commentUpdate(Model model, @PathVariable("id") int id) {
		model.addAttribute("selectOne", commentServiceImpl.findAllById(id));
		return "update";
	}
	@RequestMapping(value = "/selectOne/{id}")
		public String commentView(Model model, @PathVariable("id") int id) {
			model.addAttribute("selectOne", commentServiceImpl.findAllById(id));
			return "selectOne";
		}
	}