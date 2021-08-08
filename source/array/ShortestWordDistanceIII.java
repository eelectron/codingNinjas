package source.array;

/*
 * https://leetcode.com/submissions/detail/502781971/
 * Idea : keep most recent occurence
 * */
class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        boolean isSame = word1.equals(word2);
        int minDis = n;
        int ind1 = -1, ind2 = -1;
        String cs = "";
        for(int i = 0; i < n; i++){
            cs = wordsDict[i];
            if(isSame){
                if(cs.equals(word1)){
                    if(ind1 == -1){
                        ind1 = i;
                    }
                    else if(ind2 == -1){
                        ind2 = i;
                    }
                    else{
                        ind1 = ind2;
                        ind2 = i;
                    }
                }
            }
            else{
                if(cs.equals(word1)){
                    ind1 = i;
                }
                
                if(cs.equals(word2)){
                    ind2 = i;
                }
            }
            
            if(ind1 != -1 && ind2 != -1){
                minDis = Math.min(minDis, Math.abs(ind1 - ind2));
            }
        }
        return minDis;
    }
}