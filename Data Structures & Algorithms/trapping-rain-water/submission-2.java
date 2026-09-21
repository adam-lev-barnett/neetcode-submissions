class Solution {
    public int trap(int[] height) {
        int total = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int bottom = height[stack.pop()];
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int width = i - left - 1;
                int waterHeight = Math.min(height[left], height[i]) - bottom;
                total += width * waterHeight;
            }
            stack.push(i);
        }

        return total;
    }
}