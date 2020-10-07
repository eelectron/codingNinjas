#include <bits/stdc++.h>
#include <numeric>
using namespace std;

long getCount(int A[], int n){
    long ans = 0;
    if(n == 0){
        return 0;
    }
    
    long MOD = 1e9 + 7;
    long G = 100;
    long dp[n][G + 1];
    memset(dp, 0 , (n) * (G + 1) * sizeof(long));
    
    for(int i = 0; i < n; i++){
        dp[i][A[i]] += 1;
        // for each smaller item than A[i]
        for(int k = 0; k < i; k++){
            if(A[k] < A[i]){
                for(int m = 1; m < G + 1; m++){
                long x = __gcd(m, A[i]);
                dp[i][x] += dp[k][m];
                dp[i][x] = dp[i][x] % MOD;
            }
            }
        }
        ans = ans + dp[i][1];
        ans = ans % MOD;
    }
    return ans;
}

int main(){
    int n;
    cin >> n;
    int A[n];
    for(int i = 0; i < n; i++){
        cin >> A[i];
    }
    
    long ans = getCount(A, n);
    cout << ans << endl;
    return 0;
}