package com.core.revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutoCompleteTrie {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] dictionary = sc.next().trim().split(",");
		//To Hold on spaces in your trie
		//String[] dictionary = sc.nextLine().trim().split(",");
		String txt = sc.next();
		Trie trie = new Trie();
		for(String word : dictionary){
			trie.load(word);
		}
		List<String> probables = trie.autocomplete(txt);
		for(String p : probables){
			System.out.println(p);
		}
		sc.close();
	}
}
class Trie{
	private TrieNode root;

	public Trie() {
		super();
		root = new TrieNode();
	}

	public List<String> autocomplete(String txt) {
		List<String> strings = new ArrayList<String>();
		TrieNode node = autocompleteRecursive(txt,root,0);
		//print from this node, it van be null
		if(node != null){
			printFromHere(node,strings,txt,txt.length());
		}
		return strings;
	}

	private void printFromHere(TrieNode node, List<String> strings, String txt, int i) {
		
		if(node.isEndOfTheWord()){
			strings.add(txt);
		}
		for(Map.Entry map : node.getMap().entrySet()){
			printFromHere((TrieNode) map.getValue(),strings,txt+map.getKey(),i+1);
		}
	}

	private TrieNode autocompleteRecursive(String txt, TrieNode currNode,
			int index) {
		//txt length done then print
		if(currNode == null){
			return null;
		}
		else if(txt.length()==index){
			return currNode;
		}
		TrieNode nextNode = currNode.getMap().get(txt.charAt(index));
		return autocompleteRecursive(txt,nextNode,index+1);
	}

	public void load(String word) {
		loadRecursive(word,root,0);
	}
	
	

	private void loadRecursive(String word, TrieNode currNode, int index) {
		if(word.length()==index){
			currNode.setEndOfTheWord(true);
		}else{
			if(currNode.getMap().get(word.charAt(index))==null){
				currNode.getMap().put(word.charAt(index),new TrieNode());
			}
			TrieNode nextNode = currNode.getMap().get(word.charAt(index));
			loadRecursive(word,nextNode,index+1);
		}
	}
	
	
}
class TrieNode{
	private TreeMap<Character, TrieNode> map;
	private boolean endOfTheWord;
	
	
	public TreeMap<Character, TrieNode> getMap() {
		return map;
	}
	public void setMap(TreeMap<Character, TrieNode> map) {
		this.map = map;
	}
	public boolean isEndOfTheWord() {
		return endOfTheWord;
	}
	public void setEndOfTheWord(boolean endOfTheWord) {
		this.endOfTheWord = endOfTheWord;
	}
	public TrieNode() {
		super();
		map = new TreeMap<Character, TrieNode>();
		endOfTheWord = false;
		
	}
	
}
