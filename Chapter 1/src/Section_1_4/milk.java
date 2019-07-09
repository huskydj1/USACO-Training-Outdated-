/*
ID: huskydj1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class Farmer implements Comparable <Farmer>{
	int price;
	int stock;
	Farmer(int price, int stock){
		this.price = price;
		this.stock = stock;
	}
	public int compareTo(Farmer that) {
		return this.price-that.price;
	}
}
public class milk {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new File("milk.out"));
		
		String[] info = in.readLine().split(" ");
		int need = Integer.parseInt(info[0]);
		int numFarmer = Integer.parseInt(info[1]);
		Farmer[] list = new Farmer[numFarmer];
		for(int i = 0; i<numFarmer; i++) {
			String[] input = in.readLine().split(" ");
			list[i] = new Farmer(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		int cost = 0;
		
		Arrays.sort(list);
		
		for(int i = 0; i<numFarmer; i++) {
			if(need>=list[i].stock) {
				need = need-list[i].stock;
				cost+=(list[i].stock*list[i].price);
				System.out.println(cost + " " + need + " " + list[i].stock + " " + list[i].price);
			}
			else {
				cost+=list[i].price*need;
				break;
			}
			if(need==0) break;
		}
		out.println(cost);
		out.close();
	}

}
