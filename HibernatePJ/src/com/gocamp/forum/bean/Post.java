package com.gocamp.forum.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Post")
public class Post {
	private int postid;
	private String forumname;
	private	String title;
	private String content;
	private java.sql.Timestamp articlenewtime;
	private String favorite;
	private String author;
	private String memberid;
	private String adminid;
	private Integer viewtimes;
	private String category;
	private Set<Reply> reply = new HashSet<>();
	


	public Post() {
	}
	
	public Post(String forumname, String title, String content, String author, String category) {
		this.forumname=forumname;
		this.title=title;
		this.content=content;
		this.author=author;
		this.category=category;	
	}
	
	public Post(int postid) {
		this.postid=postid;
	}
	
	@Id @Column(name = "POSTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	
	@Column(name = "FORUMNAME")
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "ARTICLENEWTIME")
	public java.sql.Timestamp getArticlenewtime() {
		return articlenewtime;
	}
	public void setArticlenewtime(java.sql.Timestamp articlenewtime) {
		this.articlenewtime = articlenewtime;
	}
	
	@Column(name = "FAVORITE")
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	@Column(name = "AUTHOR")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "MEMBERID")
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	@Column(name = "ADMINID")
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	
	@Column(name = "VIEWTIMES")
	public Integer getViewtimes() {
		return viewtimes;
	}
	public void setViewtimes(Integer viewtimes) {
		this.viewtimes = viewtimes;
	}
	
	@Column(name = "CATEGORY")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
	public Set<Reply> getReply() {
		return reply;
	}
	public void setReply(Set<Reply> reply) {
		this.reply = reply;
	}
	
	
	
}
