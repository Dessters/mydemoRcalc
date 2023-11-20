import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String str = in.nextLine();
        String[] nums = str.split(" ");
        RomanNumber convert = new RomanNumber();
        String[] rim = {"I","II","III","IV","V",
                        "VI","VII","VIII","IX","X"};
        if(nums.length == 1 || nums.length == 2 || nums.length > 4){
            System.out.println("throws Exception");
            System.exit(0);
        }
        int value1 = 0;
        int value2 = 0;
        int check = 0;
        int i = 1;
        for (String s : rim) {
            if (nums[0].toUpperCase().equals(s)) {
                ++check;
                value1 = i;
            }
            if (nums[2].toUpperCase().equals(s)) {
                ++check;
                value2 = i;
            }
            ++i;
        }
        if(check == 1){
            System.out.println("throws Exception");
            System.exit(0);
        }
        int sum = 1;
        String operation = nums[1];
        if(check == 0){
            value1 = Integer.parseInt(nums[0]);
            value2 = Integer.parseInt(nums[2]);

        }
        if (value1 > 0 & value1 < 11 & value2 > 0 & value2 < 11){
            switch (operation){
                case ("+"):
                    sum = value1 + value2;
                    break;
                case ("-"):
                    sum = value1 - value2;
                    break;
                case ("*"):
                    sum = value1 * value2;
                    break;
                case ("/"):
                    sum = value1 / value2;
                    break;
                default:
                    System.out.println("throws Exception");
                    System.exit(0);
            }

            if(check>1){
                if (sum < 1){
                    System.out.println("throws Exception");
                    System.exit(0);
                }
                System.out.println(convert.toRoman(sum));
            }
            else{
                System.out.println(sum);
            }
        }
        else{
            System.out.println("throws Exception");
        }
    }
}
class RomanNumber {
    static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
    static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
}