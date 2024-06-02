///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package graphdsa;
//
//import java.util.ArrayList;
//
///**
// *
// * @author PANDIT
// */
//public class NoOfProvinces {
//
//    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        int V = 2;
//    }
//    private static int noProvinces(int V, ArrayList<ArrayList<Integer>> adj){
//        int[] vis = new int[V];
//        for(int i=0; i<V; i++){
//            vis[i] = 0;
//        }
//        
//        for(int )
//        
//        int prov=0;
//        for(int i=0; i<V; i++){
//            if(vis[i] == 0){
//                prov++;
//                dfs(i, adj, vis);
//            }
//        }
//        
//        return prov;
//    }
//    
//    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
//        vis[node] = 1;
//        for(Integer it : adj.get(node)){
//            if(vis[it] == 0){
//                dfs(it, adj, vis);
//            }
//        }
//    }
//    
//    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
//        
//    }
//}
//
