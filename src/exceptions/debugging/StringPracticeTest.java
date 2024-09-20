package exceptions.debugging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPracticeTest {

    @Test
    void simplePalindromeTest(){
        StringPractice practice = new StringPractice();

        assertTrue(practice.isPalindrome("madam"));
        assertTrue(practice.isPalindrome("racecar"));

    }

    @Test
    void simplePalindromeTestNegatives(){
        StringPractice practice = new StringPractice();

        assertFalse(practice.isPalindrome("hello"));
        assertFalse(practice.isPalindrome("world"));
        assertFalse(practice.isPalindrome("cisco"));

    }

    @Test
    void advancedPalindromeTest(){
        StringPractice sp = new StringPractice();

        assertTrue(sp.isPalindrome("No lemon, no melon"));
        assertTrue(sp.isPalindrome("A man a plan a canal Panama"));
    }
}