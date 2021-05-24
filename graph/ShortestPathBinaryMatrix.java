package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/submissions/detail/496729703/
 * T : O(no. of cells in matrix)
 * S : O(no. of cells in matrix)
 * 
 * Idea : Start search level by level starting from first cell (BFS)*/
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] G) {
        if(G == null || G.length == 0){
            return -1;
        }
        
        int m = G.length;
        int n = G[0].length;
        if(G[0][0] == 1){
            return -1;
        }
        
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;
        
        int x, y, d;
        while(q.isEmpty() == false){
            Node curNode = q.remove();
            if(curNode.x == m - 1 && curNode.y == n - 1){
                return curNode.d + 1;
            }
            
            List<Node> neigh = getNeighbors(curNode, G);
            for(Node nd : neigh){
                x = nd.x;
                y = nd.y;
                if(G[x][y] == 0 && visited[x][y] == false){
                    q.add(nd);
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
    
    private List<Node> getNeighbors(Node node, int[][] G){
        List<Node> neigh = new ArrayList<>();
        if(node == null){
            return neigh;
        }
        
        int m = G.length;
        int n = G[0].length;
        
        int x = node.x, y = node.y;
        for(int i = x - 1; i <= x + 1; i++){
            for(int j = y - 1; j <= y + 1; j++){
                if(i >= 0 && i < m && j >= 0 && j < n){
                    neigh.add(new Node(i, j, node.d + 1));
                }
            }
        }
        return neigh;
    }
}

class Node{
    int x, y, d;
    Node(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}