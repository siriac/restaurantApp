package entity;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Produit
 *
 */
@Entity

public class Produit implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idProduit;
	@NotEmpty
	private String Designation;
	@NotEmpty
	private String Description;
	@NotNull
	private Double Prix;
	@NotNull
	private int Quantite;
	@NotEmpty
	@Lob
	private byte [] photo;
	@ManyToOne
	@JoinColumn(name="idRegion")
	private Region region;
	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	} 
	
	
	public Produit(String designation, String description, Double prix, int quantite, byte[] photo) {
		super();
		Designation = designation;
		Description = description;
		Prix = prix;
		Quantite = quantite;
		this.photo = photo;
	}


	public long getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}   
	public String getDesignation() {
		return this.Designation;
	}

	public void setDesignation(String Designation) {
		this.Designation = Designation;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public Double getPrix() {
		return this.Prix;
	}

	public void setPrix(Double Prix) {
		this.Prix = Prix;
	}   
	public int getQuantite() {
		return this.Quantite;
	}

	public void setQuantite(int Quantite) {
		this.Quantite = Quantite;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}   
	
   
}
