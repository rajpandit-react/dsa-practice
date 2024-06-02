/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author PANDIT
 */
public class DiskatrapQ {

    //graph
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int n=6;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 3, 3);
        addEdge(adj, 2, 4, 1);
        addEdge(adj, 2, 5, 6);
        addEdge(adj, 3, 5, 2);
        addEdge(adj, 4, 5, 3);
        
        int dist[] = new int[n];
        
        System.out.println("");
        System.out.println("adj=="+adj);
//        dist = diskastFun(adj, 0, n);
        dist = disKastraPqAlgo(adj, 0, n);
        for(int i=0; i<dist.length; i++){
            System.out.print(" "+dist[i]);
        }
        System.out.println("");
    }
    
    static int[] diskastFun(ArrayList<ArrayList<ArrayList<Integer>>> adj, int s, int n){
        int dist[] = new int[n];
        System.out.println("dist.length=="+dist.length);
        for(int i=0; i<dist.length; i++){
            dist[i] = (int)1e9;
        }
        for(int i=0; i<dist.length; i++){
            System.out.print(" "+dist[i]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int[] temparr = new int[2];
        temparr[0] = 0;
        temparr[1] = s;
        pq.add(temparr);
        dist[s] = 0;
        while(!pq.isEmpty()){
            System.out.println("pq="+pq.peek()[0]+" "+pq.peek()[1]);
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            ArrayList<ArrayList<Integer>> tempList = adj.get(node);
            for(ArrayList<Integer> it : tempList){
                int adjNode = it.get(0);
                int edgeWeight = it.get(1);
                System.out.println("edgeWeight=="+edgeWeight+" adjNode=="+adjNode+" dis=="+dis);
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis+edgeWeight;
                    temparr = new int[2];
                    temparr[0] = dis+edgeWeight;
                    temparr[1] = adjNode;
                    pq.add(temparr);
                }
            }
        }
        
        return dist;
    }
    static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int wt) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(u);
        temp.add(wt);
        adj.get(v).add(temp);
        temp = new ArrayList<>();
        temp.add(v);
        temp.add(wt);
        adj.get(u).add(temp);
    }
    
    static int[] disKastraPqAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj, int s, int n){
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)1e9;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)-> x[0]-y[0]);
        int[] temp = {0,s};
        pq.add(temp);
        dist[s] = 0;
        while(!pq.isEmpty()){
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            ArrayList<ArrayList<Integer>> tempAdj = adj.get(node);
            for(ArrayList<Integer> it : tempAdj){
                int edgeWeight = it.get(1);
                int adjNode = it.get(0);
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    temp = new int[2];
                    temp[0] = dis+edgeWeight;
                    temp[1] = adjNode;
                    pq.add(temp);
                }
            }
        }
        
        return dist;
    }
}

