package binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search_Code_Using_Iterative_way {

    public static void main(String[] args) {


        int arr[] = {-1,5,-5,20,30,24,8,3};
        System.out.println("Sorting this array in ascending order");
        //First condition
        //To perform binary search array should be in ascending order

      /*
        We took 2 for loops. First i for loop is to iterate all the elements and
         second j loop is to compare all the elements with ith index element and
         swap index positions of both i and j index position elements
         if i elements is smaller than j element
       */
        int temp=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                {
                  temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
                }
            }
        }
        System.out.println("Array in ascending order "+ Arrays.toString(arr));   // [-5, -1, 3, 5, 8, 20, 24, 30]
        //Rules to perform binary search
        //key or element is same
        //1. if key == middle element then we return the index position of the middle element
        //2. if key>middle element then return the right half of the array elements.
        //3.if key< middle element then return the left half of the array elements

        //Repeat these steps until one element in array is left.


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key or element you need to search in array");
        int number = sc.nextInt();

        int first = 0;
        int last = 7;
        while (first<=last)
        {
            int middle = (first+last)/2;


            if(arr[middle] ==number)
            {
                System.out.println("Element found at index position "+middle);
                break;
            }

            if(arr[middle]<number)
            {
                first = middle+1;
            }

            if(arr[middle]>number)
            {
                last = middle-1;
            }
        }
    }

}


//Time complexity
//Best case--O(1) when element is found at middle position
//Worst case -- O(logn) -- when element is found at right or left half of the arrays

//Space complexity -  O(1)