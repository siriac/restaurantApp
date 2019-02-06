package entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	@NotEmpty
	private String NomRole;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}   
	
	public Role(String nomRole) {
		super();
		NomRole = nomRole;
	}

	public Long getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}   
	public String getNomRole() {
		return this.NomRole;
	}

	public void setNomRole(String NomRole) {
		this.NomRole = NomRole;
	}
   
}
