package com.ds.p08_sorting.runner;

import com.ds.p08_sorting.sortingalgorithm.*;

public class SortingRunner {
    public static void main(String[] args) {
        System.out.println("Bubble Sort-----------------");
        int[] inputArray = {9, 3, 6, 1, 7, 4, 5};
        S01BubbleSort.bubbleSort(inputArray);
        System.out.println("----------------------------\n");

        System.out.println("Selection Sort--------------");
        int[] inputArraySelectionSort = {9, 3, 6, 1, 7, 4, 5};
        S02SelectionSort.selectionSort(inputArraySelectionSort);
        System.out.println("----------------------------\n");

        System.out.println("Insertion Sort--------------");
        int[] inputArrayInsertionSort = {9, 3, 6, 1, 7, 4, 5};
        S03InsertionSort.insertionSort(inputArrayInsertionSort);
        System.out.println("----------------------------\n");

        System.out.println("Merge Sort--------------");
        int[] inputArray1MergeSort = {1, 3, 7, 8, 11};
        int[] inputArray2MergeSort = {2, 4, 5, 6, 19, 45};
        S04MergeSort.merge(inputArray1MergeSort, inputArray2MergeSort);

        int[] inputArrayMergeSort = {3, 1, 4, 2};
        S04MergeSort.mergeSort(inputArrayMergeSort);
        System.out.println("----------------------------\n");

        System.out.println("Quick Sort--------------");
        int[] inputPivotQuickSort = {4, 1, 6, 7, 3, 2, 5};
        S05QuickSort.pivot(inputPivotQuickSort, 0, inputPivotQuickSort.length - 1);
        System.out.println("----------------------------\n");
        int[] inputQuickSort = {4, 1, 6, 7, 3, 2, 5};
        S05QuickSort.quickSort(inputQuickSort);
    }
}
