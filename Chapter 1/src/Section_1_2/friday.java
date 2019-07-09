package Section_1_2;
/*
ID:husky.d1
LANG:JAVA
TASK:friday
 */
import java.util.*;
import java.io.*;
public class friday {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader ("friday.in"));
		PrintWriter out = new PrintWriter (new FileWriter ("friday.out"));
		
		int n = Integer.parseInt(in.readLine())+1900;
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[]dates = new int[7];
		int day = 0; 
		for (int i = 1900; i < n; i++){
			
			if(isLeap(i)) month[1] = 29; 
			else month[1] = 28;
			for (int a = 0; a<12; a++){
				int Th = day + 12;
				int d = Th%7;
				dates[d]++;
				day+=month[a];
			}
		}
		
		System.out.println(dates[5]+" "+dates[6]+" "+dates[0]+" " + dates[1]+" "+dates[2]+" "+dates[3]+" "+dates[4]);
		out.close();
		in.close();
}
	public static boolean isLeap(int i){
		if(i%400==0) return true;
		else if (i%100==0) return false; 
		else if (i%4==0) return true;
		else return false;
	}

}
