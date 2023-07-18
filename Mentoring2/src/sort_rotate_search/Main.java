package sort_rotate_search;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number");
		int num = input.nextInt();
		int[] arr = new int[num];
		
		System.out.println("enter " +num+ " values in the array");
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		MergeSort ms = new MergeSort();
		ms.divide(arr,0,arr.length-1);
		
		System.out.print("Sorted array is: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		RotateArray ra = new RotateArray();
		ra.rotateArrayFromMid(arr);
		
		System.out.print("\nRotated array is: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		SearchRotatedArray s = new SearchRotatedArray();
		System.out.println("\nEnter the number you want to search in the rotated array");
		int val = input.nextInt();
		int index = s.search(arr,val);
		System.out.println("Your value found at index: " +index);
		input.close();
	}

}
