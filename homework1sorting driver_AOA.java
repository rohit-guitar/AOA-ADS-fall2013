import java.util.Random;

public class SortingDriver {
	
	// Do not change the main method
	public static void main(String[] args) {
		final long SEED = 1378947745233l;
		Random generator = new Random(SEED);

		System.out.println("size\tselect\tinsert\tmerge\tquick");

		int start = 100, end = 100000;
		int size = start;
		while (size < end) {
			int randomArray[] = new int[size];
			for (int i = 0; i < randomArray.length; ++i)
				randomArray[i] = generator.nextInt();

			System.out.print(size + "\t");

			int a1[] = randomArray.clone(), a2[] = randomArray.clone(), a3[] = randomArray
					.clone(), a4[] = randomArray.clone();

			long startTime = System.currentTimeMillis();
			selectionSort(a1);
			long endTime = System.currentTimeMillis();
			long time = endTime - startTime;
			System.out.print(time + "\t");

			startTime = System.currentTimeMillis();
			insertionSort(a2);
			endTime = System.currentTimeMillis();
			time = endTime - startTime;
			System.out.print(time + "\t");

			startTime = System.currentTimeMillis();
			mergeSort(a3);
			endTime = System.currentTimeMillis();
			time = endTime - startTime;
			System.out.print(time + "\t");

			startTime = System.currentTimeMillis();
			quickSort(a4);
			endTime = System.currentTimeMillis();
			time = endTime - startTime;
			System.out.println(time);

			size = size * 3 / 2;
		}

	}

	// Implement your algorithms here

	public static void selectionSort(int arr[]) {
		int imin;
		for (int i=0;(i<arr.length-1);i++){
			imin=i;
			for(int j=i+1 ;j<arr.length;j++){
				if(arr[j]<arr[imin]){
					imin=j;
				}
			}
			
			if(imin!=i){
				final int temp= arr[i];
				arr[i]=arr[imin];
				arr[imin]=temp;			
			}
		} 
	}

	public static void insertionSort(int arr[]) {
		for(int i=1;i<arr.length;i++){
			int temp=i;
			int val=arr[i];
			while((temp>0) && (arr[temp-1]>val)){
				arr[temp]=arr[temp-1];
				temp--;
			}
		arr[temp]=val;
		}
		
	}

	public static void mergeSort(int arr[]) {
				
		MergeSort.mergeSort(arr); // static function call mergesort class			
	}

	public static void quickSort(int arr[]) {
		QuickSort.quickSort(arr); // static function call quick sort 
					
	}

}

// class for merge sort 

class MergeSort{
		
	static void mergeSort(int arr[]){
	    if (arr.length > 1) {
            int[] leftarr  = leftHalf(arr);
            int[] rightarr = rightHalf(arr);
            mergeSort(leftarr);
            mergeSort(rightarr);
            merge(arr, leftarr, rightarr);
        }
	}	

	 static int[] leftHalf(int[] arr){
		int n = arr.length / 2;
        	int[] left = new int[n];
        	for (int i = 0; i < n; i++) {
            		left[i] = arr[i];
        	}
        	return left;
	}

	 static int[] rightHalf(int[] arr){
	  	int n1 = arr.length / 2;
       	  	int n  = arr.length - n1;
          	int[] right = new int[n];
          	for (int i = 0; i < n; i++) {
            		right[i] = arr[i + n1];
        	}
        	return right;
    	}	

	static void merge(int[] output, int[] left, int[] right) {
        	int l = 0;   
        	int m = 0;   
        
        	for (int i = 0; i < output.length; i++) {
            		if (m >= right.length || (l < left.length && left[l] <= right[m])) {
                	output[i] = left[l];    
                	l++;
            		} 
	    		else {
                	output[i] = right[m];   
                	m++;
            		}
        	}
   	} 


}


// class for quick sort 

 class QuickSort {

  	public static void quickSort(int[] array) {
    		quickSort(array, 0, array.length - 1);
  	}

 	 private static void quickSort(int[] array, int imin, int imax) {
    		if (imax > imin) {
      		int ipivot = part(array, imin, imax);
      		quickSort(array, imin, ipivot - 1);
      		quickSort(array, ipivot + 1, imax);
    		}
  	}

  	private static int part(int[] array, int imin, int imax) {
    		int pivot = array[imin]; 
    		int ilow = imin + 1; 
    		int ihigh = imax; 

    		while (ihigh > ilow) {
     		 while (ilow <= ihigh && array[ilow] <= pivot)
        		ilow++;

		 while (ilow <= ihigh && array[ihigh] > pivot)
        	        ihigh--;

     		 if (ihigh > ilow) {
        		int temp = array[ihigh];
        		array[ihigh] = array[ilow];
        		array[ilow] = temp;
      			}
    		}

  	  while (ihigh > imin && array[ihigh] >= pivot)
      		ihigh--;

   	 if (pivot > array[ihigh]) {
      		array[imin] = array[ihigh];
      		array[ihigh] = pivot;
      		return ihigh;
    	}
    	else {
      	return imin;
    	}
}

}
 

