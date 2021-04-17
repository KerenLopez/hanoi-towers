import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	public static Integer[] arrayOfDiscs;
	public static Integer[] needles;
	public static Integer a;
	public static Integer b;
	public static Integer c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/Hanoi_input.txt"));
		PrintWriter pw = new PrintWriter("data/Hanoi_output.txt");
		int numCases = Integer.parseInt(br.readLine());
		arrayOfDiscs = new Integer[numCases];
		for(int k = 0; k<arrayOfDiscs.length;k++) {
			arrayOfDiscs[k] = Integer.parseInt(br.readLine());
			moveTowers(arrayOfDiscs[k], pw);
		}
		br.close();
		pw.close();
	}
	
	public static void moveTowers(int numDiscs, PrintWriter pw) throws FileNotFoundException {
		needles = new Integer[3];
		a = numDiscs;
		b = 0;
		c = 0;
		needles[0] = a;
		needles[1] = b;
		needles[2] = c;
		pw.println(needles[0]+" "+needles[1]+" "+needles[2]);
		moveTowers(numDiscs, numDiscs,0, 2, 1, pw);
		pw.print("\n");
	}
	
	public static void moveTowers(int numDiscs, int d, Integer initialNeedle, Integer finalNeedle, Integer tempNeedle, PrintWriter pw) throws FileNotFoundException {
		if(numDiscs == 1) {
			needles[initialNeedle]--;
			needles[finalNeedle]++;
			pw.println(needles[0]+" "+needles[1]+" "+needles[2]);
		}else{
			moveTowers(numDiscs-1, d, initialNeedle, tempNeedle, finalNeedle, pw);
			needles[initialNeedle]--;
			needles[finalNeedle]++;
			pw.println(needles[0]+" "+needles[1]+" "+needles[2]);
			moveTowers(numDiscs-1, d, tempNeedle, finalNeedle, initialNeedle, pw); 
		}
	}
}
