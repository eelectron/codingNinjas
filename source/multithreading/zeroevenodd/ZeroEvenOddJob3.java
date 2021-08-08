package source.multithreading.zeroevenodd;

/*
 * Only calls getOdd()*/
public class ZeroEvenOddJob3 implements Runnable{
	private ZeroEvenOdd zeo;
	public ZeroEvenOddJob3(ZeroEvenOdd zeo) {
		this.zeo = zeo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			zeo.getOdd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}