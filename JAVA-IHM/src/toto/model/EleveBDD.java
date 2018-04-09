package toto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class EleveBDD {
	private final static String QUERY_SAVE_ELEVES= "INSERT INTO Eleve(prenom, note) VALUES (?, ?);";

	public static ArrayList<EleveBean> getEleves() throws Exception {
		ArrayList<EleveBean> arr = null;
		return arr;
	}

	public static void Save(EleveBean eleve) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DriverManager.getConnection(ConnexionSDBBC.getURL());
			stmt = con.prepareStatement(QUERY_SAVE_ELEVES);

			//Remplir la requete
			stmt.setString(1, eleve.getPrenom());
			stmt.setString(2, eleve.getNom());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
