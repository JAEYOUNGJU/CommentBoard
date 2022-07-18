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

import kr.ac.kopo.ctc.comment.board.domain.Comment;


@Entity
public class CommentGroup {
	@Id
	// 기본키를 자동으로 생성할 때 @GeneratedValue 어노테이션이 함께 사용됨
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String title;
	@Column
	private int viewcnt;
	@Column
	private Date date;
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
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commentGroup")
	// mappedBy 양방향 관계 설정시 관계의 주체가 되는 쪽에서 정의함
	// 부모입장에서 fetch = FetchType.LAZY 은 기본값
	// CascadeType.ALL 이 설정이 되어있으면 commentGroup 이 지울 때 그 안에 있는 comment들도 지워지게 되는 것

	private List<Comment> comments; // Comment 호출

	public List<Comment> getComments() {
		if (comments == null) {
			comments = new ArrayList<Comment>();
		}
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment c) {
		List<Comment> comments = getComments();
		comments.add(c);
	}

	}

