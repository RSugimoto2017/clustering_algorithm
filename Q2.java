import java.io.*;

public class Q2 {
	public static void main(String[] args) {
		int j = 0;
		double[][] samples = new double[150][5];
		String[] tmp = new String[5];
		double[] heikinVec1 = new double[4];
		double[] hensaVec1 = new double[4];
		double[] heikinVec2 = new double[4];
		double[] hensaVec2 = new double[4];
		double[] heikinVec3 = new double[4];
		double[] hensaVec3 = new double[4];
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		
	
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
		
			for(int x = 0; x < 150; x++) {
				for(int y = 0; y < 5; y++){
					System.out.print(samples[x][y]+ " ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------------------");
			
			for(int k = 0; k < 150; k++) {
				if(samples[k][4] == 1.0) {
					for(int m = 0; m < 4; m++) {
						heikinVec1[m] += samples[k][m];
					}
					cnt1++;
				}else if(samples[k][4] == 2.0) {
					for(int m = 0; m < 4; m++) {
						heikinVec2[m] += samples[k][m];
					}
					cnt2++;
				}else if(samples[k][4] == 3.0) {
					for(int m = 0; m < 4; m++) {
						heikinVec3[m] += samples[k][m];
					}
					cnt3++;
				}
			}
			
			for(int n = 0; n < 4; n++) {
				heikinVec1[n] = heikinVec1[n]/cnt1;
				heikinVec2[n] = heikinVec2[n]/cnt2;
				heikinVec3[n] = heikinVec3[n]/cnt3;
			}
			
			
			System.out.println("平均ベクトル");
			System.out.print("Setosa : [");
			for(int a = 0; a < 4; a++) {
				System.out.print(heikinVec1[a]+", ");
			}
			System.out.println("]");
			System.out.print("Versicolor : [");
			for(int a = 0; a < 4; a++) {
				System.out.print(heikinVec2[a]+", ");
			}
			System.out.println("]");
			System.out.print("Virginia : [");
			for(int a = 0; a < 4; a++) {
				System.out.print(heikinVec3[a]+", ");
			}
			System.out.println("]");
			
			cnt1 = 0;
			cnt2 = 0;
			cnt3 = 0;
			
			for(int k = 0; k < 150; k++) {
				if(samples[k][4] == 1.0) {
					for(int m = 0; m < 4; m++) {
						hensaVec1[m] += (samples[k][m]-heikinVec1[m]) * (samples[k][m]-heikinVec1[m]);
					}
					cnt1++;
				}else if(samples[k][4] == 2.0) {
					for(int m = 0; m < 4; m++) {
						hensaVec2[m] += (samples[k][m]-heikinVec2[m]) * (samples[k][m]-heikinVec2[m]);
					}
					cnt2++;
				}else if(samples[k][4] == 3.0) {
					for(int m = 0; m < 4; m++) {
						hensaVec3[m] += (samples[k][m]-heikinVec3[m]) * (samples[k][m]-heikinVec3[m]);
					}
					cnt3++;
				}
			}
			
			for(int n = 0; n < 4; n++) {
				hensaVec1[n] = Math.sqrt(hensaVec1[n]/cnt1);
				hensaVec2[n] = Math.sqrt(hensaVec2[n]/cnt2);
				hensaVec3[n] = Math.sqrt(hensaVec3[n]/cnt3);
			}
			
			System.out.println("標準偏差ベクトル");
			System.out.print("Setosa : [");
			for(int a = 0; a < 4; a++) {
				System.out.print(hensaVec1[a]+", ");
			}
			System.out.println("]");
			System.out.print("Versicolor : [");
			for(int a = 0; a < 4; a++) {
				System.out.print(hensaVec2[a]+", ");
			}
			System.out.println("]");
			System.out.print("Virginia : [");
			for(int a = 0; a < 4; a++) {
				System.out.print(hensaVec3[a]+", ");
			}
			System.out.println("]");
				

			br.close();
   
          
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
