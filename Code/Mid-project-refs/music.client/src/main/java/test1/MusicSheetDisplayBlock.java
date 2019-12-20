package test1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ouc.cs.course.java.httpclient.FileDownloader;

public class MusicSheetDisplayBlock extends JPanel {
	showlist l=new showlist(); 
	int click=0;
	private static final long serialVersionUID = 1L;
	private String picPath = "D:/2.jpg";
	JLabel musicSheetTitleLabel;
	JLabel musicSheetCreatorLabel;
	JLabel musicSheetPictureLabel;
	
	public MusicSheetDisplayBlock() {
		this.setPreferredSize(new Dimension(550, 200));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon musicSheetPicture = new ImageIcon(picPath);
		int musicSheetPictureWidth = 250;
		int musicSheetPictureHeight = 250 * musicSheetPicture.getIconHeight() / musicSheetPicture.getIconWidth();
		musicSheetPicture.setImage(musicSheetPicture.getImage().getScaledInstance(musicSheetPictureWidth,
				musicSheetPictureHeight, Image.SCALE_DEFAULT));

		musicSheetPictureLabel = new JLabel(musicSheetPicture);
		musicSheetPictureLabel.setPreferredSize(new Dimension(musicSheetPictureWidth, musicSheetPictureHeight));
		
		JPanel musicSheetInfoPanel = new JPanel();
		musicSheetInfoPanel.setPreferredSize(new Dimension(250, 200));
		musicSheetInfoPanel.setLayout(new BoxLayout(musicSheetInfoPanel, BoxLayout.Y_AXIS));

		//此处应该与其他类进行连接，从而实现点击出现相应界面的操作
		musicSheetTitleLabel = new JLabel("随手取的名字");
		musicSheetCreatorLabel = new JLabel("于2019年12月8日 创建");

		JPanel musicSheetButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton playAllMusicButton = new JButton("播放全部");
		JButton downloadAllMusicButton = new JButton("下载全部");
		JButton CreateButton = new JButton("创建歌单");
		
		musicSheetButtonPanel.add(playAllMusicButton);
		musicSheetButtonPanel.add(downloadAllMusicButton);
		musicSheetButtonPanel.add(CreateButton);
		musicSheetButtonPanel.setOpaque(false);

		musicSheetInfoPanel.add(Box.createVerticalStrut(20));
		musicSheetInfoPanel.add(musicSheetTitleLabel);
		musicSheetInfoPanel.add(Box.createVerticalStrut(10));
		musicSheetInfoPanel.add(musicSheetCreatorLabel);
		musicSheetInfoPanel.add(Box.createVerticalStrut(30));
		musicSheetInfoPanel.add(musicSheetButtonPanel);
		
		musicSheetButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		CreateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new createNew().setVisible(true);
				}
	    });
		
		downloadAllMusicButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				String []a=l.getmd5(click).clone();
				for(int i=0;i<a.length;i++) {
					FileDownloader.downloadMusicFile("http://service.uspacex.com/music.server/downloadMusic",a[i], "D:/music");
				}
			}
		});

		this.add(musicSheetPictureLabel);
		this.add(musicSheetInfoPanel);
		
		musicSheetInfoPanel.setOpaque(false);
		this.setOpaque(false);

	}
	
	public void getclick(int t) {
		click=t;
	}
	
	public void fresh(String s) {
		musicSheetTitleLabel.setText(s);
	}
	
	public void fresh2(String str) {
		musicSheetCreatorLabel.setText(str);
	}
	/*
	public void pict(String str) {
		if(str!=picPath) {
			String[] a=str.split(".");
			FileDownloader.downloadMusicSheetPicture("http://service.uspacex.com/music.server/downloadPicture",a[0],"D:/musicd");
			picPath="D:/musicd"+str;
			ImageIcon musicSheetPicture1 = new ImageIcon(picPath);
			int musicSheetPictureWidth = 250;
			int musicSheetPictureHeight = 250 * musicSheetPicture1.getIconHeight() / musicSheetPicture1.getIconWidth();
			musicSheetPicture1.setImage(musicSheetPicture1.getImage().getScaledInstance(musicSheetPictureWidth,
					musicSheetPictureHeight, Image.SCALE_DEFAULT));

			musicSheetPictureLabel.setIcon(musicSheetPicture1);
			musicSheetPictureLabel.setPreferredSize(new Dimension(musicSheetPictureWidth, musicSheetPictureHeight));
			
		}
	}
	*/
}
