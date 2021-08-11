package source.array;

import java.util.HashSet;
import java.util.Set;

public class SparseVector {
	private int[] nums = null;
    private Set<Integer> nonZeroIndex;
    public SparseVector(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		throw new IllegalArgumentException("Please provide a valid array");
    	}
    	
        this.nums           = nums;
        this.nonZeroIndex   = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nonZeroIndex.add(i);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        Set<Integer> otherNonZeroInd = vec.getNonZeroIndex();
        
        Set<Integer> smallVec = nonZeroIndex;
        if(otherNonZeroInd.size() < smallVec.size()){
            smallVec = otherNonZeroInd;
        }
        
        for(Integer idx : smallVec){
            sum += nums[idx] * vec.getItem(idx);
        }
        return sum;
    }
    
    public Set<Integer> getNonZeroIndex(){
        return nonZeroIndex;
    }
    
    public int getItem(int idx){
        return nums[idx];
    }
}