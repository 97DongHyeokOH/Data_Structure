import java.util.Scanner; 
import java.io.*;

public class Main5 {

	public static int bin(int[] a, int key, int left, int right) {
		int mid = (left + right) / 2;
		if(a[mid] == key) {
			return mid;
		}
		
		if(left <= right) {
			if(key < a[mid]) {
				return bin(a, key, left, mid-1);
			}
			else {
				return bin(a, key, mid+1, right);
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int no = scan.nextInt();
		int[] arr = new int[no];
		
		for(int i = 0; i < no; i++) {
			arr[i] = scan.nextInt();
		}
		
		int key = scan.nextInt();
		
		int idx = bin(arr, key, 0, no-1);
		System.out.println(idx);
		
	}

}
