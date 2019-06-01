package testThread01;

public class game {
	public static void main(String[] args) {
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
		
		rab.start();
		tor.start();
		
		for(int i=0;i<100;i++) {
			System.out.println("main====>" + i);
		}
	}

}
