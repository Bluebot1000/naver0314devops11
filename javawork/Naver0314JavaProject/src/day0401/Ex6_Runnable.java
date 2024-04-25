package day0401;

public class Ex6_Runnable implements Runnable {
	private String threadName;
	private int count;
	
	public Ex6_Runnable(String threadName,int count) {
		// TODO Auto-generated constructor stub
		this.threadName=threadName;
		this.count=count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=count;i++)
		{
			System.out.println(threadName+":"+i);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_Runnable a=new Ex6_Runnable("1번쓰레드", 300);
		Ex6_Runnable b=new Ex6_Runnable("1번쓰레드", 300);
		Ex6_Runnable c=new Ex6_Runnable("1번쓰레드", 300);
		
		Thread th1=new Thread(a);
		Thread th2=new Thread(b);
		Thread th3=new Thread(c);
		
		th1.start();
		th2.start();
		th3.start();
	}

}
