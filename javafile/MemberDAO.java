package jsp;
import java.sql.*;
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
	
}