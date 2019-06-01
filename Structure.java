public class Structure{
	public static void main(String args[]){
		Dev a = new Dev();
		String s = "s";
		Dev b = new Dev(s);
	}
}

class Dev{
	static {
		System.out.println("static code block");
	}
	
	{
		System.out.println("structure code block");
	}
	
	public Dev(){
		System.out.println("structure function without parameter");
	}
	
	public Dev(String name){
		System.out.println("structure function with parameter");
	}
}

