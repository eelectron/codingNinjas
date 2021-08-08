package source.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Get the best average score of given students 
 * https://leetcode.com/problems/high-five/
 * */
public class StudentScore {
	public int getBestAverageScore(String[][] scores) {
		// Todo
		Map<String, Student> students = new HashMap<>();
        int n = scores.length;
        if(n == 0){
            return 0;
        }
        int bestAvg = Integer.MIN_VALUE;
        int curAvg = 0;
        
        String name = "";
        double score = 0;
        for(int i = 0; i < n; i++){
            name    = scores[i][0];
            score = Integer.parseInt(scores[i][1]);
            
            Student stud = students.get(name);
            if(stud == null){
                stud = new Student(0, 0);
                students.put(name, stud);
            }
            
            // find the moving average
            stud.count += 1;
            stud.avg = (((stud.count - 1) * stud.avg) + score) / stud.count;
            /*if((int)stud.avg > bestAvg) {
            	bestAvg = (int)stud.avg;
            }*/
        }
        
        
        for(Map.Entry<String, Student> entry : students.entrySet()){
            Student stud = entry.getValue();
            curAvg = (int)Math.floor(stud.avg);
            if(curAvg > bestAvg) {
            	bestAvg = curAvg;
            }
        }
		return (int)bestAvg;
	}
	
	public static void main(String[] args){
		StudentScore ss = new StudentScore();
	    System.out.println("Hello");
	    ss.testGetBestAverageScore();
	  }
	  
	  public void testGetBestAverageScore() {
	    StudentScore ss = new StudentScore();
	    
	    boolean res = true;
	    String[][] tc1 = {{"Bobby", "2"},{"Bobby", "2"}};
	    res = res && (2 == ss.getBestAverageScore(tc1));
	    
	    String[][] tc2 = {};
	    res = res && (0 == ss.getBestAverageScore(tc2));
	    
	    String[][] tc3 = {{"Bobby", "2"},{"Bobby", "2"},{"Charles", "4"},{"Charles", "4"}};
	    res = res && (4 == ss.getBestAverageScore(tc3));
	    
	    String[][] tc4 = {{"Bobby", "-2"},{"Bobby", "-2"},{"Charles", "-4"},{"Charles", "-4"}};
	    res = res && (-2 == ss.getBestAverageScore(tc4));
	    
	    if(res){
	      System.out.println("All tests pass .");
	    }
	    else{
	      System.out.println("Atleast one test is failing");
	    }
	  }
}

class Student{
	int count;
	double avg;
	Student(int count, double avg){
		this.count = count;
		this.avg = avg;
	}
	
	Student(){
		this.count = 0;
		this.avg = 0;
	}

	@Override
	public String toString() {
		return "Student [count=" + count + ", avg=" + avg + "]";
	}
	
}