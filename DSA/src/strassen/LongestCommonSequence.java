package strassen;

import java.util.Scanner;

public class LongestCommonSequence {
    static void longcommonsubseq(String first, String second, int firstLength, int secondLength) {
        int[][] LCS_ARRAY = new int[firstLength + 1][secondLength + 1]; //Initialize 2D array

        // Building the matrix in bottom-up way
        for (int i = 0; i <= firstLength; i++) {
            for (int j = 0; j <= secondLength; j++) {
                if (i == 0 || j == 0)
                    LCS_ARRAY[i][j] = 0;
                else if (first.charAt(i - 1) == second.charAt(j - 1))
                    LCS_ARRAY[i][j] = LCS_ARRAY[i - 1][j - 1] + 1;
                else
                    LCS_ARRAY[i][j] = Math.max(LCS_ARRAY[i - 1][j], LCS_ARRAY[i][j - 1]);
            }
        }

        int index = LCS_ARRAY[firstLength][secondLength];
        int temp = index;

        char[] c = new char[index + 1];
        c[index] = '\0'; //Empty character

        int i = firstLength, j = secondLength;
        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                c[index - 1] = first.charAt(i - 1);

                i--;
                j--;
                index--;
            }

            else if (LCS_ARRAY[i - 1][j] > LCS_ARRAY[i][j - 1])
                i--;
            else
                j--;
        }

      //Print longest common subsequence in console
        System.out.print("first string : " + first + "\nsecond string : " + second + "\nLongest Common Subsequence: ");
        for (int k = 0; k <= temp; k++)
            System.out.print(c[k]);
        System.out.println("");
    }

    public static void main(String[] args) {
        //Take input dynamically from console
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string");
        String first = sc.nextLine();
        System.out.println("Enter second string");
        String second = sc.nextLine();
        int firstLength = first.length();
        int secondLength = second.length();
        longcommonsubseq(first, second, firstLength, secondLength);
    }

}
