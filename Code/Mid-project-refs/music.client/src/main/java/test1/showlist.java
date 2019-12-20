package test1;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;
import ouc.cs.course.java.model.MusicSheet;
import ouc.cs.course.java.musicclient.MusicOperationClient;

public class showlist{
	@SuppressWarnings("rawtypes")
	JList list=new JList();
		MusicOperationClient mclient = new MusicOperationClient();
		List<MusicSheet> m = mclient.queryAllMusicSheets();
		String[] contents=new String[m.size()];
		int sum[]=new int[m.size()];
		int getvalue=0;
		
		String n=null;
		String []cname=new String[m.size()];
		String []time=new String[m.size()];
		String [][]mname=new String[m.size()][];//歌单内的歌曲名
		String [][]sname=new String[m.size()][];
		String [][]musicmd5=new String[m.size()][];
		//String []picture=new String[m.size()];
		int z=0;
		int size;
		@SuppressWarnings("unchecked")
		public showlist() {
			for(MusicSheet ms : m) {
				contents[z]=ms.getName();
				String []q1=new String[ms.getMusicItems().size()];
				String []q2=new String[ms.getMusicItems().size()];
				String []q4=new String[ms.getMusicItems().size()];
				String q3=ms.getCreator();
				time[z]=ms.getDateCreated();
				//picture[z]=ms.getPicture();
				int i=0;
				for(String key: ms.getMusicItems().keySet()) {
					q1[i]=this.musicname(ms.getMusicItems().get(key));
					q2[i]=this.singer(ms.getMusicItems().get(key));
					q4[i]=key;
					i++;
				}
				sum[z]=i;
				mname[z]=q1.clone();
				sname[z]=q2.clone();
				cname[z]=q3;
				musicmd5[z]=q4.clone();
				z++;
			}
			list.setListData(contents);
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
		public Object[][] click(MouseEvent e) {
			getvalue= list.getSelectedIndex();
			Object[][] musicDatam=new Object[mname[getvalue].length][4];
			for(int j=0;j<mname[getvalue].length;j++) {
				musicDatam[j][0]=mname[getvalue][j];
				musicDatam[j][1]=sname[getvalue][j];
				musicDatam[j][2]=" ";
				musicDatam[j][3]=" ";
			}
			return musicDatam;
			//music=musicDatam;
			//list.getSelectedValue()
		}
		public String setlabel(MouseEvent e) {
			getvalue=list.getSelectedIndex();
			String label1=contents[getvalue];
			return label1;
		}
		public String setcrea(MouseEvent e) {
			getvalue=list.getSelectedIndex();
			String cre;
			if(getvalue>=1&&getvalue!=289&&getvalue!=406&&getvalue!=414) {
			String []t=time[getvalue].split(" ");
			String []date=t[0].split("-");
			cre=cname[getvalue]+" 于"+date[0]+"年"+date[1]+"月"+date[2]+"日 创建";
			}
			else {
				cre=cname[getvalue]+" 于2019年1月1日 创建";
			}
			return cre;
		}
		public String []getmd5(int t){
			String []a=new String[musicmd5[t].length];
			a=musicmd5[t].clone();
			return a;
		}
		/*
		public String setpic(MouseEvent e) {
			getvalue=list.getSelectedIndex();
			String pic;
			if(picture[getvalue]!=null) {
				pic=picture[getvalue];
			}
			else{
				pic="D:/2.jpg";
			}
			return pic;
		}
		*/
}
