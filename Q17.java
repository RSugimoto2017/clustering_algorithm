import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q17 {
	public static void main(String[] args) {
		int j = 0;
		double[][] samples = new double[150][5];
		String[] tmp = new String[5];
		
		int start = 0;
		
		int kunrendata = 20;
		
		double[][]prot1 = new double[kunrendata - start][5];
		double[][]prot2 = new double[kunrendata - start][5];
		double[][]prot3 = new double[kunrendata - start][5];
		
		double seido;
		try {
			File file = new File("E:\\temp\\iris.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
	
			String str= null;
		
			while((str = br.readLine()) != null){
			
			
				//System.out.println(str);
         
				tmp = str.split(" ");
				
				if(start == 0 && j < kunrendata + start) {
					for(int i = 0; i < tmp.length; i++) {
						prot1[j][i] = Double.parseDouble(tmp[i]);
					}
					if(j == ((kunrendata + start) - 1)) {
						start = 50;
					}
				}
				
				if(start == 50 && 50 <= j && j < kunrendata + start) {
					for(int i = 0; i < tmp.length; i++) {
						prot2[j - 50][i] = Double.parseDouble(tmp[i]);
					}
					if(j == ((kunrendata + start) - 1)) {
						start = 100;
					}
				}
				
				if(start == 100 && 100 <= j && j < (kunrendata + start)) {
					for(int i = 0; i < tmp.length; i++) {
						prot3[j - 100][i] = Double.parseDouble(tmp[i]);
					}
				}
				
				
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
			
			for(int m = 0; m < kunrendata; m++) {
				for(int n = 0; n < 5; n++){
					System.out.print(prot1[m][n]+ " ");
				}
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------");
			for(int m = 0; m < kunrendata; m++) {
				for(int n = 0; n < 5; n++){
					System.out.print(prot2[m][n]+ " ");
				}
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------");
			for(int m = 0; m < kunrendata; m++) {
				for(int n = 0; n < 5; n++){
					System.out.print(prot3[m][n]+ " ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------------------");
			
			double heikin1[] = new double[4];
			double heikin2[] = new double[4];
			double heikin3[] = new double[4];
			
			for(int i = 0; i < kunrendata ; i++) {
				for(int k = 0; k < 4; k++) {
					heikin1[k] += prot1[i][k];
				}
			}
			for(int n = 0; n < 4; n++) {
				heikin1[n] = (heikin1[n] / kunrendata);
			}
			
			for(int i = 0; i < kunrendata ; i++) {
				for(int k = 0; k < 4; k++) {
					heikin2[k] += prot2[i][k];
				}
			}
			for(int n = 0; n < 4; n++) {
				heikin2[n] = (heikin2[n] / kunrendata);
			}
			
			for(int i = 0; i < kunrendata ; i++) {
				for(int k = 0; k < 4; k++) {
					heikin3[k] += prot3[i][k];
				}
			}
			for(int n = 0; n < 4; n++) {
				heikin3[n] = (heikin3[n] / kunrendata);
			}
			
			double dis1 = 0;
			double dis2 = 0;
			double dis3 = 0;
			double moyori[] = new double[150];
			double hantei[] = new double [150];
			
			for(int a = 0; a < 150; a++) {
				dis1 = 0;
				dis2 = 0;
				dis3 = 0;
				if(kunrendata <= a && a < 50) {
					for(int b = 0; b < 4; b++) {
						dis1 += (samples[a][b] - heikin1[b])*(samples[a][b] - heikin1[b]);
					}
					for(int b = 0; b < 4; b++) {
						dis2 += (samples[a][b] - heikin2[b])*(samples[a][b] - heikin2[b]);
					}
					for(int b = 0; b < 4; b++) {
						dis3 += (samples[a][b] - heikin3[b])*(samples[a][b] - heikin3[b]);
					}
					
					moyori[a] = dis1;
					hantei[a] = 1.0;
					if(moyori[a] > dis2) {
						moyori[a] = dis2;
						hantei[a] = 2.0;
					}
					if(moyori[a] > dis3) {
						moyori[a] = dis3;
						hantei[a] = 3.0;
					}
					
				}
				if(kunrendata + 50 <= a && a < 100) {
					for(int b = 0; b < 4; b++) {
						dis1 += (samples[a][b] - heikin1[b])*(samples[a][b] - heikin1[b]);
					}
					for(int b = 0; b < 4; b++) {
						dis2 += (samples[a][b] - heikin2[b])*(samples[a][b] - heikin2[b]);
					}
					for(int b = 0; b < 4; b++) {
						dis3 += (samples[a][b] - heikin3[b])*(samples[a][b] - heikin3[b]);
					}
					
					moyori[a] = dis1;
					hantei[a] = 1.0;
					if(moyori[a] > dis2) {
						moyori[a] = dis2;
						hantei[a] = 2.0;
					}
					if(moyori[a] > dis3) {
						moyori[a] = dis3;
						hantei[a] = 3.0;
					}
				}
				if(kunrendata + 100 <= a && a < 150) {
					for(int b = 0; b < 4; b++) {
						dis1 += (samples[a][b] - heikin1[b])*(samples[a][b] - heikin1[b]);
					}
					for(int b = 0; b < 4; b++) {
						dis2 += (samples[a][b] - heikin2[b])*(samples[a][b] - heikin2[b]);
					}
					for(int b = 0; b < 4; b++) {
						dis3 += (samples[a][b] - heikin3[b])*(samples[a][b] - heikin3[b]);
					}
					
					moyori[a] = dis1;
					hantei[a] = 1.0;
					if(moyori[a] > dis2) {
						moyori[a] = dis2;
						hantei[a] = 2.0;
					}
					if(moyori[a] > dis3) {
						moyori[a] = dis3;
						hantei[a] = 3.0;
					}
				}
			}
			double truecnt = 0;
			for(int i = 0; i < 150; i++) {
				if((kunrendata <= i && i < 50) || (kunrendata + 50 <= i && i < 100) || (kunrendata + 100 <= i && i < 150)) {
					if(samples[i][4] == hantei[i]) {
						truecnt++;
					}
				}
			}
			
			
			System.out.println("分類成功　：" + truecnt + "個");
			System.out.println("---------------------------------------------------------");
			seido = (truecnt / (150 - (kunrendata * 3))) * 100;
			System.out.println("分類精度　：" + seido + "%");
			
			
			
			
			br.close();
			   
	          
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
