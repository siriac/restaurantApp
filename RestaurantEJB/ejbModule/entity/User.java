package entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	@NotEmpty
	private String UserName;
	@NotEmpty
	private String Password;
	@OneToMany
	@JoinColumn(name="idUser")
	private Collection<Role> roles;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	public User(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}   
	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
   
}
