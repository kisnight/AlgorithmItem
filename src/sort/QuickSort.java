package sort;


/*
1、从数列中挑出一个元素，称为 “基准”（pivot）;
2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
   在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 */
public class QuickSort {
    public int [] quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int stardValue = arr[left];
        int index = left + 1;
        for (int i = index; i <= right; i ++) {
            if(arr[i] < stardValue) {
                swap(arr, i, index);
                index ++;
            }
        }

        swap(arr, left, index -1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
