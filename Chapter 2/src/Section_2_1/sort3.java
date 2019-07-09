/*
ID: huskydj1
LANG: JAVA
TASK: sort3 
*/

import java.io.*;
import java.util.*;

public class sort3 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new FileWriter("sort3.out"));
		
		int n = Integer.parseInt(in.readLine().replaceAll(" ", ""));
		
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(in.readLine());
		
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		int i12 = 0;
		int i21 = 0;
		int i13 = 0;
		int i31 = 0;
		int i23 = 0;
		int i32 = 0;
		
		for(int i = 0; i<n; i++) {
			if(arr[i]==1&&sorted[i]==2) i12++;
			if(arr[i]==2&&sorted[i]==1) i21++;
			if(arr[i]==1&&sorted[i]==3) i13++;
			if(arr[i]==3&&sorted[i]==1) i31++;
			if(arr[i]==2&&sorted[i]==3) i23++;
			if(arr[i]==3&&sorted[i]==2) i32++;
		}
		
		int res = Math.min(i12, i21) + Math.min(i13, i31) + Math.min(i23, i32);
		
		int resOne = res+ 2*Math.abs(i21-i12);
		int resTwo = res+ 2*Math.abs(i13-i31);
		int resThree = res + 2*Math.abs(i23-i32);
		
		if(res!=resOne) out.println(resOne);
		else if(res!=resTwo) out.println(resTwo);
		else out.println(resThree);
		
		out.close();
	}
	
}
