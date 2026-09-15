import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {

            if (matches(words[i], pattern)) {
                result.add(words[i]);
            }
        }

        return result;
    }

    public boolean matches(String word, String pattern) {

        // Mapping from pattern character -> word character
        HashMap<Character, Character> map1 =
                new HashMap<Character, Character>();

        // Mapping from word character -> pattern character
        HashMap<Character, Character> map2 =
                new HashMap<Character, Character>();

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // Check pattern -> word mapping
            if (map1.containsKey(p)) {

                if (map1.get(p) != w) {
                    return false;
                }

            } else {
                map1.put(p, w);
            }

            // Check word -> pattern mapping
            if (map2.containsKey(w)) {

                if (map2.get(w) != p) {
                    return false;
                }

            } else {
                map2.put(w, p);
            }
        }

        return true;
    }
}
