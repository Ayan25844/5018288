
// 1. Recursion is a programming technique where a function calls itself to solve smaller instances of a problem until it reaches a base case. This approach can simplify problems by breaking them down into more manageable subproblems. For example, calculating the factorial of a number n (n!) is naturally recursive: n! = n * (n-1)! with the base case 1! = 1. Recursion is particularly effective for problems like tree traversals and the Fibonacci sequence, where each step builds upon the results of previous steps.

public class Main {
    public static void main(String[] args) {
        double presentValue = 1000; // Example present value
        double growthRate = 4.8; // Example growth rate
        int periods = 4; // Example number of periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }

    public static double calculateFutureValue(double pv, double rate, int n) {

        // 2. The given recursive algorithm for calculating future value has a time
        // complexity of O(n). This is because the function makes a single recursive
        // call for each period n, decrementing n by 1 each time. Therefore, the
        // function will be called n times before reaching the base case n = 0. Since
        // each call performs a constant amount of work (multiplication and
        // addition), the overall time complexity is linear, O(n).

        if (n == 0) {

            // Base case: If there are no more periods, the future value is the present
            // value

            return pv;
        }

        // Recursive case: Calculate the future value by reducing the number of periods

        return calculateFutureValue(pv * (1 + rate), rate, n - 1);
    }
}

// 3. To optimize the above recursive solution and avoid excessive computation,
// an iterative approach can be used. By using a loop instead of recursion, the
// future value can be computed in a single pass, which eliminates the overhead
// of multiple recursive calls. This approach also has a time complexity of
// O(n) but is more efficient in terms of space since it avoids the extra memory
// overhead associated with recursive function calls.
