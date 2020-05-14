import java.io.*;
import java.util.Scanner;

class Point{
	public int x, y;
}

public class Main14 {
	
	static class Stack{
		private int top;
		private int StackSize;
		private int arr[][];
		
		public Stack() {
			top = -1;
			StackSize = 100;
			arr = new int[StackSize][3];
		}
		
		public boolean IsEmpty() {
			return top == -1;
		}
		
		public void push(int x, int y, int dir) {
			if(top == StackSize -1) return;
			else {
				top++;
				arr[top][0] = x;
				arr[top][1] = y;
				arr[top][2] = dir;
			}
		}
		
		public void pop() {
			if(top == -1) return;
			else {
				top--;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		int sizeY = scan.nextInt();
		int sizeX = scan.nextInt();
		
		Point start = new Point();
		start.x = scan.nextInt();
		start.y = scan.nextInt();
		
		Point exit = new Point();
		exit.x = scan.nextInt();
		exit.y = scan.nextInt();
		
		int maze[][] = new int[sizeY][sizeX];
		Object mark[][] = new Object[sizeY][sizeX];
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				maze[i][j] = scan.nextInt();
				mark[i][j] = maze[i][j];
			}
		}
		
		Stack stack = new Stack();
		
		Point cur = new Point();
		cur.x = start.x;
		cur.y = start.y;
		
		int dir = 0;
		
		while(true) {
			dir++;
			
			if(cur.x == exit.x && cur.y == exit.y) {
				stack.push(cur.x, cur.y, dir);
				break;
			}
			
			if(cur.x == start.x && cur.y == start.y) {
				switch(dir) {
				case 1:
					if(maze[cur.y-1][cur.x] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.y--;
					}
					break;
				case 2:
					if(maze[cur.y][cur.x+1] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.x++;
					}
					break;
				case 3:
					if(maze[cur.y+1][cur.x] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.y++;
					}
					break;
				case 4: 
					if(maze[cur.y][cur.x-1] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.x--;
					}
					break;
				}
			}
			else {
				switch(dir) {
				case 1:
					if(maze[cur.y-1][cur.x] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.y--;
					}
					break;
				case 2:
					if(maze[cur.y][cur.x+1] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.x++;
					}
					break;
				case 3:
					if(maze[cur.y+1][cur.x] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.y++;
					}
					break;
				case 4:
					if(maze[cur.y][cur.x-1] != 1) {
						stack.push(cur.x, cur.y, dir);
						maze[cur.y][cur.x] = 1;
						dir = 0;
						cur.x--;
					}
					break;
				case 5:
					maze[cur.y][cur.x] = 1;
					cur.x = stack.arr[stack.top][0];
					cur.y = stack.arr[stack.top][1];
					dir = stack.arr[stack.top][2];
					maze[cur.y][cur.x] = 0;
					stack.pop();
					break;
				}
			}
		}
		
		while(!stack.IsEmpty()) {
			int mx = stack.arr[stack.top][0];
			int my = stack.arr[stack.top][1];
			
			if(mx == start.x && my == start.y) {
				mark[my][mx] = 'S';
			}
			else if(mx == exit.x && my == exit.y) {
				mark[my][mx] = 'F';
			}
			else {
				mark[my][mx] = '*';
			}
			
			stack.pop();
		}
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}
		
	}
		
}
