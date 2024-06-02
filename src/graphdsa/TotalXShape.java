/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author PANDIT
 */
public class TotalXShape {
//    3 3
//XOX
//OXO
//XXX

//    5 6
//XOOXXO
//OOOXXX
//OXXXXX
//OOXOOX
//OOXXOO
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        
        int[][] vis = new int[n][m];
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                vis[i][j] = 0;
                System.out.println("enter x or o for "+i+" "+j);
                Scanner sc= new Scanner(System.in);
                grid[i][j] = sc.next().charAt(0);
            }
        }
        
        int cnt = 0;
        System.out.println("cnt=="+cnt);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.println("vis["+i+"]["+j+"] = "+vis[i][j]+", grid["+i+"]["+j+"] = "+grid[i][j]);
                if(vis[i][j] == 0 && grid[i][j] == 'X'){
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        
        System.out.println("cnt=="+cnt);
    }

    static void bfs(int r, int c, int[][] vis, char[][] grid){
        vis[r][c] =1;
        Queue<int[]> q = new LinkedList<>();
        int[] pair = new int[2];
        pair[0] = r;
        pair[1] = c;
        q.add(pair);
        
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();
//            int[] delrow = {1, 0, -1, 0};
//            int[] delcol = {0, 1, 0, -1};
            for(int i = 0; i<=1; i++){
                for(int j = 0; j<=1; j++){
                    int nrow = row+i;
                    int ncol = col+j;
                    System.out.println("nrow ncol == "+nrow+" "+ncol);
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'X'){
                        vis[nrow][ncol] = 1;
                        pair = new int[2];
                        pair[0] = nrow;
                        pair[1] = ncol;
                        q.add(pair);
                    }
                }
            }
        }
    }
}
