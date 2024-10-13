package Bytridge;

public class Task1 {

    // Method to find the maximum difference between any two elements such that the
    // larger element appears after the smaller element
    public static int maxDifference(int[] nums) {
        // If the array is empty or has less than 2 elements, return 0
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // Initialize minimum element as the first element
        int minElement = nums[0];
        int maxDiff = -1;  // Start with -1 to handle cases where no valid pair exists

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate the difference between current element and minElement
            int diff = nums[i] - minElement;

            // Update maxDiff if a larger difference is found
            if (diff > maxDiff) {
                maxDiff = diff;
            }

            // Update minElement if the current element is smaller
            if (nums[i] < minElement) {
                minElement = nums[i];
            }
        }

        return maxDiff;
    }

    // Method to run all test cases
    public static void runTests() {
        assert testMaxDifference(new int[] { 2, 3, 10, 6, 4, 8, 1 }, 8) : "Test Case 1 Failed";
        assert testMaxDifference(new int[] { 7, 9, 5, 6, 3, 2 }, 2) : "Test Case 2 Failed";
        assert testMaxDifference(new int[] { 1, 2, 90, 10, 110 }, 109) : "Test Case 3 Failed";
        assert testMaxDifference(new int[] { 7, 1, 5, 3, 6, 4 }, 5) : "Test Case 4 Failed";
        assert testMaxDifference(new int[] { 9, 7, 4, 3 }, -1) : "Test Case 5 Failed";
        assert testMaxDifference(new int[] { 1, 1, 1, 1 }, 0) : "Test Case 6 Failed";
        assert testMaxDifference(new int[] {}, 0) : "Test Case 7 Failed";
        assert testMaxDifference(new int[] { 100, 180, 260, 310, 40, 535, 695 }, 655) : "Test Case 8 Failed";

        System.out.println("All test cases passed!");
    }

    // Helper method to validate the result of maxDifference
    private static boolean testMaxDifference(int[] input, int expected) {
        int result = maxDifference(input);
        return result == expected;
    }

    public static void main(String[] args) {
        runTests();
    }
}