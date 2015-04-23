
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ken
 */
public class TwoThreeTree
{

    private Node root;

    /**
     * TwoThreeTree constructor which takes no parameters
     *
     */
    public TwoThreeTree()
    {
        root = new Node();
    }

    public String search(int x)
    {
        Node current = root.searchkeys(x,false);

        String result = "";
        for (int i = 0; i < current.key.size(); i++)
        {
            result += current.key.get(i) + " ";
        }
        return result.trim();
    }

    /**
     * Insert value x into the the tree
     *
     * @param x value to be inserted
     * @return true if added, false if not because of duplicate value
     */
    public boolean insert(int x)
    {
        Node current = root.searchkeys(x,true);
        if (current == null)
        {
            return false;
        }
        current.key.add(x);
        Collections.sort(current.key);
        if (current.key.size() > 2)
        {
            root.split(current, this.root);

        }
        return true;

    }

    class Node
    {

        private ArrayList<Node> child;
        private ArrayList<Integer> key;
        private Node parent;

        public Node()
        {
            child = new ArrayList<>();  // left,middle, right,temp
            key = new ArrayList<>();
            parent = null;
        }

        public boolean isLeaf()
        {
            return child.isEmpty();
        }

        /**
         * search for value x, return all values in the same node
         *
         * @param current current node
         * @param x value to be searched
         * @return all values in the node which has x in it
         */
        public Node searchKeysNoDuplicate(Node current, int x, boolean nonduplicate)
        {
            if (nonduplicate)
            {
                if (current.key.contains(x))
                {
                    return null;
                }

            } else
            {
                if (current.key.contains(x))
                {
                    return current;
                }
            }

            if (current.isLeaf())
            {
                return current;
            }

            if (x < current.key.get(0))  // x< all elements
            {
                current = searchKeysNoDuplicate(current.child.get(0), x,nonduplicate);

            }  else if (x > current.key.get(current.key.size() - 1)) //x>=all elementz in 2keys item
            {
                current = searchKeysNoDuplicate(current.child.get(current.key.size()), x,nonduplicate);
            } else
            { //  smaller<= x < bigger
                current = searchKeysNoDuplicate(current.child.get(1), x,nonduplicate);
            }

            return current;
        }

        public Node searchkeys(int x,boolean nonduplicate)
        {
            return searchKeysNoDuplicate(root, x,nonduplicate);
        }

        public void split(Node center, Node Root)

        {
            Node Parent = center.parent;
            int middle = center.key.get(1);
            Node n2 = new Node();
            if (center.isLeaf())
            {
                n2.key.add(center.key.get(2));
                center.key.remove(2);
                center.key.remove(1);

            } else
            {

                n2.child.add(center.child.get(2));
                n2.child.add(center.child.get(3));
                center.child.remove(3);
                center.child.remove(2);

                n2.key.add(center.key.get(2));
                n2.child.get(0).parent = n2;
                n2.child.get(1).parent = n2;
                center.key.remove(2);
                center.key.remove(1); // center(n1) has 1 key 2 children, n2 1key 2 children

            }
            if (Parent == null)
            {
                // if no parent , create new node
                root = new Node();
                root.parent = null;
                root.child.add(center);
                root.child.add(n2);

                root.key.add(middle);
                center.parent = root;
                n2.parent = root;
            } else
            {
               

                    center.parent.child.add(center.parent.child.indexOf(center) + 1, n2);

                    center.parent.key.add(middle);
                    Collections.sort(center.parent.key);
                    n2.parent = Parent;
                
                if (center.parent.key.size() > 2)
                {
                    split(center.parent, Root);
                }

            }

        }

    }

}
