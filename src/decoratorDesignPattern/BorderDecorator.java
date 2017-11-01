package decoratorDesignPattern;

public class BorderDecorator extends Decorator {
	
	public BorderDecorator(Widget widget) {
		super(widget);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		super.draw();
		System.out.print("[BorderDecorator]");
	}
	
}
