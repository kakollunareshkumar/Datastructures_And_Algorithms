import java.util.Scanner;

public class Binary_Search_Using_Recursion {

    static int  binarySearchAlgo(int[] arr, int number, int first, int last)
    {

        int middle = (first+last)/2;


        if(arr[middle] ==number)
        {
            return middle;
        }

        if(arr[middle]>number)
        {
            return  binarySearchAlgo(arr,number,first,middle-1);
        }

        if(arr[middle]<number)
        {
            return  binarySearchAlgo(arr,number,middle+1,last);
        }
        return  -1;
    }


    public static void main(String[] args) {
        int arr[] = {-5, -1, 3, 5, 8, 20, 24, 30};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number or element you need to search in array");
        int number = sc.nextInt();
        int index = binarySearchAlgo(arr,number,0,7);
        System.out.println("Number found at index position "+index);

    }

}

//Time complexity
//Best case--O(1) when element is found at middle position
//Worst case -- O(logn) -- when element is found at right or left half of the arrays