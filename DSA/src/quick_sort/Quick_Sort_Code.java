package quick_sort;

import java.util.Arrays;

public class Quick_Sort_Code {
    /*until start less than end we need to continuously increment and decrement start and end index positions and if start
    position greater than end index position swap pivot element and return the end index position.
    Based on end index position quicksort can divide left and right half of the array and continuously perform quick sort operation
    on remaining elements of the array.
    Quick sort will be performed recursively until  only one element is present in array.
     */
    static  int partition(int arr[], int lb, int ub) {
        int pivot = arr[lb];
        int start = lb;
        int end = ub;
        while(start<end) {
            int temp;
            //If start is less than or equal to pivot then increment start index position by one
            while (arr[start] <= pivot) {
                start++;
                //To avoid array IndexOutOfBounds Exception this condition is added otherwise start will increment to upper bound+1
                //Where we don't have that element in arrray comparision raises exception.
                if(start>ub)
                {
                    break;
                }
            }
            //If end is greater than  pivot then decrement end index position by one
            while (arr[end] > pivot) {
                end--;
            }
            if (start < end) {
                //if start less than end then swap both index position elements of start and end
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            else {
                //if start greater than end then we will swap pivot element with end index position element
                temp = arr[lb];
                arr[lb] = arr[end];
                arr[end] = temp;
            }
        }
        return end;
    }
    static  void quick_sort(int[]arr,int lb, int ub)
    {
        if(lb<ub){
            int location = partition(arr,lb,ub);
            //sort left half of the array
            quick_sort(arr,lb,location-1);
            //sort right half of the array
            quick_sort(arr,location+1,ub);
        }
    }

    public static void main(String[] args) {
        int iarr[] = { 4,2,12,-1,8,1,-6,12,5 };
        System.out.println("Array before quick sort operation "+ Arrays.toString(iarr));
        quick_sort(iarr,0,iarr.length-1);
        System.out.println("Array before quick sort operation "+Arrays.toString(iarr));
    }
}


/*
Time Complexity:
https://iq.opengenus.org/time-and-space-complexity-of-quick-sort/
Best case: O(nlogn)
Average case: O(n^2)
Worst case: O(nlogn)
 */

/*
References:
https://www.softwaretestinghelp.com/quicksort-in-java/
https://www.interviewbit.com/tutorial/quicksort-algorithm/
 */

/*
Pivot:
The first element in the array
The last element in the array
The mid element in the array
Any random element in the array

 */