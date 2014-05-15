import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;


public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(6, 8));
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 4));
		list.add(new Interval(4, 7));
		
		
		mergeIntervals(list);

	}
	
	public static void mergeIntervals(ArrayList<Interval> intervals){
		java.util.Stack<Interval> stack = new Stack<Interval>();
		Collections.sort(intervals, Interval.IntervalComparator);
		for(Interval current : intervals){
			if(stack.isEmpty())
				stack.add(current);
			else{
				Interval top = stack.peek();
				if(top.upper < current.lower)
					stack.add(current);
				else if(top.upper >= current.lower){
					top = stack.pop();
					top.upper = current.upper;
					stack.add(top);
				}
			}
		}
		while(!stack.isEmpty()){
			Interval tmp = stack.pop();
			System.out.println("{"+tmp.lower+" , "+tmp.upper+"}");
		}
			
	}

}

class Interval{
	public int lower;
	public int upper;
	
	public Interval(int lower, int upper){
		this.lower = lower;
		this.upper = upper;
	}
	
	public static Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
		
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.lower - o2.lower;
		}
	};
}