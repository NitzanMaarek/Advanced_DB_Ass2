package hib;
// Generated Dec 17, 2019 6:40:37 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	private int userid;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Timestamp dateOfBirth;
	private Timestamp registrationDate;
	private Set histories = new HashSet(0);
	private Set loginlogs = new HashSet(0);

	public Users() {
	}

	public Users(int userid, String username, String password, String firstName, String lastName,
			Timestamp dateOfBirth, Timestamp registrationDate) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
	}

	public Users(int userid, String username, String password, String firstName, String lastName,
			Timestamp dateOfBirth, Timestamp registrationDate, Set histories, Set loginlogs) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.histories = histories;
		this.loginlogs = loginlogs;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

	public Set getLoginlogs() {
		return this.loginlogs;
	}

	public void setLoginlogs(Set loginlogs) {
		this.loginlogs = loginlogs;
	}

}
