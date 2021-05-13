/* package codechef; // don't place package name! */

package codechef;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    public static void main (String[] args)
    {
        // your code goes here
        Codechef wm = new Codechef();
        wm.readInput();
    }
    
    public void readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            String[] str = new String[N];
            for(int j = 0; j < N; j++){
                str[j] = sc.next();
            }
            
            String name = getWinner(str, A, B);
            System.out.println(name);
        }
    }

    public String getWinner(String[] sa, int A, int B){
        int n = sa.length;
        long scoreA = 0, scoreB = 0;
        boolean[] seen = new boolean[26];
        seen['E' - 'A'] = true;
        seen['Q' - 'A'] = true;
        seen['U' - 'A'] = true;
        seen['I' - 'A'] = true;
        seen['N' - 'A'] = true;
        seen['O' - 'A'] = true;
        seen['X' - 'A'] = true;
        
        int c = 0;
        for(int i = 0; i < n; i++){
            c = sa[i].charAt(0) - 'A';
            if(seen[c]){
                scoreA += 1;
            }
            else{
                scoreB += 1;
            }
        }
        
        scoreA = scoreA * A;
        scoreB = scoreB * B;
        if(scoreA > scoreB){
            return "SARTHAK";
        }
        else if(scoreA < scoreB){
            return "ANURADHA";
        }
        else{
            return "DRAW";
        }
    }
}
