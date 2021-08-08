package source.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/submissions/detail/492954779/
 * */
public class LargestHistogram {
    /*
    T : O(n)
    S : O(n)
    */
    public int largestRectangleArea(int[] heights) {
        return largestRectangleAreaStack(heights);
    }
    
    /*
     * Stack approach*/
    private int largestRectangleAreaStack(int[] heights) {
    	if(heights == null || heights.length == 0){
            return 0;
        }
    	
    	List<Integer> hList = new ArrayList<>();
        for(int x: heights){
            hList.add(x);
        }
        
        hList.add(0);
        
        int n = hList.size();
        Stack<Integer> stack = new Stack<>();
        
        int maxArea = 0, topIndex, height, width, area;
        for(int i = 0; i < n; i++){
            while(stack.isEmpty() == false && hList.get(stack.peek()) > hList.get(i)){
                topIndex = stack.pop();
                height = hList.get(topIndex);
                width = i;
                if(stack.isEmpty()){
                    width -= -1;
                }
                else{
                    width -= stack.peek();
                }
                
                width -= 1;
                
                area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
    
    /*
     * Array approach*/
    private int largestRectangleAreaArray(int[] heights) {
    	if(heights == null || heights.length == 0){
            return 0;
        }
        
        int n = heights.length;
        if(n == 1){
            return heights[0];
        }
        
        // find index of first bar in left side whose height is less than current bar
        int[] leftMinBar = new int[n];
        leftMinBar[0] = -1;
        for(int i = 1; i < n; i++){
            int k = i - 1;
            while(k >= 0 && heights[k] >= heights[i]){
                k = leftMinBar[k];
            }
            leftMinBar[i] = k;
        }
        
        // find index of first bar in right side whose height is less than current bar
        int[] rightMinBar = new int[n];
        rightMinBar[n - 1] = n;
        for(int i = n - 2; i >= 0; i--){
            int k = i + 1;
            while(k < n && heights[k] >= heights[i]){
                k = rightMinBar[k];
            }
            rightMinBar[i] = k;
        }
        
        // consider largest rectangle formed by each bar
        int maxArea = 0, curArea = 0;
        for(int i = 0; i < n; i++){
            curArea = heights[i] * (rightMinBar[i] - leftMinBar[i] - 1);
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}