package xqk.learn.datastructurealgorithm.datastructure.trie;

/**
 * TrieTree-Trie树，适用于前缀搜索
 * 对于长度为k的字符串，查找的时间复杂度为O(K)
 *
 * @author xiongqiankun
 * @since 2022/5/13 18:06
 */
public class TrieTree {
    /** 根节点 */
    private final TrieNode root = new TrieNode('/');

    private static class TrieNode {
        private final char data;
        private boolean isEndingChar = false;
        private final TrieNode[] children = new TrieNode[26];

        private TrieNode(char data) {
            this.data = data;
        }

        public char getData() {
            return data;
        }
    }

    public void insert(String data) {
        insert(data.toCharArray());
    }

    public void insert(char[] data) {
        if (data.length == 0) return;
        TrieNode curr = root;
        for (char ch : data) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode(ch);

            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEndingChar = true;
    }

    public boolean find(String data) {
        return find(data.toCharArray());
    }

    public boolean find(char[] data) {
        if (data.length == 0) return false;
        TrieNode curr = root;
        for (char ch : data) {
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEndingChar;
    }

    public static void main(String[] args) {
        var trieTree = new TrieTree();
        trieTree.insert("how");
        trieTree.insert("hi");
        trieTree.insert("her");
        trieTree.insert("hello");
        trieTree.insert("so");
        trieTree.insert("see");
        trieTree.insert("");
        System.out.println(trieTree.find("hi"));
        System.out.println(trieTree.find("he"));
        System.out.println(trieTree.find("her"));
        System.out.println(trieTree.find("so"));
        System.out.println(trieTree.find(""));
    }
}
