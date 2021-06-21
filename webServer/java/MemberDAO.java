package jsp;
import java.sql.*;

import jsp.RestaurantDAO.Restaurant;
public class MemberDAO {
	private static MemberDAO instance;
	public static MemberDAO getInstance(){
		if(instance==null) {
	    	instance=new MemberDAO();
		}  
	    return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://the4456.iptime.org:3306/flavor_minority?useSSL=false&useUnicode=true&characterEncoding=euckr","root","");
		System.out.println("DB연결 성공");
		
		return conn;
	}
	
	public int loginCheck(String id, String password) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "select * FROM user_information WHERE id = \""+ id +"\";";
			ResultSet rs = stmt.executeQuery(statement);
			if(!rs.next()) {
				return -1;	
			}else {
				String pass = rs.getString("password");
				System.out.println(pass);
				if(pass.equals(password)) return 1;
				else return 0;
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}catch(SQLException e) {
			System.out.println("sql error");
		}
		return 0;
	}
	
	public boolean duplicateCheck(String id) {
		Connection conn;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "select * FROM user_information WHERE id = \""+ id +"\";";
			ResultSet rs = stmt.executeQuery(statement);
			if(rs.next()) {
				System.out.println("중복");
				return false;
			}
			else {
				System.out.println("사용가능");
				return true;
			}
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
		
		return false;
	}
	
	public void signUp(String id, String password, String name) {
		Connection conn;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "INSERT INTO user_information(id, password, name) VALUES(?, ?, ?);";
			
			pstmt = conn.prepareStatement(statement);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);

			pstmt.executeUpdate();
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
	}
	public void custom_taste(String ID, String bin_result) {
        Connection conn;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String statement = "UPDATE user_information SET("
                    + "buckwheat,"
                    + "wheat,"
                    + "soybean,"
                    + "walnut,"
                    + "peanut,"
                    + "peach,"
                    + "tomato,"
                    + "pork,"
                    + "poultry,"
                    + "milk,"
                    + "chiken,"
                    + "beef,"
                    + "shrimp,"
                    + "mackerel,"
                    + "mussel,"
                    + "abalon,"
                    + "oyster,"
                    + "shellfish,"
                    + "crab,"
                    + "squid,"
                    + "cucumber,"
                    + "onion,"
                    + "carrot,"
                    + "branch,"
                    + "broccoli,"
                    + "seaweed,"
                    + "mushroom,"
                    + "coriander"
                    + ") = (" + bin_result + ") WHERE id = '" + ID + "';";
            stmt = conn.createStatement();
            stmt.execute(statement);
        }catch(Exception e) {
        	
        }
    }
	
	public String getAvoidence(String ID) {
		Connection conn;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        String avoidence = "";
        try {
			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "SELECT * FROM user_information WHERE id = ?";
			
			pstmt = conn.prepareStatement(statement);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				avoidence += rs.getString("buckwheat");
				avoidence += rs.getString("wheat");
				avoidence += rs.getString("soybean");
				avoidence += rs.getString("walnut");
				avoidence += rs.getString("peanut");
				avoidence += rs.getString("peach");
				avoidence += rs.getString("tomato");
				avoidence += rs.getString("pork");
				avoidence += rs.getString("poultry");
				avoidence += rs.getString("milk");
				avoidence += rs.getString("chiken");
				avoidence += rs.getString("beef");
				avoidence += rs.getString("shrimp");
				avoidence += rs.getString("mackerel");
				avoidence += rs.getString("mussel");
				avoidence += rs.getString("abalon");
				avoidence += rs.getString("oyster");
				avoidence += rs.getString("shellfish");
				avoidence += rs.getString("crab");
				avoidence += rs.getString("squid");
				avoidence += rs.getString("cucumber");
				avoidence += rs.getString("onion");
				avoidence += rs.getString("carrot");
				avoidence += rs.getString("branch");
				avoidence += rs.getString("broccoli");
				avoidence += rs.getString("seaweed");
				avoidence += rs.getString("mushroom");
				avoidence += rs.getString("coriander");
			}
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
        return avoidence;
	}
	
}