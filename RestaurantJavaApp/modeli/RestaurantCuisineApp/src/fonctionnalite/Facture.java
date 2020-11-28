package fonctionnalite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.text.JTextComponent;

import ecran.E_cuisine;
import ecran.Ecran;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Facture extends DescriptionPlat{
	
	static double prixTotal;
	private static int quantite;
	
	static ArrayList<String> lPlat = new ArrayList<String>(); //Tableau qui contient les plat selectionnes.
	static ArrayList<Double> lPrix = new ArrayList<Double>(); //Tableau qui contient le prix des plat selectionnes.	//static ArrayList<String> lid = new ArrayList<String>(); //Tableau qui contient l'identifiant des plat selectionnes.
	static ArrayList<Integer> lQtt = new ArrayList<Integer>(); //Tableau qui contient les plat selectionnes.

	// Constructeur appellant les attributs du constructeur de la classe descriptionPlat.
	public Facture(String Nnom, double Pprix) {
		super(Nnom, Pprix);
		
	}

	//Methode qui calcule le prix total de la commande.
	public static void calculer_prix() {
		for (int i = 0; i < lPrix.size(); i++) {
			
			if(i == 0) {
				prixTotal = lPrix.get(0);
			}else if(i > 0) {
				prixTotal += lPrix.get(i);
			}
		}
	}
	
	
	//Methode affichant les commande pendant leur entrer.
	public static void afficher_description(String nom, double prix) {
		quantite =  Ecran.getQtt();
		lQtt.add(quantite);
		lPlat.add(nom);
		lPrix.add(((double) prix) * quantite);
		calculer_prix();
		Ecran.getDm().addElement(quantite+" -> "+nom+" -> "+prix*quantite+" $");
		 Ecran.getLblTotal().setText("Total: "+Double.toString(prixTotal)+" $");
		
	}
	
	//Methode qui supprime une commande enregistrer
	public static void supprimer_enreg() {
		lPlat.clear();
		lPrix.clear();
		lQtt.clear();
		Ecran.getDm().clear();
	}
	
	//Methode qui supprime un element selectionner lors de l'entrer
	public static void supprimer_element() {

		lPlat.remove( Ecran.getList_1().getSelectedIndex());
		lPrix.remove( Ecran.getList_1().getSelectedIndex());
		
		Ecran.getDm().removeElement(Ecran.getList_1().getSelectedIndex());
		Ecran.getDm().clear();
        for(int i=0; i<lPlat.size(); i++)
        {
        	Ecran.getDm().addElement(lQtt.get(i)+"  -> "+lPlat.get(i)+" -> "+lPrix.get(i)+" $");
        }
		
		calculer_prix();
		if(lPrix.isEmpty()) {
			Ecran.getLblTotal().setText("Total: ");
		}else {
		Ecran.getLblTotal().setText("Total: "+Double.toString(prixTotal)+" $");
		}
		
		
	}
	
}
