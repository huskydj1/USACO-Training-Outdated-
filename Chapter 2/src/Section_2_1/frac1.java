/*
ID: huskydj1
LANG: JAVA
TASK: frac1
*/
import java.io.*;
import java.util.*;
public class frac1 {
	
	static class frac implements Comparable<frac>{
		int num, den;
		
		public frac(int u, int d) {
			num = u;
			den = d;
		}
		

		@Override
		public int compareTo(frac m) {
			return this.num*m.den - m.num*this.den;
		} 
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("frac1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("frac1.out"));
		
		int n = in.nextInt();
		ArrayList<frac> list = new ArrayList<frac>();
		
		for(int down = 2; down<=n; down++) {
			for(int up = 1; up<down; up++) {
				if(isSimple(up, down)) list.add(new frac(up, down));
			}
		}
		Collections.sort(list);
		
		out.println("0/1");
		for(frac temp: list) out.println(temp.num + "/" + temp.den);
		out.println("1/1");
		out.close();
	}
	
	public static boolean isSimple(int a, int b) {
		int r = a%b;
		while(r!=0) {
			a=b; b=r; r=a%b;
		}
		return b==1;
	}
}

/*
0/1
1/5
1/4
1/3
2/5
1/2
3/5
2/3
3/4
4/5
1/1
*/