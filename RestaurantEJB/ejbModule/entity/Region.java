package entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Region
 *
 */
@Entity

public class Region implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRegion;
	@NotEmpty
	private String NomRegion;
	@OneToMany(mappedBy="region" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<Produit> produits;
	private static final long serialVersionUID = 1L;

	public Region() {
		super();
	}  
	
	public Region(String nomRegion) {
		super();
		NomRegion = nomRegion;
	}

	public Long getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(Long idRegion) {
		this.idRegion = idRegion;
	}   
	public String getNomRegion() {
		return this.NomRegion;
	}

	public void setNomRegion(String NomRegion) {
		this.NomRegion = NomRegion;
	}
   
}
