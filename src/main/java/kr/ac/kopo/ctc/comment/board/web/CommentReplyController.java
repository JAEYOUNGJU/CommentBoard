package kr.ac.kopo.ctc.comment.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.comment.board.service.CommentReplyService;

@Controller
@RequestMapping(value = "/comment")
public class CommentReplyController {
	@Autowired
	CommentReplyService commentReplyService;

	//Reply2 Delete
   @RequestMapping(value = "/Reply2Delete/{id}")
   public String deleteReply2(@PathVariable(value="id") Long id) {
	  commentReplyService.deleteById(id); 
      return "redirect:/comment/index";
   }
	   

}