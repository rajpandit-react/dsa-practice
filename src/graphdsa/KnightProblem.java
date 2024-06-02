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
public class KnightProblem {
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int[][] vis = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                vis[i][j] = 0;
            }
        }
        
        return bfs(KnightPos[0], KnightPos[1], TargetPos[0], TargetPos[1], vis, N);
    }
    
    static int bfs(int srow, int scol, int drow, int dcol, int[][] vis, int N){
        if(srow == drow && scol == dcol){
            return 0;
        }
        
        int cnt = 0;
        vis[srow][scol] = 1;
        int[] pair = new int[2];
        pair[0] = srow;
        pair[1] = scol;
        Queue<int[]> q = new LinkedList();
        q.add(pair);
        
        
        while(!q.isEmpty()){
            
            int size = q.size();
            cnt++;
            
            while(size != 0){
                int row = q.peek()[0];
                int col = q.peek()[1];
                q.poll();
                
                
                int[] delrow = {-1, 1, 2, 2, 1, -1, -2, -2};
                int[] delcol = {2, 2, 1, -1, -2, -2, -1, 1};
                
                for(int i=0; i<8; i++){
                    int nrow = row+delrow[i];
                    int ncol = col+delcol[i];
                    
                    if(nrow == drow && ncol == dcol){
                        return cnt;
                    }
                    
                    if(nrow >0 && nrow <=N && ncol >0 && ncol <= N && vis[nrow][ncol] == 0){
                           vis[nrow][ncol] = 1;
                           pair = new int[2];
                           pair[0] = nrow;
                           pair[1] = ncol;
                           q.add(pair);
                    }
                }
                
                size--;
            }
            
        }
        
        return cnt;
    }
}
