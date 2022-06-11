import java.util.Scanner;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        out.println("Input your data.");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) {
        int resoult = 0;
        byte a, b;
        boolean[] isItArab = new boolean[2];
        String[] elements = input.split(" ");

        if (elements.length > 3) {
            return "throws Exception.";
        }
        if (isNumeric(elements[0])) {
            a = Byte.valueOf(elements[0]);
            isItArab[0]=true;
        } else {
            isItArab[0] = false;
            a = toArab(elements[0]);
        }
        if (isNumeric(elements[2])) {
            b = Byte.valueOf(elements[2]);
            isItArab[1]=true;
        } else {
            isItArab[1] = false;
            b = toArab(elements[2]);
        }

        if ((isItArab[0] != isItArab[1]) || (a>10) || (b>10)) {
            return "throws Exception.";

        }
        switch (elements[1]) {
            case("+"):
                resoult = a + b;
                break;
            case("-"):
                resoult = a - b;
                break;
            case("*"):
                resoult = a * b;
                break;
            case("/"):
                resoult = a / b;
                break;
        }
        if ((isItArab[0] && isItArab[1]) == false) {
            if (resoult <= 0) {
                return "throws Exception.";
            } else {
                return toRomsky(resoult);
            }
        }
        return String.valueOf(resoult);
    }

    public static byte toArab(String image) {
        byte an=0;
        switch (image) {

            case ("I"):
                an = 1;
                break;
            case ("II"):
                an = 2;
                break;
            case ("III"):
                an = 3;
                break;
            case ("IV"):
                an = 4;
                break;
            case ("V"):
                an = 5;
                break;
            case ("VI"):
                an = 6;
                break;
            case ("VII"):
                an = 7;
                break;
            case ("VIII"):
                an = 8;
                break;
            case ("IX"):
                an = 9;
                break;
            case ("X"):
                an = 10;
                break;
        }
        return an;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String toRomsky(int x){
        String resoult = "";
        if (x/100 == 1) {
            resoult += "C";
        } else {
            switch (x/10) {
                case(9):
                    resoult += "XC";
                    break;
                case(8):
                    resoult += "LXXX";
                    break;
                case(7):
                    resoult += "LXX";
                    break;
                case(6):
                    resoult += "LX";
                    break;
                case(5):
                    resoult += "L";
                    break;
                case(4):
                    resoult += "XL";
                    break;
                case(3):
                    resoult += "XXX";
                    break;
                case(2):
                    resoult += "XX";
                    break;
                case(1):
                    resoult += "X";
                    break;
            }
        }
        switch (x%10) {
            case(9):
                resoult += "IX";
                break;
            case(8):
                resoult += "VIII";
                break;
            case(7):
                resoult += "VII";
                break;
            case(6):
                resoult += "VI";
                break;
            case(5):
                resoult += "V";
                break;
            case(4):
                resoult += "IV";
                break;
            case(3):
                resoult += "III";
                break;
            case(2):
                resoult += "II";
                break;
            case(1):
                resoult += "I";
                break;
        }
        return resoult;
    }
}
