import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
    */
    public boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
    */
    public String findDate(String string) {
        String regex = "\\b(\\d{1,2})[-/](\\d{1,2})[-/](\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() ? matcher.group() : null;
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
    */
    public int findValidPasswords(String string) {
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
    */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        String regex = "\\b[a-zA-Z]{3,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String word = matcher.group();
            if (isPalindrome(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean isPalindrome(String word) {
        String lowerWord = word.toLowerCase();
        return lowerWord.equals(new StringBuilder(lowerWord).reverse().toString());
    }

    public static void main(String[] args) {
        Exercises ex = new Exercises();

        // Test validateEmail
        System.out.println("validateEmail Tests:");
        System.out.println(ex.validateEmail("user@example.com")); // true
        System.out.println(ex.validateEmail("invalid-email"));    // false
        System.out.println(ex.validateEmail("test@domain"));     // false
        System.out.println(ex.validateEmail("valid.email@domain.com")); // true

        // Test findDate
        System.out.println("\nfindDate Tests:");
        System.out.println(ex.findDate("Today's date is 12/03/2024.")); // 12/03/2024
        System.out.println(ex.findDate("No date here.")); // null
        System.out.println(ex.findDate("Event on 3-5-2022.")); // 3-5-2022

        // Test findValidPasswords
        System.out.println("\nfindValidPasswords Tests:");
        System.out.println(ex.findValidPasswords("StrongPass1!")); // 1
        System.out.println(ex.findValidPasswords("weakpass")); // 0
        System.out.println(ex.findValidPasswords("Pass1234! SecurePass2#")); // 2

        // Test findPalindromes
        System.out.println("\nfindPalindromes Tests:");
        System.out.println(ex.findPalindromes("Madam, Anna and Civic are palindromes.")); // [Madam, Anna, Civic]
        System.out.println(ex.findPalindromes("Hello World!")); // []
    }
}
