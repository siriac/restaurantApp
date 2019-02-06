package entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Commandes
 *
 */
@Entity

public class Commandes implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date heureCommande;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	@OneToMany(mappedBy="commande" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<LigneCommande>lignesCommandes;
	private static final long serialVersionUID = 1L;

	public Commandes() {
		super();
	}
	
	
	public Commandes(Date dateCommande, Date heureCommande) {
		super();
		this.dateCommande = dateCommande;
		this.heureCommande = heureCommande;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(Collection<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}

	public Long getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}   
	
	public Date getHeureCommande() {
		return heureCommande;
	}
	public void setHeureCommande(Date heureCommande) {
		this.heureCommande = heureCommande;
	}
	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
   
}
