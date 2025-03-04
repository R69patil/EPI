package Arrays;

import java.util.*;

public class PrimeNumbersList {
    public static List<Integer> getPrimesUpToN(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n < 2) return primes; // No primes if n < 2
        
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 50; // Change this value to test different numbers
        List<Integer> primes = getPrimesUpToN(n);
        System.out.println("Prime numbers up to " + n + ": " + primes);
    }
}
