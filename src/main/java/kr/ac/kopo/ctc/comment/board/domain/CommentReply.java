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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import kr.ac.kopo.ctc.comment.board.domain.Comment;

@Entity
public class CommentReply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 생성할 때 @GeneratedValue 어노테이션이 함께 사용됨
	@Column
	private Long id;
	private Date date;
	private String content;
	private String writer;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_id")
	private Comment comment;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Comment getcomment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
