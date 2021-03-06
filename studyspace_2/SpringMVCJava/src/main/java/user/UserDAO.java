package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL="jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID); //위에 String SQL에다가 사용한 물음표 대신에 userID가 들어가고 데이터베이스에 userID가 있다면 비번을 가져오는 방식
			rs=pstmt.executeQuery(); // 가져온 결과를 rs에 저장하는ㄴ 것
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword))
					return 1;//로그인 성공
				else
					return 0;// 비밀번호는 존재하지만 비밀번호가 일치하지않는 부분
			}
			return -1; // rs.next()는 결곽값이 존재해야 다음으로 넘어가는 것인데 만약 아이디가 없다면 그대로 return -1을 반환한다
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	public int join(User user) {
		String SQL="INSERT INTO USER VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserID());
			pstmt.setString(2,user.getUserPassword());
			pstmt.setString(3,user.getUserName());
			pstmt.setString(4,user.getUserGender());
			pstmt.setString(5,user.getUserEmail());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
