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
public class MatrixDist01 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1},{1, 1, 0},{1, 0, 0}};
        int[][] vis = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] dist = new int[grid.length][grid[0].length];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }else{
                    vis[i][j] = 0;
                }
            }
        }
        
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for(int i=0; i<4; i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow >=0 && nrow<grid.length && ncol >=0 && ncol<grid[0].length && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, steps+1));
                }
            }
        }
        
        for(int i=0; i<dist.length; i++){
            for(int j=0; j<dist[0].length; j++){
                System.out.print(" "+dist[i][j]);
            }
            System.out.println("");
        }
    }
}

