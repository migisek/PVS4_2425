package exceptions.debugging;

public class StringPractice {
    public boolean isPalindrome(String s){
        if (s == null || s.isEmpty()){
            return false;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
