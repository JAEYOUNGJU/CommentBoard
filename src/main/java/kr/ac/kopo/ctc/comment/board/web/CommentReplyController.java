package kr.ac.kopo.ctc.comment.board.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.comment.board.domain.Comment;
import kr.ac.kopo.ctc.comment.board.domain.CommentReply;
import kr.ac.kopo.ctc.comment.board.repository.CommentReplyRepository;
import kr.ac.kopo.ctc.comment.board.service.CommentReplyService;

@Controller
@RequestMapping(value = "/comment")
public class CommentReplyController {
	@Autowired
	CommentReplyRepository commentReplyRepository;
	@Autowired
	CommentReplyService commentReplyService;
	//댓글 입력
	@RequestMapping(value = "/selectOne/Replyinsert")
	public String insertReply(CommentReply commentReply) {
		commentReplyService.save(commentReply);
		 return "redirect:/comment/index";
//		Long toGo = commentReply.getId();
//		return "redirect:/comment/selectone/" + toGo;
	}
	
	//댓글 삭제
   
   public String deleteReply(@PathVariable(value="id") Long id) {
	  commentReplyService.deleteById(id);
      return "redirect:/comment/index";
   }
	   

}