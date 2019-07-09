/*
ID: huskydj1
LANG: JAVA
TASK: hamming 
*/

import java.io.*;
import java.util.*;

public class hamming {

	static class pair implements Comparable<pair>{
		public int dec;
		public String binary;
		
		public pair (int d, String b) {
			dec = d;
			binary = b;
		}
		
		public int compareTo(pair that) {
			return this.dec - that.dec;
		}
	}
	
	public static ArrayList<pair> list = new ArrayList<pair>();
	public static int n, b, d;
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new FileWriter("hamming.out"));
		
		n = in.nextInt(); //num of codewords
		b = in.nextInt(); //length of bits
		d = in.nextInt(); //at least Hamming distance
		
		int max = (int)Math.pow(2, b);
		
		for(int i = 0; i<max; i++) {
			if(list.size()==n) break;
			else {
				String binary = Integer.toBinaryString(i);
				while(binary.length()!=b) binary = "0" + binary;
				//System.out.println(binary);
				if(works(i, binary)) list.add(new pair(i, binary));
			}
		}
		
		String res = "";
		for(int i = 0; i<n; i++) {
			if(i!=0&&i%10==0) {
				res = res.trim();
				System.out.println(res);
				res = "";
			}
			res +=list.get(i).dec + " ";
		}
		if(!res.equals("")) {
			res = res.trim();
			System.out.println(res);
		}
		out.close();
	}
	
	public static boolean works (int dec, String binary) {
		
		for(pair temp : list) {
			int diff = 0;
			for(int i = 0; i<b; i++) {
				if(binary.charAt(i)!=temp.binary.charAt(i)) diff++;
			}
			if(diff<d) return false;
		}
		return true;
	}
}
