import java.io.*;
import java.util.Scanner;

class Stack{
	private int top;
	private int stackSize;
	private Object arr[];
	
	public Stack() {
		top =-1;
		stackSize = 50;
		arr = new Object[stackSize];
	}
	
	public boolean IsEmpty() {
		return top == -1;
	}
	
	public void push(Object x) {
		if(top == stackSize -1) {
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

public class Main12 {

	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		
		String str = scan.next();
		while(!str.equals("$")) {
			if(str.equals("+")) {
				Object n1 = stack.peek();
				stack.pop();
				Object n2 = stack.peek();
				stack.pop();
				stack.push((double)n1 + (double)n2);
			}
			else if(str.equals("-")) {
				Object n1 = stack.peek();
				stack.pop();
				Object n2 = stack.peek();
				stack.pop();
				stack.push((double)n2 - (double)n1);
			}
			else if(str.equals("*")) {
				Object n1 = stack.peek();
				stack.pop();
				Object n2 = stack.peek();
				stack.pop();
				stack.push((double)n1 * (double)n2);
			}
			else if(str.equals("/")) {
				Object n1 = stack.peek();
				stack.pop();
				Object n2 = stack.peek();
				stack.pop();
				stack.push((double)n2 / (double)n1);
			}
			else {
				System.out.print(str + " ");;
			}
			
			str = scan.next();
		}
		
		System.out.println(stack.peek());
		
	}

}
