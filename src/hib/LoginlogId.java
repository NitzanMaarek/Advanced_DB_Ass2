package hib;
// Generated Dec 17, 2019 6:40:37 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * LoginlogId generated by hbm2java
 */
public class LoginlogId implements java.io.Serializable {

	private int userid;
	private Timestamp logintime;

	public LoginlogId() {
	}

	public LoginlogId(int userid, Timestamp logintime) {
		this.userid = userid;
		this.logintime = logintime;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LoginlogId))
			return false;
		LoginlogId castOther = (LoginlogId) other;

		return (this.getUserid() == castOther.getUserid())
				&& ((this.getLogintime() == castOther.getLogintime()) || (this.getLogintime() != null
						&& castOther.getLogintime() != null && this.getLogintime().equals(castOther.getLogintime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserid();
		result = 37 * result + (getLogintime() == null ? 0 : this.getLogintime().hashCode());
		return result;
	}

}