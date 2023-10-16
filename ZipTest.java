import java.util.Scanner;

/**
 * ZipTest.java - A program to demonstrate the conversion between ZIP codes and barcodes.
 * This program allows the user to input either a ZIP code and get its corresponding barcode,
 * or input a barcode and get its corresponding ZIP code.
 */
public class ZipTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Convert from ZIP to barcode
        System.out.println("Please enter a ZIP code: ");
        int zip = input.nextInt();
        Zipcode code1 = new Zipcode(zip);
        System.out.println("The corresponding barcode: ");
        System.out.println(code1.getBarcode());

        // Convert from barcode to ZIP code
        System.out.println("Now please provide a barcode: ");
        String bar = input.next();
        Zipcode code2 = new Zipcode(bar);
        System.out.println("The corresponding ZIP code: ");
        System.out.println(code2.getZIPcode());
    }
}
