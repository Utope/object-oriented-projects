package inclassCompositeDesignPattern;

import java.util.ArrayList;

public class Directory implements AbstractFile {
	
	String name;
	ArrayList<AbstractFile> includedFiles;
	
	public Directory(String name) {
		this.name = name;
		includedFiles = new ArrayList<AbstractFile>();
	}

	@Override
	public void ls() {
		System.out.println(name);
		for(AbstractFile aFile : includedFiles) {
			aFile.ls();
		}
	}
	
	public void add(AbstractFile file) {
		includedFiles.add(file);
	}
}
