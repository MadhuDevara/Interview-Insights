/*
    Binary search is used to efficiently find an element in a sorted array.
    It works by repeatedly dividing the array in half, and determining which
    half contains the element.
*/


package Algorithms;
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target)
                return mid;

            // If target is greater, ignore the left half
            if (arr[mid] < target)
                left = mid + 1;

                // If target is smaller, ignore the right half
            else
                right = mid - 1;
        }

        // Return -1 if element is not present
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;

        int result = binarySearch(arr, target);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
