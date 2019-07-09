package Section_1_3;

/*
ID: huskydj1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;
public class palsquare {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new File("palsquare.out"));
		
		int b = Integer.parseInt(in.readLine());
		String[] possible = new String[301];
		for(int i = 1; i<301; i++) {
			possible[i] = toBase(b, i);
		}
		
		String[] squared = new String[301];
		for(int i = 1; i<301; i++) {
			squared[i] = toBase(b, (int)Math.pow(i,2));
			if(isPal(squared[i])) out.println(possible[i] + " " + squared[i]);
		}
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
