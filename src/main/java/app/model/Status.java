package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "statusid")
	private long statusid;

	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User postedBy;

	public Status() {

	}

	public Status(User postedBy) {
		this.postedBy = postedBy;
	}

	public long getStatusid() {
		return statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Status [msg : %s, postedBy : %s]", this.message, this.postedBy.getUsername());
	}
}
