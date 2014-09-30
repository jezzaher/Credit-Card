    import java.util.Scanner;

    public class CheckDigit {

        public static boolean isValid(long num) {

            int total = sumOfEvens(num) + sumOfOdds(num);

            if ((total % 10 == 0) && (matchedPrefix(num, 1) == true)) {
                return true;
            } else {
                return false;
            }
        }

        public static int getDigit(int number) {

            if (number <= 9) {
                return number;
            } else {
                int firstDigit = number % 10;
                int secondDigit = (int) (number / 10);

                return firstDigit + secondDigit;
            }
        }

        public static int sumOfOdds(long number) {
            int result = 0;

            while (number > 0) {
                result += (int) (number % 10);
                number = number / 100;
            }

            return result;
        }

        public static int sumOfEvens(long number) {

            int result = 0;
            long temp = 0;

            while (number > 0) {
                temp = number % 100;
                result += getDigit((int) (temp / 10) * 2);
                number = number / 100;
            }

            return result;
        }

        public static boolean matchedPrefix(long number, int d) {

            if ((getPrefix(number, d) == 3)
                    || (getPrefix(number, d) == 4)
                    || (getPrefix(number, d) == 5)
                    || (getPrefix(number, d) == 6)) {

                if (getPrefix(number, d) == 3) {
                    System.out.println("\nAmerican Express Card ! ");
                } else if (getPrefix(number, d) == 4) {
                    System.out.println("\nVisa Card ! ");
                } else if (getPrefix(number, d) == 5) {
                    System.out.println("\nMaster Card !");
                } else if (getPrefix(number, d) == 6) {
                    System.out.println("\nDiscover Card !");
                }

                return true;
            
            } else {

                return false;

            }
        }

        public static int getSize(long d) {

            int count = 0;

            while (d > 0) {
                d = d / 10;

                count++;
            }

            return count;

        }

        public static long getPrefix(long number, int k) {

            if (getSize(number) < k) {
                return number;
            } else {

                int size = (int) getSize(number);

                for (int i = 0; i < (size - k); i++) {
                    number = number / 10;
                }

                return number;

            }

        }
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            System.out.print("Enter your Card Number : ");

            long input = in.nextLong();

            if (isValid(input) == true) {
                System.out.println("\nYour card is Valid");
            } else {
                System.out.println("\nYour Card is not Valid  ");
            }

        }
    }