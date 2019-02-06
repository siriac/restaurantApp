package web;

import entity.Produit;

public class ProduitCommande {
	private Produit p;
	private Integer qte;
	public Produit getP() {
		return p;
	}
	public void setP(Produit p) {
		this.p = p;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public ProduitCommande(Produit p, Integer qte) {
		super();
		this.p = p;
		this.qte = qte;
	}
	public ProduitCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
