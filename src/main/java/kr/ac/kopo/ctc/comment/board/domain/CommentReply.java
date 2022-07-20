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
	// 기본키를 자동으로 생성할 때 @GeneratedValue 어노테이션이 함께 사용됨
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private Date date;
	@Column
	private String writer;
	@Column
	private int recnt;
	@Column
	private int relevel;
	
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

	public int getRecnt() {
		return recnt;
	}

	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public Comment getcomment() {
		return comment;
	}

	public void setBoardGroup(Comment comment) {
		this.comment = comment;
	}
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY) // BoardGroup이 없는 BoardItem은 없다는 조건이므로 Inner join을 수행한다. 
	@JoinColumn(name = "comment_id")
	private Comment comment;
//Comment c = new Comment();
//c.getRootId();

	}

