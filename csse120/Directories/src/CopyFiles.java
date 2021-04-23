import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;



public class CopyFiles extends SimpleFileVisitor<Path>{
	private Path soureroot,targetroot;
	
	public CopyFiles(Path soureroot, Path targetroot) {
		this.soureroot = soureroot;
		this.targetroot = targetroot;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		Path relativizedPath=soureroot.relativize(dir);
		System.out.println("Relativize path = "+relativizedPath);
		Path copyDir=targetroot.resolve(relativizedPath);
		System.out.println("resolved path for copy = "+copyDir);
		
		try {
			Files.copy(dir,copyDir);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return FileVisitResult.SKIP_SUBTREE;
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Path relativizedPath=soureroot.relativize(file);
		System.out.println("Relativize path = "+relativizedPath);
		Path copyDir=targetroot.resolve(relativizedPath);
		System.out.println("resolved path for copy = "+copyDir);
		
		try {
			Files.copy(file,copyDir);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("error accessing file"+file.toAbsolutePath()+" "+exc.getMessage());
		return FileVisitResult.CONTINUE;
	}
	
	
	public static void main(String[] args) {
		System.out.println("--copying dir2 to dir4\\dir2copy---");
		Path copyPath=FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir4"+File.separator+"Dir2Copy");
		Path dir2Path=FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
		try {
			Files.walkFileTree(dir2Path,new CopyFiles(dir2Path,copyPath));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	
	
}
