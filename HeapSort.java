import java.util.Random;

public class HeapSort
{
    public void sort(int array[])
    {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
   
        for (int i=n-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

     void heapify(int array[], int n, int i)
    {
        int max = i;
        int left = 2*i + 1; 
        int right = 2*i + 2; 
        if (left < n && array[left] > array[max])
            max = left;

        if (right < n && array[right] > array[max])
            max = right;

        if (max != i)
        {
            int swap = array[i];
            array[i] = array[max];
            array[max] = swap;
            heapify(array, n, max);
        }
    }

    static void printArray(int array[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }


    public static void main(String args[])
    {
        Random random = new Random();
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i]= random.nextInt(100);
        }
        printArray(array);
        HeapSort ob = new HeapSort();
        ob.sort(array);
        printArray(array);
    }
}