package Model;

import Yard�mc�lar.DBConnection;

public class User {
	private int id;
	String kullan�c�Ad�, sifre, name, tip;

	DBConnection conn = new DBConnection();

	public User(int id, String kullan�c�Ad�, String sifre, String name, String tip) {

		this.id = id;
		this.kullan�c�Ad� = kullan�c�Ad�;
		this.sifre = sifre;
		this.name = name;
		this.tip = tip;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKullan�c�Ad�() {
		return kullan�c�Ad�;
	}

	public void setKullan�c�Ad�(String kullan�c�Ad�) {
		this.kullan�c�Ad� = kullan�c�Ad�;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
