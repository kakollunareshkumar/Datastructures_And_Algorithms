package bubble_sort;

import java.util.Arrays;

public class Bubble_Sort_Code {
    public static void main(String[] args) {

        int barr[] = {90,6,30,-6,10,1};

        int  swap=0;
        int count = 0;
        System.out.println("Array elements before sorting "+ Arrays.toString(barr));
        //Two for loops to compare each element with every other element in the array
        for(int i=0; i<barr.length-1; i++)
        {
            for(int j=0;j<barr.length-i-1;j++)
            {
                if(barr[j]>barr[j+1])     //Swap the jth element with j+1th element if jth element is smaller than j+1 element
                {
                    swap = barr[j];
                    barr[j] = barr[j+1];
                    barr[j+1] = swap;
                    count = 1;
                }
            }
            //if count is not equal to 1 it means atleast one swap has not occured in 1st iteration and elements are in sorted order
            if(count!=1)
            {
                break;
            }
        }
        System.out.println("Array elements after bubble sort "+Arrays.toString(barr));

    }
}
/*
Time complexity:
Best case: According to our logic best case when elements are in sorted oder and only for first iteration comparision is made
           1(outer for loop)    *(n-1)(Inner for loop)  = O(n)
Worst case: When elements are in descending order then (n-1)*(n-1) comparisions are made and O(n^2) is complexity
Average case:When some elements are in sorted order and some elements are in descending order then only half comparisions are made
            :(n-1)*(n-1)/2 =>O(n^2)
 */
