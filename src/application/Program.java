package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement("INSERT INTO seller " + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?, ?, ?, ?, ?)");

			st.setString(1, "Mano Pingado");
			st.setString(2, "manoPin@mail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("18/06/1994").getTime()));
			st.setDouble(4, 10000);
			st.setInt(5, 1);

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.closeStateMent(st);
			DB.closeConnection();
		}
	}

}
