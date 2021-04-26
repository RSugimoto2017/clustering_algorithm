import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q9 {
	public static void main(String[] args) {
		int j = 0;
		double[][] samples = new double[150][5];
		String[] tmp = new String[5];
		double g = 0;
		double w[] = {0.33, 0.23, -0.38, -0.05, 0.47};
		double[] x = new double[5];
		double[] hantei = new double[100];
		double truecnt = 0;
		double seido = 0;
		
		x[0] = 1;
		
		try {
			File file = new File("E:\\temp\\iris.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
	
			String str= null;
		
			while((str = br.readLine()) != null){
			
			
				//System.out.println(str);
         
				tmp = str.split(" ");
				for(int i = 0; i < tmp.length; i++) {
					samples[j][i] = Double.parseDouble(tmp[i]);
				}
			
				j++;
			}
		
			for(int m = 0; m < 150; m++) {
				for(int n = 0; n < 5; n++){
					System.out.print(samples[m][n]+ " ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------------------");
			for(int kaisu = 0; kaisu < 100; kaisu++) {
				for(int i = 50; i < 150; i++) {
					
					g = 0;
					
					for(int a = 0; a < 4; a++) {
						x[a + 1] = samples[i][a];
					}
					
					for(int k = 0; k < 5; k++) {
						
						g += (x[k] * w[k]);
						
					}
					
					//System.out.println("g = "+g);
					
					if(g > 0) {
						hantei[i-50] = 2.0;
					}else if(g < 0) {
						hantei[i-50] = 3.0;
					}
					
					if(hantei[i-50] == samples[i][4]) {
					}else if(hantei[i-50] == 2.0){
						for(int z = 0; z < 5; z++) {
							w[z] = w[z] - (1.0 * x[z]);
						}
					}else if(hantei[i-50] == 3.0) {
						for(int z = 0; z < 5; z++) {
							w[z] = w[z] + (1.0 * x[z]);
						}
					}
				}
			}
			
			System.out.print("w = [");
			for(int b = 0; b < 5; b++) {
				System.out.print(w[b] + ", ");
			}
			System.out.println("]");
			
			for(int i = 50; i < 150; i++) {
				
				g = 0;
				
				for(int k = 0; k < 5; k++) {
					if(k == 0) {
						g += (1 * w[k]);
					}else {
						g += (samples[i][k-1] * w[k]);
					}
				}
				
				//System.out.println("g = "+g);
				
				if(g > 0) {
					hantei[i-50] = 2.0;
				}else if(g < 0) {
					hantei[i-50] = 3.0;
				}
				
				if(hantei[i-50] == samples[i][4]) {
					truecnt++;
				}else {
				}
			}
			seido = truecnt / 100;
			
			for(int m = 0; m < 100; m++) {
				for(int n = 0; n < 5; n++){
					System.out.print(samples[m + 50][n]+ " ");
				}
				System.out.println("”»’è : " + hantei[m]);
			}
			
			seido = seido * 100;
			
			System.out.println("”»’è§“x : " + seido + "%");
				
			
				

			br.close();
   
          
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
