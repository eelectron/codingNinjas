package multithreading.zeroevenodd.src;

/*
 * Only calls getZero() */
public class ZeroEvenOddJob1 implements Runnable{
	private ZeroEvenOdd zeo;
	public ZeroEvenOddJob1(ZeroEvenOdd zeo) {
		this.zeo = zeo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			zeo.getZero();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}