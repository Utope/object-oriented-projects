package inclassCompositeDesignPattern;

public class Client {
	public static void main(String[] args) {
		Directory dir1 = new Directory("dir1");
		dir1.add(new File("file1"));
		dir1.add(new File("file1"));
		dir1.add(new File("file1"));
		
		Directory dir2 = new Directory("dir2");
		dir2.add(new File("file4"));
		dir2.add(new File("file5"));
		dir2.add(new File("file6"));
		dir2.add(new File("file7"));
		dir2.add(new File("file8"));
		
		dir1.add(dir2);
		
		dir1.ls();
		
	}
}
