package metier;

public class actionnercompte {
private int idbanquier;
private int num_compte;
private String typeopera;
private int montant;
private int num_compte_a_transfert;

public actionnercompte() {
}
public actionnercompte(int idbanquier, int num_compte, String typeopera, int montant, int num_compte_a_transfert) {
	this.idbanquier = idbanquier;
	this.num_compte = num_compte;
	this.typeopera = typeopera;
	this.montant = montant;
	this.num_compte_a_transfert = num_compte_a_transfert;
}
public int getIdbanquier() {
	return idbanquier;
}
public void setIdbanquier(int idbanquier) {
	this.idbanquier = idbanquier;
}
public int getNum_compte() {
	return num_compte;
}
public void setNum_compte(int num_compte) {
	this.num_compte = num_compte;
}
public String getTypeopera() {
	return typeopera;
}
public void setTypeopera(String typeopera) {
	this.typeopera = typeopera;
}
public int getMontant() {
	return montant;
}
public void setMontant(int montant) {
	this.montant = montant;
}
public int getNum_compte_a_transfert() {
	return num_compte_a_transfert;
}
public void setNum_compte_a_transfert(int num_compte_a_transfert) {
	this.num_compte_a_transfert = num_compte_a_transfert;
}

public String toString() {
	return "actionnercompte [idbanquier=" + idbanquier + ", num_compte=" + num_compte + ", typeopera=" + typeopera
			+ ", montant=" + montant + ", num_compte_a_transfert=" + num_compte_a_transfert + "]";
}

}
