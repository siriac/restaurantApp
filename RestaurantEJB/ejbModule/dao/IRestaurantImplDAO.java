package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Commandes;
import entity.Produit;
import entity.Region;
@Stateless(name="Restaurant")
public class IRestaurantImplDAO implements IrestaurantLocal,IrestaurantRemote{
@PersistenceContext(name="Resto")
private EntityManager em;
	@Override
	public void CreerPlat(Produit p) {
		// TODO Auto-generated method stub
		em.persist(p);
		
	}

	@Override
	public Boolean DeletePlat(Long idProduit) {
		// TODO Auto-generated method stub
		Produit p=em.find(Produit.class, idProduit);
		if(p==null)
		{
			return false;
		}else
		{
			em.remove(p);
			return true;
		}
	
	}

	@Override
	public void ModifierPlat(Produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
		
	}

	@Override
	public Produit RechercherPlat(Long idProduit) {
		// TODO Auto-generated method stub
		Produit p=em.find(Produit.class, idProduit);
		return p;
	}

	@Override
	public List<Produit> produits() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select p from Produit p");
		
		return (List<Produit>)req.getResultList();
	}

	@Override
	public void CreerRegion(Region r) {
		// TODO Auto-generated method stub
		em.persist(r);
		
	}

	@Override
	public Boolean DeleteRegion(Long idRegion) {
		// TODO Auto-generated method stub
		Region r=em.find(Region.class, idRegion);
		if(r==null)
		{
			return false;
		}
		else
		{
			em.remove(r);
			return true;
		}
		
	}

	@Override
	public void ModifierRegion(Region r) {
		// TODO Auto-generated method stub
		em.merge(r);
		
	}

	@Override
	public Region RechercherRegion(Long idRegion) {
		// TODO Auto-generated method stub
		Region r=em.find(Region.class, idRegion);
		
		return r;
	}

	@Override
	public List<Region> regions() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select r from Region r");
		return (List<Region>)req.getResultList();
	}

	@Override
	public void CreerCommande(Commandes c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}

	@Override
	public Boolean DeleteCommande(Long idCommande) {
		// TODO Auto-generated method stub
		Commandes c=em.find(Commandes.class, idCommande);
		if(c==null)
		{
			return false;
		}
		else
		{
			em.remove(c);
			return true;
		}
	}

	@Override
	public void ModifierCommande(Commandes c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
	}

	@Override
	public Commandes RechercherCommande(Long idCommande) {
		// TODO Auto-generated method stub
		Commandes c=em.find(Commandes.class, idCommande);
		
		return c;
	}

	@Override
	public List<Commandes> listeCommande() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select c from Commandes c");
		return (List<Commandes>)req.getResultList();
	}

	@Override
	public Long RechercherRegionByName(String NomRegion) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select r from Region r where r.NomRegion =:NomRegion");
		req.setParameter("NomRegion", NomRegion);

		Region r=(Region) req.getResultList().get(0);
		return r.getIdRegion();
	}

	@Override
	public List<Produit> ListeProduitByRegion(String nomRegion) {
		// TODO Auto-generated method stub
		Long idregion= RechercherRegionByName(nomRegion);
		Query req=em.createQuery("select r.produits from Region r where r.idRegion =:idregion");
		req.setParameter("idregion", idregion);
		return (List<Produit>)req.getResultList();
	}
	

}
