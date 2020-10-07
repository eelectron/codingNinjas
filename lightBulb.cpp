#include<bits/stdc++.h>
using namespace std;

long minCost(int n, int x, int y, string &s, int start, vector<long> & memo){
    if(start >= s.size()){
        return 0;
    }
    /*
    if(memo[start] != -1){
        return memo[start];
    }
    */
	if(s[start] == '1'){
        // skip 1
        int oi = start;
        while(s[oi] == '1'){
            oi += 1;
        }
        memo[start] = minCost(n, x, y, s, oi, memo);
        return memo[start];
    }
    else{
        // find 0...1...1
        int zi = start;
        while(zi < s.size() && s[zi] == '0'){
            zi += 1;
        }
        
        // flip
        long fc = y + minCost(n, x, y, s, zi, memo);
        
        // reverse
        int oi = zi;
        while(oi < s.size() && s[oi] == '1'){
            oi += 1;
        }
        
        long rc = LONG_MAX;
        if(oi > zi){
            reverse(s.begin() + start, s.begin() + oi);
        	rc = x + minCost(n, x, y, s, start, memo);    
            reverse(s.begin() + start, s.begin() + oi);
        }
        memo[start] = min(fc, rc);
        return memo[start];
    }
}

int main(){
    int n, x, y;
    cin >> n >> x >> y;
    string s;
    cin >> s;
    
    vector<long> memo(n + 1, -1);
    long cost = minCost(n, x, y, s, 0, memo);
    
    cout << cost << endl;
	return 0;
}
