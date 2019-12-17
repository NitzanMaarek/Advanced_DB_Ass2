import org.hibernate.Session;
import org.hibernate.Transaction;
import hib.Mediaitems;
import hib.Users;
import hib.History;
import hib.HistoryId;
import hib.Administrators;
import hib.Similarity;
import hib.SimilarityId;
import hib.Loginlog;
import hib.LoginlogId;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Assignment {
	
	public static void main(String[] args) {

	}
	
//	public static void test() {
//		try {
//			Session session = HibernateUtil.currentSession();
//			String hqlQuery = "select MI from Mediaitems MI";
//			@SuppressWarnings("unchecked")
//			List<Mediaitems> items = session.createQuery(hqlQuery).list();
//			for(Mediaitems mi:items) {
//				System.out.println(mi.getTitle());
//			}
//			System.out.println(items.size());
//
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			HibernateUtil.closeSession();
//		}
//	}
	
	public static boolean isExistUsername(String username) {
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "select USER from Users USER where Users.username = '"+username+"'";
			@SuppressWarnings("unchecked")
			List<Users> users = session.createQuery(hqlQuery).list();
			if(users.size() > 0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
		return false;
	}
	
	public static String insertUser(String username, String password, String first_name, String last_name, String day_of_birth, String month_of_birth, String year_of_birth) {
		if(!isExistUsername(username)) {
			try {
				Session session = HibernateUtil.currentSession();
				Transaction tx = session.beginTransaction();
				DateFormat format = new SimpleDateFormat("dd-MM-yyy", Locale.ENGLISH);
				String birthdate = day_of_birth + "-" + month_of_birth + "-" + year_of_birth;
				Date date = format.parse(birthdate);
				Timestamp dateOfBirth = new Timestamp(date.getTime());
				Users userNew = new Users();
				userNew.setUsername(username);
				userNew.setPassword(password);
				userNew.setFirstName(first_name);
				userNew.setLastName(last_name);
				userNew.setDateOfBirth(dateOfBirth);
				userNew.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
				
				Integer userId = (Integer) session.save(userNew);
				tx.commit();
				return Integer.toString(userId);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				HibernateUtil.closeSession();
			}
		}
		return null;
	}
	
	public static List<Mediaitems> getTopNItems(int top_n){
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "SELECT MI FROM Mediaitems MI ORDER BY MID.mid desc";
			@SuppressWarnings("unchecked")
			List<Mediaitems> items = session.createQuery(hqlQuery).setMaxResults(top_n).list();
			return items;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
		return null;
	}
	
	public static String validateUser(String username, String password) {
		String ans = null;
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "SELECT USER FROM Users USER WHERE USER.username = '"+username+"' AND USER.password = '"+password+"'";
			@SuppressWarnings("unchecked")
			Users user = (Users)session.createQuery(hqlQuery);
			return Integer.toString(user.getUserid());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
		return ans;
	}
	
	public static String validateAdministrator(String username, String password) {
		String ans = "";
		return ans;
	}
	
	public static void insertToHistory(String userid, String mid) {
		
	}
	
	public static List<?> getHistory(String userid){
		List<?> history = new ArrayList<>();
		return history;
	}
	
	public static void insertToLog(String userid) {
		
	}
	
	public static int getNumberOfRegistredUsers(int n) {
		int ans = 0;
		return ans;
	}
	
	public static List<Users> getUsers(){
		List<Users> users = new ArrayList<>();
		return users;
	}

	public static Users getUser(String userid) {
		return null; 
	}
	
	
}
