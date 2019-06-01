import java.util.Arrays;
import java.util.BitSet;

public class MissingNumber{
	public static void main(String args[]){
		printMissingNumber(new int[] {1,2,3,4,9,8}, 10);
	}
	
	private static void printMissingNumber(int[] numbers, int count){
		int missingCount = count-numbers.length;
		BitSet bitSet = new BitSet(count);
		
		for (int number : numbers) {
			bitSet.set(number - 1);
		}
		
		int lastMissingIndex = 0;
		for (int i=0; i<missingCount; i++){
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}
}
		
		