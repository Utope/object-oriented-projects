package decoratorDesignPattern;

public class Main {
	public static void main(String[] args) {
		Widget widget = new TextField(80,24);
		widget.draw();
		System.out.println();
		Widget widget2 = new ScrollDecorator(new TextField(80,24));
		widget2.draw();
		System.out.println();
		Widget widget3 = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField(80,24))));
		widget3.draw();
		System.out.println();
	}
}
