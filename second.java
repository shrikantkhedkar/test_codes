package meta;
public class MaxNumberFinder {

    public static int findMaxNumber(Object[] array) {
        int maxNumber = Integer.MIN_VALUE;

        for (Object element : array) {
            if (element instanceof Integer) {
                int currentNumber = (int) element;
                maxNumber = Math.max(maxNumber, currentNumber);
            } else if (element instanceof Object[]) {
                int maxInSubArray = findMaxNumber((Object[]) element);
                maxNumber = Math.max(maxNumber, maxInSubArray);
            }
        }

        return maxNumber;
    }

    public static void main(String[] args) {
        Object[] input = {2, 4, 10, new Object[]{12, 4, new Object[]{100, 99}, 4}, new Object[]{3, 2, 99}, 0};
        int maxNumber = findMaxNumber(input);
        System.out.println("Maximum number in the jagged array: " + maxNumber);
    }
}
