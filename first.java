package meta;
public class LongestWordFinder {

    public static String findLongestWord(String input) {
        String[] words = input.split("\\s+"); // Split the input string into words

        String longestWord = "";

        for (String word : words) {
            // Remove non-alphabetic characters for accurate word length
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");

            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        String input1 = "dummy text of the printing and typesetting industry.";
        String output1 = findLongestWord(input1);
        System.out.println("Input 1: " + input1);
        System.out.println("Output 1: " + output1);

        String input2 = "It is a long-established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distributionqqqqqqqqqqqqqqqqqqq of letters, as opposed to using 'Content here, content here', making it look like readable English";
        String output2 = findLongestWord(input2);
        System.out.println("Input 2: " + input2);
        System.out.println("Output 2: " + output2);
    }
}
