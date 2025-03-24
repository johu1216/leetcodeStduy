package algorithms.string;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第2255题: 统计是给定字符串前缀的字符串数目
 * 
 * 给你一个字符串数组 words 和一个字符串 s，请你统计并返回 words 中有多少个字符串是 s 的前缀。
 * 字符串的前缀是出现在字符串开头的子字符串。
 * 
 * 示例 1：
 * 输入：words = ["a","b","c","ab","bc","abc"], s = "abc"
 * 输出：3
 * 解释：
 * - "a" 是 "abc" 的前缀。
 * - "ab" 是 "abc" 的前缀。
 * - "abc" 是 "abc" 的前缀。
 * 共计 3 个字符串。
 * 
 * 示例 2：
 * 输入：words = ["a","a"], s = "aa"
 * 输出：2
 * 解释：
 * - "a" 是 "aa" 的前缀，且在 words 中出现 2 次。
 * 共计 2 个字符串。
 */
public class P2255_CountPrefixesOfGivenString {
    
    /**
     * 我的解决方案
     * @param words 字符串数组
     * @param s 目标字符串
     * @return 是 s 的前缀的字符串数目
     */
    public int myMethod(String[] words, String s) {
        int result = 0;
        List<String> prefixList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            prefixList.add(s.substring(0, i + 1));
        }
        for (int i = 0; i < words.length; i++) {
            if (prefixList.contains(words[i])) {
                result++;
            }
        }
        return result;
    }
    
    /**
     * 学习后的优化解决方案
     * @param words 字符串数组
     * @param s 目标字符串
     * @return 是 s 的前缀的字符串数目
     */
    public int learnedMethod(String[] words, String s) {
        int count = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                count++;
            }
        }
        return count;
    }

    
    // 测试
    public static void main(String[] args) {
        P2255_CountPrefixesOfGivenString solution = new P2255_CountPrefixesOfGivenString();
        
        // 测试用例1
        String[] words1 = {"a", "b", "c", "ab", "bc", "abc"};
        String s1 = "abc";
        System.out.println("测试用例1 (我的方法): " + solution.myMethod(words1, s1));
        System.out.println("测试用例1 (学习方法): " + solution.learnedMethod(words1, s1));
        
        // 测试用例21
        String[] words2 = {"a", "a"};
        String s2 = "aa";
        System.out.println("测试用例2 (我的方法): " + solution.myMethod(words2, s2));
        System.out.println("测试用例2 (学习方法): " + solution.learnedMethod(words2, s2));
    }
}
