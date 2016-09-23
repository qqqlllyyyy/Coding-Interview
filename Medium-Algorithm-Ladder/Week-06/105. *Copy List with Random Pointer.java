/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;
        while (head != null) {

            // 先复制出新的 newNode
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }

            // 再构建新的链表, 这一步放在第 40 行也没问题
            pre.next = newNode;

            // 最后放置这个 newNode 的 random 指针
            if (head.random != null) { // 千万别忘了这一步
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = newNode;
            head = head.next;
        }

        return dummy.next;
    }
}

/*  20160913
    以上的方法需要一个额外的hashmap，比较直观的把原始点和新的对应点存在一个hashmap中。

    几点要注意的：
    1. 第22行不能直接 newNode = head. 需要一个新的object。
    2. 第19行对于每一个循环的head，都要检查是否head已经在 HashMap 中了，是因为后面(第31-32行)在找newNode.random的时候，
       如果不存在新的random的复制点，就新建一个放入 HashMap 中。所以可能对于某个head来说，它已经被存储过了(是之前某个点的 ‘.random’)
    3. 新建 dummy 之后不急着让 dummy.next = pre 是因为 pre 从 dummy 开始，第29行的时候会把next指针接到第一个新的复制节点上。
*/

/*  20160914
    再次做，忘记了第32行的条件，注意！
*/




