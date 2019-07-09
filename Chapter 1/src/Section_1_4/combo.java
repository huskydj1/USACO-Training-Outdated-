/*
ID: huskydj1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;
public class combo {

public static int n;
public static int f1, f2, f3;
public static int m1, m2, m3;

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("combo.in"));
		PrintWriter out = new PrintWriter(new File("combo.out"));

		//input
		n = in.nextInt();
		f1 = in.nextInt();
		f2 = in.nextInt();
		f3 = in.nextInt();
		m1 = in.nextInt();
		m2 = in.nextInt();
		m3 = in.nextInt();
		
		int count = 0;
		
		//going through all
		for(int a = 1; a<=n; a++) {
			for(int b = 1; b<=n; b++) {
				for(int c = 1; c<=n; c++) {
					if(solveF(a, b, c)||solveM(a,b,c)) count++;
				}
			}
		}
		
		//output
		out.println(count);
		out.close();
		}
	public static boolean solveF(int a, int b, int c) {
		return check(a, f1)&&check(b, f2)&&check(c, f3);
	}
	public static boolean solveM(int a, int b, int c) {
		return check(a, m1)&&check(b, m2)&&check(c, m3);
	}
	public static boolean check (int x, int y) {
		if (Math.abs(x-y)<=2) return true;
		if (Math.abs(x-y)>=n-2) return true;
		return false;
	}
}
