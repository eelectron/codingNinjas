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
		if(scores == null || scores.length == 0 || scores[0].length == 0) {
			return 0;
		}
		
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