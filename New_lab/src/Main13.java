import java.io.*;
import java.util.Scanner;

public class Main13 {
	
	static class Stack{
		private int top;
		private int StackSize;
		private Object arr[];
		
		public Stack() {
			top =-1;
			StackSize = 50;
			arr = new Object[StackSize];
		}
		
		public boolean IsEmpty() {
			return top == -1;
		}
		
		public void push(Object x) {
			if(top == StackSize -1) {
				return;
			}
			else {
				top++;
				arr[top] = x;
			}
		}
		
		public Object pop() {
			if(IsEmpty()) return null;
			else return arr[top--];
		}
		
		public void delete() {
			if(IsEmpty()) return;
			else top--;
		}
		
		public Object peek() {
			if(IsEmpty()) return null;
			else return arr[top];
		}
	}

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		
		String str = scan.next();
		while(!str.equals("$")) {
			if(str.equals("(")){
				stack.push(str);
			}
			else if(str.equals(")")) {
				while(true) {
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
					else {
						System.out.print(stack.pop() + " ");
					}
				}
			}
			else if(str.equals("+") || str.equals("-")){
				if(!stack.IsEmpty()) {
					if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("/")) {
						System.out.print(stack.pop() + " ");
					}
				}
				stack.push(str);
			}
			else if(str.equals("*") || str.equals("/")) {
				if(!stack.IsEmpty()) {
					if(stack.peek().equals("*") || stack.peek().equals("/")) {
						System.out.print(stack.pop() + " ");
					}
				}
				stack.push(str);
			}
			else {
				System.out.print(str + " ");
			}
			
			str = scan.next();
		}
		
		while(!stack.IsEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
	}

}
