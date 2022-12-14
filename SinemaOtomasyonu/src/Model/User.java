package Model;

import Yardımcılar.DBConnection;

public class User {
	private int id;
	String kullanıcıAdı, sifre, name, tip;

	DBConnection conn = new DBConnection();

	public User(int id, String kullanıcıAdı, String sifre, String name, String tip) {

		this.id = id;
		this.kullanıcıAdı = kullanıcıAdı;
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

	public String getKullanıcıAdı() {
		return kullanıcıAdı;
	}

	public void setKullanıcıAdı(String kullanıcıAdı) {
		this.kullanıcıAdı = kullanıcıAdı;
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
