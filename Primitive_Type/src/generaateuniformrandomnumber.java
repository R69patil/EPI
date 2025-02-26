import java.util.Random;


public class generaateuniformrandomnumber {
    public static int uniformRandom(int n) {
        Random random = new Random();
        int result;
        int bits = Integer.toBinaryString(n).length(); // Number of bits needed

        do {
            result = 0;
            for (int i = 0; i < bits; i++) {
                // Generate a random bit (0 or 1) and shift it to the correct position
                result = (result << 1) | (random.nextInt(2));
            }
        } while (result >= n); // Reject numbers outside the range

        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Generate numbers between 0 and 9
        for (int i = 0; i < 10; i++) {
            int randomNumber = uniformRandom(n);
            System.out.println("Random Number: " + randomNumber);
        }
    }
}
