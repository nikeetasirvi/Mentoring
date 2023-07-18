package sort_rotate_search;
public class MergeSort {
	
	public void divide(int[] arr,int start,int end) {
		if (start<end){
			int mid = start + (end - start) / 2;
			divide(arr,start,mid);
			divide(arr,mid+1,end);
			conqure(arr,start,end,mid);
		}
	}
	
	public void conqure(int[] arr,int start,int end,int mid) {
		int[] merged = new int[end-start+1];
		int index1 = start;
		int index2 = mid+1;
		int x=0;
		while(index1<=mid && index2<=end) {
			if(arr[index1]<arr[index2]) {
				merged[x++] = arr[index1++];
			} else {
				merged[x++] = arr[index2++];
			}
		}
		while(index1<=mid) {
			merged[x++] = arr[index1++];
		}
		while(index2<=end) {
			merged[x++] = arr[index2++];
		}
		for(int i=0,j=start; i<merged.length; i++,j++) {
			arr[j] = merged[i];
		}
	}
	
}
