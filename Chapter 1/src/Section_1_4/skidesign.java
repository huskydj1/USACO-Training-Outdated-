import java.io.*;
import java.util.*;
public class skidesign {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("skidesign.in"));
		PrintWriter out = new PrintWriter(new File("skidesign.out"));
		
		int n = in.nextInt();
		int[] heights = new int[n];
		for(int i = 0; i<n; i++) heights[i] = in.nextInt();
		Arrays.sort(heights);
		System.out.println(Arrays.toString(heights)+"\n");
		
		int[] arr = new int[101];
		for(int i = 0; i<n; i++) {
			
		}
	}

}
