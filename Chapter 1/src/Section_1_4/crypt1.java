/*
ID: huskydj1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;
public class crypt1 {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new File("crypt1.out"));
		
		int n = in.nextInt();
		ArrayList<Integer> digits = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) digits.add(in.nextInt());
		
		int count = 0;
		for(int big = 100; big<1000; big++) {
			for(int small = 10; small<100; small++) {
				if(contained(big, digits)&&contained(small, digits)&&check(big, small, digits)) {
					count++;
				}
			}
		}
		out.println(count);
		out.close(); in.close();
		
	}
	public static boolean check(int big, int small, ArrayList<Integer>digits) {
		int firstProd = big*(small%10);
		int secondProd = big*(small/10);
		int finalProd = firstProd + secondProd*10;
		
		if(contained(firstProd, digits) && contained(secondProd, digits) && contained(finalProd, digits)) {
			if(countDigits(firstProd)==3
				&& countDigits(secondProd)==3
				&& countDigits(finalProd)==4)
				return true;
			return false;
		}
		return false;	
	}
	public static boolean contained (int num, ArrayList<Integer> digits) {
		while(num>0) {
			int temp = num%10; 
			if(!digits.contains(temp)) return false;
			num/=10;
		}
		return true;
	}
	public static int countDigits (int num) {
		String temp = Integer.toString(num);
		return temp.length();
	}
}
