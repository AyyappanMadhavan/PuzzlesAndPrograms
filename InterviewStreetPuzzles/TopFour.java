package InterviewStreet;

import java.util.Scanner;

public class TopFour
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int totalnum = scan.nextInt();
        Tree tr = new Tree();
        for(int i=0;i<totalnum;i++)
        {
            tr.createNode(scan.nextInt());
        }

        tr.printTree();
    }
}

class Node
{
    int data = 0;
    Node left;
    Node right;
}
class Tree
{
    Node root = null;
    public int counter = 0;

    public void createNode(int data)
    {
        Node nd = new Node();
        nd.data = data;
        addToTree(nd);
    }

    public void addToTree(Node nd)
    {
        if(root == null)
        {
            root = nd;
            root.right = null;
            root.left = null;
        }
        else
        {
           Node curr = root;
           Node prev = root;

           while(curr!=null)
           {
              prev = curr;
              if(curr.data<nd.data)
                  curr = curr.right;
              else
                  curr = curr.left;
           }

           if(prev.data<nd.data)
                prev.right = nd;
           else
               prev.left = nd;
        }
    }

    public void printTree()
    {
        inorder(root);
    }

    public void inorder(Node r)
    {
        if (r == null) return;
        inorder(r.right);
        if(counter < 4)
            System.out.println(r.data);
        counter++;
        inorder(r.left);
    }
}
