package selection_sort;

import java.util.Arrays;

public class Selection_Sort_Code {
    public static void main(String[] args) {

        int i, j,  min , temp;

        int[] sarray = { 10, -1, 5, -5, 0};
        System.out.println("Array before sorting with selection sort "+ Arrays.toString(sarray));
        for(i=0; i<sarray.length;i++)
        {
            //intially minimum index position is ith index
            min = i;

            for(j = i+1; j<sarray.length; j++)
            {
                //Every time when you found the minimum element change j index position to minimum element index
                //position
                if(sarray[j]<sarray[min])
                {
                    min = j;
                }
            }
            //When we found the smallest or minimum element in the whole array swap position of minimum element
            // and the index position element
            temp = sarray[i];
            sarray[i]  = sarray[min];
            sarray[min]  = temp;

        }
        System.out.println("Array after sorting with selection sort "+Arrays.toString(sarray));
    }
}

// Time complexity
/*
Whether the array is ascending order or descending order time complexity doesn't matter for this array
because we are going to find the min index elements from total no of elements even if the array is
sorted as well. So complexity will be same for best worst and average case
 Calculation: (n-1)+(n-2)+(n-3)+ .........+1 = sum of n natural numbers = n(n+1)/2 = O(n^2)

Best case - O(n^2)
Worst case -O(n^2)
Average case -O(n^2)

Space complexity - O(1)
 */