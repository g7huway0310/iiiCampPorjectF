package com.gocamp.forum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.gocamp.forum.bean.Post;

public class PostBeanDAO {

	private Session session;

	public PostBeanDAO(Session session) {
		this.session = session;
	}

	public Post insert(Post post) {
		Post result = session.get(Post.class, post.getPostid());
		if (result == null) {
			session.save(post);
		}
		return null;
	}


	
	public List<Post> select(int postid){
		Query<Post> query = session.createQuery("from Post where postid="+postid,Post.class);
		List<Post> list = query.list();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getPostid()!=postid) {
				return null;
			}
		}
		return list;
	}

	public List<Post> selectAll() {
		Query<Post> query = session.createQuery("From Post", Post.class);
		List<Post> list = query.list();
		return list;
	}

	public Post update(int postid, Post post) {
		Post result=session.get(Post.class, postid);
		if(result!= null) {
			
			result.setForumname(post.getForumname());
			result.setTitle(post.getTitle());
			result.setAuthor(post.getAuthor());
			result.setContent(post.getContent());
			result.setCategory(post.getCategory());
		}
		return result;
	}

	public boolean delete(int postid) {
		Post result = session.get(Post.class, postid);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}


	
}
