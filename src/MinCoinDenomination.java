
public class MinCoinDenomination {

	public static void main(String[] args) {
		int[] coins = new int[]{1,3,5};
		int sum = 23;
		System.out.println(minCoins(coins, sum, 0, coins.length-1));
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

}
