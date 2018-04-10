package toto.model;

public class EleveBean {
	public Long id;
	public String nom;
	public String prenom;

	public EleveBean(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}
