package sort_rotate_search;

public class RotateArray {
	
	public void rotateArrayFromMid(int[] arr) {
		
		int mid = (arr.length-1)/2;
		
		for(int i=0;i<mid;i++) {
			int temp = arr[0];
			for(int j=0;j<arr.length-1;j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = temp;
		}
	}

}
