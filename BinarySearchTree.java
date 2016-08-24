 class BinarySearchTree{
 public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
		tree.addNode(15);
		tree.addNode(18);
		tree.addNode(51);
		tree.addNode(23);
		tree.addNode(30);
		tree.addNode(27);
		tree.remove(30);
		tree.InOrder(tree.root);
		System.out.println(tree.find(23));
    }
}

class BinaryTree{
    Node root;
    public void addNode(int key){
        Node newNode=new Node(key);
        if(root==null)
            root=newNode;
        else{
            Node currentNode=root;
			Node parent;
			while(true){
				parent=currentNode;
            if(key<currentNode.key){
				currentNode=currentNode.leftc;
				if(currentNode==null){
					parent.leftc=newNode;
				    return;
			}}
			else{
				currentNode=currentNode.rightc;
				if(currentNode==null){
					parent.rightc=newNode;
					return;
				}
			}
        }
    }
    
}

public void InOrder(Node currentNode){
	if(currentNode!=null){
	InOrder(currentNode.leftc);
	System.out.println(currentNode);
	InOrder(currentNode.rightc);
	}
}
public Node find(int k){
	Node currentNode=root;
	if(currentNode==null)
		return null;

		
		while(currentNode.key!=k){
		if(k<currentNode.key)
		currentNode=currentNode.leftc;
		else
			currentNode=currentNode.rightc;
		}
		
		return currentNode;
	}
	public boolean remove(int key){
		Node currentNode=root;
		Node parent=root;
		boolean isleftc=true;
		while(currentNode.key!=key){
			parent=currentNode;
			if(key<currentNode.key){
				isleftc=true;
				currentNode=currentNode.leftc;
			}else{
				isleftc=false;
				currentNode=currentNode.rightc;
				
			}
			if(currentNode==null)
				return false;
			
		}
		if(currentNode.leftc==null && currentNode.rightc==null){
			if(currentNode==root){
			root=null;}
			else if(isleftc)
				parent.leftc=null;
			else 
				parent.rightc=null;
		}
		else if(currentNode.rightc==null){
			if(currentNode==root)
				root=currentNode.leftc;
			else if(isleftc)
				parent.leftc=currentNode.leftc;
			else
				parent.rightc=currentNode.leftc;
			
		}
		else if(currentNode.leftc==null){
			if(currentNode==root)
				root=currentNode.rightc;
			else if(isleftc)
				parent.leftc=currentNode.rightc;
			else
				parent.rightc=currentNode.leftc;
			
		}
		else{
			Node replacement=getReplacementNode(currentNode);
			if(currentNode==root)
				root=replacement;
			else if(isleftc)
				parent.leftc=replacement;
			else
				parent.rightc=replacement;
		}
		return true;
		

			}
			public Node getReplacementNode(Node replacenode){
				Node replacementParent=replacenode;
				Node replacement=replacenode;
				Node currentNode=replacenode.rightc;
				while(currentNode!=null){
					replacementParent=replacement;
					replacement=currentNode;
					currentNode=currentNode.leftc;
				}
				if(replacement!=replacenode.rightc){
					replacementParent.leftc=replacement.rightc;
					replacement.rightc=replacenode.rightc;
				}
				return replacement;
			}
	
}



    
    class Node{
        int key;
         Node leftc;
         Node rightc;
         Node(int key){
             this.key=key;
         }
		 public String toString(){
			 return ""+key;
		 }
	}
    