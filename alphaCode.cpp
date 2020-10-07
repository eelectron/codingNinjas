#include <bits/stdc++.h>
using namespace std;

long codes(string s){
    if(s.size() < 2){
        return 1;
    }
    cout << s << endl;
    int MOD = 1e9 + 7;
    int n = s.size();
    long dp[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i < n + 1; i++){
        dp[i] = 0;
        
        if(s[i - 1] != '0'){
        	dp[i] = dp[i - 1];    
        }
        
        // last two
        int lastTwo = (s[i - 2] - '0') * 10 + (s[i - 1] - '0');
        if(lastTwo >= 10 && lastTwo <= 26){
            dp[i] += dp[i - 2];
            dp[i] = dp[i] % MOD;
        }
        //cout << dp[i] << " ";
    }
    return dp[n];
}

int main()
{
    string s;
    while(getline(cin, s)){
        if(s == "0"){
            break;
        }
        long ans = codes(s);
        cout << ans << endl;
        s.clear();
    }
    return 0;
}

/*
6887997192
8767125399
4439144517
6185884715
7587418153
2999338423
8834854139
0
*/