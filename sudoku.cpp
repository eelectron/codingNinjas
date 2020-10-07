#include<bits/stdc++.h>
using namespace std;
#define N 9

bool isValid(int S[][N], int x, int y){
    // row
    bool v[N + 1];
    memset(v, 0, (N + 1) * sizeof(bool));
    
    for(int j = 0; j < N; j++){
        if(S[x][j] != 0){
            if(v[S[x][j]]){
                return false;
            }
            v[S[x][j]] = true;
        }
    }
    
    // col
    memset(v, 0, (N + 1) * sizeof(bool));
    for(int i = 0; i < N; i++){
        if(S[i][y] != 0){
            if(v[S[i][y]]){
                return false;
            }
            v[S[i][y]] = true;
        }
    }
    
    memset(v, 0, (N + 1) * sizeof(bool));
    int tx = x / 3, ty = y / 3;
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(S[tx * 3 + i][ty * 3 + j] != 0){
                if(v[S[tx * 3 + i][ty * 3 + j]]){
                    return false;
                }
                v[S[tx * 3 + i][ty * 3 + j]] = true;
            }
        }
    }
    return true;
}

bool canSolve(int S[][N], int x, int y){
    if(x >= N){
        return true;
    }
    
    if(y >= N){
        return canSolve(S, x + 1, 0);
    }
    
    if(S[x][y] != 0){
        return canSolve(S, x, y + 1);
    }
    
    for(int v = 1; v <= 9; v++){
    	S[x][y] = v;
        if(isValid(S, x, y)){
            bool r = canSolve(S, x, y + 1);
            if(r){
                return true;
            }
        }
    }
    return false;
}

bool canSolve(int S[][N]){
    return canSolve(S, 0, 0);
}

int main(){
    int S[N][N];
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> S[i][j];
        }
    }
    
    bool ans = canSolve(S);
    cout << ans << endl;
	return 0;
}
