package com.gocamp.forum.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.forum.bean.Post;
import com.gocamp.forum.bean.Reply;
import com.gocamp.util.HibernateUtil;
/////廢掉的檔案
public class PostReplyAction1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Post post = new Post();
			post.setTitle("Too difficult");
			post.setContent("Too hard to pickup in a short time");
//			post.setArticlenewtime(articlenewtime);
			post.setAuthor("TMD");
			post.setCategory("Mood");
			
			Reply rep1 = new Reply();
			Reply rep2 = new Reply();
			Reply rep3 = new Reply();
			Reply rep4 = new Reply();
			Reply rep5 = new Reply();
			
			rep1.setReplycontent("told you 1 times");
			rep2.setReplycontent("told you 2 times");
			rep3.setReplycontent("told you 3 times");
			rep4.setReplycontent("told you 4 times");
			rep5.setReplycontent("told you thousand times");

			Set<Reply> reply = new HashSet<Reply>();
			reply.add(rep1);
			reply.add(rep2);
			reply.add(rep3);
			reply.add(rep4);
			reply.add(rep5);
			
			post.setReply(reply);
			
			session.save(post);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed");
			HibernateUtil.closeSessionFactory();
		}
		
		HibernateUtil.closeSessionFactory();
	}

}
