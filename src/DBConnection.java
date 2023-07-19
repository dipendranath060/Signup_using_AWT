import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded Successfully...");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid-19","root","");

			System.out.println("Connection Established Successfully...");

			return con;

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static int save(String name,String address) {
		try {
			Connection con=DBConnection.connect();

			String sql="INSERT INTO tbl_lockdown_contacts(name,address)"
					+"VALUES(?,?)";
			java.sql.PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, address);


			stmt.executeUpdate();

			con.close();

			System.out.println("Record Saved Successfully...");
			return 1;


		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}


}


