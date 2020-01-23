package math.sorts;

import java.util.Comparator;

public class ComparableSort implements Sortable {
    private ComparableSort() {
    }

    public static <T> void sort(T[] arr,
                                Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (c.compare(arr[j], arr[j + 1]) > 0) {

                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) {

                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
