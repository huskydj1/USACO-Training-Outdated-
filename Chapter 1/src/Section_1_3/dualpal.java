package Section_1_3;

/*
ID: huskydj1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;
public class dualpal {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("dualpal.in"));
		PrintWriter out = new PrintWriter(new File("dualpal.out"));
		
		int n = in.nextInt(); 
		int s = in.nextInt()+1;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(result.size()!=n) {
			int count = 0;
			for(int i = 2; i<=10; i++) {
				String converted = toBase(i, s);
				if(isPal(converted)) count++;
				if(count==2) break;
			}
			if(count==2) result.add(s);
			s++;
		}
		for(int i = 0; i<n; i++) out.println(result.get(i));
		out.close();
		in.close();
	}
	public static String toBase (int base, int num) {
		if(num ==0) return "";
		else {
			return toBase(base, num/base) + makeSure(Integer.toString(num%base));
		}
	}
	public static String makeSure (String input) {
		int a = Integer.parseInt(input);
		if(a>=0&&a<10) return input;
		else return ((char)(a+55))+"";
	}
	public static boolean isPal (String input) {
		char[] word = input.toCharArray();
		int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
}
