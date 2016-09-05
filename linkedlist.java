import java.util.Scanner;

/**
 *
 * @author Home
 */
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}
public class linkedlist {
	public static Node insert(Node head,int data){
		Node newNode=new Node(data);
		if(head==null)
			head=newNode;
		else{
			Node current=head;
			Node parent=current;
			while(current!=null){
				parent=current;
				current=current.next;
			}
			parent.next=newNode;
		}
		return head;
		
	} 
	public static void display(Node head){
		if(head==null)
			System.out.println("Linked list is empty");
		else{
			Node temp=head;
                        System.out.print(temp.data+" ");
			while(temp.next!=null){
				
				temp=temp.next;
                                System.out.print(temp.data+" ");
			}
		}
		
	}
        public static void delete(Node head,int n){
            if(head==null)
                System.out.println("Linked list is empty");
            else{
                Node temp=head;
                Node parent=temp;
                while(temp.data!=n){
                   
               parent=temp;
                    temp=temp.next;
                }
                parent.next=temp.next;
            }
            
        }
        public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Node head=null;
		System.out.println("Enter the number of elements in linked list");
		int n=sc.nextInt();
		System.out.println("Enter the elements");
		while(n!=0){
			int ele=sc.nextInt();
			head=insert(head,ele);
			n--;
		}
		display(head);
		System.out.println("Enter the element to be deleted");
                int l=sc.nextInt();
                delete(head,l);
                display(head);
		sc.close();
	}

}
