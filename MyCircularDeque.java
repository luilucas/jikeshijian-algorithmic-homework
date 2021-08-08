/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 * 641. 设计循环双端队列
 */

class MyCircularDeque {

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size + 1 > capacity) {
            return false;
        }
        if (head == null) {
            head = new ListNode(value);
            tail = head;
        } else {
            ListNode temp = new ListNode(value);
            head.pre = temp;
            temp.next = head;
            head = temp;
        }

        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size + 1 > capacity) {
            return false;
        }

        if (tail == null) {
            tail = new ListNode(value);
            head = tail;
        } else {
            ListNode temp = new ListNode(value);
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
        }

        size++;
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return true;
        }
        ListNode temp = head.next;
        head.next = null;
        temp.pre = null;
        head = temp;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        ListNode temp = tail.pre;
        tail.next = null;
        temp.next = null;
        tail = temp;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (tail == null) {
            return -1;
        }
        return tail.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size = 0;
    int capacity = 0;
    ListNode head;
    ListNode tail;
}