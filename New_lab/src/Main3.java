
import java.io.*;

class Point2{
	public int x;
	public int y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Point p) {
		if(x == p.x) {
			if(y == p.y) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
}

public class Main3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x1 = Integer.parseInt(br.readLine());
		int y1 = Integer.parseInt(br.readLine());
		int x2 = Integer.parseInt(br.readLine());
		int y2 = Integer.parseInt(br.readLine());
		
		Point2 point1 = new Point2(x1, y1);
		Point2 point2 = new Point2(x2, y2);
		
		System.out.println(point1.equals(point2));

	}

}
