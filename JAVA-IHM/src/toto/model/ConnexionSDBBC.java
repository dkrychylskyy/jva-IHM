package toto.model;

public class ConnexionSDBBC {
	private static String URL = "jdbc:sqlite:C:/SQLiteStudio/IHMBDD";

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}
}
