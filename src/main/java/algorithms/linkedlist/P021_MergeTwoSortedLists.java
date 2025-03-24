package algorithms.linkedlist;

import datastructure.ListNode;
import utils.ListNodeUtils;

/**
 * LeetCode 第21题: 合并两个有序链表
 * 
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class P021_MergeTwoSortedLists {
    
    /**
     * 解法1：递归
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(n+m)
     */
    public ListNode solution1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = solution1(l1.next, l2);
            return l1;
        } else {
            l2.next = solution1(l1, l2.next);
            return l2;
        }
    }
    
    /**
     * 解法2：迭代
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(1)
     */
    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // 连接剩余链表
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    // 测试
    public static void main(String[] args) {
        P021_MergeTwoSortedLists solution = new P021_MergeTwoSortedLists();
        
        // 创建测试链表
        ListNode l1 = ListNodeUtils.createLinkedList(new int[]{1, 2, 4});
        ListNode l2 = ListNodeUtils.createLinkedList(new int[]{1, 3, 4});
        
        System.out.println("链表1: " + l1);
        System.out.println("链表2: " + l2);
        
        // 测试递归解法
        ListNode mergedRecursive = solution.solution1(
            ListNodeUtils.createLinkedList(new int[]{1, 2, 4}),
            ListNodeUtils.createLinkedList(new int[]{1, 3, 4})
        );
        System.out.println("递归合并结果: " + mergedRecursive);
        
        // 测试迭代解法
        ListNode mergedIterative = solution.solution2(
            ListNodeUtils.createLinkedList(new int[]{1, 2, 4}),
            ListNodeUtils.createLinkedList(new int[]{1, 3, 4})
        );
        System.out.println("迭代合并结果: " + mergedIterative);
    }
}
