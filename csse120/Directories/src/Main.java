import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
	public static void main(String[] args) {
		
//		DirectoryStream.Filter<Path> filter=new DirectoryStream.Filter<Path>() {
//			public boolean accept(Path path) throws IOException{
//				return Files.isRegularFile(path);
//			}
//		};
		DirectoryStream.Filter<Path> filter=p->Files.isRegularFile(p);
//		Path directory=FileSystems.getDefault().getPath("FileTree\\Dir2");
		Path directory=FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
		try(DirectoryStream<Path> contents=Files.newDirectoryStream(directory,filter)){
			for(Path file:contents) {
				System.out.println(file.getFileName());
			}
		}catch (IOException|DirectoryIteratorException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		String separator=File.separator;
		System.out.println(separator); 
		separator=	FileSystems.getDefault().getSeparator();
		System.out.println(separator);
		
//		try {
//			Path tempFile=Files.createTempFile("myapp",".appext");
//			System.out.println("Temperory file path = "+tempFile.toAbsolutePath());
//		} catch (IOException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
		
		Iterable<FileStore> stores=FileSystems.getDefault().getFileStores();
		for(FileStore store:stores) {
			System.out.println(store);
			System.out.println(store.name());
		}
		
		Iterable<Path> rootPaths=FileSystems.getDefault().getRootDirectories();
		for(Path path:rootPaths) {
			System.out.println(path);
		}
	}
}
