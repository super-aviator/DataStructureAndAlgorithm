package xqk.learn.datastructurealgorithm.datastructure.tree;

/**
 * BinaryTree-二叉树
 *
 * @author xiongqiankun
 * @since 2022/4/25 17:16
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
        }
    }

    public BinarySearchTree() {
    }

    public Node<E> find(E e) {
        if (root == null) {
            return null;
        }
        var p = root;
        while (p != null) {
            if (e.compareTo(p.data) < 0) {
                p = p.left;
            } else if (e.compareTo(p.data) > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(E e) {
        if (root == null) {
            root = new Node<>(e);
            size++;
            return;
        }
        var p = root;
        while (true) {
            if (e.compareTo(p.data) < 0) {
                if (p.left == null) {
                    p.left = new Node<>(e);
                    size++;
                    return;
                }
                p = p.left;
            } else if (e.compareTo(p.data) > 0) {
                if (p.right == null) {
                    p.right = new Node<>(e);
                    size++;
                    return;
                }
                p = p.right;
            } else {
                return;
            }
        }
    }

    /**
     * 1. 第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为 null。
     * 2. 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，
     * 让它指向要删除节点的子节点就可以了。
     * 3. 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
     * 然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。
     *
     * @param e e
     */
    public void delete(E e) {
        var p = root;
        Node<E> pre = null;
        while (true) {
            if (p == null) return;
            if (e.compareTo(p.data) < 0) {
                pre = p;
                p = p.left;
            } else if (e.compareTo(p.data) > 0) {
                pre = p;
                p = p.right;
            } else break;
        }

        //待删除节点有两个子节点
        if (p.left != null && p.right != null) {
            //找到并删除p的右子树中的最小节点
            var temp = p.right;
            var tempPre = p;
            while (temp.left != null) {
                tempPre = temp;
                temp = temp.left;
            }
            //填充至p的位置
            p.data = temp.data;
            //绝了：接下来相当于删除temp节点了
            p = temp;
            pre = tempPre;
        }

        //删除节点没有节点或者只有一个节点
        Node<E> child = null;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;

        //删除的是根节点
        if (pre == null) root = child;
            //删除的不是根节点
        else if (p == pre.left) pre.left = child;
        else pre.right = child;
        size--;
    }

    public int size() {
        return size;
    }

    public void printPostOrder() {
        var sb = new StringBuilder();
        sb.append("[");
        printPostOrder(root, sb);
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "]");
        } else {
            sb.append("]");
        }
        System.out.println(sb);
    }

    private void printPostOrder(Node<E> node, StringBuilder sb) {
        if (node == null) return;
        printPostOrder(node.left, sb);
        printPostOrder(node.right, sb);
        sb.append(node.data).append(",");
    }

    public void printPreOrder() {
        var sb = new StringBuilder();
        sb.append("[");
        printPreOrder(root, sb);
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "]");
        } else {
            sb.append("]");
        }
        System.out.println(sb);
    }

    private void printPreOrder(Node<E> node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.data).append(",");
        printPreOrder(node.left, sb);
        printPreOrder(node.right, sb);
    }

    public void printInOrder() {
        var sb = new StringBuilder();
        sb.append("[");
        printInOrder(root, sb);
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "]");
        } else {
            sb.append("]");
        }
        System.out.println(sb);
    }

    private void printInOrder(Node<E> node, StringBuilder sb) {
        if (node == null) return;
        printInOrder(node.left, sb);
        sb.append(node.data).append(",");
        printInOrder(node.right, sb);
    }

    public int level() {
        return level(root, 0);
    }

    public int level(Node<E> node, int level) {
        if (node == null) return level;
        return Math.max(level(node.left, level + 1), level(node.right, level + 1));
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree<Integer>();
        tree.insert(3);
        tree.insert(1);
        tree.insert(0);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        System.out.println("size:" + tree.size);
        System.out.println("find 4:" + tree.find(4));
        System.out.println("find -1:" + tree.find(-1));
        tree.printInOrder();
        tree.printPreOrder();
        tree.printPostOrder();
        System.out.println("level:" + tree.level());
        System.out.println("----");

        tree.delete(0);
        tree.delete(1);
        tree.delete(2);
        tree.delete(3);
        System.out.println("size:" + tree.size);
        System.out.println("find 6:" + tree.find(6));
        System.out.println("find -1:" + tree.find(-1));
        tree.printInOrder();
        tree.printPreOrder();
        tree.printPostOrder();
        System.out.println("level:" + tree.level());
    }
}

//      4
//  1       5
// 0  2

//        3
//    1         5
// 0     2   4      6