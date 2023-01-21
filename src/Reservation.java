import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Reservation {

	String book_id, date_of_reservation, return_date;

	public Reservation(String book_id, String date_of_reservation, String return_date) {
		super();
		this.book_id = book_id;
		this.date_of_reservation = date_of_reservation;
		this.return_date = return_date;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getDate_of_reservation() {
		return date_of_reservation;
	}

	public void setDate_of_reservation(String date_of_reservation) {
		this.date_of_reservation = date_of_reservation;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public static ArrayList<Reservation> getReservation(String email) {
		try {
			Connection conn = JDBCConnection.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT book_id, date_of_reservation,return_date FROM reservation,reader WHERE reservation.reader_id = reader.id AND\r\n"
							+ "reader.email='" + email + "'");
			ArrayList<Reservation> reservations = new ArrayList<Reservation>();
			while (rs.next()) {
				String book_id = rs.getString(1);
				String date_of_reservation = rs.getString(2);
				String return_date = rs.getString(3);

				reservations.add(new Reservation(book_id, date_of_reservation, return_date));
			}
			return reservations;

		} catch (Exception e) {
			System.out.println("Greska sa bazom.");
			return null;
		}
	}

}