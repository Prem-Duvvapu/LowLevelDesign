package FileDirectoryLLD;
import java.util.*;

public class Main {
    /*
    DSA---|
          |---Arrays---|
          |            |---KadaneAlgo
          |            |---BoyorMooreAlgo
          |            |---SortingAlgos---|
          |                               |---MergeSort
          |                               |---QuickSort
          |---Graphs
     */

    public static void main(String[] args) {
        FileSystem mergeSort=new File("MergeSort");
        FileSystem quickSort=new File("QuickSort");
        List<FileSystem> sortingAlgosList=new ArrayList<>();
        sortingAlgosList.add(mergeSort);
        sortingAlgosList.add(quickSort);
        FileSystem sortingAlgos=new Directory("SortingAlgso",sortingAlgosList);

        FileSystem KadaneAlgo=new File("KadaneAlgo");
        FileSystem BoyorMooreAlgo=new File("BooyerMooreAlgo");
        List<FileSystem> arraysList=new ArrayList<>();
        arraysList.add(KadaneAlgo);
        arraysList.add(BoyorMooreAlgo);
        arraysList.add(sortingAlgos);
        FileSystem arrays=new Directory("Arrays", arraysList);

        FileSystem graphs=new Directory("Graphs", new ArrayList<>());
        List<FileSystem> dsaList=new ArrayList<>();
        dsaList.add(arrays);
        dsaList.add(graphs);

        FileSystem dsa=new Directory("DSA",dsaList);

        dsa.ls();
    }
}
