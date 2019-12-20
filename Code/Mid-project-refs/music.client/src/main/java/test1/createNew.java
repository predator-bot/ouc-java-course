package test1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class createNew extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel n=new JLabel("歌单名称");
	JTextField name=new JTextField(80);
	
	JLabel cr=new JLabel("创建者");
	JLabel ci=new JLabel("创建者ID");
	JLabel l=new JLabel("歌曲位置");
	JLabel m=new JLabel("歌曲");
	JTextField creatorid=new JTextField(80);
	JTextField creator=new JTextField(80);
	JTextField location=new JTextField(80);
	JTextArea music=new JTextArea();
	JButton save=new JButton("保存");
	JButton cancel=new JButton("取消");
	public createNew() {
		super();
		Container c=getContentPane();
		//c.setLayout(null);
		setLayout(new GridLayout(6,2,5,5));
		n.setLabelFor(name);
		cr.setLabelFor(creator);
		ci.setLabelFor(creatorid);
		l.setLabelFor(location);
		m.setLabelFor(music);
		setBounds(100, 100, 400, 300);
		c.add(n, BorderLayout.WEST);
	    c.add(name, BorderLayout.CENTER);
	    c.add(ci, BorderLayout.WEST);
	    c.add(creatorid, BorderLayout.CENTER);
	    c.add(cr, BorderLayout.WEST);
	    c.add(creator, BorderLayout.CENTER);
	    c.add(l, BorderLayout.CENTER);
	    c.add(location, BorderLayout.CENTER);
	    c.add(m, BorderLayout.WEST);
	    c.add(music, BorderLayout.CENTER);
	    save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Name=name.getText();
				String Crea=creator.getText();
				String Crid=creatorid.getText();
				String loca=location.getText();
				String []mus=music.getText().split("\n");
				try {
					new addcontent(Name, Crid,Crea,loca,mus);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
	    });
	    cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
	    });
	    c.add(save);
	    c.add(cancel);
	}
}

