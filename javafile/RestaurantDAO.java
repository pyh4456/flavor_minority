package jsp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class RestaurantDAO {
	public int increase(int i) {
		return ++i;
	}
	
	class Restaurant{
		String name;
		float latitude;
		float longitude;
	}
	
	public List<Restaurant> restaurants = new ArrayList<Restaurant>();
	private static RestaurantDAO instance;
	
	public static RestaurantDAO getInstance(){
		if(instance==null) {
	    	instance=new RestaurantDAO();
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
	
	public boolean register(String name, float latitude, float longitude) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "SELECT name FROM restaurant WHERE latitude = ? AND longitude = ?";
			pstmt = conn.prepareStatement(statement);
			pstmt.setFloat(1, latitude);
			pstmt.setFloat(2, longitude);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("yes");
				statement = "INSERT INTO restaurant (name, latitude, longitude) VALUES(?, ?, ?);";
				pstmt = conn.prepareStatement(statement);
				pstmt.setString(1, name);
				pstmt.setFloat(2, latitude);
				pstmt.setFloat(3, longitude);
				pstmt.executeUpdate();
				
				
			}
			statement = "CREATE TABLE IF NOT EXISTS "+name+"("
					+ "name char(20) NOT NULL,"
					+ "buckwheat binary(2),"
					+ "wheat binary(2),"
					+ "soybean binary(2),"
					+ "walnut binary(2),"
					+ "peanut binary(2),"
					+ "peach binary(2),"
					+ "tomato binary(2),"
					+ "pork binary(2),"
					+ "poultry binary(2),"
					+ "milk binary(2),"
					+ "chiken binary(2),"
					+ "beef binary(2),"
					+ "shrimp binary(2),"
					+ "mackerel binary(2),"
					+ "mussel binary(2),"
					+ "abalon binary(2),"
					+ "oyster binary(2),"
					+ "shellfish binary(2),"
					+ "crab binary(2),"
					+ "squid binary(2),"
					+ "cucumber binary(2),"
					+ "onion binary(2),"
					+ "carrot binary(2),"
					+ "branch binary(2),"
					+ "broccoli binary(2),"
					+ "seaweed binary(2),"
					+ "mushroom binary(2),"
					+ "coriander binary(2)"
					+ ");";
			stmt = conn.createStatement();
			stmt.execute(statement);
			
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
		
		return true;
	}
	
	public int findRestaurants(float latitude, float longitude) {
		int number = 0;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			float latitude_upper_bound = (float) (latitude + 0.003);
			float latitude_lower_bound = (float) (latitude - 0.003);
			float longitude_upper_bound = (float) (longitude + 0.003);
			float longitude_lower_bound = (float) (longitude - 0.003);
			
			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "SELECT * FROM restaurant WHERE latitude < ? AND latitude > ? AND longitude < ? AND longitude > ?";
			
			pstmt = conn.prepareStatement(statement);
			pstmt.setFloat(1, latitude_upper_bound);
			pstmt.setFloat(2, latitude_lower_bound);
			pstmt.setFloat(3, longitude_upper_bound);
			pstmt.setFloat(4, longitude_lower_bound);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.name = rs.getString("name");
				restaurant.latitude = Float.parseFloat(rs.getString("latitude"));
				restaurant.longitude = Float.parseFloat(rs.getString("longitude"));
				
				restaurants.add(restaurant);
				System.out.println(restaurant.latitude);
				System.out.println(restaurant.longitude);
			}
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
		int result = restaurants.size();
		return result;
	}
	
	public float getLatitude(int i) {
		return restaurants.get(i).latitude;
	}
	public float getLongitude(int i) {
		return restaurants.get(i).longitude;
	}
	public String getName(int i) {
		return restaurants.get(i).name;
	}
	
}