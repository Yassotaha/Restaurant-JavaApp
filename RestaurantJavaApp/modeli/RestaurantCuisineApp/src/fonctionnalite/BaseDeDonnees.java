package fonctionnalite;


import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ecran.Ecran;
/*
 * Une library a ete telecharger a partir du site suivant: https://bitbucket.org/xerial/sqlite-jdbc/downloads/
 * nous l'avions referencer dans la liste des library referencer de java il n'est plus besoin de la re referencer.
 * cependant si tel est le cas qu'il perd la reference vous pouvez donc la re referencer en le telechargent dans le site
 * https://bitbucket.org/xerial/sqlite-jdbc/downloads/. vous devriez choisir le fichier "sqlite-jdbc-3.27.2.1.jar".
 * 
 * 
 */

public class BaseDeDonnees {
	static Connection connection = null; //verifie le statut de la connection.
	private static int verif = 0; //permet la verification des identifiant.
	
	public static int getverif() {
		return verif;
	}
	
	//La methode dbConnector permet de faire la connection entre la base de donnee et le lapplication.
	//En cas de non fonctionnement du path vous pouvez l'entrer manuellement comme dans la ligne en commentaire en dessous, veuillez garder "jdbc:sqlite:"
public static Connection dbConnector()
{
	try {
		Class.forName("org.sqlite.JDBC");
		String path = Paths.get("").toAbsolutePath().toString();
		String path_p = path+"\\dijss.db";
		Connection conn=DriverManager.getConnection("jdbc:sqlite:"+path_p);
		
		//Connection conn=DriverManager.getConnection("jdbc:sqlite:D:\\JAVA Workspace\\INF1163_Projet_Equipe_X\\dijss.db");
		return conn;
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		return null;
	}
	
}

//La methode verifier_connection permet de verifier l'indentifiant de chaque employer.
public static void verifier_connection() {
	connection = dbConnector();
	try {
		String query = "select * from "+ Ecran.getUserSwitch() +" where empid = ? and pass = ?";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setString(1, Ecran.getId_textField() );
		pst.setString(2, Ecran.getPasswordField());
		
		ResultSet rs= pst.executeQuery();
		int count =0;
		while(rs.next()) {
			count = count+1;
		}
		if(count == 1) {
			//JOptionPane.showMessageDialog(null, "userN and pass is correct");
			verif = 1;
		}else {
			JOptionPane.showMessageDialog(null, "userN and pass is not correct");

		}
		rs.close();
		pst.close();
	}catch(Exception e1) {
		JOptionPane.showMessageDialog(null, e1);
	}
}

//La methode enregistrer_employer permet d'enregistrer un nouveau employer dans la base de donnees.
public static void enregistrer_employer() {
	try {
		String query = "insert into employee(empid, pass, title) values (?,?,?)";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setString(1, Ecran.getIdField().getText());
		pst.setString(2, Ecran.getPassField().getText());
		pst.setString(3, Ecran.getTitreField().getText());
		pst.execute();
		pst.close();
	}catch(Exception e2) {
		e2.printStackTrace();
	}
}

//La methode supprimer_employer permet de supprimer un employer de la base de donnees.
public static void supprimer_employer() {
	try {
		String query = "delete from employee where empid = '"+ Ecran.getIdField().getText()+"'";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.execute();
		pst.close();
	}catch (Exception ex) {
		ex.printStackTrace();
	}
}

//La methode loadTable permet d'afficher la liste des employer enregistrer dans la base de donnees.
public static void loadTable() {
	DefaultTableModel table = new DefaultTableModel();
	
	table.addColumn("EMPLOYER");
	table.addColumn("MOTS DE PASSE");
	table.addColumn("TITRE");
	
	
	try {
		
		String query = "select * from employee";
		Statement pst=connection.createStatement();
		ResultSet R = pst.executeQuery(query);
		
		while(R.next()) {
			table.addRow(new Object[] {
					R.getString(1),
					R.getString(2),
					R.getString(3),
					
			});
		}Ecran.getEmployer_table().setModel(table);
	}
	catch(Exception e1) {
		System.out.println(e1);
		JOptionPane.showMessageDialog(null, e1);
}
}

//La methode enregistrer_vente permet d'enregistrer les articles vendus dans la base de donnees.
public static void enregistrer_vente() {
	try {
		String query = "insert into vente(article, prix, quantite) values (?,?,?)";
		PreparedStatement pst=connection.prepareStatement(query);
		for(int i = 0; i<Facture.lPlat.size(); i++) {
		pst.setString(1, Facture.lPlat.get(i));
		pst.setString(2, Double.toString(Facture.lPrix.get(i)));
		pst.setString(3, Double.toString(Facture.lQtt.get(i)));
		pst.execute();
		}
		
		pst.close();
	}catch(Exception e2) {
		e2.printStackTrace();
	}
}

//La methode loadTableVente permet d'afficher le tableau des element vendu dans le magasin.
public static void loadTableVente() {
	DefaultTableModel table = new DefaultTableModel();
	
	table.addColumn("ARTICLE");
	table.addColumn("PRIX");
	table.addColumn("QUANTITE");
	
	
	try {
		
		String query = "select * from vente";
		Statement pst=connection.createStatement();
		ResultSet R = pst.executeQuery(query);
		
		while(R.next()) {
			table.addRow(new Object[] {
					R.getString(1),
					R.getString(2),
					R.getString(3),
					
			});
		}Ecran.getTable_vente().setModel(table);
	}
	catch(Exception e1) {
		System.out.println(e1);
		JOptionPane.showMessageDialog(null, e1);
}
}

//la methode reinit_vente permet deffacer lenssemble des commande enregistrer dans la base de donnees.
public static void reinit_vente() {
	try {
		String query = "delete from vente";
		PreparedStatement pst=connection.prepareStatement(query);
		pst.execute();
		pst.close();
	}catch (Exception ex) {
		ex.printStackTrace();
	}
}

}

