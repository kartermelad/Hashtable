/**
 * Linear Probing
 * 
 * @author Karter Melad
 * @version Fall 2023
 */
public class LinearProbing extends Hashtable {

    /**
     * Constructor for creating a new Linear Probe
     * 
     * @param capacity
     * @param loadFactor
     */
    public LinearProbing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    /**
     * Linear Probing function
     * 
     * @param element
     * @param probe
     * @return integer probe value
     */
    @Override
    protected int h(HashObject element, int probe) {
        int h1 = positiveMod(element.getKey().hashCode(), capacity);
        return (h1 + probe) % capacity;
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
