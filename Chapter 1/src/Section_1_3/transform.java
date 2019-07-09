package Section_1_3;
/*
ID: huskydj1
LANG: JAVA
TASK: transform
*/
import java.util.*;
import java.io.*;
public class transform {

	private static char[][]b;
	private static char[][]w;
	private static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(new File("transform.in"));
		PrintWriter out=new PrintWriter(new File("transform.out"));
		n=in.nextInt();
		b=new char[n][n];
		w=new char[n][n];
		
		for(int i=0; i<n; i++){
			b[i]=in.next().toCharArray();
		}
		for(int i=0; i<n; i++){
			w[i]=in.next().toCharArray();
		}
		
		boolean check=false;
		rotate();
		if(isTrue()&&check==false){
			out.println(1);
			check=true;
		}
		rotate();
		if(isTrue()&&check==false){
			out.println(2);
			check=true;
		}
		rotate();
		if(isTrue()&&check==false){
			out.println(3);
			check=true;
		}
		rotate();
		reflect();
		if(isTrue()&&check==false){
			out.println(4);
			check=true;
		}
		rotate();
		if(isTrue()&&check==false){
			out.println(5);
			check=true;
		}
		rotate();
		if(isTrue()&&check==false){
			out.println(5);
			check=true;
		}
		rotate();
		if(isTrue()&&check==false){
			out.println(5);
			check=true;
		}
		rotate();
		if(isTrue()&&check==false){
			out.println(6);
			check=true;
		}
		if(check==false)
			out.println(7);
		out.close();
	}
	
	public static void rotate(){
		char[][]arr=new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=b[i][j];
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				b[i][j]=arr[n-j-1][i];
			}
		}
	}
	public static void reflect(){
		char[][]arr=new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=b[i][j];
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				b[i][j]=arr[i][n-j-1];
			}
		}
	}
	public static boolean isTrue(){
		int count=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(b[i][j]==w[i][j])
					count++;
			}
		}
		if(count==(n*n))
			return true;
		else
			return false;
	}
}