/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;      // 节点存储的数字值
 *     ListNode next; // 指向下一个节点的指针
 *     
 *     ListNode() {} // 无参构造函数
 *     ListNode(int val) { this.val = val; } // 只传入值的构造函数
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // 传入值和下一个节点的构造函数
 * }
 */

/**
 * 解决方案类 - 两数相加
 * 题目描述：给定两个用链表表示的整数，每个节点包含一个数位，返回一个新的链表表示它们的和
 * 注意：数字是逆序存储的，即个位在链表头部
 * 示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 解释：342 + 465 = 807
 */
class Solution {
    /**
     * 两数相加主方法
     * 
     * @param l1 第一个链表，表示第一个整数（逆序存储）
     * @param l2 第二个链表，表示第二个整数（逆序存储）
     * @return 返回一个新的链表，表示两个整数之和（逆序存储）
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建指针分别指向两个输入链表的头部
        ListNode p1 = l1;
        ListNode p2 = l2;

        // 创建结果链表的哑节点（dummy node），简化边界条件处理
        ListNode head = new ListNode();
        // 创建临时指针用于构建结果链表
        ListNode temp = head;

        // 使用双端队列存储每位的和（包含进位处理前的原始和）
        // Deque比Stack更高效，支持两端操作
        Deque<Integer> res = new ArrayDeque<>();

        // 第一阶段：同时遍历两个链表，逐位相加并存入队列
        // 处理两个链表都有剩余节点的情况
        while (p1 != null && p2 != null) {
            // 将对应位置的两个数字相加，暂时不考虑进位
            res.addLast(p1.val + p2.val);
            // 移动两个指针到下一个节点
            p1 = p1.next;
            p2 = p2.next;
        }

        // 第二阶段：处理剩余的较长链表
        // 如果第一个链表还有剩余节点，继续将其值加入队列
        while (p1 != null) {
            res.addLast(p1.val);
            p1 = p1.next;
        }

        // 如果第二个链表还有剩余节点，继续将其值加入队列
        while (p2 != null) {
            res.addLast(p2.val);
            p2 = p2.next;
        }

        // 进位标志，true表示有进位需要处理
        Boolean flag = false;

        // 第三阶段：处理队列中的和，计算进位并构建结果链表
        while (!res.isEmpty()) {
            // 取出队列头部的和
            Integer n = res.peekFirst();
            res.pollFirst();

            // 如果前一位有进位，当前位需要加1
            if (flag) {
                n = n + 1;
                flag = false; // 重置进位标志
            }

            // 创建新节点，值为当前位的结果（取模得到个位数）
            // 使用尾插法构建链表（temp始终指向链表尾部）
            ListNode p = new ListNode(n % 10, null);
            temp.next = p;
            temp = p;

            // 检查是否需要进位（和大于等于10时需要进位）
            if (n >= 10) {
                flag = true;
            }
        }

        // 第四阶段：处理最高位的进位
        // 如果遍历完所有位后仍有进位，需要在链表末尾添加一个值为1的新节点
        if (flag) {
            ListNode p = new ListNode(1, null);
            temp.next = p;
            temp = p;
        }

        // 返回结果链表（跳过哑节点）
        return head.next;
    }
}
