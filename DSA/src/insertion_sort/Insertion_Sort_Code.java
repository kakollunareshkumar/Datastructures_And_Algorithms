package insertion_sort;

import java.util.Arrays;

public class Insertion_Sort_Code {

    public static void main(String[] args) {

        int[] iArray = { 50,-1,10,-2,5};
        System.out.println("Array before sorting "+ Arrays.toString(iArray));
        //This variable is used for storing key  and is inserted at the correct position after swapping is done
        int key =0;
        //We started with i=1 because there should be atleast one element on the left hand side to compare and swap
        for(int i=1; i<iArray.length;i++)
        {
            //In every iteration key element will become the index position array element
            key = iArray[i];

            int j= i-1;
         /*   While loop to swap elements one by one on the left side of the array
            This while loop gets iterated when J becomes greater than zero
            In insertion sort we compare elements on the left hand side of the array and we check first if there is
            an index position before our current index position then only we compare elements  */

            while(j>=0 && iArray[j]>key)
            {
                iArray[j+1] = iArray[j];
                j=j-1;
            }
            //Key is inserted at this index position after elements are swapped
            iArray[j+1] = key;
        }
        System.out.println("Array after sorting "+Arrays.toString(iArray));
    }
}

/*



 */