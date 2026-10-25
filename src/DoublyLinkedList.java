public class DoublyLinkedList {

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    // 1. Inserting at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // 2. Inserting at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    // 3. Inserting at a Specific Position
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

    if (current == tail) {
        insertAtEnd(data);
        return;
    }

    Node newNode = new Node(data);

    newNode.next = current.next;
    newNode.prev = current;
    current.next.prev = newNode;
    current.next = newNode;
}
    // 4. Inserting After a Specific Node
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
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode; // Update tail if inserting at the end
        }

        current.next = newNode;
    }
    // 5. Insert Before a Node
    public void insertBefore(int target, int data) {
    Node current = head;

    while (current != null && current.data != target) {
        current = current.next;
    }

    if (current == null) {
        System.out.println("Value not found.");
        return;
    }

    if (current == head) {
        insertAtBeginning(data);
        return;
    }

    Node newNode = new Node(data);
    newNode.prev = current.prev;
    newNode.next = current;
    current.prev.next = newNode;
    current.prev = newNode;
}
// 6. Delete from Beginning
public void deleteFromBeginning() {
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }

    if (head == tail) {
        head = null;
        tail = null;
        return;
    }

    head = head.next;
    head.prev = null;
}

// 7. Delete from End
public void deleteFromEnd() {
    if (tail == null) {
        System.out.println("List is empty.");
        return;
    }

    if (head == tail) {
        head = null;
        tail = null;
        return;
    }

    tail = tail.prev;
    tail.next = null;
}
// 8. Delete from Position
public void deleteFromPosition(int position) {
    if (head == null || position < 1) {
        System.out.println("Invalid position or empty list.");
        return;
    }

    if (position == 1) {
        deleteFromBeginning();
        return;
    }

    Node current = head;

    for (int i = 1; current != null && i < position; i++) {
        current = current.next;
    }

    if (current == null) {
        System.out.println("Invalid position.");
        return;
    }

    if (current == tail) {
        deleteFromEnd();
        return;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
}

// 9. Delete by Value
public void deleteByValue(int value) {
    Node current = head;

    while (current != null && current.data != value) {
        current = current.next;
    }

    if (current == null) {
        System.out.println("Value not found.");
        return;
    }

    if (current == head) {
        deleteFromBeginning();
        return;
    }

    if (current == tail) {
        deleteFromEnd();
        return;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
}

// 10. Search
public int search(int value) {
    Node current = head;
    int position = 1;

    while (current != null) {
        if (current.data == value) {
            return position;
        }

        current = current.next;
        position++;
    }

    return -1;
}
// 11. Update 
public void update(int oldValue, int newValue) {
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

// 12. Display Forward
public void displayForward() {
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }

    Node current = head;

    while (current != null) {
        System.out.print(current.data + " <-> ");
        current = current.next;
    }

    System.out.println("null");
}
//13. Display Backward
public void displayBackward() {
    if (tail == null) {
        System.out.println("List is empty.");
        return;
    }

    Node current = tail;

    while (current != null) {
        System.out.print(current.data + " <-> ");
        current = current.prev;
    }

    System.out.println("null");
}

//14. Count Nodes
public int countNodes() {
    int count = 0;
    Node current = head;

    while (current != null) {
        count++;
        current = current.next;
    }

    return count;
}
//15. Find Maximum
public Integer findMaximum() {
    if (head == null) {
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
//16. Find Minimum
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
//17. Find Middle Element
public Integer findMiddle() {
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
//18. Reverse the Linked List
public void reverse() {
    Node current = head;

    while (current != null) {
        Node temp = current.next;
        current.next = current.prev;
        current.prev = temp;

        current = temp;
    }

    Node temp = head;
    head = tail;
    tail = temp;
}

//19. Sort in Ascending Order
public void sort() {
    for (Node i = head; i != null; i = i.next) {
        for (Node j = i.next; j != null; j = j.next) {
            if (i.data > j.data) {
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
    }
}
//20. Remove Duplicates
public void removeDuplicates() {
    java.util.HashSet<Integer> seen =
            new java.util.HashSet<>();

    Node current = head;

    while (current != null) {
        if (seen.contains(current.data)) {
            Node duplicate = current;

            current.prev.next = current.next;

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }

            current = current.next;
        } else {
            seen.add(current.data);
            current = current.next;
        }
    }
}




}
