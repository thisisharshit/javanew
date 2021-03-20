import java.util.Arrays;
import java.util.Scanner;





public class array {
	private static Scanner s  =new Scanner(System.in);
	private static int[] a = {1,2};
	public static void main(String args[]) {
		/*int []arr = getint(4);
		int[] arr2=arr;
		arr2[0]=10;
		System.out.println(a[0]);
		System.out.println(Arrays.toString(arr));
		print(arr);
		sortarr(arr);
		
		print(arr);
*/
		int [] b = a;
		a=new int[4];
		b[0]=10;
		System.out.println(Arrays.toString(a));
		
		
		
		
		
	}
	public static int[] getint(int n) {
		int[] val = new int[n];
		for(int i=0;i<n;i++) {
			val[i] = s.nextInt();
		}
		return val;
	}
	public static void print(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void sortarr(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
	}

}
