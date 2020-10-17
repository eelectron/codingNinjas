package graph;

import java.util.Scanner;

public class LargestPiece {
	   int getCount(String[] C, int x, int y, boolean[][] v){
	        if(x < 0 || x >= C.length || y < 0 || y >= C[x].length() || v[x][y] == true || C[x].charAt(y) == '0'){
	            return 0;
	        }
	        
	        int count = 1;
	        v[x][y] = true;
	        count += getCount(C, x - 1, y, v);
	        count += getCount(C, x + 1, y, v);
	        count += getCount(C, x, y - 1, v);
	        count += getCount(C, x, y + 1, v);
	        return count;
	    }
	    
	    public int solve(int n, String cake[]) {
	        int maxSize = 0;
	        boolean[][] v = new boolean[n][n];
	        
	        for(int i = 0; i < n; i++){
	        	for(int j = 0; j < n; j++){
	                if(v[i][j] == false){
	                	int ans = getCount(cake, i, j, v);
	                	maxSize = Math.max(maxSize, ans);    
	                }
	            }    
	        }
	        return maxSize;
	    }
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n;
			Scanner scan = new Scanner(System.in);
			n = scan.nextInt();
			scan.nextLine();
			
			String[] C = new String[n];
			for(int i=0;i<n;i++){
				C[i]=scan.nextLine();
			}
			
			LargestPiece lp = new LargestPiece();
			System.out.println(lp.solve(n, C));
		}
}
