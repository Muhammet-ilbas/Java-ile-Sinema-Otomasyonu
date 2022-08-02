package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Sistemimize film ekleyip çýkaran yöneticinin oluþturulduðu sýnýf. Yöneticiye ait özellikler  bu sýnýfta tanýmlanýyor.
public class Yonetici extends User {

	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();

	PreparedStatement preparedStatement = null;

	public Yonetici(int id, String kullanýcýAdý, String sifre, String name, String tip) {
		super(id, kullanýcýAdý, sifre, name, tip);

	}

	public Yonetici() {
		// Yöneticimizin 2 tane görevi var.Sisteme film ekleyip film çýkarma burada film
		// eklemek için oluþturulan methot gözükmekte.
	}

	// filmimizin özelliklerini parametre kabul eden boolean tipinde bir methodumuz
	// var. Bu metot þöyle çalýþýr.
	// veritabanýnda oluþturduðumuz filmlerin özelliklerini alýr. Film eklemek için
	// bir sorgu yapýyoruz.ve filmin özellikleri ? ile boþ býrakýlýyor.
	// bu boþluklarý preparedStatement aracýlýðýyla sýrasýyla deðiþtiroyoruz.
	// Filmekle methodune gelen deðerler sýrasýyla ? iþaretlerinin yerine
	// geçiyor. Bu sayede yönetici sisteme film ekleyebiliyor. Buradaki keyin amacý
	// eðer bir hata olursa bunu göstermesi için bulunuyor.
	// keyin deðeri true olursa bir hata oluþtuðunu farkediyoruz.
	public boolean FilmEkle(String adý, String türü, String dili, String tarihi, String salonu) throws SQLException {
		String sorgu = "INSERT INTO film" + "(adý,türü,dili,tarihi,salonu) VALUES" + "(?,?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, adý);
			preparedStatement.setString(2, türü);
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

		// Burada da ayný iþlem var. Filmi silmek için o filmin id isine göre silinme
		// yapar yönetici filmleri oluþturulduðu id numarasýna göre
		// siler. yönetici panelinde id kýsmýný yönetici eliyle yazarak deðil panelde ki
		// tablo üzerinden film için oluþturduðu satýra týklayýnca
		// id numarasý panelde gözükmektedir ve yönetici sil butonuna basarsa film
		// silinir o satýr kaybolur.
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
