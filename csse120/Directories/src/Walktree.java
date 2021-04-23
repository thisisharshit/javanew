import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Walktree extends SimpleFileVisitor<Path>{
	public static void main(String[] args) {
		System.out.println("--walking tree for Dir2---");
		Path dir2Path=FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
		try {
			Files.walkFileTree(dir2Path,new Walktree());
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(dir.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
//		return super.visitFile(file, attrs);
		System.out.println(file.toAbsolutePath());
		return FileVisitResult.CONTINUE;
		
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("error accessing file"+file.toAbsolutePath()+" "+exc.getMessage());
		return FileVisitResult.CONTINUE;
	}
}
