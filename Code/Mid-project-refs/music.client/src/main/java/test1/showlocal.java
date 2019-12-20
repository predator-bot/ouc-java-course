package test1;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;


public class showlocal {
	int i=0;
	int getvalue=0;
	List<String> l=new ArrayList<>();
	//List<String>m=new ArrayList<>();
	@SuppressWarnings("rawtypes")
	JList list=new JList();
	String []cname;
	String []time;
	String []mname;
	String []sname;
	String []contents;
	//String [][]mname=new String[this.getsum()][];//歌单内的歌曲名
	//String [][]sname=new String[this.getsum()][];
	public showlocal(){
		try {
			this.getcontent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void getcontent() throws SQLException {
		String url="jdbc:sqlite:D:/local.db";
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
		List<String>n=new ArrayList<>();
		List<String>d=new ArrayList<>();
		ResultSet rs=null;
		try {
			rs = state.executeQuery("select * from MUSICSHEET;");
			while(rs.next()) {
				l.add(rs.getString("NAME"));
				n.add(rs.getString("CREATOR"));
				d.add(rs.getString("DATECREATED"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		String[]content=l.toArray(new String[l.size()]);
		String[]creator=n.toArray(new String[n.size()]);
		String[]date=d.toArray(new String[d.size()]);
		contents=content.clone();
		cname=creator.clone();
		time=date.clone();
		list.setListData(content);
	}
	/*
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
			rs.last();
			total = rs.getRow();  
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
	*/
	public void getmusic(int t) {
		String url="jdbc:sqlite:D:/local.db";
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
		List<String>m=new ArrayList<>();
		List<String>s=new ArrayList<>();
		ResultSet rs=null;
		try {
			t=t+1;
			rs = state.executeQuery("select * from MUSICITEMS where MID="+t+" ;");
			while(rs.next()) {
				String mid=rs.getString("MUSIC");
				m.add(this.musicname(mid));
				s.add(this.singer(mid));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []m1=m.toArray(new String[m.size()]);
		String []m2=s.toArray(new String[s.size()]);
		mname=m1.clone();
		sname=m2.clone();
	}
	
	public Object[][] click(MouseEvent e) {
		getvalue= list.getSelectedIndex();
		this.getmusic(getvalue);
		Object[][] musicDatam=new Object[mname.length][4];
		for(int j=0;j<mname.length;j++) {
			musicDatam[j][0]=mname[j];
			musicDatam[j][1]=" ";
			musicDatam[j][2]=" ";
			musicDatam[j][3]=" ";
		}
		/*
		for(int j=0;j<mname[getvalue].length;j++) {
			musicDatam[j][0]=mname[getvalue][j];
			musicDatam[j][1]=sname[getvalue][j];
			musicDatam[j][2]=" ";
			musicDatam[j][3]=" ";
		}*/
		return musicDatam;
		//music=musicDatam;
		//list.getSelectedValue()
	}
	
	public String musicname(String s) {
		if(s.contains("-")) {
		String[]a=s.split("-");
		if(a[1].substring(0, 1)==" ") {
		a[1]=a[1].substring(1);
		return a[1];
		}
		else return a[1];
		}
		else return s;
	}
	
	public String singer(String s) {
		if(s.contains("-")) {
		String []a=s.split("-");
		return a[0];
		}
		else {
			return null;
		}
	}
	
	public String setlabel(MouseEvent e) {
		getvalue=list.getSelectedIndex();
		String label1=contents[getvalue];
		return label1;
	}
	
	public String setcrea(MouseEvent e) {
		getvalue=list.getSelectedIndex();
		String cre;
		if(getvalue>=0) {
		String []t=time[getvalue].split(" ");
		String []date=t[0].split("-");
		cre=cname[getvalue]+" 于"+date[0]+"年"+date[1]+"月"+date[2]+"日 创建";
		}
		else {
			cre=cname[getvalue]+" 于2019年1月1日 创建";
		}
		return cre;
	}
}
