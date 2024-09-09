package numList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int cnt = 1;
		while(true) {
			System.out.print("입력할 숫자 개수(2~10) : " );
			num = sc.nextInt();
			if(num >= 2 && num <= 10) {
				System.out.printf("\n숫자 데이터 %d개 입력\n", num);
				break;
			}else {
				System.out.println("\n2~10사이의 값을 입력해주세요");				
			}
		}
		double[] list = new double[num];
		for (int i = 0; i < num; i++) {
			System.out.printf("%d. 입력값 : ", cnt);
			cnt++;
			list[i] = sc.nextDouble();
		}
//		System.out.println(Arrays.toString(list));
		sc.close();
		BigNumber big = new BigNumber();
		SmallNumber small = new SmallNumber();
		Average avg = new Average();
		
		big.mtdNumRes(list);
		small.mtdNumRes(list);
		avg.mtdNumRes(list);
	}
	
}