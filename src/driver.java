import java.util.ArrayList;

public class driver {
	public static void main(String[] args) {
		rock r = new rock(5);
		Human h = new Human(10);
		
		ArrayList<WeightAdapter> canbeweighed = new ArrayList<WeightAdapter>();
		canbeweighed.add(new RockAdapter(r));
		canbeweighed.add(new HumanAdapter(h));
		
		for(WeightAdapter a : canbeweighed) {
			System.out.println(a.getWeight());
		}
		
	}
}
