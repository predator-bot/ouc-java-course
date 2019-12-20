package music.client;

import ouc.cs.course.java.httpclient.FileDownloader;

/**
 * FileDownloader 测试类
 */
public class FileDownloaderTest {

	public static void main(String[] args) {
		FileDownloader.downloadMusicFile("http://service.uspacex.com/music.server/downloadMusic",
				"9fd7673940ea0e10037daa9c94138011", "D:");

		//FileDownloader.downloadMusicSheetPicture("http://service.uspacex.com/music.server/downloadPicture",
			//	"235edc3a68144beb8e8980e59941c470", "/Users/xiaodong/Downloads");
	}
}