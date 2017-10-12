package inclassexercise7;

public class RectangleAdapter implements Shape {
	Rectangle adaptee;
	public RectangleAdapter(Rectangle rectangle) {
		this.adaptee = rectangle;
	}
	
	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		
		int height;
		int width;
		
		if(y2 > y1) {
			height = y2 - y1;
		}else {
			height = y1 - y2;
		}
		
		if(x2 > x1) {
			width = x2 - x1;
		}else {
			width = x1 - x2;
		}
		
		
		this.adaptee.draw(x1, y1, width, height);
		
	}
	
}
