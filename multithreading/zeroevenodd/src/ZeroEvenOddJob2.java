package multithreading.zeroevenodd.src;

/*
 * Only calls getEven()*/
public class ZeroEvenOddJob2 implements Runnable{
	private ZeroEvenOdd zeo;
	public ZeroEvenOddJob2(ZeroEvenOdd zeo) {
		this.zeo = zeo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			zeo.getEven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
