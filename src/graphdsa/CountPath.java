/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author PANDIT
 */
public class CountPath {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[4];
        for(int i=0; i<4; i++){
            adj.add(new ArrayList<>());
            vis[i]=0;
        }
        addEdge(0, 3, adj);
        addEdge(0, 1, adj);
        addEdge(1, 3, adj);
        addEdge(1, 2, adj);
        addEdge(2, 3, adj);
        
        System.out.println("adj = "+adj);
        
        int cnt= bfs(0, adj, 3, 0);
        System.out.println("cnt == "+cnt);
    }
    
    static int bfs(int s, ArrayList<ArrayList<Integer>> adj, int d, int cnt){
        System.out.println("s= "+s);
        Queue<Integer> q = new LinkedList();
        q.add(s);
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(Integer it : adj.get(node)){
                if(it == d){
                    cnt++;
                }else{
                    q.add(it);
                }
            }
        }
        return cnt;
    }
    
    static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
    }
}
