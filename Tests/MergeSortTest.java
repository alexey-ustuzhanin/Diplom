import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void testSort() {
        int[] arrayOfNumbers = {123,14,-4,31,0,-71,29,-9,4};
        MergeSort mergeSort = new MergeSort();
        int actualResult[] = mergeSort.sort(arrayOfNumbers);
        Arrays.sort(arrayOfNumbers);
        Assert.assertArrayEquals(arrayOfNumbers, actualResult);
    }

    @Test
    public void testMerge() {
        int[] arrayOfNumbers = {-71, -9, 4, 29, 123, 0, 0, 0, 0};
        int[] tempArray = {-4, 0, 14, 31, 123, -71, -9, 4, 29};
        MergeSort mergeSort = new MergeSort();
        mergeSort.intArray = arrayOfNumbers;
        mergeSort.merge(tempArray,0,4,8);
        Arrays.sort(arrayOfNumbers);
        Assert.assertArrayEquals(arrayOfNumbers, mergeSort.intArray);
    }
}