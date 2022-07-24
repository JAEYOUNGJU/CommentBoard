package kr.ac.kopo.ctc.comment.board.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.comment.board.domain.CommentReply;
import kr.ac.kopo.ctc.comment.board.repository.CommentReplyRepository;
import kr.ac.kopo.ctc.comment.board.service.CommentReplyService;
import kr.ac.kopo.ctc.comment.board.service.CommentReplyServiceImpl;

@Controller
@RequestMapping(value = "/comment")
public class CommentReplyController {
	@Autowired
	CommentReplyRepository commentReplyRepository;
	@Autowired
	CommentReplyService commentReplyService;
	@Autowired
	CommentReplyServiceImpl commentReplyServiceImpl;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// 댓글 입력
	@RequestMapping(value = "/selectOne/ReplyInsert")
	public String insertReply(CommentReply commentReply) {
		commentReplyService.save(commentReply);
		 return "redirect:/comment/index";
//		Long here = commentReply.getReplyId();
//		return "redirect:/comment/selectOne/" + here;
	}

	//댓글 수정
	@RequestMapping(value = "/replyUpdateForm/{id}")
	public String updateFormReply(Model model, @PathVariable("id") Long id) {
		model.addAttribute("updateReply", commentReplyService.findOneById(id));
		return "replyUpdateForm";
	}
	@RequestMapping(value = "/replyUpdateForm/ReplyUpdate/{id}")
	public String updateReply(CommentReply commentReply) {
		commentReplyServiceImpl.updateReply(commentReply);
		return "redirect:/comment/index";
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/ReplyDelete/{id}")
	public String deleteReply(@PathVariable(value = "id") Long id) {
		commentReplyService.deleteById(id);
		return "redirect:/comment/index";
	}

}