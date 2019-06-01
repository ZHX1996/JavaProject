public class FindMinMax{
	public static void main(String args[]){
		int[] numbers = new int[] {5,3,7,2,6,1};
		int minValue = numbers[0];
		int maxValue = numbers[0];
		for (int i = 1; i<numbers.length; i++){
			if (numbers[i] < minValue){
				minValue = numbers[i];
			}
			if (numbers[i] > maxValue){
				maxValue = numbers[i];
			} 
		}
		System.out.println(String.valueOf(minValue) + '\n' + String.valueOf(maxValue));
	}
}