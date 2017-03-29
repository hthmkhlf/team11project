import java.util.*;

/**
 * Class representing a fraction object containing a numerator and a denominator.
 * The fraction will be always be in simplified form.
 */
public class Fraction {
    private int numerator = 0;
    private int denominator = 1;

    /**

     * Creates a default fraction representing 0/1.
     */
    public Fraction() {
        this(0,1);
    }

    /**
     * Copies the data from the fraction provided as an argument to the Fraction
     * that we are creating.
     * @param toCopy the fraction that we are to copy in this constructor.
     */
    public Fraction(Fraction toCopy) {
        this(toCopy.numerator, toCopy.denominator);
    }

    /**
     * Creates a fraction using the specified numerator and denominator.  The denominator
     * must be non-zero and the fraction will be simplified if possible.
     * @param aNumerator the value for the numerator for this fraction.
     * @param aDenominator the value for the denominator for this fraction.
     */
    public Fraction(int aNumerator, int aDenominator) {
        setNumerator(aNumerator);
        setDenominator(aDenominator);
        simplify();
    }

    /**
     * Simplifies this fraction if possible.
     */
    private void simplify() {
        int divider = 1;
        if (numerator > this.denominator) {
            divider = denominator;
        } else {
            divider = numerator;
        }
        while (divider > 1 && (denominator % divider != 0 || numerator % divider != 0)) {
            divider--;
        }

        if (divider > 1) {
            numerator = numerator / divider;
            denominator = denominator / divider;
        }
    }

    /**
     * Changes the value of the numerator to the specified value.  The resulting
     * fraction will be simplified if possible.
     * @param value the new value for the numerator.
     */
    public void setNumerator(int value) {

        numerator = value;
        simplify();
    }

    /**
     * Changes the value of the denominator to the specified value as long as this value is
     * is not zero.  The resulting fraction will be simplified if possible.
     * @param value the new value for the denominator.
     */
    public void setDenominator(int value) {
        denominator = value;
        simplify();
        if (denominator == 0){
          throw new IllegalArgumentException("Denominator of 0 is not valid");
        }
    }

    /**
     * returns a string representation of this fraction object in the format
     * <numerator>/<denominator>.
     * @return string representation of this fraction object.
     */
    public String toString() {
        return numerator + "/" +denominator;
    }

    public void init() {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter denominator: ");
            int den = keyboard.nextInt();
            setDenominator(den);
            System.out.print("Enter numerator: ");
            int num = keyboard.nextInt();
            setNumerator(num);
            System.out.println("You created: " + toString()+"\n");
        }catch(InputMismatchException e) {
            System.out.println("Please enter whole numbers only");
            init();
        }catch(IllegalArgumentException e) {
            System.out.println("Denominator of 0 is not valid");
            init();
        }
    }

    public void getInput() {

    }

    public static void main(String[] args){
        Fraction f = new Fraction();
        f.init();
    }


}
