package math.sorts;

public class ArraySortAlgorithms {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort(int[] arr, int startInd, int endInd) {
        if (startInd < endInd) {

            int partitioningIndex = partition(arr, startInd, endInd);

            quickSort(arr, startInd, partitioningIndex - 1);
            quickSort(arr, partitioningIndex + 1, endInd);
        }
    }

    void merge(int[] arr, int l, int m, int r) {

        int size1 = m - l + 1;
        int size2 = r - m;

        int[] leftArr = new int[size1];
        int[] rightArr = new int[size2];

        System.arraycopy(arr, l, leftArr, 0, size1);

        for (int j = 0; j < size2; ++j)
            rightArr[j] = arr[m + 1 + j];

        int i = 0;
        int j = 0;

        int k = l;
        while (i < size1 && j < size2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }
}
