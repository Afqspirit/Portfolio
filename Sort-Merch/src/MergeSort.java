import java.util.Scanner;

public class MergeSort {
    // Слияние двух подмассивов arr[].
    // Первый подмассив arr[l..m]
    // Второй подмассив arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Ищем размер двух подмассивов, kt должны быть замержены (слиты в одно)
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Создаем временные массивы */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Копируем содержимое во временные массивы*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        /* Мержим оба массива  */
        // исходные индексы для первого и второго подмассива
        int i = 0, j = 0;

        // исходный индекс для замерженного подмассива
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Копируем оставшиеся элементы L[]*/
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Копируем оставшиеся элементы R[]*/
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Главный метод, kt сортирует arr[l..r], используя merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Поиск средней точки
            int m = (l+r)/2;

            // Сортировка 1й и 2й половины
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Мердж сортированных половинок
            merge(arr, l, m, r);
        }
    }

    /* Метод для принта массива размером n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

            // интерфейс
    public static void main(String args[])
    {
        int arr[] = {5, 2, 4, 6, 1, 3, 2, 6}; //ВВОДИМ любой МАССИВ для сортировки

        System.out.println("Начальный массив");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nСортированный массив");
        printArray(arr);
    }
}
/* Created by  Aleksandr Zhuk for Portfolio */
/* More projects https://github.com/Afqspirit */