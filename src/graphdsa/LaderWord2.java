/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author PANDIT
 */
public class LaderWord2 {
    public static void main(String[] args) {
        String[] wordList = {"pat", "bot", "pol", "poz", "coz"};
        String beginWord = "pat";
        String endWord = "coz";
        
        System.out.println("=="+findSequence(beginWord, endWord, wordList));
    }
    
    public static ArrayList<ArrayList<String>> findSequence (String startWord, String endWord, String[] wordList){
        Set<String> st = new HashSet();
        st.addAll(Arrays.asList(wordList));
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(startWord);
        q.add(list);
        
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        ArrayList<ArrayList<String>> ans  = new ArrayList<>();
        while(!q.isEmpty()){
            st.iterator().forEachRemaining(action -> System.out.println("action start =="+action));
            ArrayList<String> vcc = q.peek();
            q.remove();
            System.out.println("vcc=="+vcc.size()+" ledn=="+level);
            if(vcc.size() > level){
                level++;
                usedOnLevel.forEach((it) -> {
                    st.remove(it);
                });
            }
            
            String word = vcc.get(vcc.size()-1);
            if(word.equals(endWord)){
                System.out.println("ans=="+ans);
                if(ans.isEmpty()){
                    ans.add(vcc);
                }else if(ans.get(0).size() == vcc.size()){
                    ans.add(vcc);
                }
            }
            
            st.iterator().forEachRemaining(action -> System.out.println("action end =="+action));
            
            System.out.println("word=="+word);
            for(int i=0; i<word.length(); i++){
                for(char c = 'a'; c<='z'; c++){
                    char replaceArr[] = word.toCharArray();
                    replaceArr[i] = c;
                    String replacedWord = new String(replaceArr);
                    System.out.println("replacedWord=="+replacedWord);
//                    System.out.println("word=="+word);
//                    System.out.println("st=="+st.size());
                    
                    if(st.contains(replacedWord)){
                        System.out.println("yes");
                        vcc.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vcc);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vcc.remove(vcc.size()-1);
                    }
                }
            }
        }
        
        return ans;
    }
}
