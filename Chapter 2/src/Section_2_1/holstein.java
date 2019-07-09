/*
ID: huskydj1
LANG: JAVA
TASK: holstein 
*/

import java.io.*;
import java.util.*;

public class holstein {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new FileWriter("holstein.out"));
		
		//Input
		int v = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] min = new int[v];
		for(int i = 0; i<v; i++) min[i] = Integer.parseInt(st.nextToken());
		
		int g = Integer.parseInt(in.readLine());
		int[][] options  = new int[g][v];
		
		for(int i = 0; i<g; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<v; j++) {
				options[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		//Process
		int minScoops = g+1;
		ArrayList<Integer> exactScoops = new ArrayList<Integer>();
		
		
		int max = (int) Math.pow(2, g);
		for(int binaryIterator = 1; binaryIterator<max; binaryIterator++) {
			String comb = Integer.toBinaryString(binaryIterator);
			while(comb.length()!=g) comb="0" +comb;
			
			int[] temp = new int[v];
			
			int thisScoops = 0;
			ArrayList<Integer> tempScoops = new ArrayList<Integer>();
			
			for(int i = 0; i<g; i++) {
				if(comb.charAt(i)=='1') {
					thisScoops++;
					tempScoops.add(i+1);
					for(int j = 0; j<v; j++) {
						temp[j] += options[i][j];
					}
				}
			}
			
			//System.out.println(comb + " " + Arrays.toString(temp));
			
			boolean works = true;
			for(int i = 0; i<v; i++) {
				if(temp[i]<min[i]) {
					works = false;
					break;
				}
			}
			if(works) {
				if(minScoops>=thisScoops) {
					minScoops = thisScoops;
					exactScoops = new ArrayList<Integer>();
					exactScoops.addAll(tempScoops);
				}
			}
			
		}
		
		out.print(minScoops);
		for(int i = 0; i<exactScoops.size(); i++) out.print(" " + exactScoops.get(i));
		out.println();
		out.close();
	}

}
