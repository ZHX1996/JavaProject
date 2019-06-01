package testThreadWaitNotify;

public class Watcher implements Runnable{
	private Movie movie;
	
	public Watcher(Movie movie) {
		super();
		this.movie = movie;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			movie.watch();
		}
	}
}
