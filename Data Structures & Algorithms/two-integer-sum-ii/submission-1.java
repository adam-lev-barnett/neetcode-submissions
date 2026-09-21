class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int R = numbers.length - 1;
        int L = 0;

        while (R > L) {
            System.out.println("Left index = " + L);
            System.out.println("Value at L = " + numbers[L]);
            System.out.println();
            System.out.println("Right index = " + R);
            System.out.println("Value at R = " + numbers[R]);
            System.out.println();

            int sum = numbers[R] + numbers[L];
            System.out.println("Sum of L+R = " + sum);

            if (sum == target) {
                System.out.println("Success! Returning indices: " + L + ", " + R);
                System.out.println("Array: " + Arrays.toString(new int[] {L + 1, R + 1}));
                return new int[] {L + 1, R + 1};
            }

            if (sum > target) {
                System.out.println("Nope! Decrementing R.\n");
                R--;
            }

            else {
                System.out.println("Nope! Incrementing L.\n");
                L++;
            }
        }

        return new int[] {L, R};

    }
    
}
