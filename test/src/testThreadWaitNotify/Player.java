package testThreadWaitNotify;

public class Player implements Runnable{
	private Movie movie;
	
	public Player(Movie movie) {
		super();
		this.movie = movie;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				movie.play("左青龙");
			}
			else {
				movie.play("右白虎");
			}
		}
	}
}
