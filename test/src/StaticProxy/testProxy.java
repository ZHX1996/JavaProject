package StaticProxy;
/*
 *   静态代理
 * 真实角色和代理角色实现同一个接口
   *  创建代理角色，传入真实角色的引用
 */
public class testProxy {
	public static void main(String[] args) {
		Marry you = new You();
		weddingCompany com = new weddingCompany(you);
		com.marry();
	}
}

interface Marry{
	public abstract void marry();
}

class You implements Marry{
	@Override
	public void marry() {
		System.out.println("结婚了。。。");
	}
}

class weddingCompany implements Marry{
	private Marry you;

	public weddingCompany() {
		super();
	}

	public weddingCompany(Marry you) {
		super();
		this.you = you;
	}

	public void before() {
		System.out.println("布置房间。。。");
	}
	
	public void after() {
		System.out.println("打扫卫生。。。");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
}