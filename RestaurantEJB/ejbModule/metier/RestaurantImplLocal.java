package metier;

import java.util.List;

import dao.IrestaurantLocal;
import entity.Commandes;
import entity.Produit;
import entity.Region;

public class RestaurantImplLocal implements IrestaurantLocal {
private IrestaurantLocal dao;
	@Override
	public void CreerPlat(Produit p) {
		// TODO Auto-generated method stub
		dao.CreerPlat(p);
		
	}

	@Override
	public Boolean DeletePlat(Long idProduit) {
		// TODO Auto-generated method stub
		return dao.DeletePlat(idProduit);

	}

	@Override
	public void ModifierPlat(Produit p) {
		// TODO Auto-generated method stub
		dao.ModifierPlat(p);
		
	}

	@Override
	public Produit RechercherPlat(Long idProduit) {
		// TODO Auto-generated method stub
		return dao.RechercherPlat(idProduit);

	}

	@Override
	public List<Produit> produits() {
		// TODO Auto-generated method stub
		return dao.produits();
	}

	@Override
	public void CreerRegion(Region r) {
		// TODO Auto-generated method stub
		dao.CreerRegion(r);
		
	}

	@Override
	public Boolean DeleteRegion(Long idRegion) {
		// TODO Auto-generated method stub
		
		return dao.DeleteRegion(idRegion);
	}

	@Override
	public void ModifierRegion(Region r) {
		// TODO Auto-generated method stub
		dao.ModifierRegion(r);
		
	}

	@Override
	public Region RechercherRegion(Long idRegion) {
		// TODO Auto-generated method stub
		return dao.RechercherRegion(idRegion);
	}

	@Override
	public List<Region> regions() {
		// TODO Auto-generated method stub
		return dao.regions();
	}

	@Override
	public void CreerCommande(Commandes c) {
		// TODO Auto-generated method stub
		dao.CreerCommande(c);
		
	}

	@Override
	public Boolean DeleteCommande(Long idCommande) {
		// TODO Auto-generated method stub
		
		return dao.DeleteCommande(idCommande);
	}

	@Override
	public void ModifierCommande(Commandes c) {
		// TODO Auto-generated method stub
		dao.ModifierCommande(c);
		
	}

	@Override
	public Commandes RechercherCommande(Long idCommande) {
		// TODO Auto-generated method stub
		return dao.RechercherCommande(idCommande);
	}

	@Override
	public List<Commandes> listeCommande() {
		// TODO Auto-generated method stub
		return dao.listeCommande();
	}

	@Override
	public Long RechercherRegionByName(String NomRegion) {
		// TODO Auto-generated method stub
		return dao.RechercherRegionByName(NomRegion);
	}

	@Override
	public List<Produit> ListeProduitByRegion(String nomRegion) {
		// TODO Auto-generated method stub
		return dao.ListeProduitByRegion(nomRegion);
	}

}
