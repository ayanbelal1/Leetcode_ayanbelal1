import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        List<Integer> divisors = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        int totalSum = 0;
        
        for (int k : divisors) {
            boolean isValid = true;
            for (int i = 0; i < n; i += k) {
                
                int[] block = Arrays.copyOfRange(nums, i, i + k);
                int[] target = Arrays.copyOfRange(sortedNums, i, i + k);
                
                if (!isCyclicRotationKMP(block, target)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                totalSum += k;
            }
        }
        
        return totalSum;
    }
    
    private boolean isCyclicRotationKMP(int[] block, int[] target) {
        int k = block.length;
        if (k == 0) return true;
        
       
        int[] text = new int[2 * k];
        for (int i = 0; i < k; i++) {
            text[i] = block[i];
            text[i + k] = block[i];
        }
        
        int[] pattern = target;
        
        int[] lps = computeLPS(pattern);
        int i = 0; 
        int j = 0; 
        
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            }
            if (j == pattern.length) {
                return true;
            } else if (i < text.length && text[i] != pattern[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return false;
    }
    
    private int[] computeLPS(int[] pattern) {
        int[] lps = new int[pattern.length];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        
        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}