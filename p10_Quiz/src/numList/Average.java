package numList;

public class Average implements NumberSequence {

	@Override
	public void mtdNumRes(double[] list) {
		double sum = 0;
		double avg = 0;
		for (double num : list) sum += num;
		avg = sum/list.length;
		System.out.printf("평균 : %.1f", avg);
	}

}