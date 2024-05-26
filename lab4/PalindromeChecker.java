public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        // Видалимо знаки пунктуації та пробіли
        String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        // Порівнюємо першу половину слова з його зеркальним відображенням
        for (int i = 0; i < cleanWord.length() / 2; i++) {
            if (cleanWord.charAt(i) != cleanWord.charAt(cleanWord.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
