/**
 * Double Hashing
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class DoubleHashing extends Hashtable {

    /**
     * Constructor for creating a new DoubleHash
     * 
     * @param capacity
     * @param loadFactor
     */
    public DoubleHashing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    /**
     * Double hash function
     * 
     * @param element
     * @param probe
     * @return integer hash value
     */
    @Override
    protected int h(HashObject element, int probe) {
        int h1 = positiveMod(element.getKey().hashCode(), capacity);
        int h2 = 1 + positiveMod(element.getKey().hashCode(), capacity - 2);
        return (h1 + (probe * h2)) % capacity;
    }

    /**
     * Ensures the probing calculation always returns positive integers
     * 
     * @param dividend
     * @param divisor
     * @return integer quotient
     */
    protected int positiveMod(int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0) {
            quotient += divisor;
        }
        return quotient;
    }
}
