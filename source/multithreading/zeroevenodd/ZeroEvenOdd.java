package source.multithreading.zeroevenodd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
	private List<Integer> nums;
	private Semaphore zeroSem, evenSem, oddSem;
	private List<Integer> output;
	// 0 1 3 5 7 3 0 3 0 3 5
	// 0 1 3 5 7 3 0 3 0 3 5
	public ZeroEvenOdd(List<Integer> nums) {
		this.nums = nums;
		zeroSem = new Semaphore(0);		// 0
		evenSem = new Semaphore(0);		// 0
		oddSem = new Semaphore(0);		// 0
		
		output = new ArrayList<>();
		
		if(nums == null || nums.size() == 0) {
			return;
		}
		
		int item = nums.get(0);
		release(item);
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
	 * Only prints 0 */
	public void getZero() throws InterruptedException {
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) == 0) {
				zeroSem.acquire();
				addToList(nums.get(i));
				
				if(i + 1 < nums.size()) {
					release(nums.get(i + 1));
				}
			}
		}
	}
	
	

	/*
	 * Only prints even number except 0*/
	public void getEven() throws InterruptedException {
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) != 0 && nums.get(i) % 2 == 0) {
				evenSem.acquire();
				addToList(nums.get(i));
				
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
				addToList(nums.get(i));
				
				if(i + 1 < nums.size()) {
					release(nums.get(i + 1));
				}
			}
		}
	}
	
	private synchronized void addToList(int e) {
		output.add(e);
	}
	
	public String toString() {
		return output.toString();
	}
}