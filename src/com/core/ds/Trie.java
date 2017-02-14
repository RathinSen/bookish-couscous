package com.core.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Trie {

	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}

	//insert
	public void insert(String phrase){
		insertRecursive(phrase, root, 0);
	}
	private void insertRecursive(String phrase, TrieNode currentNode, int index) {
		if(index == phrase.length()){
			currentNode.endOfWord = true;
		}
		else{
			if(currentNode.map.get(phrase.charAt(index))==null){
				currentNode.map.put(phrase.charAt(index), new TrieNode());
			}
			insertRecursive(phrase,currentNode.map.get(phrase.charAt(index)),index+1);
		}
	}
	
	private List<String> autocomplete(String text) {
		// TODO Auto-generated method stub
		TrieNode node = matchPrefix(text,this.root,0);
		List<String> pW = new ArrayList<String>();
		autocompleteRecursive(text,node,pW);
		return pW;
	}

	private void autocompleteRecursive(String text, TrieNode node, List<String> pW) {
		if(node == null){
			return;
		}
		if(node.endOfWord){
			pW.add(text);
		}
		for(Map.Entry<Character,TrieNode> pair : node.map.entrySet()){
			autocompleteRecursive(text+pair.getKey(),pair.getValue(),pW);
		}
	}

	private TrieNode matchPrefix(String text, TrieNode currentNode, int index) {
		// TODO Auto-generated method stub
		if(currentNode == null){
			return null;
		}
		if(index == text.length()){
			return currentNode;
		}
		return matchPrefix(text,currentNode.map.get(text.charAt(index)),index+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		String[] strings = sc.next().trim().split(",");
		
		Trie trie = new Trie();
		for(String s : strings){
			trie.insert(s);
		}
		String text = sc.next().trim();
		List<String> possibleWords = trie.autocomplete(text);
		for(String possibleWord : possibleWords){
			System.out.println(possibleWord);
		}
		sc.close();
	}

	

}
class TrieNode{
	Map<Character, TrieNode> map;
	boolean endOfWord;
	
	//constructor
	public TrieNode() {
		this.map = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}
