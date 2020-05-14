import java.io.*;
import java.util.Scanner;

class SparseMatrix{
	int [][] m;
	int []n;
	int []k;
	int nCol, nRow, nNo;
	
	public SparseMatrix(int row, int col, int no) {
		m = new int[no+1][3];
		n = new int[row];
		k = new int[row];
		m[0][0] = col;
		m[0][1] = row;
		m[0][2] = no;
		this.nCol = col;
		this.nRow = row;
		this.nNo = no;
	}
	
	public void transpose() {
		SparseMatrix sm = new SparseMatrix(nCol, nRow, nNo);
		
		for(int i = 1; i <= nNo; i++) {
			n[m[i][1]]++;
		}
		
		k[0] = 1;
		
		for(int i = 1; i < nRow; i++) {
			k[i] = k[i-1] + n[i-1];
		}
		
		for(int i = 1; i <= nNo; i++) {
			sm.m[k[m[i][1]]][0] = m[i][1];
			sm.m[k[m[i][1]]][1] = m[i][0];
			sm.m[k[m[i][1]]][2] = m[i][2];
			
			k[m[i][1]]++;
			
		}
		
		m = sm.m;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		for(int i = 0; i <= nNo; i++) {
			str.append(m[i][0]).append(" ")
			   .append(m[i][1]).append(" ")
			   .append(m[i][2]).append("\n");
		}
		
		return str.toString();
	}
}

public class Main8 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int col = scan.nextInt();
		int row = scan.nextInt();
		int no = scan.nextInt();
		
		SparseMatrix matrix = new SparseMatrix(row, col, no);
		
		for(int i = 1; i <= no; i++) {
			matrix.m[i][0] = scan.nextInt();
			matrix.m[i][1] = scan.nextInt();
			matrix.m[i][2] = scan.nextInt();
		}
		
		matrix.transpose();
		
		System.out.println(matrix);
	}

}
