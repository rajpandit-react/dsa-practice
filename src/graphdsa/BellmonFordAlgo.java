/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;

/**
 *
 * @author PANDIT
 */
public class BellmonFordAlgo {
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        addEdge(adj, 0, 1, 5);
        addEdge(adj, 1, 5, -3);
        addEdge(adj, 1, 2, -2);
        addEdge(adj, 3, 2, 6);
        addEdge(adj, 3, 4, -2);
        addEdge(adj, 2, 4, 3);
        addEdge(adj, 5, 3, 1);
        System.out.println("adj=="+adj);
        
        int dist[] = new int[6];
        for(int i = 0; i<dist.length; i++){
            dist[i] = (int)1e9;
        }
        
        dist[0] = 0;
        
        for(int i=0; i<6; i++){
            for(ArrayList<Integer> it : adj){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u] != 1e9 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        for(ArrayList<Integer> it : adj){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != 1e9 && dist[u]+wt < dist[v]){
                dist[v] = dist[u]+wt;
            }
        }
        
        for(int i=0; i<dist.length; i++){
            System.out.print(" "+dist[i]);
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int wt) {
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(u);
        tempList.add(v);
        tempList.add(wt);
        adj.add(tempList);
    }
}
