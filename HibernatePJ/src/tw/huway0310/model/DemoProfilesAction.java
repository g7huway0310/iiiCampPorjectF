package tw.huway0310.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.gocamp.util.HibernateUtil;



public class DemoProfilesAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		//Query From xxx要跟Bean一樣
		Query<Profiles> query = session.createQuery("From Profiles where username=:user and userpwd=:pwd",Profiles.class);
		
		query.setParameter("user","mary");
		
		query.setParameter("pwd", "test123");
		
		Profiles p1 = query.uniqueResult();
		
		if (p1!=null) {
			System.out.println("login!");
		}else {
			System.out.println("fail");
		}
		
		
		
		session.getTransaction().commit();
		
		HibernateUtil.closeSessionFactory();
		
	}

}
