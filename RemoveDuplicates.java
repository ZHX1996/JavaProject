import java.util.Arrays;

public class RemoveDuplicates{
	public static void main(String args[]) {
		int[][] test = new int[][]{
		{1,1,2,2,3,4,5},
		{1,1,1,1,1,1,1},
		{1,2,3,4,5,6,7},
		{1,2,1,1,1,1,1},
		};
		for (int[] input : test){
			System.out.println(Arrays.toString(removeDuplicates(input)));
		}
	}
	
	public static int[] removeDuplicates(int[] numbers){
		Arrays.sort(numbers);
		int previous = numbers[0];
		int[] result = new int[numbers.length];
		result[0] = previous;
		
		for (int i = 1; i<numbers.length; i++){
			int ch = numbers[i];
			if (previous != ch){
				result[i] = ch;
			};
			previous = ch;
		}
		return result;
	}
}