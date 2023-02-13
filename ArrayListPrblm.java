package Assignment;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListPrblm {
	public static Integer max(ArrayList<Integer> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		
		int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> c1 = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of values to be inserted in arraylist");
		int s = sc.nextInt();
		System.out.println("Enter the values");
		
		for (int i = 0; i < s; i++) {
			int k = sc.nextInt();
			c1.add(k);
		}
		
		Integer max = max(c1);
		
		if (max == null) {
			System.out.println("Null");
		} else {
			System.out.println("Maximum element in array list is: " + max);
		}
	}	
}
