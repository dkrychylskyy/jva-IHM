package toto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EleveBDD {
	private final static String QUERY_SAVE_ELEVES= "INSERT INTO Eleves(prenom, nom) VALUES (?, ?);";
	private final static String QUERY_FIND_ELEVES= "SELECT * FROM Eleves";

	public static ArrayList<EleveBean> getEleves() throws Exception {
		Connection con = null;
		Statement stmt = null;

		ArrayList<EleveBean> eleves = new ArrayList<>();

		try {
			con = DriverManager.getConnection(ConnexionSDBBC.getURL());
			stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(QUERY_FIND_ELEVES);
			while (rset.next()) {
				EleveBean eleve = rsetToEleve(rset);
				eleves.add(eleve);
			}
		}
		finally {
			con.close();
		}
		return eleves;
	}

	private static EleveBean rsetToEleve(ResultSet rset) throws SQLException {
		EleveBean eleve = new EleveBean(rset.getString(2), rset.getString(3));
		return eleve;
	}

	// Save daonne dans BDD
	public static void Save(EleveBean eleve) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DriverManager.getConnection(ConnexionSDBBC.getURL());
			stmt = con.prepareStatement(QUERY_SAVE_ELEVES);

			//Remplir la requete
			stmt.setString(1, eleve.getPrenom());
			stmt.setString(2, eleve.getNom());

			// Lancer la requete
			stmt.executeUpdate();
		} finally {
			// On ferle la connexion
			if (con !=null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
