import java.util.PriorityQueue;
import java.util.Scanner;

public class TimeForJuices {

	public static int timeToPrepare(PriorityQueue<Integer> maxheap) {
		int time = 0;
		
		while(maxheap.size()>1) {
			time++;
			int first = maxheap.poll() - 1;
			int second = maxheap.poll() - 1;
			if(first>0) {
				maxheap.add(first);
			}
			if(second>0) {
				maxheap.add(second);
			}
		}
		if(maxheap.size()==1) {
			time = time+maxheap.remove();
		}
		return time;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
		
		System.out.println("Total no of orders for mango juice");
		int mangoOrders = input.nextInt();
		System.out.println("Total no of orders for orange juice");
		int orangeOrders = input.nextInt();
		System.out.println("Total no of orders for pineapple juice");
		int pineappleOrders = input.nextInt();
		maxheap.add(mangoOrders);
		maxheap.add(orangeOrders);
		maxheap.add(pineappleOrders);
		System.out.println(maxheap);
		System.out.println("Time taken is " +timeToPrepare(maxheap));
	}

}
