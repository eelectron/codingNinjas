package multithreading.zeroevenodd.src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
	private List<Integer> nums;
	private Semaphore zeroSem, evenSem, oddSem;
	private List<Integer> output;
	public ZeroEvenOdd(List<Integer> nums) {
		this.nums = nums;
		zeroSem = new Semaphore(0);
		evenSem = new Semaphore(0);
		oddSem = new Semaphore(0);
		output = new ArrayList<>();
		
		if(nums == null || nums.size() == 0) {
			return;
		}
		
		int item = nums.get(0);
		release(item);
	}
	
	/*
	 * Only prints 0 */
	public void getZero() throws InterruptedException {
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) == 0) {
				zeroSem.acquire();
				//System.out.print(nums.get(i) + " ");
				output.add(nums.get(i));
				if(i + 1 < nums.size()) {
					release(nums.get(i + 1));
				}
			}
		}
	}
	
	/*
	 * Release a resource based on given input
	 * */
	private void release(Integer item) {
		// TODO Auto-generated method stub
		if(item == 0) {
			zeroSem.release();
		}
		else if(item % 2 == 0) {
			evenSem.release();
		}
		else {
			oddSem.release();
		}
	}

	/*
	 * Only prints even number except 0*/
	public void getEven() throws InterruptedException {
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) != 0 && nums.get(i) % 2 == 0) {
				evenSem.acquire();
				//System.out.print(nums.get(i) + " ");
				output.add(nums.get(i));
				if(i + 1 < nums.size()) {
					release(nums.get(i + 1));
				}
			}
		}
	}
	
	/*
	 * Only prints odd number*/
	public void getOdd() throws InterruptedException {
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) != 0 && nums.get(i) % 2 == 1) {
				oddSem.acquire();
				//System.out.print(nums.get(i) + " ");
				output.add(nums.get(i));
				if(i + 1 < nums.size()) {
					release(nums.get(i + 1));
				}
			}
		}
	}
	
	public List<Integer> getOutput(){
		return output;
	}
}