package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Sistemimize film ekleyip ��karan y�neticinin olu�turuldu�u s�n�f. Y�neticiye ait �zellikler  bu s�n�fta tan�mlan�yor.
public class Yonetici extends User {

	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();

	PreparedStatement preparedStatement = null;

	public Yonetici(int id, String kullan�c�Ad�, String sifre, String name, String tip) {
		super(id, kullan�c�Ad�, sifre, name, tip);

	}

	public Yonetici() {
		// Y�neticimizin 2 tane g�revi var.Sisteme film ekleyip film ��karma burada film
		// eklemek i�in olu�turulan methot g�z�kmekte.
	}

	// filmimizin �zelliklerini parametre kabul eden boolean tipinde bir methodumuz
	// var. Bu metot ��yle �al���r.
	// veritaban�nda olu�turdu�umuz filmlerin �zelliklerini al�r. Film eklemek i�in
	// bir sorgu yap�yoruz.ve filmin �zellikleri ? ile bo� b�rak�l�yor.
	// bu bo�luklar� preparedStatement arac�l���yla s�ras�yla de�i�tiroyoruz.
	// Filmekle methodune gelen de�erler s�ras�yla ? i�aretlerinin yerine
	// ge�iyor. Bu sayede y�netici sisteme film ekleyebiliyor. Buradaki keyin amac�
	// e�er bir hata olursa bunu g�stermesi i�in bulunuyor.
	// keyin de�eri true olursa bir hata olu�tu�unu farkediyoruz.
	public boolean FilmEkle(String ad�, String t�r�, String dili, String tarihi, String salonu) throws SQLException {
		String sorgu = "INSERT INTO film" + "(ad�,t�r�,dili,tarihi,salonu) VALUES" + "(?,?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, ad�);
			preparedStatement.setString(2, t�r�);
			preparedStatement.setString(3, dili);
			preparedStatement.setString(4, tarihi);
			preparedStatement.setString(5, salonu);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;

		// Burada da ayn� i�lem var. Filmi silmek i�in o filmin id isine g�re silinme
		// yapar y�netici filmleri olu�turuldu�u id numaras�na g�re
		// siler. y�netici panelinde id k�sm�n� y�netici eliyle yazarak de�il panelde ki
		// tablo �zerinden film i�in olu�turdu�u sat�ra t�klay�nca
		// id numaras� panelde g�z�kmektedir ve y�netici sil butonuna basarsa film
		// silinir o sat�r kaybolur.
	}

	public boolean FilmSil(int id) throws SQLException {
		String sorgu = "DELETE FROM film WHERE id= ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;

	}

}
