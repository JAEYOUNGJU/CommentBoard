//package kr.ac.kopo.ctc.comment.board.repository;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import kr.ac.kopo.ctc.comment.board.domain.Comment;
//import kr.ac.kopo.ctc.comment.board.domain.CommentReply;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest // 스프링부트에서 테스트를 작성하기 위한 어노테이션
//public class CommentReplyRepositoryTest {
//
//	@Autowired
//	CommentReplyRepository commentGroupRepository;
//
//	@Autowired
//	CommentRepository commentRepository;
//
////	@Test
////	void selectOne() {
////		CommentGroup commentGroup = new CommentGroup();
////		commentGroup.setTitle("이용후기1");
////		commentGroup.setDate(new Date());
////		commentGroupRepository.save(commentGroup);
////
////		Comment comment1 = new Comment();
////		comment1.setTitle("댓글1");
////		comment1.setViewcnt(0);
////		comment1.setDate(new Date());
////		comment1.setContent("댓글내용1");
////		comment1.setRelevel(0);
////		comment1.setRecnt(0);
////		comment1.setCommentGroup(commentGroup);
////		commentRepository.save(comment1);
////
////
////	}
//	
//	@Test
//	void selectOne() {
//		CommentReply commentGroup = new CommentReply();
//		commentGroup.setTitle("이용후기2");
//		commentGroup.setDate(new Date());
//		commentGroupRepository.save(commentGroup);
//
//		Comment comment1 = new Comment();
//		comment1.setTitle("댓글1");
//		comment1.setViewcnt(0);
//		comment1.setDate(new Date());
//		comment1.setContent("댓글내용1");
//		comment1.setRelevel(0);
//		comment1.setRecnt(0);
//		comment1.setCommentGroup(commentGroup);
//		commentRepository.save(comment1);
//		
//		Comment comment2 = new Comment();
//		comment2.setTitle("댓글2");
//		comment2.setViewcnt(0);
//		comment2.setDate(new Date());
//		comment2.setContent("댓글내용2");
//		comment2.setRelevel(0);
//		comment2.setRecnt(0);
//		comment2.setCommentGroup(commentGroup);
//		commentRepository.save(comment2);
//
//
//	}
//
//}
//
