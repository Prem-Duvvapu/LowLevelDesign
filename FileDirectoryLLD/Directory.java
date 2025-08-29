package FileDirectoryLLD;
import java.util.*;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystemList=new ArrayList<>();

    Directory(String directoryName,List<FileSystem> fileSystemList) {
        this.directoryName=directoryName;
        this.fileSystemList=fileSystemList;
    }

    public void ls() {
        System.out.println("Directory name is: "+directoryName);

        for (FileSystem fs: fileSystemList)
            fs.ls();
    }
}

