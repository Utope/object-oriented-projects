
public class RockAdapter implements WeightAdapter {
	
	rock rock;
	
	public RockAdapter(rock rock) {
		this.rock = rock;
	}
	
	@Override
	public int getWeight() {
		return rock.getWeight();
	}

}
