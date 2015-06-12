package filehandler;

import java.io.File;

public class FileHandler {

	String path;

	public FileHandler() {

	}

	public FileHandler(String path) {
		this.path = path;
	}

	public void displayFileSystem(String path, int level) {
		File file = new File(path);
		if (file.exists()) {
			if(0==level)
				System.out.println(printPlaceholder(level) + file.getName());
			File[] fileList = file.listFiles();
			if (0 != fileList.length) {
				level++;
				for (File f : fileList) {
					if (f.isFile()) {
						System.out.println(printPlaceholder(level) + f.getName());
					}
					else {
						System.out.println(printPlaceholder(level) + f.getName());
						displayFileSystem(f.getAbsolutePath(), level);
					}
				}
			}
		}
		return;
	}
	
	private String printPlaceholder(int level) {
		String placeholder = "";
		if(level<0)
			return null;
		else if(0==level)
			placeholder = "";
		else
			for(int i=level;i>=1;i--) {
				placeholder += "----";
			}
		return placeholder;
	}

	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		fh.displayFileSystem("D://Adobe", 0);
	}

}
