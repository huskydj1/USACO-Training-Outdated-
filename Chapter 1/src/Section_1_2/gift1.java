package Section_1_2;
/*
ID: husly.d1
LANG: JAVA
TASK: gift1
 */

import java.util.*;
import java.io.*;
public class gift1 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader ("gift1.in"));
		PrintWriter out = new PrintWriter (new FileWriter ("gift1.out"));
			
		int n = Integer.parseInt(in.readLine());
		
		Map<String, Integer> g = new LinkedHashMap<String, Integer>();
		
		for(int i = 0; i<n; i++){
			g.put(in.readLine(), 0);
		}
		
		for(int k = 0; k<n;k++){
			String giver = in.readLine();
			String[] temp = in.readLine().split(" ");
			int money = Integer.parseInt(temp[0]);
			int num = Integer.parseInt(temp[1]);
			if(num!= 0){
			g.put(giver, g.get(giver)-money);
			int given = money/num;
			int remainder = money%num;
			
			for (int i = 0; i<num; i++){
				String name = in.readLine();
				g.put(name, g.get(name)+given);
			}
			
			g.put(giver, g.get(giver)+remainder);
			}
		}
		
		Iterator<String> key = g.keySet().iterator();
		while(key.hasNext()){
			String name = (String)key.next();
			out.println(name+" " + g.get(name));
		}
		out.close();
		in.close();
	}

}
