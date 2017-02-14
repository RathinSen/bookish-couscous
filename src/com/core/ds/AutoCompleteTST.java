package com.core.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoCompleteTST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] dictionary = sc.next().trim().split(",");
		String txt = sc.next().trim();
		TernarySearchTree tree = new TernarySearchTree();
		
		for(String s : dictionary){
			tree.load(s);
		}
		
		List<String> pWs = tree.autocomplete(txt);
		for(String pW : pWs){
			System.out.println(pW);
		}
		sc.close();
	}

}
class TernarySearchTree{
	Node root;

	public TernarySearchTree() {
		super();
		root = new Node();
	}
	
	public List<String> autocomplete(String txt) {
		// TODO Auto-generated method stub\List<String>
		List<String> strings = new ArrayList<String>();
		Node matchedNode = matchPrefix(root,txt,0);
		if(matchedNode!=null){
			autocompleteRecursive(matchedNode,txt,strings);
		}
		return strings;
	}

	private void autocompleteRecursive(Node currNode, String txt,
			List<String> strings) {
		if(currNode.eow){
			strings.add(txt);
		}
		if(currNode.c!=null){
			autocompleteRecursive(currNode.c,txt+currNode.ch,strings);
		}
		if(currNode.l!=null){
			autocompleteRecursive(currNode.l,txt,strings);
		}
		if(currNode.r!=null){
			autocompleteRecursive(currNode.r,txt,strings);
		}
	}

	private Node matchPrefix(Node currNode, String txt, int index) {
		if(txt.length() == index){
			return currNode;
		}
		if(currNode.ch == null){
			return null;
		}
		if(currNode.ch == txt.charAt(index)){
			return matchPrefix(currNode.c,txt,index+1);
		}else if(currNode.ch >= txt.charAt(index)){
			return matchPrefix(currNode.l,txt,index);
		}else{
			return matchPrefix(currNode.r, txt, index);
		}
	}

	public void load(String s) {
		loadRecursive(root,s,0);
	}

	private void loadRecursive(Node currNode, String s, int index) {
		// TODO Auto-generated method stub
		if(s.length() == index){
			currNode.eow = true;
		}
		else{
			if(currNode.ch==null){
				currNode.ch = s.charAt(index);
				if(currNode.c==null){
					currNode.c = new Node();
				}
				loadRecursive(currNode.c,s,index+1);
			}else{
				if(currNode.ch == s.charAt(index)){
					if(currNode.c==null){
						currNode.c = new Node();
					}
					loadRecursive(currNode.c, s, index+1);
				}else if(currNode.ch >= s.charAt(index)){
					if(currNode.l==null){
						currNode.l = new Node();
					}
					loadRecursive(currNode.l, s, index);
				}
				else{
					if(currNode.r==null){
						currNode.r = new Node();
					}
					loadRecursive(currNode.r, s, index);
				}
			}
		}
		
	}
	
}
class Node{
	Character ch;
	Node l,c,r;
	boolean eow;
	public Node() {
		super();
		eow=false;
	}
	
}