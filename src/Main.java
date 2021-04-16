import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static int[] arrayOfDiscs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String message = "";
		int numCases = Integer.parseInt(br.readLine());
		arrayOfDiscs = new int[numCases];
		for(int k = 0; k<arrayOfDiscs.length;k++) {
			arrayOfDiscs[k] = Integer.parseInt(br.readLine());
			message += solveTowers(arrayOfDiscs[k])+"\n";
		}
		bw.write(message);
		bw.flush();
		br.close();
		bw.close();
	}

	public static String solveTowers(int numDiscs) {
		return solveTowers(numDiscs,numDiscs,0,0);
	}
	
	public static String solveTowers(int numDiscs, int initialNeedle, int tempNeedle, int finalNeedle) {
		if(numDiscs == 1) {
			String msg = "\n"+initialNeedle+" "+tempNeedle+" "+finalNeedle;
			finalNeedle = initialNeedle;
			initialNeedle = 0;
			return msg+="\n"+initialNeedle+" "+tempNeedle+" "+finalNeedle;
		}else{
			String msg = "\n"+initialNeedle+" "+tempNeedle+" "+finalNeedle;
			msg += solveTowers(numDiscs-1, numDiscs-(numDiscs-1), numDiscs-(numDiscs-1), finalNeedle);
			msg += solveTowers(numDiscs-1, tempNeedle, finalNeedle, initialNeedle);
			return msg; 
		}
	}
}
