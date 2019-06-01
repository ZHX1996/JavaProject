package testThreadWaitNotify;

public class Entrance {
	public static void main(String[] args) {
		Movie m = new Movie();
		
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		new Thread(p).start();
		new Thread(w).start();
	}

}
