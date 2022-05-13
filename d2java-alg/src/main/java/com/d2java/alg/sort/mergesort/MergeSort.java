package com.d2java.alg.sort.mergesort;

import com.d2java.alg.sort.Sortable;

public class MergeSort implements Sortable {

    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        merge(arr, 0, arr.length - 1);
        return arr;
    }

    private void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        merge(arr, left, mid);
        merge(arr, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {

            }
        }
    }
}
