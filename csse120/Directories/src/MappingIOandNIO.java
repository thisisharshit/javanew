import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MappingIOandNIO {
	public static void main(String[] args) {
		File file=new File("C:\\Examples\\file.txt");
		Path convertedPath=file.toPath();
		System.out.println(convertedPath);
		
		
		File parent=new File("C:\\Examples");
		File resolvedFile=new File(parent,"dir\\file.txt");
		System.out.println(resolvedFile.toPath());
		
		resolvedFile=new File("C:\\Examples","dir\\file.txt");
		System.out.println(resolvedFile.toPath());
		
		Path parentPath=Paths.get("C:\\Examples");
		Path childRelativePath=Paths.get("dir\\file.txt");
		System.out.println(parentPath.resolve(childRelativePath));
		
		File workingDirectory=new File("").getAbsoluteFile();
		System.out.println("working Directory = "+workingDirectory.getAbsolutePath());
		
		System.out.println("----print dir2 contents using list method---");
		File dir2File=new File(workingDirectory,"\\FileTree\\Dir2");
		String[] dir2Contents=dir2File.list();
		for(String i:dir2Contents) System.out.println(i);
		
		System.out.println("----print dir2 contents using listfile  method---");
		File[] dir2Files=dir2File.listFiles();
		for(File i:dir2Files) System.out.println(i.getName());
		
		
		
	}
}
