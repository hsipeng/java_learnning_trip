package bean;


public class Proxy implements Rent{
	private Host host=new Host();
	public void rent(){
		System.out.println("带客户看房子");
		host.rent();
		System.out.println("收取中介费");
		
	}
	
}
