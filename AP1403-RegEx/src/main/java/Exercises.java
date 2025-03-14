import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
    */
    public boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-%]+[^.]@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
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
        String regex = "(\\b(\\d{4})[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])\\b)|" +
                "(\\b(\\d{4})[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])\\b)|" +
                "(\\b(0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])[-/](\\d{4})\\b)|" +
                "(\\b(0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])[-/](\\d{4})\\b)";
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
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[\\S]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        int count = 0;
        String check [] = string.split("\\s+")
        for (String variable : check) {
            Matcher matcher = pattern.matcher(variable) ;
             if (matcher.matches()) {
                 count++;
             }
        }
        return count;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
    */
    public static List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        // todo
        List<String> seen = new ArrayList<>();
        String[] words = string.split("\\W+");

        for (String word : words) {
            if (word.length() >= 3) {
                String lowerCaseWord = word.toLowerCase();
                String reversedWord = new StringBuilder(lowerCaseWord).reverse().toString();

                if (lowerCaseWord.equals(reversedWord) && !seen.contains(lowerCaseWord)) {
                    list.add(word);
                    seen.add(lowerCaseWord);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Exercises ex = new Exercises();


    }
}
