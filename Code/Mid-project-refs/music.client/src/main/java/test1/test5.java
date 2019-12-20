package test1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

class test5 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JButton bplay=new JButton();
	JButton stop=new JButton();
	JButton upb=new JButton();
	JButton downp=new JButton();
	JPanel major=new JPanel();
	JPanel control=new JPanel();
	final JSplitPane js1=new JSplitPane();
	final JSplitPane js2=new JSplitPane();
	JSplitPane js3=new JSplitPane();

	showlist listothers=new showlist();
	JScrollPane others=new JScrollPane(listothers.list);
	showlocal listown=new showlocal();
	JScrollPane own=new JScrollPane(listown.list);
	play Iplay=new play();
	File file;
	String temp;
	
	MusicPlayerBlock m=new MusicPlayerBlock();
	
	public test5(){
			super();
			setTitle("Music Player");
			setBounds(100,100,800,600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			init();
			setVisible(true);
	}
		void init() {
			listothers.list.setBackground(Color.yellow);
			listown.list.setBackground(Color.yellow);
			Border titleBorder1=BorderFactory.createTitledBorder("别人都在听");            
			listothers.list.setBorder(titleBorder1);
		    Border titleBorder2=BorderFactory.createTitledBorder("我的歌单");            
		    listown.list.setBorder(titleBorder2);
			
			major.setSize(600, 500);
			major.setBackground(Color.pink);
			control.setSize(800, 100);
			control.setBackground(Color.pink);
			
			m.setBackground(Color.white);
			
			MusicSheetDisplayBlock msdb=new MusicSheetDisplayBlock();
			
			major.add(msdb);
			major.add(m);
			
			listothers.list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					m.refresh(listothers.click(e));
					msdb.fresh(listothers.setlabel(e));
					msdb.fresh2(listothers.setcrea(e));
				}
		    });
			listown.list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					m.refresh(listown.click(e));
					msdb.fresh(listown.setlabel(e));
					msdb.fresh2(listown.setcrea(e));
				}
		    });
			m.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					
				}
			});
			/*
		    listshow2.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					check(e);
				}
		    	public void check(ListSelectionEvent e) {
		    		
		    	}
		    });
			*/
			js1.setOneTouchExpandable(true);
			js1.setContinuousLayout(false);
			js1.setEnabled(false);
			js1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

			js1.setLeftComponent(js2);
			js1.setRightComponent(major);
			js1.setDividerSize(8);
			js1.setDividerLocation(200);
			
			js2.setOneTouchExpandable(true);
			js2.setContinuousLayout(false);
			js2.setEnabled(false);
			js2.setOrientation(JSplitPane.VERTICAL_SPLIT);
			
			js2.setLeftComponent(others);
			js2.setRightComponent(own);
			js2.setDividerSize(8);
			js2.setDividerLocation(320);
			
			js3.setOneTouchExpandable(true);
			js3.setContinuousLayout(false);
			js3.setEnabled(false);
			js3.setOrientation(JSplitPane.VERTICAL_SPLIT);
			
			js3.setLeftComponent(js1);
			js3.setRightComponent(control);
			js3.setDividerSize(8);
			js3.setDividerLocation(500);
			setContentPane(js3);
			
			upb.setBounds(320, 530, 40, 40);
			Icon iconu=new ImageIcon("src/main/java/test1/bu.png");
			upb.setIcon(iconu);
			upb.setOpaque(false);
			upb.setContentAreaFilled(false);
			upb.setFocusPainted(false);
			upb.setBorder(null);
			control.add(upb);
			
			bplay.setBounds(380, 530, 40, 40);
			Icon iconp=new ImageIcon("src/main/java/test1/p.png");
			bplay.setIcon(iconp);
			bplay.setOpaque(false);
			bplay.setContentAreaFilled(false);
			bplay.setFocusPainted(false);
			bplay.setBorder(null);
			bplay.addActionListener(this);
			control.add(bplay);
			
			/*JButton splay=new JButton();
			splay.setBounds(380, 400, 40, 40);
			Icon icons=new ImageIcon("src/player/p.jpg");
			splay.setIcon(icons);
			splay.setOpaque(false);
			splay.setContentAreaFilled(false);
			splay.setFocusPainted(false);
			splay.setBorder(null);
			container.add(splay);*/
			
			stop.setBounds(380, 530, 40, 40);
			Icon icone=new ImageIcon("src/main/java/test1/pause.png");
			stop.setIcon(icone);
			stop.setOpaque(false);
			stop.setContentAreaFilled(false);
			stop.setFocusPainted(false);
			stop.setBorder(null);
			stop.addActionListener(this);
			stop.setVisible(false);
			control.add(stop);
			
			downp.setBounds(440, 530, 40, 40);
			Icon icond=new ImageIcon("src/main/java/test1/bd.png");
			downp.setIcon(icond);
			downp.setOpaque(false);
			downp.setContentAreaFilled(false);
			downp.setFocusPainted(false);
			downp.setBorder(null);
			control.add(downp);
			}
		
		
	public static void main(String[] args) {
		new test5();
	}
	public void actionPerformed(ActionEvent e) {
		//TODO Auto-generated method stub
		if(e.getSource()==bplay) {
			
			bplay.setVisible(false);
		    stop.setVisible(true);
		    temp=m.getname(e);
		    file=new File("/"+temp);
			Iplay.iplay(System.getProperty("user.dir")+ file);
		}
		if(e.getSource()==stop) {
			bplay.setVisible(true);
		    stop.setVisible(false);
		    try {
				Iplay.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==upb) {
			
		}
		if(e.getSource()==downp) {
			
		}
		
	}

}
