package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void test() {
        assertEquals(2, StringUtils.countChars("aabbccdd", 'a'));
        assertEquals(2, StringUtils.countChars("aabbccdd", 'b'));
        assertEquals(6, StringUtils.countChars("aabbccccccdd", 'c'));
        assertEquals(0, StringUtils.countChars("e", 'c'));
    }


    @Test
    public void testEndsWith() {
        assertTrue(StringUtils.endsWith("Java Exercises", "es"));
        assertTrue(StringUtils.endsWith("Java Exercises", "ses"));
        assertTrue(StringUtils.endsWith("Java Exercises", "Exercises"));
        assertTrue(StringUtils.endsWith("Java Exercises", "Java Exercises"));


        assertFalse(StringUtils.endsWith("Java Exercises", "e"));
        assertFalse(StringUtils.endsWith("Java Exercises", "se"));
        assertFalse(StringUtils.endsWith("Java Exercises", "Exerci"));
        assertFalse(StringUtils.endsWith("Java Exercises", "Java Exercise"));
    }


    @Test
    public void testContainsSameChars() {
        assertTrue(StringUtils.containsSameChars("dog", "god"));
        assertTrue(StringUtils.containsSameChars("god", "dog"));
        assertTrue(StringUtils.containsSameChars("dgo", "god"));
        assertTrue(StringUtils.containsSameChars("odg", "odg"));


        assertFalse(StringUtils.containsSameChars("dogg", "god"));
        assertFalse(StringUtils.containsSameChars("", "god"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("ana"));
    }

    @Test
    public void testIsPalindrome2() {
        assertTrue(StringUtils.isPalindrome2("aa".toCharArray()));
        assertTrue(StringUtils.isPalindrome2("a".toCharArray()));
        assertTrue(StringUtils.isPalindrome2("ana".toCharArray()));
        assertTrue(StringUtils.isPalindrome2("aaaannnnaaaa".toCharArray()));
        assertFalse(StringUtils.isPalindrome2("amna".toCharArray()));
        assertFalse(StringUtils.isPalindrome2("anpa".toCharArray()));
    }

    @Test
    public void testFizzBuzz() {
        final String fizzBuzz = "FizzBuzz";
        final String fizz = "Fizz";
        final String buzz = "Buzz";

        assertEquals("2", StringUtils.fizzBuzz(2));
        assertEquals(fizz, StringUtils.fizzBuzz(3));
        assertEquals(buzz, StringUtils.fizzBuzz(5));
        assertEquals(buzz, StringUtils.fizzBuzz(20));
        assertEquals(fizzBuzz, StringUtils.fizzBuzz(15));
        assertEquals(fizzBuzz, StringUtils.fizzBuzz(30));

    }

    @Test
    public void testLongestPalindromaticString() {
        assertEquals("ana", StringUtils.longestPalindromaticString("ana"));
        assertEquals("bab", StringUtils.longestPalindromaticString("babad"));
        assertEquals("bb", StringUtils.longestPalindromaticString("cbbd"));
        assertEquals("a", StringUtils.longestPalindromaticString("a"));
        assertEquals("a", StringUtils.longestPalindromaticString("ac"));
        assertEquals("aaaaaacaaaaaa", StringUtils.longestPalindromaticString("aaaaaacaaaaaaaaab"));
        assertEquals("aba", StringUtils.longestPalindromaticString("abacdfgdcaba"));

    }


    @Test
    public void testLongestRepeatingSubstring() {
        assertEquals(Map.entry(3, "abc"), StringUtils.longestRepeatingSubstring("abcabcbb"));
        assertEquals(Map.entry(1, "b"), StringUtils.longestRepeatingSubstring("bbbbb"));
        assertEquals(Map.entry(3, "wke"), StringUtils.longestRepeatingSubstring("pwwkew"));
        assertEquals(Map.entry(0, ""), StringUtils.longestRepeatingSubstring(""));
        assertEquals(Map.entry(1, " "), StringUtils.longestRepeatingSubstring(" "));
    }

}