package Section_1_3;

/*
ID: huskydj1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;
import java.util.*;

class Time implements Comparable <Time>{
	int begin;
	int end;
	Time(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	public int compareTo(Time that) {
		return this.begin-that.begin;
	}
}

public class milk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new File("milk2.out"));
		int n = Integer.parseInt(in.readLine());
		Time[] schedule = new Time[n];
		int begin = 5000;
		int end = 0;
		for(int i = 0; i<n; i++) {
			String[] temp = in.readLine().split(" ");
			begin = Math.min(begin, Integer.parseInt(temp[0]));
			end = Math.max(end, Integer.parseInt(temp[1]));
			schedule[i] = new Time(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}
		Arrays.sort(schedule);
		
		int[] list = new int[end];
		for(int i = 0; i<n; i++) {
			for(int a = schedule[i].begin; a<schedule[i].end; a++) {
				list[a]=1;
			}
		}
		int milked = 0;
		int notMilked = 0;
		
		int temp1 = 0;//zeroes
		int temp2 = 0;//ones
		for(int i = begin; i<end; i++) {
			if(list[i]==0) {
				temp1++;
				notMilked = Math.max(notMilked, temp2);
				temp2=0;
			}
			else{
				temp2++;
				milked = Math.max(milked, temp1);
				temp1=0;
			}
		}
		milked = Math.max(milked, temp1);
		notMilked = Math.max(notMilked, temp2);
		out.println(notMilked +" " + milked);
		out.close();
		in.close();
	}
}