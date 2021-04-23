import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
//	public static void main(String[] args) {
//		Path path=FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//		printfile(path);
//		System.out.println();
////		path=FileSystems.getDefault().getPath("Files\\SubDirectory.txt");
////		path=FileSystems.getDefault().getPath("Files","SubDirectory.txt");
//		path=Paths.get(".","Files","SubDirectory.txt");
//		printfile(path);
//		System.out.println();
//		path=Paths.get("C:\\EclipseWorkspaces\\csse120\\Outthere.txt");
//		printfile(path);
//		
//		path=Paths.get(".");
//		System.out.println(path.toAbsolutePath());
//		
//		path=FileSystems.getDefault().getPath(".","Files","..","Files","SubDirectory.txt");
//		System.out.println(path.normalize().toAbsolutePath());
//		printfile(path.normalize());
//		
//		
////		Path path3=FileSystems.getDefault().getPath("doesnotexist.txt");
////		System.out.println(path3.toAbsolutePath());
//		
//		
//		Path path4=Paths.get("C:\\","Files","whatever.txt");
//		System.out.println(path4.toAbsolutePath());
//		
//		path=FileSystems.getDefault().getPath("Files");
//		System.out.println("exists = "+Files.exists(path));
//		
//		System.out.println("exists = "+Files.exists(path4));
//	}
//	private static void printfile(Path path) {
//		try (BufferedReader fileReader=Files.newBufferedReader(path)){
//			String line;
//			while((line=fileReader.readLine())!=null) {
//				System.out.println(line);
//			}
//		} catch (IOException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		
		try {
//			Path sourceFile=FileSystems.getDefault().getPath("Examples", "file1.txt");
//			Path copyFile=FileSystems.getDefault().getPath("Examples","file1copy.txt");
//			Files.copy(sourceFile, copyFile,StandardCopyOption.REPLACE_EXISTING);
			
//			sourceFile=FileSystems.getDefault().getPath("Examples", "Dir1");
//			copyFile=FileSystems.getDefault().getPath("Examples","Dir4");
//			Files.copy(sourceFile, copyFile,StandardCopyOption.REPLACE_EXISTING);
			
//			Path filetomove=FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//			Path destination=FileSystems.getDefault().getPath("Examples", "Dir1","file1copy.txt");
//			Files.move(filetomove,destination);
			
//			Path filetomove=FileSystems.getDefault().getPath("Examples", "file1.txt");
//			Path destination=FileSystems.getDefault().getPath("Examples", "file2.txt");
//			Files.move(filetomove,destination);
			
//			Path filetodelete=FileSystems.getDefault().getPath("Examples","Dir1","file1copy.txt");
//			Files.deleteIfExists(filetodelete);
			
//			Path filetocreate=FileSystems.getDefault().getPath("Examples","file2.txt");
//			Files.createFile(filetocreate);
//			Path dirtocreate=FileSystems.getDefault().getPath("Examples","Dir4");
//			Files.createDirectories(dirtocreate);
			
//			Path dirtocreate=FileSystems.getDefault().getPath("Examples","Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//			Files.createDirectories(dirtocreate);
			
			Path filePath = FileSystems.getDefault().getPath("Examples","Dir1\\file1.txt");
			long size=Files.size(filePath);
			System.out.println("size = "+size);
			System.out.println("Last modified = "+Files.getLastModifiedTime(filePath));
			
			BasicFileAttributes attrs=Files.readAttributes(filePath,BasicFileAttributes.class);
			System.out.println(attrs.size());
			System.out.println(attrs.lastModifiedTime());
			System.out.println(attrs.creationTime());
			System.out.println(attrs.isDirectory());
			System.out.println(attrs.isRegularFile());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
