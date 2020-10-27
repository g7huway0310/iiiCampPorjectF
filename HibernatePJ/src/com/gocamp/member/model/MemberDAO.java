package com.gocamp.member.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;



public class MemberDAO {
	
	

	private Session session;

	public MemberDAO(Session session) {
		this.session=session;
	}
	
	public Member insert(Member member) {
		Member result=session.get(Member.class, member.getId());
		
		if(result==null) {
			session.save(member);
			return member;
		}
		
		return null;
	}
	
	public List<Member> select(int id) {
		Query<Member> query=session.createQuery("from Member where id="+id,Member.class);
		List<Member> list=query.list();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId()!=id) {
				return null;
			}
		}
		return list;
	}
	
	public List<Member> selectAll() {
		Query<Member> query=session.createQuery("From Member",Member.class);
		List<Member>list=query.list();
		return list;
	}
	
	public Member update(int id,Member member) {
		Member result=session.get(Member.class,id);
		if(result!=null) {
		
			result.setName(member.getName());
			result.setMobile(member.getMobile());
			result.setAddress(member.getAddress());
			result.setEmail(member.getEmail());
		
		}
		return result;
	}
	
	public boolean delete(int id) {
		Member result=session.get(Member.class,id);
		if(result!=null) {
			session.delete(result);
			return true;
		}
		return false;
	}



	


	}
		
		
	


