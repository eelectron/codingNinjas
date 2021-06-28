package array.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentScore {
	public int getBestAverageScore(String[][] scores) {
		Map<String, List<Integer>> students = new HashMap<>();
        int n = scores.length;
        if(n == 0){
            return 0;
        }

        String name = "";
        int score = 0;
        for(int i = 0; i < n; i++){
            name    = scores[i][0];
            score = Integer.parseInt(scores[i][1]);
            
            List<Integer> scoreList = students.get(name);
            if(scoreList == null){
                scoreList = new ArrayList<>();    // using min heap
                students.put(name, scoreList);
            }
            scoreList.add(score);
        }
        
        
        int bestAvg = Integer.MIN_VALUE;
        double curAvg = 0;
        for(Map.Entry<String, List<Integer>> entry : students.entrySet()){
            List<Integer> scoreList = entry.getValue();
            curAvg = scoreList.stream().mapToInt(x -> x).sum();
            curAvg = Math.floor(curAvg / scoreList.size());
            if(curAvg > bestAvg) {
            	bestAvg = (int)curAvg;
            }
        }
		return bestAvg;
	}
}