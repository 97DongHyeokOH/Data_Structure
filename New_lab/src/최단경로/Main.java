package 최단경로;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Graph{
	int noVertex;
	int[][] m;
	public static final int NONE = 999;
	public static final int start = 0;
	public static final int arriv = 3;
	
	public void  loadDate(Scanner scan) {
		int noVertex = scan.nextInt();
		int end = scan.nextInt();
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];
		
		for(int n = 0; n < end; n++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			m[i][j] = scan.nextInt();
		}
		
		for(int i = 0; i < noVertex; i++) {
			for(int j = 0; j < noVertex; j++) {
				if(i == j) m[i][j] = 0;
				else if(m[i][j] == 0) m[i][j] = NONE;
			}
		}
	}
	
	public ArrayList<Integer> shortestPath(int startVertex){
		ArrayList<Integer> path = new ArrayList<Integer>();
		int[] pathNum = new int[noVertex];
		int n = 0;
		boolean[] visit = new boolean[noVertex];
		
		path.add(startVertex);
		visit[start] = true;
		
		for(int i = 0; i < noVertex; i++) {
			int val = NONE;
			for(int j = 0; j < noVertex; j++) {
				if(visit[j] == false) {
					if(m[i][j] < val) {
						val = m[i][j];
						pathNum[n++] = j;
					}
				}
			}
		}
		
		ArrayList<Integer> noPath = new ArrayList<Integer>();
		return noPath;
	}
}

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		
		Graph g = new Graph();
		g.loadDate(scan);
		
		int startVertex = scan.nextInt();
		int finalVertex = scan.nextInt();
		
		ArrayList<Integer> path = g.shortestPath(startVertex);
		
		for(int vertex : path) {
			System.out.print(vertex + " ");
		}
	}

}
