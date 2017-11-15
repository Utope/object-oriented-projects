
public class HumanAdapter implements WeightAdapter {

	public Human human;
	
	public HumanAdapter(Human human) {
		this.human = human;
	}
	
	@Override
	public int getWeight() {
		return human.weight();
	}

}
