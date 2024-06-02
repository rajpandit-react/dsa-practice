/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author PANDIT
 */
public class PrimsAlgo {
    
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0; i<5; i++){
            adj.add(new ArrayList());
        }
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 1);
        addEdge(adj, 2, 1, 1);
        addEdge(adj, 2, 4, 2);
        addEdge(adj, 2, 3, 2);
        addEdge(adj, 3, 4, 1);
//        for(int i=0; i<adj.size(); i++){
//            System.out.println("list == "+adj.get(i));
//        }
        
        ArrayList<int[]> mst = primsImpl(adj, 5, 0);
        
        System.out.println("");
        for(int i=0; i<mst.size(); i++){
//            for(Integer it : mst.get(i)){
                System.out.print(" ("+mst.get(i)[0]+", "+mst.get(i)[1]+"), ");
//            }
            
        }
        System.out.println("");
    }
    
    static ArrayList<int[]> primsImpl(ArrayList<ArrayList<ArrayList<Integer>>> adj, int v, int s){
        ArrayList<int[]> mst = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[0]-y[0]);
        int[] vis = new int[v];
        int[] tempArr = new int[3];
        tempArr[0] = 0;
        tempArr[1] = 0;
        tempArr[2] = -1;
        pq.add(tempArr);
        int sum = 0;
        vis[0]=1;
        while(!pq.isEmpty()){
            int wt = pq.peek()[0];
            int cnode = pq.peek()[1];
            int pnode = pq.peek()[2];
            pq.poll();
            System.out.println("cnode=="+cnode+" pnode=="+pnode+" wt=="+wt);
            sum +=wt;
            if(pnode != -1){
                tempArr = new int[2];
                tempArr[0] = wt;
                tempArr[1] = cnode;
                mst.add(tempArr);
            }
            
            ArrayList<ArrayList<Integer>> tempAdj = adj.get(cnode);
            System.out.println("tempAdj=="+tempAdj+" cnode=="+cnode);
            for(ArrayList<Integer> it : tempAdj){
                int node = it.get(0);
                int cwt = it.get(1);
                
                if(vis[node] == 0){
                    System.out.println("visnode == "+vis[node]+" node=="+node+" cwt=="+cwt);
                    vis[node] = 1;
                    tempArr = new int[3];
                    tempArr[0] = cwt;
                    tempArr[1] = node;
                    tempArr[2] = cnode;
                    pq.add(tempArr);
                    
//                    System.out.println("sum=="+sum);
                }
            }
        }
        
        System.out.println("sum=> "+sum);
        
        return mst;
    }

    static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int wt) {
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(v);
        tempList.add(wt);
        adj.get(u).add(tempList);
        
        tempList = new ArrayList<>();
        tempList.add(u);
        tempList.add(wt);
        adj.get(v).add(tempList);
    }

}
