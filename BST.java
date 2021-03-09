import java.util.*;
//https://www.coursera.org/lecture/algorithms-part1/red-black-bsts-GZe13
//from Robert Sedgewick
//the code is so exquisite

public class BST<K,V>{
    static final boolean RED = true;
    static final boolean BLACK = false;
    Node root;
    class Node{
        K key;
        V val;
        Node left,right;
        boolean color;// color of parent link!
        Node(K key, V val, boolean color){
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }
    boolean isRed(Node x){
        if(x == null) return BLACK;
        return x.color==RED;
    }
    public V get(K key){
        Node x = root;
        while(x != null){
            int cmp = ((Comparable)key).compareTo(x.key);
            if(cmp<0) x = x.left;
            else if (cmp>0) x = x.right;
            else if(cmp==0) return x.val;
        }
        return null;
    }
    Node rotateLeft(Node h){
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;    //child = fa.right
        x.left = h;          //child.left, fa.right = fa, child.left 
        x.color = h.color;   //child.color, fa.color = fa.color RED
        h.color = RED;
        return x;
    }
    Node rotateRight(Node h){//the same as rl
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;    //child = fa.left
        x.right = h;         //child.right, fa.left = fa, child.right
        x.color = h.color;   //child.color, fa.color = fa.color RED
        h.color = RED;
        return x;
    }
    void flipColors(Node h){//child both RED
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;        //fa.color = RED
        h.left.color = BLACK; //l_child, r_child = BLACK
        h.right.color = BLACK;
    }
    Node put(Node h, K key, V val){
        if(h==null) return new Node(key,val,RED);
        int cmp = ((Comparable)key).compareTo(h.key);
        if(cmp<0) h.left = put(h.left, key, val);
        else if(cmp>0) h.right = put(h.right, key, val);
        else if(cmp==0) h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }
    public void add(K key, V val){
        root = put(root, key, val);
    }
    BST(){}
    public void levelOrder(){//show all  key
        ArrayList<ArrayList<K>> li = new ArrayList<>();
        dfs(root,0,li);
        int lev = 0;
        for(ArrayList<K> l:li){
            System.out.println("level "+lev+" :");
            System.out.println(l.toString()+" size->"+l.size());
            lev++;
        }
    }
    void dfs(Node p,int level,ArrayList<ArrayList<K>> li){
        if(p==null)return;
        if(level==li.size())li.add(new ArrayList<K>());
        li.get(level).add(p.key);
        dfs(p.left,level+1,li);
        dfs(p.right,level+1,li);
    }
}
