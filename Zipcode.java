public class Zipcode {
    // Instance variables:
    private String barcode;
    private int zipcode;

    // Constructors:

    // Constructor used for zipcode input.
    public Zipcode(int zip) {
        zipcode = zip;
    }

    // Constructor used for both barcode and zipcode inputs.
    public Zipcode(String bar) {
        barcode = bar;
    }

    // Instance Methods

    /**
     * Method to convert from barcode to zipcode.
     *
     * @return zipcodeDigits the zipcode converted from barcode.
     */
    public String getZIPcode() {
        String zipcodeDigits = "";
        for (int i = 1; i < barcode.length() - 10; i += 5) {
            String encoding = barcode.substring(i, i + 5);
            zipcodeDigits += this.getDigit(encoding);
        }
        return zipcodeDigits;
    }

    /**
     * Helper method to convert from barcode encoding of a digit to its digit.
     *
     * @param bar barcode encoding to be converted to a digit
     * @return digit the digit corresponding to a sub-section of the encoding
     */
    public String getDigit(String bar) {
        int sum = 0;
        String digit;
        for (int i = 0; i < bar.length(); i++) {
            if (bar.charAt(i) == '|') {
                switch (i) {
                    case 0:
                        sum += 7; // weight = 7;
                        continue; // skip to the next iteration of the for loop.
                    case 1:
                        sum += 4; // weight = 4;
                        continue;
                    case 2:
                        sum += 2; // weight = 2;
                        continue;
                    case 3:
                        sum += 1; // weight = 1;
                        continue;
                    case 4:
                        sum += 0; // weight = 0;
                        continue;
                }
            }
        }
        if (sum == 11) {
            digit = "0";
        } else {
            digit = Integer.toString(sum);
        }
        return digit;
    }

    /**
     * Method to convert zipcode into barcode.
     *
     * @return barcode the barcode representation of the zipcode
     */
    public String getBarcode() {
        String barcode = "|";
        int checkDigit;
        String zip;

        // Handle leading zeroes:
        if (zipcode <= 9) { // 4 leading zeroes
            zip = "0000" + Integer.toString(zipcode);
        } else if (zipcode <= 99) { // 3 leading zeroes
            zip = "000" + Integer.toString(zipcode);
        } else if (zipcode <= 999) { // 2 leading zeroes
            zip = "00" + Integer.toString(zipcode);
        } else if (zipcode <= 9999) { // 1 leading zero
            zip = "0" + Integer.toString(zipcode);
        } else {
            zip = Integer.toString(zipcode);
        }

        String zipWithCheck = zip + Integer.toString(getCheckdigit());

        for (int i = 0; i < zipWithCheck.length(); i++) {
            switch (zipWithCheck.charAt(i)) {
                case '0':
                    barcode += "||:::";
                    continue;
                case '1':
                    barcode += ":::||";
                    continue;
                case '2':
                    barcode += "::|:|";
                    continue;
                case '3':
                    barcode += "::||:";
                    continue;
                case '4':
                    barcode += ":|::|";
                    continue;
                case '5':
                    barcode += ":|:|:";
                    continue;
                case '6':
                    barcode += ":||::";
                    continue;
                case '7':
                    barcode += "|:::|";
                    continue;
                case '8':
                    barcode += "|::|:";
                    continue;
                case '9':
                    barcode += "|:|::";
                    continue;
            }
        }

        return barcode + "|";
    }

    /**
     * Helper method to find the check digit of a given zipcode.
     *
     * @return the check digit
     */
    public int getCheckdigit() {
        // Leading zeroes aren't considered since they have no effect on the check digit.
        String zip = Integer.toString(zipcode);
        int sum = 0;
        for (int i = 0; i < zip.length(); i++) {
            sum += Character.getNumericValue(zip.charAt(i));
        }
        if (sum > 10) {
            return 10 - (sum % 10);
        } else {
            return 10 - sum;
        }
    }
}
