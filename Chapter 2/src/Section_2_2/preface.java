
/*
ID: huskydj1
LANG: JAVA
PROG: preface
*/

import java.io.*;
import java.util.*;

public class preface {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        int N = Integer.parseInt(br.readLine());
        int[] totals = new int[7];
        int[] values = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
        char[] symbols = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        for (int num = 1; num <= N; num++) {
            int n = num;
            System.out.println();
            for (int i = totals.length - 1; i >= 0; i -= 2) {
                int times = n / values[i];

                if (times == 9) {
                    totals[i]++;
                    totals[i + 2]++;
                } else if (times > 4) {
                    totals[i + 1]++;
                    totals[i] += times - 5;
                } else if (times == 4) {
                    totals[i]++;
                    totals[i + 1]++;
                } else {
                    totals[i] += times;
                }

                n -= values[i] * times;
            	//System.out.println(n+" " + values[i]+" "+times+" "+ Arrays.toString(totals));

            }            
        }
        for (int i = 0; i < totals.length; i++) {
            if (totals[i] != 0) {
                out.println(symbols[i] + " " + totals[i]);
            }
        }
        br.close();
        out.close();       
    }
}