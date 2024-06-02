/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author PANDIT
 */
public class GraphDSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 3; int m = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(2);
        System.out.println("adj==="+adj);
        
        //for weoighted graph
        
        ArrayList<ArrayList<HashMap<Integer, Integer>>> adjList = new ArrayList<>();
        for(int i=0; i<=5; i++){
            adjList.add(new ArrayList<>());
        }
        
        HashMap hm = new HashMap();
        hm.put(2, 5);
        adjList.get(1).add(hm);
        hm = new HashMap();
        hm.put(3, 4);
        adjList.get(1).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(2).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(2).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(2).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(3).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(3).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(4).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(4).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(4).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(5).add(hm);
        hm = new HashMap();
        hm.put(2, 5);
        adjList.get(5).add(hm);
        
        
        System.out.println("==> "+adjList);
    }
    
}
