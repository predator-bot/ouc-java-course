package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addcontent {
	public addcontent(String n,String ci,String c,String d,String []m) throws SQLException {
		String url="jdbc:sqlite:D:/local.db";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateCreated = formatter.format(new Date());
		try {
		Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		Statement state = null;
		try {
		state = conn.createStatement();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		ResultSet rs=null;
		try {
			rs = state.executeQuery("select * from MUSICSHEET;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int q=this.getsum();
		state.executeUpdate( "insert into MUSICSHEET values("+(q+1) +",'"+n+"','"+ci+"','"+c+"','"+d+"','"+dateCreated+"','p.jpg');");
		for(int i=0;i<m.length;i++) {
		state.executeUpdate( "insert into MUSICITEMS values("+(q+1)+",'"+m[i]+"');");
		}
		rs.close();
		conn.close();
	}
	public int getsum() {
		String url="jdbc:sqlite:D:/local.db";
		int total=0;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement state = null;
		try {
			state = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs=null;
		try {
			rs = state.executeQuery("select * from MUSICSHEET;");
			while(rs.next()) {
				++total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
}
