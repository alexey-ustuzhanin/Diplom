public class Diplom {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        WorkWithFile.writeFile(mergeSort.sort(WorkWithFile.getArrayFromFile()));
        System.out.println("Look at the file.");
    }
}