package entity;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: LigneCommande
 *
 */
@Entity

public class LigneCommande implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneCommande;
	@NotNull
	private Integer Quantite;
	@NotNull
	private Double Prix;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commandes commande;
	private static final long serialVersionUID = 1L;

	public LigneCommande() {
		super();
	}   
	
	public LigneCommande(Integer quantite, Double prix) {
		super();
		Quantite = quantite;
		Prix = prix;
	}

	public Long getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}   
	public Integer getQuantite() {
		return this.Quantite;
	}

	public void setQuantite(Integer Quantite) {
		this.Quantite = Quantite;
	}   
	public Double getPrix() {
		return this.Prix;
	}

	public void setPrix(Double Prix) {
		this.Prix = Prix;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commandes getCommande() {
		return commande;
	}

	public void setCommande(Commandes commande) {
		this.commande = commande;
	}
   
}
