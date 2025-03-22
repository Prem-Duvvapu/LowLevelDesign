package FileDirectoryLLD;
import java.util.*;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> files=new ArrayList<>();

    Directory(String directoryName,List<FileSystem> files) {
        this.directoryName=directoryName;
        this.files=files;
    }

    public void ls() {
        System.out.println("Directory name is: "+directoryName);

        for (FileSystem file: files)
            file.ls();
    }
}
