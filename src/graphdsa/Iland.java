/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author PANDIT
 */
public class Iland {
    public static void main(String[] args) {
        int[][] greed = {{0, 1, 1, 0},{0,1,1,0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 1}};
        boolean[][] vis = {{false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}};
       int cnt = 0;
        for(int i = 0; i<5; i++){
            for(int j=0; j<4; j++){
                if(!vis[i][j] && greed[i][j] == 1){
                   bfs(i, j, vis, greed); 
                   cnt++;
                }
            }
        }
        
        System.out.println("cnt=="+cnt);
    }
    
    public static void bfs(int row, int col, boolean vis[][], int[][] grid){
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(row, col));
        int n= grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int roww = q.peek().first;
            int coll = q.peek().second;
            q.remove();
            for(int delrow = 0; delrow <=1; delrow++){
                for(int delcol = 0; delcol<=1; delcol++){
                    int nrow = roww+delrow;
                    int ncol = coll+delcol;
                    if(nrow>=0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}

class Pair{
    int first;
    int second;
    int third;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    
    public Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
