# Red-Black-BST
red-black tree in 80 lines

learn from Algorithms, Part I, Princeton University, Robert Sedgewick



    BST<Integer,Integer> tree = new BST<>();
    for(int i=1;i<64;i++){
        tree.add(i,i);
        tree.levelOrder();
    }
        
level 0:
[32] size->1

level 1:
[16, 48] size->2

level 2:
[8, 24, 40, 56] size->4

level 3:
[4, 12, 20, 28, 36, 44, 52, 60] size->8

level 4:
[2, 6, 10, 14, 18, 22, 26, 30, 34, 38, 42, 46, 50, 54, 58, 62] size->16

level 5:
[1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 63] size->32

Process finished with exit code 0
