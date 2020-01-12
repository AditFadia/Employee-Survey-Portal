import java.util.*;
import java.sql.*;


public class admindao1 {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(Emp1 e) {
		int status = 0;
		try {
			Connection con = admindao1.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into quizlogin(emailid,pasword) values (?,?)");
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());

			
		/*	ps.setString(1, e.getName());
			ps.setString(2, e.getName());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCountry());*/

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	
}
