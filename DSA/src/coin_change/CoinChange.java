package coin_change;
//KAKOLLU NARESH KUMAR 11200862 CSCE 5150 Program no 3
class CoinChange{

    static  int ans[] = new int[100];

    static int findMinCoins(int coins[], int size,  int value)
    {
        int i, count = 0;
        for(i = 0; i < size; i++)
        {
            //take as many coins from coins[i]
            while(value >= coins[i])
            {
                //after taking  coin from coin array, reduce the value.
                value -= coins[i];
                ans[count] = coins[i];
                count++;
            }
            if(value == 0)
                break;
        }
        return count;
    }
    public static void main(String[] args) {
        int coins[] = {25,10,5,1};
        int value = 67, i;
        //Find the length of the coins array
        int size = coins.length;
        int MinCount = findMinCoins(coins,size,value);
        System.out.printf("Total minimum coins required = %d\n",MinCount);
        System.out.println("Total coins dispensed are:\t");
        for(i = 0; i < MinCount; i++)
            System.out.printf("%d ", ans[i]);
    }
}