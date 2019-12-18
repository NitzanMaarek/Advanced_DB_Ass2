package logic;
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
		
//		// ******************** Testing insertUser() ********************
//		System.out.println("******************** Testing insertUser() ********************");
//		System.out.println("Input is: aviv101 = username, 123456 = password,   Aviv = first_name,   Zuckerman = last_name,   1 = day_of_birth,   1 = month_of_birth,   1992 = year_of_birth");
//		System.out.println("Output: " + insertUser("aviv101", "123456", "Aviv", "Zuckerman", "1", "1", "1992"));
//		System.out.println("Output should be: 1");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************
//		
//		// ******************** Testing isExistUsername() ********************
//		System.out.println("******************** Testing isExistUsername() ********************");
//		System.out.println("Input is: Jesus");
//		System.out.println("Output: " + isExistUsername("Jesus"));
//		System.out.println("Output should be: false");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************
//		
//		// ******************** Testing isExistUsername() ********************
//		System.out.println("******************** Testing isExistUsername() ********************");
//		System.out.println("Input is: aviv101");
//		System.out.println("Output: " + isExistUsername("aviv101"));
//		System.out.println("Output should be: true");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************		

//		// ******************** Testing validateUser() ********************
//		System.out.println("******************** Testing validateUser() ********************");
//		System.out.println("Input is: aviv101, 123456");
//		System.out.println("Output: " + validateUser("aviv101", "123456"));
//		System.out.println("Output should be: 1");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************			
//
//		// ******************** Testing validateUser() ********************
//		System.out.println("******************** Testing validateUser() ********************");
//		System.out.println("Input is: Jesus, Christ");
//		System.out.println("Output: " + validateUser("Jesus", "Christ"));
//		System.out.println("Output should be: Not Found");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************				
		
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
		
		
//		// ******************** Testing validateAdministrator() ********************
//		System.out.println("******************** Testing validateAdministrator() ********************");
//		System.out.println("Input is: Master, Plaster");
//		System.out.println("Output: " + validateAdministrator("Master", "Plaster"));
//		System.out.println("Output should be: 0");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************				
//	
//		// ******************** Testing validateAdministrator() ********************
//		System.out.println("******************** Testing validateAdministrator() ********************");
//		System.out.println("Input is: Jesus, Christ");
//		System.out.println("Output: " + validateAdministrator("Jesus", "Christ"));
//		System.out.println("Output should be: Not Found");
//		System.out.println("******************************************************************* \r \n \r \n");
//		// *******************************************************************				
		
		// ******************** Testing insertToHistory() ********************
		System.out.println("******************** Testing insertToHistory() ********************");
		System.out.println("Input is: 100, 100");
		System.out.println("Output: ");
		insertToHistory(100, 100);
		System.out.println("Output should be: USER DOES NOT EXIST");
		System.out.println("******************************************************************* \r \n \r \n");
		// *******************************************************************				
				
		// ******************** Testing insertToHistory() ********************
		System.out.println("******************** Testing insertToHistory() ********************");
		System.out.println("Input is: aviv101, 100");
		System.out.println("Output: ");
		insertToHistory("aviv101", "Christ");
		System.out.println("Output should be: MEDIAITEM DOES NOT EXIST");
		System.out.println("******************************************************************* \r \n \r \n");
		// *******************************************************************		
		
		// ******************** Testing insertToHistory() ********************
		System.out.println("******************** Testing insertToHistory() ********************");
		System.out.println("Input is: aviv101, Pulp Fiction");
		System.out.println("Output: ");
		insertToHistory("aviv101", "Fiction");
		System.out.println("Output should be: The insertion to history table was successful <timestamp>");
		System.out.println("******************************************************************* \r \n \r \n");
		// *******************************************************************		
		
//		// ********************** Insertion of an admin *************		
//		try {
//			Session session = HibernateUtil.currentSession();
//			Transaction tx = session.beginTransaction();
//			Administrators adminNew = new Administrators();
//			adminNew.setUsername("Master");
//			adminNew.setPassword("Plaster");	
//			Integer adminId = (Integer) session.save(adminNew);
//			tx.commit();
//			System.out.println("Admin inserted successfuully.");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			HibernateUtil.closeSession();
//		}
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
		String ans = "Not Found";
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "FROM Users US WHERE US.username = '"+username+"' AND US.password = '"+password+"'";
			@SuppressWarnings("unchecked")
			List<Users> users = session.createQuery(hqlQuery).list();
			return (users.size() > 0) ? Integer.toString(users.get(0).getUserid()) : "Not Found";
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
		String ans = "Not Found";
		try {
			Session session = HibernateUtil.currentSession();
			String hqlQuery = "FROM Administrators AD WHERE AD.username = '"+username+"' AND AD.password = '"+password+"'";
			@SuppressWarnings("unchecked")
			List<Administrators> admins = session.createQuery(hqlQuery).list();
			return (admins.size() > 0) ? Integer.toString(admins.get(0).getAdminid()) : "Not Found";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
		return ans;
	}
	
	public static void insertToHistory(String userid, String mid) {
		/*
		 * 	The function insert the row to the History table with current server time.
			Print “The insertion to history table was successful <server time>“.
		 */
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			History historyNew = new History();
			Users user = (Users)session.get(Users.class, Integer.parseInt(userid));
			if(user == null) {
				throw new Exception("USER DOES NOT EXIST.");
			}
			
			Mediaitems mediaitem = (Mediaitems)session.get(Mediaitems.class, Integer.parseInt(mid));
			if(mediaitem == null) {
				throw new Exception("MEDIAITEM DOES NOT EXIST.");
			}
			Timestamp insertionTime = new Timestamp(System.currentTimeMillis());
			HistoryId historyIdObject = new HistoryId(user.getUserid(), mediaitem.getMid(), insertionTime);
			historyNew.setId(historyIdObject);
			historyNew.setUsers(user);
			historyNew.setMediaitems(mediaitem);
			
			Integer historyId = (Integer) session.save(historyNew);		
			tx.commit();
			System.out.println("The insertion to history table was successful" + insertionTime.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}
		
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
