package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Commandes;
import entity.Produit;
import entity.Region;
@Local
public interface IrestaurantLocal {
	
		public void CreerPlat(Produit p);
		public Boolean DeletePlat(Long idProduit);
		public void ModifierPlat(Produit p);
		public Produit RechercherPlat(Long idProduit);
		public List<Produit> produits();
		public List<Produit> ListeProduitByRegion(String nomRegion);
		
		
		public void CreerRegion(Region r);
		public Boolean DeleteRegion(Long idRegion);
		public void ModifierRegion(Region r);
		public Region RechercherRegion(Long idRegion);
		public List<Region> regions();
		public Long RechercherRegionByName(String NomRegion);
		
		
		public void CreerCommande(Commandes c);
		public Boolean DeleteCommande(Long idCommande);
		public void ModifierCommande(Commandes c);
		public Commandes RechercherCommande(Long idCommande);
		public List<Commandes> listeCommande();


}
