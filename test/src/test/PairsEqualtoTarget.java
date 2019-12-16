package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairsEqualtoTarget{
	public static void main(String args[]){
		int[] numbers = new int[]{2,4,3,5,6,-2,4,7,8,9};
		int target = 7;
		int diff;
		for (int i : numbers){
			diff = target - i;
			if (Arrays.binarySearch(numbers, diff)>0){
				System.out.printf("(%d, %d)\n", i, diff);
			}
		}
		System.out.print("\n");
		Set set = new HashSet(numbers.length);
		for (int i : numbers){
			diff = target - i;
			
			if (!set.contains(diff)){
				set.add(i);
			}
			else{
				System.out.printf("(%d, %d)\n", i, diff);
			}
		}
	}
}