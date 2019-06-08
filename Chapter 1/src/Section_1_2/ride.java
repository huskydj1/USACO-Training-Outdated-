package Section_1_2;
/*
ID: husky.d1
LANG: JAVA
TASK: ride
 */
import java.util.*;
import java.io.*;
public class ride {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader ("ride.in"));
		PrintWriter out = new PrintWriter(new FileWriter ("ride.out"));
		
		String CometName = in.readLine();
		String GroupName = in.readLine();
		
		int cn = 1;
		int gn = 1;
		for (int i = 0; i<CometName.length(); i++){
			int j= CometName.charAt(i)-64;
			cn*=j;
		}
		for (int i = 0; i<GroupName.length(); i++){
			int j= GroupName.charAt(i)-64;
			gn*=j;
		}
		
		if (cn%47==gn%47) out.println("GO");
		else out.println("STAY");
		
		out.close();
		in.close();
	}

}
