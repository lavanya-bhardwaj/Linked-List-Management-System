public class SinglyLinkedList{
    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    private Node head;
//1. Inserting at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

//2. Inserting at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
//3. Inserting at a Specific Position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        Node current = head;

        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }
//4. Inserting After a Specific Node
    public void insertAfterNode(int data, int targetData) {
        Node current = head;
        while (current != null && current.data != targetData) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Target node not found.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }
//5. Inserting Before a Specific Node
    
    public void insertBefore(int target, int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;

        }
//6. Delete From Beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

//7. Delete From End
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;

    }
//8. Delete from Position
    public void deleteFromPosition(int position){
        if(head == null || position < 1){
            System.out.println("Invalid position or list is empty.");
            return;
        }
        if(position == 1){
            deleteFromBeginning();
            return;
        }
        Node current = head;
        for(int i = 1; current != null && i < position - 1; i++){
            current = current.next;
        }
        if(current.next == null){
            System.out.println("Invalid position.");
            return;
        }
        current.next = current.next.next;

    }
//9. Delete by Value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }
        current.next = current.next.next;
    }
//10. Search
    public int search(int value){
        Node current = head;
        int position = 1;
        while(current != null){
            if(current.data == value){
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Value not found
    }
//11. Update a Node's Value
    public void updateNodeValue(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                return;
            }
            current = current.next;
        }
        System.out.println("Value not found.");
    }
//12. Display the Linked List
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
//13. Count Nodes
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
//14. Find Maximum
    public Integer findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }
//15. Find Minimum
    public Integer findMinimum() {
        if (head == null) {
            return null;
        }

        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }
//16. Find Middle Element
    public Integer findMiddleElement() {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
//17. Reverse the Linked List
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


}