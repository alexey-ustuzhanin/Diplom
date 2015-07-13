import java.util.Arrays;

public class MergeSort {
    protected int[] intArray;

    public int[] sort(int[] arr){
        intArray = Arrays.copyOf(arr, arr.length);
        int []tempArray = new int[arr.length];
        mergeSort(tempArray, 0, arr.length - 1);
        return intArray;
    }

    private void mergeSort(int []tempArray,int lowerIndex,int upperIndex){
        if(lowerIndex == upperIndex){
            return;
        }else{
            int mid = (lowerIndex+upperIndex)/2;
            mergeSort(tempArray, lowerIndex, mid);
            mergeSort(tempArray, mid+1, upperIndex);
            merge(tempArray,lowerIndex,mid+1,upperIndex);
        }
    }

    protected void merge(int []tempArray,int lowerIndexCursor,int higherIndex,int upperIndex){
        int tempIndex=0;
        int lowerIndex = lowerIndexCursor;
        int midIndex = higherIndex-1;
        int totalItems = upperIndex-lowerIndex+1;
        while(lowerIndex <= midIndex && higherIndex <= upperIndex){
            if(intArray[lowerIndex] < intArray[higherIndex]){
                tempArray[tempIndex++] = intArray[lowerIndex++];
            }else{
                tempArray[tempIndex++] = intArray[higherIndex++];
            }
        }

        while(lowerIndex <= midIndex){
            tempArray[tempIndex++] = intArray[lowerIndex++];
        }

        while(higherIndex <= upperIndex){
            tempArray[tempIndex++] = intArray[higherIndex++];
        }

        for(int i=0;i<totalItems;i++){
            intArray[lowerIndexCursor+i] = tempArray[i];
        }
    }
}