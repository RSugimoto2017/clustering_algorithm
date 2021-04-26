import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q7 {
	public static void main(String[] args) {
		int j = 0;
		double[][] samples = new double[150][5];
		String[] tmp = new String[5];
		double g = 0;
		double w[] = {0.33, 0.23, -0.38, -0.05, 0.47};
		double[] hantei = new double[100];
		double truecnt = 0;
		double seido = 0;
		
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
				for(int i = 0; i < 100; i++) {
					
					g = 0;
					
					for(int k = 0; k < 5; k++) {
						if(k == 0) {
							g += (1 * w[k]);
						}else {
							g += (samples[i][k-1] * w[k]);
						}
					}
					
					System.out.println("g = "+g);
					
					if(g > 0) {
						hantei[i] = 1.0;
					}else if(g < 0) {
						hantei[i] = 2.0;
					}
					
					if(hantei[i] == samples[i][4]) {
						truecnt++;
					}else {
					}
				}
				seido = truecnt / 100;
				
				for(int m = 0; m < 100; m++) {
					for(int n = 0; n < 5; n++){
						System.out.print(samples[m][n]+ " ");
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
