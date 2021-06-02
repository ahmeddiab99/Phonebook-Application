/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Ahmed Diab, Fengnan Zhang
 */
public class Trie {
    
    class Node {

        char c;

        HashMap<Character, Node> children = new HashMap<Character, Node>();
        boolean isLeaf;

        public Node() {

        }

        public Node(char c) {
            this.c = c;
        }
    }
    
    public Node root;
    int size = 0;

    public Trie() {
        root = new Node();
    }
    
    
    /**
     * Inserts the specified string into the Trie. The Last node associated to the
     * of the last char of the specified string will be marked as an end-of-word node.
     * @param word
     */
    public void insert(String word){

        HashMap<Character, Node> children = root.children;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            Node t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new Node(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;
        }
        size++;
    }

    /**
     * Returns true if this Trie contains the specified string. In other words
     * the last char of the specified string is a node that is marked as
     * a end-of-word node.
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node t = searchNode(word);

        if(t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    /**
     * Returns true if this Trie contains the specified string as a word or a
     * word in the Trie begins with the specified string.
     * @param prefix
     * @return
     */
    public boolean containsPrefix(String prefix){
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    /**jui
     * Returns all words that begin with the specified prefix.
     * @param prefix
     * @return
     */
    public Set<String> getAllWords(String prefix) {

        char[] arr = prefix.toCharArray();
        Node t = root;
        Set list = new HashSet<>();
        for(char c:arr) {
            t = t.children.get(c);
            if (t == null)
                break;
        }
        if(t !=null){
            getWords(t,prefix,list);
        }

        return list;
    }

    private void getWords(Node node, String prefix, Set list){
        if(node.isLeaf){
            list.add(prefix);
        }
        for(Map.Entry e:node.children.entrySet()){
           getWords((Node) e.getValue(),prefix+e.getKey(),list);
        }
    }



    /**
     * Returns all words of odd length (odd number of characters) that begin
     * with the specified prefix.
     * @param prefix
     * @return
     */
    public Set<String> getAllOddWords(String prefix){
        Set<String> allwords = getAllWords(prefix);
        Set<String> allOddWords = new HashSet<String>();
        for(String word:allwords){
            if(word.length()%2 !=0){
                allOddWords.add(word);
            }
        }
        return allOddWords;
    }

    /**
     * Returns all words of even length (even number of characters) that begin
     * with the specified prefix.
     * @param prefix
     * @return
     */
    public Set<String> getAllEvenWords(String prefix){
        Set<String> allWords=getAllWords(prefix);
        Set<String> allEvenWords=new HashSet<String>();
        for(String word:allWords) {
            if(word.length()%2 == 0) {
                allEvenWords.add(word);
            }
        }
        return allEvenWords;
    }

    public Node searchNode(String str){
        Map<Character, Node> children = root.children;
        Node t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }

        return t;
    }
    
    public boolean search(String word)
    {
        Node t = searchNode(word);
        if(t != null && t.isLeaf){return true;}
        else{return false;}
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) 
    {
        if(searchNode(prefix) == null) {return false;}
        else{return true;}
    }
    
    /*public Node get(int index){

        Node curNode = head;
        for (int i = 0; curNode != null; ++i, curNode = curNode.nextContact) {
            if (index == i) {
                return (E) curNode.contact;
            }
        }
        return null;
    }*/
    
    public int size(){
        return size;
    }
    
}
