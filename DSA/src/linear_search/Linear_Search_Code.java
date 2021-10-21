package linear_search;

import java.util.Arrays;
import java.util.Scanner;

//Time complexity
//o(1)- Best case -   if element is present at index position 1
//o(n) - Worst case - if element is present at index n or if element itself is not present in the array
//Is also called sequential search-->Elements are compared one by one in array and returns the index position of that element
public class Linear_Search_Code {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the array");
        int size = sc.nextInt();

        int ls[] = new int[size];

        for(int i=0; i<=4;i++)
        {
            System.out.println("Enter element at index position "+i);
            ls[i] = sc.nextInt();
        }
            //In traditional approach
        for(int i=0;i<ls.length;i++)
        {
            System.out.printf("%s \t",ls[i]);
        }
        //new Approach to display elements
        System.out.println(Arrays.toString(ls));


        System.out.println("Enter element you need to search in this array");

        int element = sc.nextInt();

        int count = 0;
        //For loop iterates until element is found. if element found count increases by 1 and breaks the loop
        for(int i=0;i<ls.length;i++)
        {
            if(ls[i]==element)
            {
                System.out.println("Element found at index position "+i);
                count++;
                break;
            }
        }

        if(count ==0)
        {
            System.out.println("Element is not present in the array");
        }

    }
}
