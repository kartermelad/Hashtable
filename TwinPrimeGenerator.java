/**
 * Generates twin prime numbers
 * 
 * @Author Karter Melad
 * @version Fall 2023
 */
public class TwinPrimeGenerator {
    
    /**
     * Generates twin prime numbers
     * 
     * @param min
     * @param max
     * @return two prime numebrs that are 'twins'
     */
    public static int generateTwinPrime(int min, int max) {
        for (int i = min + 2; i <= max; i++) {
            if (isPrime(i) && isPrime(i - 2)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Check to see if the argument is a prime number
     * 
     * @param n
     * @return true if the input is prime, else false
     */
    private static boolean isPrime(int n) {
        boolean prime = true;
        if (n <= 1) {
            prime = false;
            return prime;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}