import java.io.*;
import java.util.Scanner;

class ListNode{
	String data;
	ListNode rlink;
	ListNode llink;
}

class DoubleLinkedList{
	private ListNode head;
	private ListNode tail;
	
	public DoubleLinkedList() {
		head = tail = null;
	}
	
	public void insert(String str) {
		ListNode l = new ListNode();
		ListNode cur = new ListNode();
		
		l.data = str;
		cur = head;
		
		if(head == null) {
			head = tail = l;
			return;
		}
		
		while(cur != null) {
			if(str.compareTo(cur.data) < 0) {
				if(cur == head) {
					l.llink = cur.llink;
					l.rlink = cur;
					cur.llink = l;
					head = l;
				}
				else {
					l.llink = cur.llink;
					l.rlink = cur;
					cur.llink.rlink = l;
					cur.llink = l;
				}
				return;
			}
			else if(cur.rlink == null) {
				cur.rlink = l;
				l.llink = cur;
				return;
			}
			else {
				cur = cur.rlink;
			}
		}
	}
	
	public void delete(String str) {
		 if (head == null) {
	         return;
	      }
		
		for (ListNode p = head; p != null; p = p.rlink) {
	         if (p.data.equals(str)) {
	           if (p.llink == null) {
	        	   p.rlink.llink = p.llink;
	        	   head = p.rlink;
	               return;
	            } else if (p.rlink == null) {
	               p.llink.rlink = p.rlink;
	               tail = p.llink;
	               return;
	            } 
	            else {
	            	p.llink.rlink = p.rlink;
		            p.rlink.llink = p.llink;
		            return;
	            }
	         }
	      }
	}
	
	public void print() {
		if(head == null) {
			System.out.println("EMPTY");
			return;
		}
		
		String str = "";
		for(ListNode p = head; p != null; p = p.rlink) {
			System.out.print(p.data + " ");
		}
		System.out.println();
	}
}

public class Main10 {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList list = new DoubleLinkedList();
		
		while(true) {
			String cmd = scan.next();
			if(cmd.equals("E")) break;
			
			if(cmd.equals("I")) {
				list.insert(scan.next());
			}
			else if(cmd.equals("D")) {
				list.delete(scan.next());
			}
			else if(cmd.equals("P")) {
				list.print();
			}
			else {
				System.out.println("ERROR");
			}
		}
	}

}
