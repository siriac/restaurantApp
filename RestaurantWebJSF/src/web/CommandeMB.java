package web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.omnifaces.util.Utils;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import dao.IrestaurantLocal;
import entity.Commandes;
import entity.LigneCommande;
import entity.Panier;
import entity.Produit;
import entity.Region;


@ManagedBean(name="commandeMB")
@SessionScoped
public class CommandeMB {
	@EJB
	private IrestaurantLocal metier;
	private String nomRegion;
	private Part file1;
	private String NomPlat;
	private String PrixPlat;
	private String Quantite;
	private String DescriptionPlat;
	private Integer TotalPanier=0;
	private DataModel<ProduitCommande> produitDataModels;
	private Boolean [] tabChoix;
	private Boolean Choix;
    private List<Produit> selectedProduits;
    private Produit p ;
    private List <Produit> ligneCommandes =new ArrayList<Produit>();
    private List <ProduitCommande> ligneProduitCommandes =new ArrayList<ProduitCommande>();
    private int indiceProduit=0;
    private Double MontantPanier=0.0;
    private Double PrixTotalUnitaire=0.0;
	public List<Produit> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<Produit> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Produit getP() {
		return p;
	}

	public void setP(Produit p) {
		this.p = p;
	}

	public List<Produit> getSelectedProduits() {
		return selectedProduits;
	}

	public void setSelectedProduits(List<Produit> selectedProduits) {
		this.selectedProduits = selectedProduits;
	}

	public Boolean getChoix() {
		return Choix;
	}

