package fonctionnalite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ecran.E_cuisine;
import ecran.Ecran;

public class CommandeEnCours {

	private static double prixTotal1;
	private static double prixTotal2;
	private static double prixTotal3;
	private static double prixTotal4;
	static String transit;
	static Map<String, String> e_cuisine = new HashMap<>();
	
	static ArrayList<String> lPlat1 = new ArrayList<String>(); static ArrayList<String> lPlat2 = new ArrayList<String>(); static ArrayList<String> lPlat3 = new ArrayList<String>(); static ArrayList<String> lPlat4 = new ArrayList<String>();//Tableau qui contient les plats selectionnes.
	static ArrayList<Double> lPrix1 = new ArrayList<Double>(); static ArrayList<Double> lPrix2 = new ArrayList<Double>(); static ArrayList<Double> lPrix3 = new ArrayList<Double>(); static ArrayList<Double> lPrix4 = new ArrayList<Double>();//Tableau qui contient le prix des plats selectionnes.	static ArrayList<String> lid1 = new ArrayList<String>(); static ArrayList<String> lid2 = new ArrayList<String>(); static ArrayList<String> lid3 = new ArrayList<String>(); static ArrayList<String> lid4 = new ArrayList<String>();//Tableau qui contient les plat selectionnes.
	static ArrayList<Integer> lQtt1 = new ArrayList<Integer>(); static ArrayList<Integer> lQtt2 = new ArrayList<Integer>(); static ArrayList<Integer> lQtt3 = new ArrayList<Integer>(); static ArrayList<Integer> lQtt4 = new ArrayList<Integer>();//Tableau qui contient la quantite des plats selectionnes.
	
	//La methode btnPret permet de notifier quel commande est pret au serveur.
public static void btnPret(String Btn) {
	if( Btn == "Table 1" ) {
		
		
	}
	else if( Btn == "Table 2") {
		
		
	}
	else if( Btn == "Table 3") {
	
		
	}
	else if( Btn == "Table 4") {
	
	
	}
	Ecran.getComboBox_1().addItem(Btn);
	}
	
	//La methode afficher_ecran_cuisine permet d'affiche les element dans lecran du cuisinier.
	public static void afficher_ecran_cuisine() {
		for(int i = 0; i < Facture.lPlat.size(); i++) {
			transit += Ecran.getList_1().getModel().getElementAt(i)+"\n";
		}
		e_cuisine.put(String.valueOf(Ecran.getComboBox().getSelectedItem()), transit);
		transit = "";
		if( String.valueOf(Ecran.getComboBox().getSelectedItem()) == "Table 1" ) {

			E_cuisine.getTextArea().append("Table 1 \n \n"+e_cuisine.get("Table 1"));
			for(int i = 0; i < Facture.lPlat.size(); i++) {
			lQtt1.add(Facture.lQtt.get(i));
			lPlat1.add(Facture.lPlat.get(i));
			lPrix1.add(Facture.lPrix.get(i));
			}
			prixTotal1 = Facture.prixTotal;
			Facture.prixTotal=0;
			Ecran.getLblTotal().setText("Total: ");
		}
		else if( String.valueOf(Ecran.getComboBox().getSelectedItem()) == "Table 2") {
			
			E_cuisine.getTextArea_1().append("Table 2 \n \n"+e_cuisine.get("Table 2"));
			for(int i = 0; i < Facture.lPlat.size(); i++) {
			lQtt2.add(Facture.lQtt.get(i));
			lPlat2.add(Facture.lPlat.get(i));
			lPrix2.add(Facture.lPrix.get(i));
			}
			prixTotal2 = Facture.prixTotal;
			Facture.prixTotal=0;
			Ecran.getLblTotal().setText("Total: ");
		}
		else if( String.valueOf(Ecran.getComboBox().getSelectedItem()) == "Table 3") {
		
			E_cuisine.getTextArea_2().append("Table 3 \n \n"+e_cuisine.get("Table 3"));
			for(int i = 0; i < Facture.lPlat.size(); i++) {
			lQtt3.add(Facture.lQtt.get(i));
			lPlat3.add(Facture.lPlat.get(i));
			lPrix3.add(Facture.lPrix.get(i));
			}
			prixTotal3 = Facture.prixTotal;
			Facture.prixTotal=0;
			Ecran.getLblTotal().setText("Total: ");
		}
		else if( String.valueOf(Ecran.getComboBox().getSelectedItem()) == "Table 4") {
		
			E_cuisine.getTextArea_3().append("Table 4 \n \n"+e_cuisine.get("Table 4"));
			for(int i = 0; i < Facture.lPlat.size(); i++) {
			lQtt4.add(Facture.lQtt.get(i));
			lPlat4.add(Facture.lPlat.get(i));
			lPrix4.add(Facture.lPrix.get(i));
			}
			prixTotal4 = Facture.prixTotal;
			Facture.prixTotal=0;
			Ecran.getLblTotal().setText("Total: ");
		}
	
	}
	
