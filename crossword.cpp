#include<bits/stdc++.h>
using namespace std;

void printCW(char cw[][10], int n){
    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 10; j++){
            cout << cw[i][j];
        }
    }
}

bool fillWordV(string word, char cw[][10], int x, int y){
	if(cw[x][y] == '+' || (x > 0 && cw[x - 1][y] == '-')){
        return false;
    }
    
    if(x > 0 && cw[x - 1][y] != '+' && cw[x - 1][y] != word[0]){
        return false;
    }
    
    int count = 0;
    int start = 0;
    if(x > 0 && cw[x - 1][y] == word[0]){
        start = 1;
        count = 1;
    }
    
    for(int i = start; x + i < 10 && i < word.size(); i++){
        if(cw[x + i - start][y] == '-' || cw[x + i - start][y] == word[i]){
        	cw[x + i - start][y] = word[i];    
        }
        else{
            break;
        }
        count += 1;
    }
    return count == word.size();
}

bool undoV(string word, char cw[][10], int x, int y){
    int start = 0;
    if(x > 0 && cw[x - 1][y] == word[0]){
        start = 1;
    }
    
    for(int i = start; i < word.size(); i++){
        if((y > 0 && isalpha(cw[x][y - 1])) || (y < 9 && isalpha(cw[x][y + 1]))){
            continue;
        }
        cw[x + i - start][y] = '-';
    }
    return true;
}

bool fillWordH(string word, char cw[][10], int x, int y){
    if(cw[x][y] == '+' || (y > 0 && cw[x][y - 1] == '-')){
        return false;
    }
    
    if(y > 0 && isalpha(cw[x][y - 1]) && cw[x][y - 1] != word[0]){
        return false;
    }
    
    int start = 0, count = 0;
    if(y > 0 && cw[x][y - 1] == word[0]){
        start = 1;
        count = 1;
    }
    
    for(int j = start; y + j - start < 10 && j < word.size(); j++){
        if(cw[x][y + j - start] == '-' || cw[x][y + j - start] == word[j]){
            cw[x][y + j - start] = word[j];
            count += 1;
        }
        else{
            break;
        }
    }
    return count == word.size();
}

bool undoH(string word, char cw[][10], int x, int y){
    int start = 0;
    if(y > 0 && cw[x][y - 1] == word[0]){
        start = 1;
    }
    
    for(int j = start; j < word.size(); j++){
        if((x > 0 && isalpha(cw[x - 1][y])) || (x < 9 && isalpha(cw[x + 1][y])) ){
            continue;
        }
        cw[x][y + j - start] = '-';
    }
    return true;
}

bool fillCW(char cw[][10], int start, vector<string> & words){
    if(start >= words.size()){
        printCW(cw, 10);
        return true;
    }
    
    string word = words[start];
    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 10; j++){
    		bool isFilledV = fillWordV(word, cw, i, j);   
            if(isFilledV == true){
                bool res = fillCW(cw, start + 1, words);
                if(res == false){
                    undoV(word, cw, i, j);
                }
            }
            
            bool isFilledH = fillWordH(word, cw, i, j);
            if(isFilledH){
                bool res = fillCW(cw, start + 1, words);
                if(res == false){
                    undoH(word, cw, i, j);
                }
            }
        }
    }
    return false;
}

int main() {

	// Write your code here
    char cw[10][10];
    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 10; j++){
            cin >> cw[i][j];
        }
    }
    
    vector<string> words;
    string s;
    
    while(getline(cin, s, ';')){
        words.push_back(s);
        s.clear();
    }
    
    fillCW(cw, 0, words);
}

