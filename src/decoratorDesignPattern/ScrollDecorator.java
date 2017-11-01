package decoratorDesignPattern;

public class ScrollDecorator extends Decorator {

	public ScrollDecorator(Widget widget) {
		super(widget);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		super.draw();
		System.out.print("[ScrollDecorator]");
	}

}
