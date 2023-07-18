package sort_rotate_search;
public class SearchRotatedArray {
	
	public int search(int[] arr,int val) {
		
		int start = 0;
		int end = arr.length-1;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == val) {
				return mid;
			}
			if(arr[start] < arr[mid]) {
				//left part of array is sorted
				if(val>=arr[start] && val<=arr[mid]) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			} else {
				//right part of array is sorted
				if(val>=arr[mid] && val<=arr[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
		}
		return -1;
	}
}
