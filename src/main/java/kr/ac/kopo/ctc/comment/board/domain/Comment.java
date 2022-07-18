package kr.ac.kopo.ctc.comment.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.ac.kopo.ctc.comment.board.domain.CommentGroup;

@Entity //데이터베이스 구조 만들기 -> CRUD 작업
public class Comment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	public CommentGroup getCommentGroup() {
		return commentGroup;
	}

	public void setCommentGroup(CommentGroup commentGroup) {
		this.commentGroup = commentGroup;
	}
	@JsonBackReference
	@ManyToOne(optional=false) // BoardGroup이 없는 BoardItem은 없다는 조건이므로 Inner join을 수행한다. 
	@JoinColumn(name = "rootid")
	private CommentGroup commentGroup;
	
	
	@Column
	private String title;
	
	@Column
	private int viewcnt;
	
	@Column
	private Date date;
	
	@Column
	private String content;

	@Column
	private int relevel;
	
	@Column
	private int recnt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
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


	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public int getRecnt() {
		return recnt;
	}

	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}

}
