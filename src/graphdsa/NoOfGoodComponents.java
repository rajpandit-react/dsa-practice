/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author PANDIT
 */
public class NoOfGoodComponents {
 
    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        int[] vis = new int[V+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=V; i++){
            adj.add(i, new ArrayList<>());
            vis[i] = 0;
        }
        
        System.out.println("adj => "+adj);
        
        for(int j=0; j<E; j++){
            Scanner sc = new Scanner(System.in);
            System.out.println("enter source");
            int u = sc.nextInt();
            System.out.println("enter detination");
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        
        
//        addEdge(adj, 1, 2);
//        addEdge(adj, 7, 2);
//        addEdge(adj, 3, 5);
//        addEdge(adj, 3, 4);
//        addEdge(adj, 4, 5);
        
        System.out.println("adj == "+adj);
        
        int cnt = 0;
        for(int i=1; i<=V; i++){
            if(vis[i] == 0){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, i, adj, vis, temp);
                if(goodComponent(adj, temp)){
                    cnt++;
                }
            }
        }
        
        System.out.println("cnt == "+cnt);
    }
    
    static boolean goodComponent(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> temp){
        int s = temp.size();
        for(Integer it : temp){
            System.out.println("adj.get(it).size()=== "+adj.get(it).size()+" == "+(s-1));
            if(adj.get(it).size() != s-1){
                return false;
            }
        }
        return true;
    }
    
    static void dfs(int node, int pnode, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> temp){
        vis[node] = 1;
        temp.add(node);
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
               dfs(it, node, adj, vis, temp);
            }
        }
    }
    
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

