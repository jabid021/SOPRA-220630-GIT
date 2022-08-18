package eshop.model.jsonview;

public class JsonViews {
	public static class Base {

	};
	//views pour les produits
	public static class ProduitWithFournisseur extends Base {

	}

	public static class ProduitWithAchats extends Base {

	}

	public static class ProduitWithAchatsAndFournisseur extends ProduitWithFournisseur {

	}
	
	//views pour les fournisseurs
	public static class FournisseurWithProduits extends Base{
		
	}
}