	public void setChoix(Boolean choix) {
		Choix = choix;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	

	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

	public String getNomPlat() {
		return NomPlat;
	}

	public void setNomPlat(String nomPlat) {
		NomPlat = nomPlat;
	}

	public String getPrixPlat() {
		return PrixPlat;
	}

	public void setPrixPlat(String prixPlat) {
		PrixPlat = prixPlat;
	}

	public String getQuantite() {
		return Quantite;
	}

	public void setQuantite(String quantite) {
		Quantite = quantite;
	}
	

	public String getDescriptionPlat() {
		return DescriptionPlat;
	}

	public void setDescriptionPlat(String descriptionPlat) {
		DescriptionPlat = descriptionPlat;
	}

	public Integer getTotalPanier() {
		return TotalPanier;
	}

	public void setTotalPanier(Integer totalPanier) {
		TotalPanier = totalPanier;
	}

	public DataModel<ProduitCommande> getProduitDataModels() {
		if(produitDataModels==null)
		{
			produitDataModels= new ListDataModel<ProduitCommande>();
					produitDataModels.setWrappedData(ligneProduitCommandes);
		}
		return produitDataModels;
	}

	public void setProduitDataModels(DataModel<ProduitCommande> produitDataModels) {
		this.produitDataModels = produitDataModels;
	}

	public Region [] getValeurTableauRegion()
    {
    	Region [] tabReagion=new Region[metier.regions().size()];
        for(int i=0;i<metier.regions().size();i++)
        {
        	tabReagion[i]=metier.regions().get(i);
        }
        return tabReagion;
    }

public Boolean[] getTabChoix() {
		return tabChoix;
	}

	public void setTabChoix(Boolean[] tabChoix) {
		this.tabChoix = tabChoix;
	}

public Double getMontantPanier() {
		return MontantPanier;
	}

	public void setMontantPanier(Double montantPanier) {
		MontantPanier = montantPanier;
	}


public List<ProduitCommande> getLigneProduitCommandes() {
		return ligneProduitCommandes;
	}

	public void setLigneProduitCommandes(List<ProduitCommande> ligneProduitCommandes) {
		this.ligneProduitCommandes = ligneProduitCommandes;
	}


public int getIndiceProduit() {
		return indiceProduit;
	}

	public void setIndiceProduit(int indiceProduit) {
		this.indiceProduit = indiceProduit;
	}


public Double getPrixTotalUnitaire() {
		return PrixTotalUnitaire;
	}

	public void setPrixTotalUnitaire(Double prixTotalUnitaire) {
		PrixTotalUnitaire = prixTotalUnitaire;
	}

public void AjouterRegion()
{
	Region r=new Region(nomRegion);
	metier.CreerRegion(r);
}
	
public void Upload()
{
	Double prix=Double.parseDouble(PrixPlat);
	int qte=Integer.parseInt(Quantite);
	InputStream input;
	byte[]  photo;
	try {
			input = file1.getInputStream();
		photo = IOUtils.toByteArray(input);
		System.out.println("voici la photo "+photo);
		Produit p=new Produit(NomPlat,DescriptionPlat,prix,qte,photo);
		p.setRegion(metier.RechercherRegion(metier.RechercherRegionByName(nomRegion)));
		metier.CreerPlat(p);
		/*for(Produit pp:metier.ListeProduitByRegion(nomRegion))
		{
			System.out.println(pp.getDesignation());
		}*/
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void Lancer()
{
	getListProduitByRegion();
}

public List<Produit> getListProduitByRegion()
{
	if(nomRegion==null)
	{
		return null;
	}
	else
	{
	/*for(Produit p:metier.ListeProduitByRegion(nomRegion))
	{
		System.out.println(p.getDesignation());
	}*/
	return metier.ListeProduitByRegion(nomRegion);}
}
@PostConstruct
public void init()
{
	
}
public byte[] obtenirPhoto(Long id)throws IOException
{
	Produit p=new Produit();
	p=metier.RechercherPlat(id);
	return Utils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
}
public void IncrementerTotalPanier(Produit pr)
{

	TotalPanier++;
	if(RechercherProduit(pr, ligneProduitCommandes))
	{
		int q=ligneProduitCommandes.get(indiceProduit).getQte();
		ligneProduitCommandes.get(indiceProduit).setQte(q+1);
		/*produits=getProduits();
		p=new Produit();
	p=produits.getRowData();*/
//		ligneCommandes.add(pr);
//	panier.AjouterProduit(pr,5);
	
	System.out.println(ligneProduitCommandes.size()+" Montant Total");
	}

else{
	ProduitCommande pc=new ProduitCommande(pr,1);
	ligneProduitCommandes.add(pc);
	System.out.println("Nouveau Produit Ajouter Dans Panier"+pc.getP().getDescription());
}
}
public Boolean ComparerProduit(Produit P1,Produit P2)
{
	if(P1.getIdProduit()==P2.getIdProduit())
	{
		return true;
	}
	return false;
}
public Boolean RechercherProduit(Produit pd,List<ProduitCommande> lp)
{
	for(int i=0;i<lp.size();i++)
	{
		if(ComparerProduit(pd, lp.get(i).getP()))
		{
			indiceProduit=i;
			return true;
		}
	}
	return false;
}
public void TestTabBol()
{
	System.out.println(Choix);
	if(tabChoix==null)
	{
		System.out.println("null");
	}
	else
		{
		System.out.println("ok");
		}
	
}

public void onRowSelect(SelectEvent event) {
    FacesMessage msg = new FacesMessage("Plat Selected", ((Produit) event.getObject()).getDescription());
    FacesContext.getCurrentInstance().addMessage(null, msg);
}

public void onRowUnselect(UnselectEvent event) {
    FacesMessage msg = new FacesMessage("Car Unselected", ((Produit) event.getObject()).getDescription());
    FacesContext.getCurrentInstance().addMessage(null, msg);
}
public List <ProduitCommande> getContenuPanier()
{
	
	System.out.println("Le panier Contient "+ligneProduitCommandes.size());
	return ligneProduitCommandes;
}
public Double Montant()
{
	MontantPanier=0.0;
	for(ProduitCommande p:ligneProduitCommandes)
	{
		MontantPanier+=p.getQte()*p.getP().getPrix();
	}
	return MontantPanier;
}
public Double CalculTotalPrixUnitaire(ProduitCommande pc)
{
	return PrixTotalUnitaire=pc.getP().getPrix()*pc.getQte();
}
public String SupprimerLigne(ProduitCommande pc)
{
	System.out.println("before"+ligneProduitCommandes.size());
	ligneProduitCommandes.remove(pc);
	TotalPanier--;
	Montant();
	System.out.println("after"+ligneProduitCommandes.size());
	
	return null;
}
public int AjouterQuantite(ProduitCommande pc)
{
	pc.setQte(pc.getQte()+1);
	Montant();
	return pc.getQte();
}
public int DiminuerQuantite(ProduitCommande pc)
{
	pc.setQte(pc.getQte()-1);
	Montant();
	return pc.getQte();
}
public String gotoContenuPanier()
{
	return "ContenuDuPanier2";
}
public void ValiderPanier()
{
	Panier panier=new Panier();
	for(ProduitCommande p:ligneProduitCommandes)
	{
		panier.AjouterProduit(p.getP(), p.getQte());
		
	}
}
}
