package com.core.revision;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutoCompleteTrieAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] strings = sc.next().trim().split(",");
		String pat = sc.next().trim();
		TrieTree trie = new TrieTree();
		for(String s : strings){
			trie.load(s);
		}
		trie.autocomplete(pat);
		sc.close();
	}

}
class TrieTree{
	private Node head;

	public TrieTree() {
		super();
		head = new Node();
	}

	public void autocomplete(String pat) {
		Node node  = prefix(pat);
		if(node!=null){
			printRecursive(node,pat);
		}
	}

	private void printRecursive(Node node, String pat) {
		if(node.isEndOfWord()){
			System.out.println(pat);
		}
		for(Map.Entry pair : node.getMap().entrySet()){
			printRecursive((Node) pair.getValue(),pat+pair.getKey());
		}
	}

	private Node prefix(String pat) {
		// TODO Auto-generated method stub
		return prefixRecursive(head, pat, 0);
	}

	private Node prefixRecursive(Node node, String pat, int i) {
		if(node == null){
			return null;
		}
		else if(pat.length() == i){
			return node;
		}
		return prefixRecursive(node.getMap().get(pat.charAt(i)), pat, i+1);
	}

	public void load(String s) {
		loadRecursive(head,s,0,s.length());
	}

	private void loadRecursive(Node node, String s, int index, int length) {
		if(index == length){
			node.setEndOfWord(true);
			return;
		}
		Node next = node.getMap().get(s.charAt(index));
		if(next==null){
			node.getMap().put(s.charAt(index), new Node());
			next = node.getMap().get(s.charAt(index));
		}
		loadRecursive(next, s, index+1, length);
	}
	
}
class Node{
	
	private TreeMap<Character,Node> map;
	private boolean endOfWord;
	
	public Node() {
		super();
		map = new TreeMap<Character, Node>();
		this.endOfWord = false;
	}
	public TreeMap<Character, Node> getMap() {
		return map;
	}
	public void setMap(TreeMap<Character, Node> map) {
		this.map = map;
	}
	public boolean isEndOfWord() {
		return endOfWord;
	}
	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	
	
}
