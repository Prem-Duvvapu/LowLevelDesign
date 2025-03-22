package FileDirectoryLLD;

public class File implements FileSystem {
    String fileName;

    File(String fileName) {
        this.fileName=fileName;
    }

    public void ls() {
        System.out.println("File name is: "+fileName);
    }
}
