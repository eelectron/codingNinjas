#include <iostream>
using namespace std;

bool safe(int n, int col[], int r){
    if(r == 0){
        return true;
    }
    
    int qr = r, qc = col[r];
    for(int i = 0; i < r; i++){
        // col
        if(qc == col[i]){
            return false;
        }
        
        // diag
        if(abs(i - col[i]) == abs(qr - qc)){
            return false;
        }
        
        // anti diag
        if(qr + qc == i + col[i]){
            return false;
        }
    }
    return true;
}

void printBoard(int n, int col[]){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(j == col[i]){
                cout << 1 << " ";
            }
            else{
                cout << 0 << " ";
            }
        }
        cout << endl;
    }
}

void placeNQueens(int n, int r, int col[]){
    if(r >= n){
        printBoard(n, col);
        return;
    }
    
    for(int i = 0; i < n; i++){
        col[r] = i;
        if(safe(n, col, r) == true){
            placeNQueens(n, r + 1, col);
        }
    }
}

void placeNQueens(int n){

  /* Don't write main().
   *  Don't read input, it is passed as function argument.
   *  Print output as specified in the question
  */
    int col[n];
	placeNQueens(n, 0, col);
	
}

int main(){
	int n = 4;
	placeNQueens(n);
	return 0;
}
