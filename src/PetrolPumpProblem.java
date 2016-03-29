import java.lang.reflect.Array;
import java.util.ArrayList;


public class PetrolPumpProblem {

	public static void main(String[] args) {
		ArrayList<PetrolPump> pumps = new ArrayList<PetrolPump>();
		pumps.add(new PetrolPump(4, 6));
		pumps.add(new PetrolPump(3, 5));
		pumps.add(new PetrolPump(6, 5));
		pumps.add(new PetrolPump(7, 3));
		pumps.add(new PetrolPump(4, 5));
		
		idealTour(pumps);
	}
	
	public static void idealTour(ArrayList<PetrolPump> pumps){
		int start =0; int end = pumps.size()-1;
		int current_petrol = 0;
		int i= start;
		while(i!=end){
			current_petrol += pumps.get(i).petrol - pumps.get(i).distance;
			if(current_petrol<0){
				i = (i+1)%pumps.size();
				start = i;
				if(start == 0){
					System.out.println("Not possible to visit");
					return;
				}
					
				current_petrol = 0;
				end = (start+pumps.size()-1)%pumps.size();
			}
			else
				i = (i+1)%pumps.size();
			
		}
		System.out.println("Ideal tour is ");
		while(start!=end){
			pumps.get(start).print();
			start+=1;
			start%=pumps.size();
		}
		pumps.get(end).print();
	}

}

class PetrolPump{
	public int petrol;
	public int distance;
	
	public PetrolPump(int petrol, int distance){
		this.petrol= petrol;
		this.distance = distance;
	}
	
	public void print(){
		System.out.println("("+petrol+" , "+distance+")");
	}
}
