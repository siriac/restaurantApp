package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Map<Long, LigneCommande> items=new HashMap<Long,LigneCommande>();
public void  AjouterProduit(Produit p ,int qte)
{
	System.out.println(items.get(p.getIdProduit())==null);
	if(items.get(p.getIdProduit())==null)
	{
		System.out.println("je suis dans le cas ou le produit n est pas present dans le panier mon id :"+p.getIdProduit());
		LigneCommande lc=new LigneCommande();
        lc.setProduit(p);
        lc.setPrix(p.getPrix()*p.getQuantite());
        lc.setQuantite(qte);
       items.put(lc.getIdLigneCommande(),lc);
	}
	else
	{
		System.out.println("je suis dejas dans le panier avec l id "+p.getIdProduit());
		LigneCommande lc=items.get(p.getIdProduit());
		lc.setQuantite(lc.getQuantite()+qte);
	}
}
public Collection<LigneCommande> getItems()
{
	return items.values();
}
public Double getTotal()
{
	Double total=0.0;
	for(LigneCommande lc:items.values())
	{
		total+=lc.getPrix()*lc.getQuantite();
	}
	return total;
}
public int getNombreProduit()
{
	return items.size();
}
public void delete(Long idProduit)
{
	items.remove(idProduit);
}
}
