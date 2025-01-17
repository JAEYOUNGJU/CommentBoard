package kr.ac.kopo.ctc.comment.board.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity // 데이터베이스 구조 만들기 -> CRUD 작업
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String title;
	private String writer;
	private Date date;
	private String content;

	// mappedBy 양방향 관계 설정시 관계의 주체가 되는 쪽에서 정의함
	// 부모입장에서 fetch = FetchType.LAZY 은 기본값
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comment")
	private List<CommentReply> commentReplys;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<CommentReply> getCommentReplys() {
		if (commentReplys == null) {
			commentReplys = new ArrayList<CommentReply>();
		}
		return commentReplys;
	}

	public void setCommentReplys(List<CommentReply> commentReplys) {
		this.commentReplys = commentReplys;
	}

	public void addCommentReply(CommentReply c) {
		List<CommentReply> commentReplys = getCommentReplys();
		commentReplys.add(c);
	}

}
