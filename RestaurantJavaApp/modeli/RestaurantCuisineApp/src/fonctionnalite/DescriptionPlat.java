package fonctionnalite;

public class DescriptionPlat {
	
	private String nom;
	private double prix;
	private String id;
	

	//Constructeur 
	public DescriptionPlat(String nnom, double pprix) {
		this.nom = nnom;
		this.prix = pprix;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}
	
	
}
