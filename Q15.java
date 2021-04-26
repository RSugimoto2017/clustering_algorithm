import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q15 {
	public static void main(String[] args) {
		int j = 0;
		double[][] samples = new double[150][5];
		String[] tmp = new String[5];
		
		int start = 0;
		
		int kunrendata = 10;
		
		double[][]prot1 = new double[kunrendata - start][5];
		double[][]prot2 = new double[kunrendata - start][5];
		double[][]prot3 = new double[kunrendata - start][5];
		
		double[][]nearprot = new double[150][4];
		
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
			
			int near1 = 0;
			double sum = 0;
			double nearsum1 = 1000000;
			int near2 = 0;
			double nearsum2 = 1000000;
			int near3 = 0;
			double nearsum3 = 1000000;
			
			start = 0;
			
			for(int i = 0; i < kunrendata; i++) {
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot1[l][k] - samples[i][k])*(prot1[l][k] - samples[i][k]));
					}
					if(sum < nearsum1) {
						nearsum1 = sum;
						near1 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス１で最も近いプロトタイプ" + near1 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][0] = nearsum1;
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot2[l][k] - samples[i][k])*(prot2[l][k] - samples[i][k]));
					}
					if(sum < nearsum2) {
						nearsum2 = sum;
						near2 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス２で最も近いプロトタイプ" + near2 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][1] = nearsum2;
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot3[l][k] - samples[i][k])*(prot3[l][k] - samples[i][k]));
					}
					if(sum < nearsum3) {
						nearsum3 = sum;
						near3 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス３で最も近いプロトタイプ" + near3 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][2] = nearsum3;
			}
			
			
			near1 = 0;
			sum = 0;
			near2 = 0;
			near3 = 0;
			start = 50;
			
			for(int i = start; i < start + kunrendata; i++) {
				nearsum1 = 1000000;
				nearsum2 = 1000000;
				nearsum3 = 1000000;
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot1[l][k] - samples[i][k])*(prot1[l][k] - samples[i][k]));
					}
					if(sum < nearsum1) {
						nearsum1 = sum;
						near1 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス１で最も近いプロトタイプ" + near1 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][0] = nearsum1;
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot2[l][k] - samples[i][k])*(prot2[l][k] - samples[i][k]));
					}
					if(sum < nearsum2) {
						nearsum2 = sum;
						near2 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス２で最も近いプロトタイプ" + near2 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][1] = nearsum2;
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot3[l][k] - samples[i][k])*(prot3[l][k] - samples[i][k]));
					}
					if(sum < nearsum3) {
						nearsum3 = sum;
						near3 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス３で最も近いプロトタイプ" + near3 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][2] = nearsum3;
			}
			
			
			near1 = 0;
			sum = 0;
			near2 = 0;
			near3 = 0;
			start = 100;
			
			for(int i = start; i < start + kunrendata; i++) {
				nearsum1 = 1000000;
				nearsum2 = 1000000;
				nearsum3 = 1000000;
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot1[l][k] - samples[i][k])*(prot1[l][k] - samples[i][k]));
					}
					if(sum < nearsum1) {
						nearsum1 = sum;
						near1 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス１で最も近いプロトタイプ" + near1 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][0] = nearsum1;
				
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot2[l][k] - samples[i][k])*(prot2[l][k] - samples[i][k]));
					}
					if(sum < nearsum2) {
						nearsum2 = sum;
						near2 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス２で最も近いプロトタイプ" + near2 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][1] = nearsum2;
				
				for(int l = 0; l < kunrendata; l++) {
					for(int k = 0; k < 4; k++) {
						sum += ((prot3[l][k] - samples[i][k])*(prot3[l][k] - samples[i][k]));
					}
					if(sum < nearsum3) {
						nearsum3 = sum;
						near3 = l;
					}
					sum = 0;
				}
				System.out.println(i+1 + "番目にクラス３で最も近いプロトタイプ" + near3 + "番目");
				System.out.println("---------------------------------------------------------");
				nearprot[i][2] = nearsum3;
				
			}
			
			double truecnt = 0;
			start = 0;
			for(int i = 0 ; i < kunrendata; i++) {
				
				double mostnear = 1000000;
				for(int k = 0; k < 3; k++) {
					System.out.println(nearprot[i][k]);
					if(nearprot[i][k] < mostnear) {
						mostnear = nearprot[i][k];
						nearprot[i][3] = k + 1;
					}
				}
				System.out.println(i+1 + "番目に最も近いプロトタイプは" + nearprot[i][3] + "グループ");
				if(samples[i][4] == nearprot[i][3]) {
					truecnt++;
				}
			}
			
			start = 50;
			
			for(int i = start; i < start + kunrendata; i++) {
				
				double mostnear = 1000000;
				for(int k = 0; k < 3; k++) {
					System.out.println(nearprot[i][k]);
					if(nearprot[i][k] < mostnear) {
						mostnear = nearprot[i][k];
						nearprot[i][3] = k + 1;
					}
				}
				System.out.println(i+1 + "番目に最も近いプロトタイプは" + nearprot[i][3] + "グループ");
				if(samples[i][4] == nearprot[i][3]) {
					truecnt++;
				}
			}
			
			start = 100;
			
			for(int i = start; i < start + kunrendata; i++) {
				
				double mostnear = 1000000;
				for(int k = 0; k < 3; k++) {
					System.out.println(nearprot[i][k]);
					if(nearprot[i][k] < mostnear) {
						mostnear = nearprot[i][k];
						nearprot[i][3] = k + 1;
					}
				}
				System.out.println(i+1 + "番目に最も近いプロトタイプは" + nearprot[i][3] + "グループ");
				if(samples[i][4] == nearprot[i][3]) {
					truecnt++;
				}
			}
			System.out.println("分類成功　：" + truecnt + "個");
			System.out.println("---------------------------------------------------------");
			seido = (truecnt / (kunrendata * 3)) * 100;
			System.out.println("分類精度　：" + seido + "%");
			
			
			
			
			br.close();
			   
	          
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
