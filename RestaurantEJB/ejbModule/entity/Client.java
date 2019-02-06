package entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	@NotEmpty
	private String NomClient;
	@NotEmpty
	private String Telephone;
	@OneToMany(mappedBy="client" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<Commandes>listeCommande;
	
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}  
	
	public Client(String nomClient, String telephone) {
		super();
		NomClient = nomClient;
		Telephone = telephone;
	}

	public Long getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}   
	public String getNomClient() {
		return this.NomClient;
	}

	public void setNomClient(String NomClient) {
		this.NomClient = NomClient;
	}   
	public String getTelephone() {
		return this.Telephone;
	}

	public void setTelephone(String Telephone) {
		this.Telephone = Telephone;
	}

	public Collection<Commandes> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(Collection<Commandes> listeCommande) {
		this.listeCommande = listeCommande;
	}
	
   
}
