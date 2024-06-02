/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author PANDIT
 */
public class TopoSortAlgo {
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<6; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 5, 0);
        addEdge(adj, 5, 2);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
        
        System.out.println("doTopoSort == "+doTopoSort(adj, 6, 0));
    }
    
    public static ArrayList<Integer> doTopoSort(ArrayList<ArrayList<Integer>> adj, int V, int snode){
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(adj, i, vis, st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        
        return ans;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, it, vis, st);
            }
        }
        st.push(node);
    }
    
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }
}
