
public class LowestCommonAncestor {
	Node root;

    public LowestCommonAncestor(Node root) {
        this.root = root;
    }
    
	static class Node{
	    int data;
	    Node left;
	    Node right;

	    public Node(int data) {
	        this.data = data;
	    }
	}
	
	public static Node lca(Node root, int n1, int n2){
        if (root == null){
            return null;
        }
        if (root.data == n1 || root.data == n2){
        	//if we have 4th case in word file where we pass 20,40
            return root;
        }
        Node left = lca(root.left, n1 ,n2);
        Node right = lca(root.right, n1 ,n2);

        if (left!= null && right!=null){
        	//if one value found on left and other on right
            return root;
        }
        return (left!=null)? left:right; // if both value found on left or both found on right
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestor binaryTree = new LowestCommonAncestor(new Node(10));
        Node left = new Node(20);
        Node right = new Node(30);
        binaryTree.root.left = left;
        binaryTree.root.right = right;
        left.left = new Node(40);
        left.right = new Node(50);
        right.left = new Node(60);
        right.right = new Node(70);

        System.out.println(lca(binaryTree.root, 20 , 40).data);
	}

}
