package merge_sort;

public class Merge_Sort_Code {

    static  int  arr[]={40,-1,20,60,37,-5,0};

    public static void main(String args[])
    {
        // Print array before merge sort
        System.out.println("Array before sorting:");
        printArray(arr,0,arr.length-1);
        System.out.println("=================================");

        mergeSort(0,arr.length-1);

        System.out.println("==================================");

        // Print array after merge sorting
        System.out.println("Array After sorting:");
        printArray(arr,0,arr.length-1);

    }

    // Recursive algorithm for merge sort to divide array in to two equal halves until we reach a single element array
    public static void mergeSort(int start,int end)
    {
        int mid=(start+end)/2;
        if(start<end)
        {
            // Sort left half of the array
            mergeSort(start,mid);
            // Sort right half of the array
            mergeSort(mid+1,end);
            // Merge left and right half of the array
            merge(start,mid,end);
        }

    }

    private static void merge(int lb, int mid, int ub) {
        // Initializing one temp array of length equal to initial array arr[]
        int[] barr=new int[arr.length];
        int i = lb;
        int j = mid+1;
        int k =lb;

        System.out.print("Before Merging  array elements:  ");
        printArray(arr,lb,ub);

        // It will iterate until smaller list reaches to the end
        while(i<=mid && j<=ub)
        {
            if(arr[i]<=arr[j])
            {
                barr[k]=arr[i];
                i++;
            }
            else
            {
                barr[k]=arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements

        if(i>mid)

        {
            while (j<=ub)

            {
                barr[k]=arr[j];
                j++;
                k++;
            }

        }
        else {
            while (i<=mid){
                barr[k]=arr[i];
                i++;
                k++;

            }
        }

        // Copy tempArray elements to actual array after merge sort operation
        for (int m = lb; m <=ub; m++) {
            arr[m]=barr[m];
        }

        System.out.print("After merging elements in array:   ");
        printArray(barr,lb,ub);
        System.out.println();
    }

    public static void printArray(int arr[],int start,int end)
    {
        for (int i = start; i <=end; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

/*
Time complexity:
Best case: O(nlogn)
Average case: O(nlogn)
Worst case: O(nlogn)
 */