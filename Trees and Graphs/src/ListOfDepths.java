import java.util.*;

public class ListOfDepths {
    static Tree root;
    static LinkedList<LinkedList<Integer>> depths = new LinkedList<>();
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        //creating tree
        root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        int h = height(root);
        //allocating memory
        for(int i=0; i<=h; i++)
            depths.add(new LinkedList<>());

        for(Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            for(int node : m.getValue())
                depths.get(m.getKey()).add(node);
        }

        //displaying at each depth
        for(int i=1; i<=h; i++) {
            System.out.println("At depth : " + i);
            for(int node : depths.get(i)) {
                    System.out.print(" "+ node);
            }
        }
    }

    private static int height(Tree root) {
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);

        if(left < right) {
            map.putIfAbsent(right+1, new ArrayList<>());
            map.get(right+1).add(root.data);
            return right + 1;
        }
        else {
            map.putIfAbsent(left+1, new ArrayList<>());
            map.get(left+1).add(root.data);
            return left + 1;
        }
    }
}
