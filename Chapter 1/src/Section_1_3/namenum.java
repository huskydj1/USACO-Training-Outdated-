package Section_1_3;

/*

ID: huskydj1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

public class namenum {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new File("namenum.out"));
		
		long num = Long.parseLong(in.readLine());
		int len = Long.toString(num).length();
		
		ArrayList<String> possible = new ArrayList<String>();
		for(int i = 0; i<4617; i++) {
			String name = dict.readLine();
			if(name.length()==len) possible.add(name);
		}
		
		ArrayList[] combinations = new ArrayList[len];
		for(int i = len-1; i>=0; i--) {
			combinations[i] = new ArrayList<Character>();
			combinations[i] = convert(num%10);
			num=num/10;
		}
		
		ArrayList<String> result = new ArrayList<String>();
		int size = possible.size();
		for(int i = 0; i<size; i++) {
			boolean check = true;
			String word = possible.get(i);
			for(int j = 0; j<len; j++) {
				if(combinations[j].contains(word.charAt(j)));
				else {
					check = false;
					break;
				}
			}
			if(check) result.add(word);
		}
		
		size = result.size();
		if(size!=0) for(int i = 0; i<size; i++) out.println(result.get(i));
		else out.println("NONE");
		out.close();
		in.close();
	}
	public static ArrayList<Character> convert (long l){
		ArrayList<Character> converted = new ArrayList<Character>();
		if(l==2) {
			converted.add('A'); converted.add('B'); converted.add('C');
		}
		else if(l==3) {
			converted.add('D'); converted.add('E'); converted.add('F');
		}
		else if(l==4) {
			converted.add('G'); converted.add('H'); converted.add('I');
		}
		else if(l==5) {
			converted.add('J'); converted.add('K'); converted.add('L');
		}
		else if(l==6) {
			converted.add('M'); converted.add('N'); converted.add('O');
		}
		else if(l==7) {
			converted.add('P'); converted.add('R'); converted.add('S');
		}
		else if(l==8) {
			converted.add('T'); converted.add('U'); converted.add('V');
		}
		else if(l==9) {
			converted.add('W'); converted.add('X'); converted.add('Y');
		}
		return converted;
	}
}
