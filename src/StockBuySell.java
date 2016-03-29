import java.util.ArrayList;


public class StockBuySell {

	public static void main(String[] args) {
		int[] stockPrices = new int[]{100, 180, 260, 310, 40, 535, 695};
		//stockPrices = new int[]{6,5,4,3,2,1};
		findStockBuySell(stockPrices);
		singletransaction(stockPrices);
	}
	
	public static void singletransaction(int[] arr){
		int buy=-1,sell=-1,curr_profit=-1,max_profit=Integer.MIN_VALUE;
		int localBuy;
		localBuy=0;
		for(int i=1; i<=arr.length-1; i++){
			
			if(arr[i]<arr[localBuy]){
				localBuy=i;
			}
			else{
				curr_profit = arr[i] -arr[localBuy];
				if(curr_profit>max_profit){
					max_profit=curr_profit;
					sell=arr[i];
					buy=arr[localBuy];
				}
			}
		}
		System.out.println("Max Profit is "+max_profit);
		System.out.println("Stock should be bought on "+buy+" & sold when "+sell );
	}
	
	public static void findStockBuySell(int[] arr){
		if(arr.length ==1){
			System.out.println("Not Profitable at all");
			return;
		}
			
		ArrayList<BuySellPair> list = new ArrayList<BuySellPair>();
		BuySellPair pair=null;
		int i=0;
		while(i<arr.length){
			while(i<arr.length-1 && arr[i]>arr[i+1])
				i++;
			if(i==arr.length-1)
				break;
			pair = new BuySellPair();
			pair.buy = i++;
			
			while(i<arr.length && arr[i]>arr[i-1])
				i++;
			pair.sell = i-1;
			list.add(pair);
		}
		if(!list.isEmpty()){
			for(BuySellPair tmpPair : list)
				System.out.println("Buy on "+tmpPair.buy +" and sell on "+tmpPair.sell);
		}
		else
			System.out.println("Not Profitable at all");
		
		
	}

}

class BuySellPair{
	public int buy;
	public int sell;
}
