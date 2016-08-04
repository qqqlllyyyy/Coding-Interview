/**
 * Definition of Node:
 * class Node {
 *     public int val;
 *     public Node(int val) {
 *         this.val = val;
 *     }
 * }
 */
public class ReferenceManager {
    public Node node;

    public void copyValue(Node obj) {
        // copy value from obj to node
        if (obj == null) {
            return; 
        }
        if (node == null) {
            node = new Node(obj.val);
        }
        node.val = obj.val;
    }

    public void copyReference(Node obj) {
        // copy reference from obj to node
        node = obj;
    }
}

/*
    先看 object 是不是 null
    注意这里第19行在 node 前不要加 ‘Node’, 因为 'node' 这个 object 已经被声明过了，这里只是换一下它的 reference.
*/