	//la methode rechercher_commande permet d'afficher les commandes pretes pour proceder au paiment.
	public static void rechercher_commande() {
		if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 1" ) {
			Ecran.getDm().clear();
			for(int i=0; i<lPlat1.size(); i++)
	        {
	        	Ecran.getDm().addElement(lQtt1.get(i)+"  -> "+lPlat1.get(i)+" -> "+lPrix1.get(i)+" $");
	        	Ecran.getLblTotal().setText("Total: "+Double.toString(prixTotal1)+" $");
	        }
			
		}
		else if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 2" ) {
			Ecran.getDm().clear();
			for(int i=0; i<lPlat2.size(); i++)
	        {
	        	Ecran.getDm().addElement(lQtt2.get(i)+"  -> "+lPlat2.get(i)+" -> "+lPrix2.get(i)+" $");
	        	Ecran.getLblTotal().setText("Total: "+Double.toString(prixTotal2)+" $");
	        }
			
		}
		else if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 3" ) {
			Ecran.getDm().clear();
			for(int i=0; i<lPlat3.size(); i++)
	        {
	        	Ecran.getDm().addElement(lQtt3.get(i)+"  -> "+lPlat3.get(i)+" -> "+lPrix3.get(i)+" $");
	        	Ecran.getLblTotal().setText("Total: "+Double.toString(prixTotal3)+" $");
	        }
			
		}
		else if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 4" ) {
			Ecran.getDm().clear();
			for(int i=0; i<lPlat4.size(); i++)
	        {
	        	Ecran.getDm().addElement(lQtt4.get(i)+"  -> "+lPlat4.get(i)+" -> "+lPrix4.get(i)+" $");
	        	Ecran.getLblTotal().setText("Total: "+Double.toString(prixTotal4)+" $");
	        }
			
		}
	}
	
	//La methode payer_commande permet deffectuer un paiment comptant.
	public static void payer_commande() {
		double montant = Double.parseDouble(Ecran.getTextFieldMontant().getText());
		
		if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 1" ) {
			if (montant < prixTotal1) {
				Ecran.getLblTemoinPaye().setText("Le montant est inferieure au prix total.");
			}else {
				double reste = montant - prixTotal1;
				Ecran.getLblTemoinPaye().setText("Succes!! vous devez "+ reste+" $ au client ");
				Ecran.getComboBox_1().removeItem(Ecran.getComboBox_1().getSelectedItem());
				Ecran.getDm().clear();
				Ecran.getLblTotal().setText("Total: ");
				lPlat1.clear();
				lPrix1.clear();
				lQtt1.clear();
			}
	        
			
		}
		else if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 2" ) {
			if (montant < prixTotal2) {
				Ecran.getLblTemoinPaye().setText("Le montant est inferieure au prix total.");
			}else {
				double reste = montant - prixTotal2;
				Ecran.getLblTemoinPaye().setText("Succes!! vous devez "+ reste+" $ au client ");
				Ecran.getComboBox_1().removeItem(Ecran.getComboBox_1().getSelectedItem());
				Ecran.getDm().clear();
				Ecran.getLblTotal().setText("Total: ");
				lPlat2.clear();
				lPrix2.clear();
				lQtt2.clear();
			}
			
		}
		else if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 3" ) {
			if (montant < prixTotal3) {
				Ecran.getLblTemoinPaye().setText("Le montant est inferieure au prix total.");
			}else {
				double reste = montant - prixTotal3;
				Ecran.getLblTemoinPaye().setText("Succes!! vous devez "+ reste+" $ au client ");
				Ecran.getComboBox_1().removeItem(Ecran.getComboBox_1().getSelectedItem());
				Ecran.getDm().clear();
				Ecran.getLblTotal().setText("Total: ");
				lPlat3.clear();
				lPrix3.clear();
				lQtt3.clear();
			}
			
		}
		else if( String.valueOf(Ecran.getComboBox_1().getSelectedItem()) == "Table 4" ) {
			if (montant < prixTotal4) {
				Ecran.getLblTemoinPaye().setText("Le montant est inferieure au prix total.");
			}else {
				double reste = montant - prixTotal4;
				Ecran.getLblTemoinPaye().setText("Succes!! vous devez "+ reste+" $ au client ");
				Ecran.getComboBox_1().removeItem(Ecran.getComboBox_1().getSelectedItem());
				Ecran.getDm().clear();
				Ecran.getLblTotal().setText("Total: ");
				lPlat4.clear();
				lPrix4.clear();
				lQtt4.clear();
			}
			
		}
		Ecran.getTextFieldMontant().setText("");
	}
	
	
}
