package test;

import java.util.Arrays;

public class ReverseArray{
	public static void main(String args[]){
		int[] iArray = {1,2,3,4,5};
		String[] sArray = {"one", "two", "three"};
		reverse(iArray);
		System.out.println(Arrays.toString(iArray));
	}
	
	public static void reverse(int[] arrays){
		for (int i=0;i<arrays.length/2;i++){
			int temp = arrays[i];
			arrays[i] = arrays[arrays.length-i-1];
			arrays[arrays.length-i-1] = temp;
		}
	}
}