package test1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MusicPlayerBlock extends JPanel {

	private static final long serialVersionUID = 1L;
	//Object[][] singerData=new Object[l.size][];
	private String[] musicColumnNames = { "曲名", "歌手","下载","播放"};
	//showlist list1=new showlist();
	int i=0;
	Object[][]musicData=new Object[1][4];
	JTable musicTable;
	//尝试一下将showlist里的object直接导入，将musictable内容放到函数中，
	public MusicPlayerBlock() {
		this.setPreferredSize(new Dimension(550, 300));
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		musicData[0][0]="a";
		musicData[0][1]="b";
		musicData[0][2]="c";
		musicData[0][3]="d";
		//for(int i=0;i<l.z;i++) {
			//musicData[i]=new Object[4];
			
		//}
		
		
		//JTable musicTable = new JTable(musicData, musicColumnNames);
		DefaultTableModel dtm=new DefaultTableModel(musicData,musicColumnNames);//定义表格模型
		musicTable=new JTable(dtm);//根据表格模型创建表格
		musicTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//musicTable.setShowGrid(false);
		
		musicTable.getTableHeader().setOpaque(false);
		musicTable.setOpaque(false);
		
		
		JScrollPane musicTablePanel = new JScrollPane(musicTable);
		musicTablePanel.setOpaque(false);
		musicTablePanel.setViewportView(musicTable);
		musicTablePanel.setOpaque(false);
		
		this.add(musicTablePanel);
		this.setOpaque(false);
		
	}
	
	public void refresh(Object[][] a) {
		
		DefaultTableModel dtm2=(DefaultTableModel)musicTable.getModel();//获取表格模型

		dtm2.setDataVector(a,musicColumnNames);//设置新内容

		dtm2.fireTableStructureChanged();//更新显示
	}
	
	public String getname(ActionEvent e) {
		int getvalue=this.musicTable.getSelectedRow();
		DefaultTableModel dtm = (DefaultTableModel) this.musicTable.getModel();
		String value = (String) dtm.getValueAt(getvalue, 0);
		String value1=(String) dtm.getValueAt(getvalue, 1);
		value=value1+"-"+value;
		return value;
	}
}