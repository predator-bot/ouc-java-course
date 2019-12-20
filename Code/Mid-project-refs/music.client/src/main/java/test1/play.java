package test1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class PlayThread extends Thread {
	Player player = null;

	public PlayThread(Player player) {
		this.player = player;
	}

	@Override
	public void run() {

		synchronized (player) {
			try {
				player.wait();
				player.play();
				player.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

/*class ControlThread extends Thread {
	Player player = null;

	public ControlThread(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
				if (i == 1) {
					synchronized (player) {
						try {
							player.notify();
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			
				if (i == 4) {
					synchronized (player) {
						try {
							player.wait();
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}

			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(player.getPosition());
		}
	}
}*/

public class play {

	public play() {}

	public void iplay(String filename){
		BufferedInputStream buffer=null;
		try {
			buffer = new BufferedInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Player player=null;
		try {
			player = new Player(buffer);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread playThread = new PlayThread(player);
		//Thread controlThread = new ControlThread(player);

		playThread.start();
		//controlThread.start();

	}
}