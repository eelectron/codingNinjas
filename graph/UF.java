package graph;

import java.util.HashSet;

public class UF{
    private int[] parent;		// parent[i] = set no. to which i belongs
    private int[] treeSize;		// treeSize[i] = no. of nodes in subtree rooted at i
    private int setCount;		// count of disjoint sets made
    public UF(int n){
        parent = new int[n];
        treeSize = new int[n];
        setCount = n;
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            treeSize[i] = 1;
        }
    }
    
    private int find(int node){
        int x = node;
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }
    
	public void union(int u, int v){
        int ru = find(u);
        int rv = find(v);
        if(isConnected(u, v) == true){
            return;
        }
        
        // join two nodes
        // sets decreased by one
        setCount -= 1;
        
        if(treeSize[ru] >= treeSize[rv]){
            parent[rv] = ru;
            treeSize[ru] += treeSize[rv];
        }
        else{
            parent[ru] = rv;
            treeSize[rv] += treeSize[ru];
        }
    }    
    
    public boolean isConnected(int u, int v){
        int ru = find(u);
        int rv = find(v);
        return ru == rv;
    }
    
    public int countSets() {
    	return setCount;
    }
}