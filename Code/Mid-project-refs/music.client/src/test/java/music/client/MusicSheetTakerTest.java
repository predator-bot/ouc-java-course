package music.client;

import java.util.Iterator;

import ouc.cs.course.java.httpclient.MusicSheetTaker;
import ouc.cs.course.java.model.MusicSheet;

/**
 * MusicSheetTaker ������
 */
public class MusicSheetTakerTest {
	private static final String URL = "http://service.uspacex.com/music.server/queryMusicSheets?type=top20";

	public static void main(String[] args) throws Exception {

		/**
		 * ��ѯ��ȡ�������ֵ���UUID������
		 * 
		 */
		for (MusicSheet ms : MusicSheetTaker.queryMusicSheets(URL)) {
			Iterator<String> it = ms.getMusicItems().keySet().iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			//System.out.println("[UUID] " + ms.getUuid() + "\t[Music sheet name] " + ms.getName());
		}

	}
}