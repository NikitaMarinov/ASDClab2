import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList<>();
        list = Manager.readFromFIle();
        System.out.println("Our list(unsorted):");
        //Manager.showStudentArrayList(list);


        //Сортировки:
        List<Student> list0 = new ArrayList<>();
        list0 = Manager.readFromFIle();
        //Manager.showStudentArrayList(list0);
        int start = 0;
        int end = list0.size() - 1;
        long startTime = System.nanoTime();
        Manager.quicksort(start,end,list0);
        long endTime = System.nanoTime();
        Manager.AlgorithmExecutionTimeQuickSort = endTime - startTime;
        //Manager.showStudentArrayList(list0);
        System.out.println("---------------------------------------------");

        List<Student> list1 = new ArrayList<>();
        list1 = Manager.readFromFIle();
        Manager.shellSort(list1);
        //Manager.showStudentArrayList(list1);
        System.out.println("---------------------------------------------");

        List<Student> list2 = new ArrayList<>();
        list2 = Manager.readFromFIle();
        Manager.selectionSort(list2);
        //Manager.showStudentArrayList(list2);

        System.out.println("---------------------------------------------");
        System.out.println("Information about methods:");
        Manager.printSelectionSortInformation();
        Manager.printShellSortInformation();
        Manager.printQuickSortInformation();


    }
}
