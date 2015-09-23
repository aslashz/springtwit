package app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	long userid;

	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "postedBy")
	private List<Status> liststatus;

	public List<Status> getListstatus() {
		return liststatus;
	}

	public void setListstatus(List<Status> liststatus) {
		this.liststatus = liststatus;
	}

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Customer[id=%d, username=%s, password=%s]", userid, username, password);
	}
}
