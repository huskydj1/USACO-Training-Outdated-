/*
ID: huskydj1
LANG: JAVA
TASK: castle
*/
import java.io.*;
import java.util.*;
public class castle {

	public static int r, c, orig[][], roomno[][], room[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new FileWriter("castle.out"));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		orig = new int[r+2][c+2];
		roomno = new int[r+2][c+2];
		room = new int[(c+1)*(r*1)];
		
		for(int i = 1; i<=r; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j<=c; j++){
				orig[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		int max = -1;
		for(int i = 1; i<=r; i++) {
			for(int j = 1; j<=c; j++) {
				if(roomno[i][j]==0) {
					count++;
					floodfill(i, j, count);
					max = Integer.max(max, room[count]);
				}
			}
		}
		//One: The number of rooms the castle has.
		out.println(count);
		//Two: The size of the largest room
		out.println(max);
		//System.out.println(Arrays.toString(room));
		
		//for(int x = 1; x<=r; x++) System.out.println(Arrays.toString(roomno[x]));
		
		max = -1;
		int x1 = 0;
		int y1 = 0;
		char d = 'a';
		
		for(int y=1; y<=c; y++) {
			for(int x = r; x>=1; x--) {
				int num = roomno[x][y];
				//System.out.println(num);
				
				if(roomno[x-1][y]!=0) {
					if((orig[x][y]&2)!=0 && roomno[x-1][y]!=num) {
						int value = room[num]+room[roomno[x-1][y]];
						//System.out.println("HELLO");
						if(max<value) {
							x1=x;
							y1=y;
							d = 'N';
							max = value;
						}
					}
				}
				
				
				if(roomno[x][y+1]!=0) {
					if((orig[x][y]&4)!=0 && roomno[x][y+1]!=num) {
						int value = room[num]+room[roomno[x][y+1]];
						//System.out.println("HELLO");
						if(max <value) {
							x1=x;
							y1=y;
							d = 'E';
							max = value;
						}
					}
				}
				
			}
		}
		out.println(max);
		out.println(x1 + " " + y1 + " " + d);
		out.close();
	}
	
	public static void floodfill (int x, int y, int id) {
		roomno[x][y]=id;
		room[id]++;
		
		if((orig[x][y]&1)==0 && roomno[x][y-1]==0) floodfill(x, y-1, id);
		if((orig[x][y]&2)==0 && roomno[x-1][y]==0) floodfill(x-1, y, id);
		if((orig[x][y]&4)==0 && roomno[x][y+1]==0) floodfill(x, y+1, id);
		if((orig[x][y]&8)==0 && roomno[x+1][y]==0) floodfill(x+1, y, id);
	}

}
