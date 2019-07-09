/*
ID: huskydj1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;
public class barn1 {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new File("barn1.out"));
		
		int boards = in.nextInt();
		int stalls = in.nextInt();
		int cows = in.nextInt();
		
		if(boards>=cows) out.println(cows);
		else {
			int[] locations = new int[cows];
			for(int i = 0; i<cows; i++)locations[i] = in.nextInt();
			Arrays.sort(locations);
			
			//System.out.println(Arrays.toString(locations));
			int[] gaps = new int[cows-1];
			for(int i = 0; i<cows-1; i++) gaps[i] = ((locations[i+1]-1)-(locations[i]+1))+1;
			//System.out.println(Arrays.toString(gaps));
			
			Arrays.sort(gaps);
			int results = 0;
			for(int i  = cows-2; i>(cows-2-(boards-1)); i--) {
				results +=gaps[i];
			}
			
			results +=(locations[0]-1 + (stalls-(locations[cows-1]+1)+1));
			out.println(stalls-results);
		}
		
		out.close(); in.close();
	}

}
//http://train.usaco.org/usacoprob2?a=DmTzM0Tde8F&S=barn1