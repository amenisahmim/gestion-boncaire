package metier;

public class Admin {
	private long idbadmin;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	public Admin(int idbanquier, String nom, String prenom, String email, String adresse) {
		super();
		this.idbadmin = idbadmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;}
	public long getIdbadmin() {
		return idbadmin;
	}
	public void setIdbadmin(long idbadmin) {
		this.idbadmin = idbadmin;
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
	
	public String toString() {
		return "Admin [idbadmin=" + idbadmin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse="
				+ adresse + "]";
	}

}
