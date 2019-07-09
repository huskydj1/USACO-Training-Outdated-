package Section_1_2;
/*
ID:husky.d1
LANG:JAVA
TASK:beads
*/
import java.util.*;
import java.io.*;
public class beads {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader ("beads.in"));
		PrintWriter out = new PrintWriter (new FileWriter ("bead.out"));
		
		int len = Integer.parseInt(in.readLine());
		String necklace = in.readLine();
		necklace+= necklace;
		//System.out.println(necklace);
		int case1 = 0;
		int c; 
		int same = 0; 
		int max = 0; 
		char key; 
		for (int i = 0; i<len; i++){
			same = 0;
			case1=0;
			c = 0;
			key = necklace.charAt(i); 
			//System.out.println(key);
			while (c<(len+i) && case1<=2){
				
				char next = necklace.charAt(c); 
				System.out.println(next+" "+case1);
				if (next!='w'&&next!=key){
					case1 ++;
					key = next;
				}
				c++;
				same++;
			}
			same--;
			if (same > max) max = same;
		}
		
		out.println(max);
		out.close();
		in.close();
		
	}

}
