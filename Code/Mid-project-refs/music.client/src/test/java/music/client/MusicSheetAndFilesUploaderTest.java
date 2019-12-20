package music.client;

import java.util.ArrayList;
import java.util.List;

import ouc.cs.course.java.httpclient.MusicSheetAndFilesUploader;
import ouc.cs.course.java.model.MusicSheet;

public class MusicSheetAndFilesUploaderTest {
	public static void main(String[] args) {
		//String url = "http://localhost:8080/music.server/upload";
		String url = "http://service.uspacex.com/music.server/upload";

		List<String> filePaths = new ArrayList<String>();
		/*
		filePaths.add("/Users/xiaodong/Music/Beyond/无声的告别.mp3");
		filePaths.add("/Users/xiaodong/Music/Beyond/AMANI.mp3");
		filePaths.add("/Users/xiaodong/Music/Beyond/命运是你家.mp3");
		filePaths.add("/Users/xiaodong/Music/Beyond/长城.mp3");
		filePaths.add("/Users/xiaodong/Music/Beyond/谁伴我闯荡.mp3");
		filePaths.add("/Users/xiaodong/Music/Beyond/旧日的足迹.mp3");
		filePaths.add("/Users/xiaodong/Music/Beyond/光辉岁月.mp3");
		
		filePaths.add("/Users/xiaodong/Music/guns and roses/14 Years.mp3");
		filePaths.add("/Users/xiaodong/Music/guns and roses/Breakdown.mp3");
		filePaths.add("/Users/xiaodong/Music/guns and roses/Estranged.mp3");
		filePaths.add("/Users/xiaodong/Music/guns and roses/Knockin' On Heaven's Door.mp3");
		*/
		
		filePaths.add("E:/Download/古巨基 - Monica.mp3");
		filePaths.add("E:/Download/古巨基 - 爱得太迟.mp3");
		filePaths.add("E:/Download/古巨基 - 爱与诚.mp3");
		filePaths.add("E:/Download/古巨基 - 告别我的恋人们.mp3");
		filePaths.add("E:/Download/古巨基 - 花洒.mp3");
		filePaths.add("E:/Download/古巨基 - 劲歌金曲.mp3");
		filePaths.add("E:/Download/古巨基 - 情歌王.mp3");
		filePaths.add("E:/Download/古巨基 - 情人(live).mp3");

		
		MusicSheet ms = new MusicSheet();
		// ms.setUuid("cddc055bfa33439a889cb611c1cb6db2");
		ms.setCreatorId("18020031100");
		//ms.setPicture("/Users/xiaodong/Music/Beyond/fig-beyond-band.jpg");
		//ms.setPicture("/Users/xiaodong/Music/guns and roses/fig-guns and roses.jpg");
		ms.setPicture("C:/Users/13361/Pictures/Saved Pictures/T002R800x800M000003otvdv2xyQGz.jpg");
		
		ms.setCreator("Yang Yao");
		ms.setName("古巨基必听的几首歌");

		MusicSheetAndFilesUploader.createMusicSheetAndUploadFiles(url, ms, filePaths);
	}
}
