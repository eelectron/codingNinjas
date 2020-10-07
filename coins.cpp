#include <bits/stdc++.h>
using namespace std;

int main(){
	int N;
    cin >> N;
    int B[N + 2];
    memset(B, 0, sizeof(B));
    
    int M;
    cin >> M;
    
    int L, R;
    for(int i = 0; i < M; i++){
        cin >> L >> R;
        B[L] += 1;
        B[R + 1] -= 1;
    }
    
    // cumulative
    for(int i = 1; i < N + 1; i++){
        B[i] += B[i - 1];
    }
    
    // sort
    sort(B + 1, B + N + 1);
    
    // count boxes 
    int C[N + 2];
    C[B[1]] = N;
    for(int i = 1; i < N + 1; i++){
        if(B[i - 1] != B[i]){
            C[B[i]] = N - i + 1;
        }
    }
    
    // query
    int Q;
    cin >> Q;
    for(int i = 0; i < Q; i++){
        int coins;
        cin >> coins;
        
        //auto it = lower_bound(B, B + N + 2, coins);
        //long ans = B + N + 2 - it;
        cout << C[coins] << endl;
    }
    return 0;
}
