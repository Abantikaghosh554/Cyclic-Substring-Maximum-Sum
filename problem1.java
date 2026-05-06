public class problem1 {
    
    public static int maxCyclicSubstringSum(String S) {
        int n = S.length();
        // Concatenate the string to easily handle cyclic substrings
        String E = S + S;
        int max_sum = 0;
        
        // The maximum length of a substring with all unique characters is bounded by 26
        int max_len = Math.min(n, 26);
        
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[26];
            int current_sum = 0;
            
            for (int j = i; j < i + max_len; j++) {
                int char_val = E.charAt(j) - 'a' + 1;
                int char_idx = char_val - 1;
                
                // If the character has already appeared, stop for the current starting position
                if (seen[char_idx]) {
                    break;
                }
                
                seen[char_idx] = true;
                current_sum += char_val;
                max_sum = Math.max(max_sum, current_sum);
            }
        }
        
        return max_sum;
    }

    public static void main(String[] args) {
        String S = "abca";
        System.out.println("Maximum sum: " + maxCyclicSubstringSum(S));
    }
}