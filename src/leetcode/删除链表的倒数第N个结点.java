package leetcode;

/**
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-30 10:37
 **/
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
    }
}
class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }


 }
class Solution11 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //让结点的数从第一个开始计数
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;//同时指向0
        ListNode second = dummy;//同时指向0
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}