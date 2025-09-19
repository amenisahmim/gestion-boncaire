package metier;



public class Comptes {
	
	public String toString() {
		return "Comptes [client=" + id + ", num_compte=" + num_compte + ", solde=" + solde + ",  type_compte=" + type_compte + "]";
	}
private int id;
private int num_compte;
private int solde;
private String type_compte ;
public Comptes(int num_compte,String type_compte , int solde,int id ) {
	super();
	this.id = id;
	this.num_compte = num_compte;
	this.solde = solde;
	this.type_compte = type_compte;
}

public Comptes() {
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNum_compte() {
	return num_compte;
}
public void setNum_compte(int num_compte) {
	this.num_compte = num_compte;
}
public int getSolde() {
	return solde;
}
public void setSolde(int solde) {
	this.solde = solde;
}
public String getType_compte() {
	return type_compte;
}
public void setType_compte(String type_compte) {
	this.type_compte = type_compte;
}


}
