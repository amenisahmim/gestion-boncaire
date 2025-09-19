package metier;

public class Banquier {
	
	public String toString() {
		return "Personne [id=" + idbanquier + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "+ , adresse=" + adresse + "]";
	}

private long idbanquier;
private String nom;
private String prenom;
private String email;
private String adresse;

public Banquier(int idbanquier, String nom, String prenom, String email, String adresse) {
	super();
	this.idbanquier = idbanquier;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.adresse = adresse;}

public long getId() {
	return idbanquier;
}

public void setId(int id) {
	this.idbanquier = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

}
