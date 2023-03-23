import java.io.*;
import java.util.*;

import org.jetbrains.annotations.NotNull;

    public class Manager {

        private static File file;
        private static Scanner sc = new Scanner(System.in);
        public static int NumberOfComparisonsQuickSort;
        public static int NumberOfComparisonsShellSort;
        public static int NumberOfComparisonsSelectionSort;
        public static int NumberOfPermutationsQuickSort;
        public static int NumberOfPermutationsShellSort;
        public static int NumberOfPermutationsSelectionSort;
        public static long AlgorithmExecutionTimeQuickSort;
        public static long AlgorithmExecutionTimeShellSort;
        public static long AlgorithmExecutionTimeSelectionSort;

        public static List<Student> readFromFIle() throws IOException {
            List<Student> list = new LinkedList<>();
            file = new File("C:\\IntellijProjects\\Lab2_ASDC\\src\\DataBaseNonSorted.txt");

            try (Reader bufferedReader = new BufferedReader(new FileReader(new File(file.toURI())));) {
                String headerOfFile = ((BufferedReader) bufferedReader).readLine();
                String line = ((BufferedReader) bufferedReader).readLine();
                String[] lineArray = new String[6];
                while (line != null) {
                    lineArray = line.split(",");
                    list.add(new Student(
                                    Integer.parseInt(lineArray[0]),
                                    lineArray[1],
                                    lineArray[2],
                                    Integer.parseInt(lineArray[3]),
                                    Integer.parseInt(lineArray[4]),
                                    Integer.parseInt(lineArray[5])
                            )
                    );
                    line = ((BufferedReader) bufferedReader).readLine();

                }
            } catch (Exception e) {
                e.getStackTrace();
            }
            return list;
        }

        public static void showStudentArrayList(@NotNull List<Student> list) {
            for (Student st : list) {
                System.out.println(st.toString());
            }
        }

        public static void selectionSort(List<Student> list) {
            long startTime = System.nanoTime();
            for (int i = 0; i < list.size() - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j).getId() < list.get(minIdx).getId()) {
                        minIdx = j;
                        NumberOfComparisonsSelectionSort++;
                    }
                }
                Collections.swap(list,i,minIdx);
                NumberOfPermutationsSelectionSort++;
            }
            long endTime = System.nanoTime();
            AlgorithmExecutionTimeSelectionSort = endTime - startTime;
        }

        //Кнут
        public static void shellSort(List<Student> list) {
            long startTime = System.nanoTime();
            int h = 1;
            while (h * 3 < list.size()) {
                h = h * 3 + 1;
            }
            while (h >= 1) {
                hSort(list, h);
                h = h / 3;
            }
            long endTime = System.nanoTime();
            AlgorithmExecutionTimeShellSort = endTime - startTime;
        }
        //Можно вместо h использовать list.size / 2, и на каждой иттераций делим это числа на 2,пока d <= 1.
        //В нашем случае мы берем каждый элемент от позиции h до конца и сравниваем его с элементом на расстояний h от
        // исходного, если правый элемент меньше левого,свапаем их, и левый савниваем сэлементов на расстояний h в лево
        // иначе выходим из вложенного цикла и берем след элемент, то есть h+1.
        private static void hSort(@NotNull List<Student> list, int h) {
            for (int i = h; i <  list.size(); i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (list.get(j).getId() < list.get(j - h).getId()) {
                        Collections.swap(list, j, j - h);
                        NumberOfPermutationsShellSort++;
                        NumberOfComparisonsShellSort++;
                    } else
                        break;
                }
            }
        }


        public static void quicksort(int start, int end, List<Student> list) {
            if (start >= end) {
                return;
            }
            int i = start, j = end;
            int current = i - (i - j) / 2;

            while (i < j) {
                while (i < current && (list.get(i).getId() <= list.get(current).getId())) {
                    i++;
                    NumberOfComparisonsQuickSort++;
                }
                while (j > current && (list.get(current).getId() <= list.get(j).getId())) {
                    j--;
                    NumberOfComparisonsQuickSort++;
                }
                if (i < j) {

                    Collections.swap(list, i, j);
                    NumberOfPermutationsQuickSort++;
                    if (i == current) {
                        current = j;
                        NumberOfComparisonsQuickSort++;
                    } else if (j == current){
                        current = i;
                        NumberOfComparisonsQuickSort++;
                    }
                }
            }
            quicksort(start, current, list);
            quicksort(current + 1, end, list);
        }

        public static void printSelectionSortInformation(){
            System.out.println("1) Selection sort:");
            System.out.println("Algorithm complexity: O(n^2)");
            System.out.println("Number of comparisons: " + Manager.NumberOfComparisonsSelectionSort);
            System.out.println("Number of permutations: " + Manager.NumberOfPermutationsSelectionSort);
            System.out.println("Algorithm execution time(nanoseconds):" + Manager.AlgorithmExecutionTimeSelectionSort);
            System.out.println();
        }

        public static void printShellSortInformation() {
            System.out.println("2) Shell sort:");
            System.out.println("Algorithm complexity: O(n^(3/2))");
            System.out.println("Number of comparisons: " + Manager.NumberOfComparisonsShellSort);
            System.out.println("Number of permutations: " + Manager.NumberOfPermutationsShellSort);
            System.out.println("Algorithm execution time(nanoseconds):" + Manager.AlgorithmExecutionTimeShellSort);
            System.out.println();
        }

        public static void printQuickSortInformation() {
            System.out.println("3) Quick sort:");
            System.out.println("Algorithm complexity:");
            System.out.println("- worst case time:  O(n^2)");
            System.out.println("- in the average case: O(n*log n)");
            System.out.println("Number of comparisons: " + Manager.NumberOfComparisonsQuickSort);
            System.out.println("Number of permutations: " + Manager.NumberOfPermutationsQuickSort);
            System.out.println("Algorithm execution time(nanoseconds):" + Manager.AlgorithmExecutionTimeQuickSort);
        }
    }