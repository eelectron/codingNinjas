package source.array;

/*
 * https://leetcode.com/submissions/detail/502743473/
 * Idea : keep the most recent index of both words seen so far
 * */
class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int wi1 = -1, wi2 = -1;
        int n = wordsDict.length;
        int shortDis = n;
        
        String curStr = "";
        for(int i = 0; i < n; i++){
            curStr = wordsDict[i];
            if(curStr.equals(word1)){
                wi1 = i;
            }
            
            if(curStr.equals(word2)){
                wi2 = i;
            }
            
            if(wi1 != -1 && wi2 != -1){
                shortDis = Math.min(shortDis, Math.abs(wi1 - wi2));
            }
        }
        return shortDis;
    }
}