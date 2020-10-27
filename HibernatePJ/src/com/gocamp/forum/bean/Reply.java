package com.gocamp.forum.bean;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "reply")
public class Reply {
	private int replyid;
	private int postid;
	private String replycontent;
	private String memberid;
	private java.sql.Timestamp newtimereply;
	private Post post;
	
	@Id @Column(name = "REPLYID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	
	@Transient
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	
	@Column(name = "REPLYCONTENT")
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	
	@Column(name = "MEMBERID")
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	@Column(name = "NEWTIMEREPLY")
	public java.sql.Timestamp getNewtimereply() {
		return newtimereply;
	}
	public void setNewtimereply(java.sql.Timestamp newtimereply) {
		this.newtimereply = newtimereply;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTID")
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
