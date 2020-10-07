#include<bits/stdc++.h>
using namespace std;

long balls(long k, long n){
    if(k == 0){
	return k >= n / 2;
    }

    long sharma = 0, singh = 0, balls = n;
    while(n >= k){
    //cout << k << " " << n << endl;
        sharma += k;
        n = n - k;
        
        singh += n / 10;
        n -= (n / 10);
    }
    
    sharma += n;
    return sharma;
}

int getK(long n){
    if(n <= 3){
        return 1;
    }
    
    long k = n / 2;
    int lo = 0, hi = n / 2 + 1, m;
    while(lo <= hi){
        m = lo + (hi - lo) / 2;
        //cout << m << endl;
        long b = balls(m, n);
        if(b >= (n + 1)/ 2){
    		k = m;
    		//cout << k << " " << b << endl;
    		hi = m - 1;
    	}
    	else{
    		lo = m + 1;
    	}
    }
    return k;
}

int main(){
    int n;
    cin >> n;
    
    long k = getK(n);
    cout << k << endl;
	return 0;
}

