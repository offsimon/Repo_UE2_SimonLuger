import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {

    private String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {

        int numberOfTests = -1;
        String line = "";
        String[] split;
        int num;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            numberOfTests = Integer.parseInt(br.readLine());

            while ((line = br.readLine()) != null) {

                split = line.split(" ");
                num = Integer.parseInt(split[1]);

                if(split[0].equals("1")) {

                    setOddEvenTester((int n) -> n%2 == 0);
                    if(oddTester.testNumber(num)){
                        System.out.println("EVEN");
                    }else {
                        System.out.println("ODD");
                    }

                }else if(split[0].equals("2")) {

                    setPrimeTester((int n) -> isPrime(n));
                    if(primeTester.testNumber(num)) {
                        System.out.println("PRIME");
                    }else {
                        System.out.println("NO PRIME");
                    }

                }else if(split[0].equals("3")) {

                    setPalindromeTester((int n) -> isPalindrome(n));
                    if(palindromeTester.testNumber(num)) {
                        System.out.println("PALINDROME");
                    }else {
                        System.out.println("NO PALINDROME");
                    }
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPrime(int n) {

        if (n<= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public boolean isPalindrome(int n) {

        int palindrome = n;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        if (n == reverse) {
            return true;
        }
        return false;
    }
}
