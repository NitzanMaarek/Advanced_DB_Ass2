package logic;
import org.hibernate.Query;
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
import java.time.LocalDate;
import java.util.*;

public class Assignment {
	
	public static void main(String[] args) {
		
//		// ******************** Testing isExistUsername() ********************
//		System.out.println("******************** Testing isExistUsername() ********************");
//		System.out.println("Input is: Jesus");
//		System.out.println("Output: " + isExistUsername("Jesus"));
//		System.out.println("Output should be: false");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************
//		
//		// ******************** Testing insertUser() ********************
//		System.out.println("******************** Testing insertUser() ********************");
//		System.out.println("Input is: aviv101 = username, 123456 = password,   Aviv = first_name,   Zuckerman = last_name,   1 = day_of_birth,   1 = month_of_birth,   1992 = year_of_birth");
//		System.out.println("Output: " + insertUser("aviv101", "123456", "Aviv", "Zuckerman", "1", "1", "1992"));
//		System.out.println("Output should be: false");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************
//			
//		
//		// ******************** Testing getTopNItems() ********************
//		System.out.println("******************** Testing isExistUsername() ********************");
//		System.out.println("Input is: 10");
//		System.out.println("Output: ");
//		List<Mediaitems> mediaitems = getTopNItems(10);
//		for(Mediaitems mi : mediaitems) {
//			System.out.println(mi.getMid() + " : " + mi.getTitle());
//		}
//		System.out.println("Output should be \r\n 32 : WALLE\r\n" + 
//				"31 : Se7en\r\n" + 
//				"30 : It's a Wonderful Life\r\n" + 
//				"29 : The Lord of the Rings: The Two Towers\r\n" + 
//				"28 : The Matrix\r\n" + 
//				"27 : Citizen Kane\r\n" + 
//				"26 : Memento\r\n" + 
//				"25 : North by Northwest\r\n" + 
//				"24 : Sunset Blvd.\r\n" + 
//				"23 : Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************

		insertToLog("1");
		
		// ******************** Testing getNumberOfRegistredUsers() ********************
		System.out.println("******************** Testing getNumberOfRegistredUsers() - TEST 1 ********************");
		System.out.println("Output: ");
		Integer numOfUsers = getNumberOfRegistredUsers(0);
		System.out.println("Output: " + numOfUsers.toString());
		System.out.println("Output should be: 0");
		System.out.println("******************************************************************* \r \n \r \n");
		
		System.out.println("******************** Testing getNumberOfRegistredUsers() - TEST 2 ********************");
		System.out.println("Output: ");
		numOfUsers = getNumberOfRegistredUsers(100000);
		System.out.println("Output: " + numOfUsers.toString());
		System.out.println("Output should be: 1");
		System.out.println("******************************************************************* \r \n \r \n");
		
		// *******************************************************************
		
		
		// ******************** Testing getUsers() ********************
		System.out.println("******************** Testing getUsers() ********************");
		System.out.println("Output: ");
		List<Users> users = getUsers();
		for (Users user : users) {
			System.out.println(user.getUserid());
		}
		
		System.out.println("Output should be: 1");
		System.out.println("******************************************************************* \r \n \r \n");
		// *******************************************************************
		
		// ******************** Testing getUser() ********************
		System.out.println("******************** Testing getUser() ********************");
		System.out.println("Input is: 1");
		System.out.println("Output: " + getUser("1").getUsername());
		System.out.println("Output should be: aviv101");
		System.out.println("******************************************************************* \r \n \r \n");
		// *******************************************************************
	}
	
	public static void test() {
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "select MI from Mediaitems MI";
			@SuppressWarnings("unchecked")
			List<Mediaitems> items = session.createQuery(hqlQuery).list();
			for(Mediaitems mi:items) {
				System.out.println(mi.getTitle());
			}
			System.out.println(items.size());

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
	}
	
	public static boolean isExistUsername(String username) {
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "from Users where username = '"+username+"'";
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
//			String hqlQuery = "SELECT MI FROM Mediaitems MI ORDER BY MID.mid desc";
			String hqlQuery = "FROM Mediaitems MI ORDER BY MI.mid DESC";
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
			String hqlQuery = "SELECT USER FROM Users USER WHERE USER.username = '"+ username+"' AND USER.password = '"+password+"'";
			@SuppressWarnings("unchecked")
			Users user = (Users)session.createQuery(hqlQuery).list().get(0);
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
		if(!isExistUsername(userid)) {
			try {
				Session session = HibernateUtil.currentSession();
				Transaction tx = session.beginTransaction();
//				DateFormat format = new SimpleDateFormat("dd-MM-yyy", Locale.ENGLISH);
				Timestamp date = new Timestamp(System.currentTimeMillis());
//				Date date = java.sql.Date.valueOf(LocalDate.now());
				LoginlogId log = new LoginlogId();
				log.setLogintime(date);
				log.setUserid(Integer.parseInt(userid));
				tx.commit();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				HibernateUtil.closeSession();
			}
		}
	}
	
	public static int getNumberOfRegistredUsers(int n) {
		int ans = 0;
		Session session = HibernateUtil.currentSession();
		Date date = java.sql.Date.valueOf(LocalDate.now().minusDays(n));
		Query q = session.createQuery("select user FROM Users user where user.registrationDate > :date");
		q.setDate("date", date);
		ans = q.list().size();
		return ans;
	}
	
	
	public static List<Users> getUsers(){
		Session session = HibernateUtil.currentSession();
		String hqlQuery = "FROM Users user";
		@SuppressWarnings("unchecked")
		List<Users> users = session.createQuery(hqlQuery).list();
		return users;
	}

	public static Users getUser(String userid) {
		Session session = HibernateUtil.currentSession();
		@SuppressWarnings("unchecked")
		Users user = (Users)session.get(Users.class,  Integer.parseInt(userid));
		return user;
	}
	
	
}