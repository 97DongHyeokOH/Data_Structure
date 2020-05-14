import java.io.*;
import java.util.Scanner;

class Polynomial{
	class Term{
		int coef;
		int exp;
		Term link;
	}
	
	 Term head;
	 Term tail;
	
	public Polynomial() {
		head = tail = null;
	}
	
	public void addTerm(int coef, int exp) {
		Term term = new Term();
		term.coef = coef;
		term.exp = exp;
		term.link = null;
		
		if(head == null) {
			head = tail = term;
		}
		else {
			tail.link = term;
			tail = term;
		}
	}
	
	public String toString() {
	      StringBuffer str = new StringBuffer();
	      int idx = 0;
	      
	      if(head == null) {
	    	  str.append("0");
	    	  return str.toString();
	      }
	      
	      while(head != null) {
	    	  if(head.coef > 0) {
	    		  if(idx != 0) {
	    			  str.append("+");
	    		  }
	    		  if(head.coef == 1) {
	    			  if(head.exp == 0) {
	    				  str.append("1");
	    			  }
	    			  else if(head.exp == 1) {
	    				  str.append("x");
	    			  }
	    			  else {
	    				  str.append("x^").append(head.exp);
	    			  }
	    		  }
	    		  else if(head.exp == 1) {
	    			  str.append(head.coef).append("x");
	    		  }
	    		  else if(head.exp == 0) {
	    			  str.append(head.coef);
	    		  }
	    		  else {
	    			  str.append(head.coef).append("x^").append(head.exp);
	    		  }
	    	  }
	    	  else {
	    		  if(head.coef == -1) {
	    			  if(head.exp == 0) {
	    				  str.append("-1");
	    			  }
	    			  else if(head.exp == 1) {
	    				  str.append("x");
	    			  }
	    			  else {
	    				  str.append("x^").append(head.exp);
	    			  }
	    		  }
	    		  else if(head.exp == 1) {
	    			  str.append(head.coef).append("x");
	    		  }
	    		  else if(head.exp == 0) {
	    			  str.append(head.coef);
	    		  }
	    		  else {
	    			  str.append(head.coef).append("x").append(head.exp);
	    		  }
	    	  }
	    	  head = head.link;
	    	  idx++;
	      }
	      
	      return str.toString();
	   }

	
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		Polynomial p = new Polynomial();
		
		while(p1.head != null || p2.head != null) {
			if(p1.head == null || p2.head == null) {
				if(p1.head == null) {
					p1.addTerm(0, 0);
				}
				else if(p2.head == null) {
					p2.addTerm(0, 0);
				}
			}
			
			if(p1.head.exp == p2.head.exp) {
				if(p1.head.coef + p2.head.coef != 0) {
					p.addTerm(p1.head.coef + p2.head.coef, p1.head.exp);
				}
				p1.head = p1.head.link;
				p2.head = p2.head.link;
			}
			else if(p1.head.exp > p2.head.exp) {
				p.addTerm(p1.head.coef, p1.head.exp);
				p1.head = p1.head.link;
			}
			else {
				p.addTerm(p2.head.coef, p2.head.exp);
				p2.head = p2.head.link;
			}
			
			if(p1.head == null && p2.head == null) {
				break;
			}
		}
		
		return p;
	}
}

public class Main9 {

	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p1.addTerm(coef, exp);
		}
		
		Polynomial p2 = new Polynomial();
		int no2 = scan.nextInt();
		for(int i = 0; i < no2; i++) {
			int coef2 = scan.nextInt();
			int exp2 = scan.nextInt();
			p2.addTerm(coef2, exp2);
		}
		
		Polynomial p3 = Polynomial.polyAdd(p1, p2);
		
		System.out.println(p3);
		
	}

}
