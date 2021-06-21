package jsp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
		String ingredient;
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
		//System.out.println("DB연결 성공");
		
		return conn;
	}
	
	public boolean register(String name, float latitude, float longitude) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnection();
			stmt = conn.createStatement();
			String statement = "SELECT * FROM restaurant WHERE name = ?";
			pstmt = conn.prepareStatement(statement);
			pstmt.setString(1, name);
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
			else {
				//return false;
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
				String ingredient = "";
				Restaurant restaurant = new Restaurant();
				restaurant.name = rs.getString("name");
				restaurant.latitude = Float.parseFloat(rs.getString("latitude"));
				restaurant.longitude = Float.parseFloat(rs.getString("longitude"));
				ingredient += rs.getString("buckwheat");
				ingredient += rs.getString("wheat");
				ingredient += rs.getString("soybean");
				ingredient += rs.getString("walnut");
				ingredient += rs.getString("peanut");
				ingredient += rs.getString("peach");
				ingredient += rs.getString("tomato");
				ingredient += rs.getString("pork");
				ingredient += rs.getString("poultry");
				ingredient += rs.getString("milk");
				ingredient += rs.getString("chiken");
				ingredient += rs.getString("beef");
				ingredient += rs.getString("shrimp");
				ingredient += rs.getString("mackerel");
				ingredient += rs.getString("mussel");
				ingredient += rs.getString("abalon");
				ingredient += rs.getString("oyster");
				ingredient += rs.getString("shellfish");
				ingredient += rs.getString("crab");
				ingredient += rs.getString("squid");
				ingredient += rs.getString("cucumber");
				ingredient += rs.getString("onion");
				ingredient += rs.getString("carrot");
				ingredient += rs.getString("branch");
				ingredient += rs.getString("broccoli");
				ingredient += rs.getString("seaweed");
				ingredient += rs.getString("mushroom");
				ingredient += rs.getString("coriander");
				restaurant.ingredient = ingredient;
				restaurants.add(restaurant);
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
	public boolean isSafe(String avoidence, int num) {
		String ingredient = restaurants.get(num).ingredient;
		for(int i = 0; i < avoidence.length(); i++) {
			int j = i * 2 + 1;
			if((avoidence.charAt(i) == '1') && (ingredient.charAt(j) == '1') ) {
				return true;
			}
			
		}
		return false;
	}
	public void maketable( String name) {
		int number = 0;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			String statement;
			conn = getConnection();
			stmt = conn.createStatement();
		
			statement = "CREATE TABLE IF NOT EXISTS "+name+"("
					+ "restaurant char(30) NOT NULL,"
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
			
			stmt.execute(statement);
			System.out.println(name);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
	}
	public void drop(String name) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			String statement;
			conn = getConnection();
			stmt = conn.createStatement();
		
			statement = "DROP TABLE "+name+";";
			
			stmt.execute(statement);
			System.out.println(name);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
	}
	
	public String getMenu(String name) {
		String out="";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			String statement;
			conn = getConnection();
			stmt = conn.createStatement();
		
			statement = "SELECT * FROM menu WHERE restaurant = ?";
			pstmt = conn.prepareStatement(statement);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				out += ",";
				out += rs.getString("name");//,name*재료유무(0010...) 의 형식
				out += "&";
				out += rs.getString("buckwheat");
				out += rs.getString("wheat");
				out += rs.getString("soybean");
				out += rs.getString("walnut");
				out += rs.getString("peanut");
				out += rs.getString("peach");
				out += rs.getString("tomato");
				out += rs.getString("pork");
				out += rs.getString("poultry");
				out += rs.getString("milk");
				out += rs.getString("chiken");
				out += rs.getString("beef");
				out += rs.getString("shrimp");
				out += rs.getString("mackerel");
				out += rs.getString("mussel");
				out += rs.getString("abalon");
				out += rs.getString("oyster");
				out += rs.getString("shellfish");
				out += rs.getString("crab");
				out += rs.getString("squid");
				out += rs.getString("cucumber");
				out += rs.getString("onion");
				out += rs.getString("carrot");
				out += rs.getString("branch");
				out += rs.getString("broccoli");
				out += rs.getString("seaweed");
				out += rs.getString("mushroom");
				out += rs.getString("coriander");
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		}
		catch(SQLException e) {
			System.out.println("sql error");
		}
		
		return out;
	}
	public void addMenu(String restaurant, String menu, String ingredient) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String statement = "INSERT INTO menu VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				
		try {
			conn = getConnection();//menu 테이블 에 메뉴 추가
			pstmt = conn.prepareStatement(statement);
			pstmt.setString(1, restaurant);
			pstmt.setString(2, menu);
			for (int i = 1; i <= 28; i++){
				pstmt.setString(i+2, ingredient.substring(2*i-2, 2*i));
			}
			pstmt.executeUpdate();
			
			System.out.println("0");
			//restaurant테이블에서 재료상황 가져오기
			statement = "SELECT * FROM restaurant WHERE name=?;";
			pstmt = conn.prepareStatement(statement);
			pstmt.setString(1, restaurant);
			rs = pstmt.executeQuery();
			String out = "";
			while(rs.next()) {
				out += rs.getString("buckwheat");
				out += rs.getString("wheat");
				out += rs.getString("soybean");
				out += rs.getString("walnut");
				out += rs.getString("peanut");
				out += rs.getString("peach");
				out += rs.getString("tomato");
				out += rs.getString("pork");
				out += rs.getString("poultry");
				out += rs.getString("milk");
				out += rs.getString("chiken");
				out += rs.getString("beef");
				out += rs.getString("shrimp");
				out += rs.getString("mackerel");
				out += rs.getString("mussel");
				out += rs.getString("abalon");
				out += rs.getString("oyster");
				out += rs.getString("shellfish");
				out += rs.getString("crab");
				out += rs.getString("squid");
				out += rs.getString("cucumber");
				out += rs.getString("onion");
				out += rs.getString("carrot");
				out += rs.getString("branch");
				out += rs.getString("broccoli");
				out += rs.getString("seaweed");
				out += rs.getString("mushroom");
				out += rs.getString("coriander");
			}
			System.out.println(out);
			String ing = "";
			for(int i = 0; i < out.length(); i++) {
				if(out.charAt(i)=='1' || ingredient.charAt(i)=='1') ing += "1";
				else ing += "0";
			}
			

			//restaurant table update
			statement = "UPDATE restaurant SET "
					+ "buckwheat = ?,"
					+ "wheat = ?,"
					+ "soybean =?,"
					+ "walnut =?,"
					+ "peanut =?,"
					+ "peach =?,"
					+ "tomato =?,"
					+ "pork =?,"
					+ "poultry =?,"
					+ "milk =?,"
					+ "chiken =?,"
					+ "beef =?,"
					+ "shrimp =?,"
					+ "mackerel =?,"
					+ "mussel =?,"
					+ "abalon =?,"
					+ "oyster =?,"
					+ "shellfish =?,"
					+ "crab =?,"
					+ "squid =?,"
					+ "cucumber =?,"
					+ "onion =?,"
					+ "carrot =?,"
					+ "branch =?,"
					+ "broccoli =?,"
					+ "seaweed =?,"
					+ "mushroom =?,"
					+ "coriander =?"
					+ " WHERE name = ?;";
	
			pstmt = conn.prepareStatement(statement);
			for (int i = 1; i <= 28; i++){
				pstmt.setString(i, ing.substring(2*i-2, 2*i));
			}
			pstmt.setString(29, restaurant);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로드 실패");
		} catch(SQLException e) {
			System.out.println("sql error");
		}
	}
	
}