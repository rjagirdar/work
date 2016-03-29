
public class MinCoinDenomination {

	public static void main(String[] args) {
		int[] coins = new int[]{1,3,5};
		int sum = 23;
		System.out.println(minCoins(coins, sum, 0, coins.length-1));
		coins = new int[]{1,2,3};
		sum =6;
		minCoins(coins, sum);
	}
	
	public static int minCoins(int[] coins, int sum, int current_sum, int index){
		if(index<0)
			return 0;
		
		int count=0;
		
		if(coins[index] > sum-current_sum)
			count+=minCoins(coins, sum, current_sum, index-1);
		else{
			int j=1;
			int tmpSum=0;
			while(tmpSum <sum-current_sum){
				tmpSum=j*coins[index];
				count++;
				j++;
			}
			
			if(tmpSum > sum){
				tmpSum-=coins[index];
				count--;
				count+=minCoins(coins, sum, tmpSum, index-1);
			}
				
		}
		return count;
	}
	
	public static void minCoins(int[] arr, int sum){
		int[][] table = new int[sum+1][arr.length+1];
		for(int j=0; j<=arr.length; j++)
			table[0][j] = 0;
		for(int i=0; i<=sum; i++)
			table[i][0] = 0;
		int minCount;
		for(int i=1; i<=sum; i++){
			for(int j=1; j<=arr.length; j++){
				minCount= Integer.MAX_VALUE;
				if(i>=arr[j-1]){
					minCount = Math.min(minCount, 1+table[i-arr[j-1]][j]);
				}
				else{
					minCount = Math.min(minCount, table[i][j-1]);
				}
				table[i][j] = minCount;
			}
		}
		System.out.println("Min Coins needed to form "+sum+" is "+table[sum][arr.length]);
	}

}
