import java.util.Scanner;
import java.util.*;

public class JavaMentor {
    static RomanNumeral Numeral = new RomanNumeral();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String allString = scanner.nextLine();
        String[] all = allString.split(" ");
        String symbol = all[1];

        try {
            if(Character.isDigit(all[0].charAt(0)) && Character.isDigit(all[2].charAt(0))){
                int int_value1 = Integer.parseInt(all[0]);
                int int_value2 = Integer.parseInt(all[2]);

                int result = Numeral.Result(int_value1,symbol,int_value2);
                System.out.println(result);
            }else{
                int String_value1 = Numeral.convertRomanToInt(all[0]);
                int String_value2 = Numeral.convertRomanToInt(all[2]);

                int result = Numeral.Result(String_value1,symbol,String_value2);
                String roman = Numeral.convertIntegerToRoman(result);
                System.out.println(roman);
            }
        }catch (NumberFormatException e){
            System.out.println("Problem: Invalid format");
        }
    }
}

class RomanNumeral {
    static int numbers[]  = {1, 4, 5, 9, 10};
    static String letters[]  = { "I", "IV", "V", "IX", "X"};

    public int convertRomanToInt(String romanNumeral) throws NumberFormatException {
        int integerValue = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt( i );
            int number = letterToNumber( ch );

            if ( number == -1) {
                throw new NumberFormatException("Invalid format");
            }

            integerValue += number;
        }
        return integerValue;
    }

    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            default:   return -1;
        }
    }

    public String convertIntegerToRoman(int number) {
        String romanValue = "";
        int N = number;

        while ( N > 0 ) {
            for (int i = 0; i < numbers.length; i++) {
                if ( N < numbers[i] ) {
                    N -= numbers[i-1];
                    romanValue += letters[i-1];
                    break;
                }
            }
        }
        return romanValue;
    }

    public int Result(int x, String symbol,int y){
        int res = 0;
        switch (symbol){
            case ("+"):
                res = x + y;
                break;
            case ("-"):
                res = x - y;
                break;
            case ("*"):
                res = x * y;
                break;
            case ("/"):
                res = x / y;
        }
        return res;
    }
}
