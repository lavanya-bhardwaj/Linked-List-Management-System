
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList singly = new SinglyLinkedList();
        DoublyLinkedList doubly = new DoublyLinkedList();

        while (true) {
            System.out.println("\n========== LINKED LIST MANAGEMENT SYSTEM ==========");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    singlyMenu(singly);
                    break;
                case 2:
                    doublyMenu(doubly);
                    break;
                case 3:
                    compareLists();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println("Please enter a valid integer.");
            sc.next();
        }
    }

    private static void singlyMenu(SinglyLinkedList list) {
        while (true) {
            System.out.println("\n****** SINGLY LINKED LIST ******");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    list.insertAtBeginning(readInt("Enter value: "));
                    break;
                case 2:
                    list.insertAtEnd(readInt("Enter value: "));
                    break;
                case 3: {
                    int value = readInt("Enter value: ");
                    int pos = readInt("Enter position: ");
                    list.insertAtPosition(value, pos);
                    break;
                }
                case 4: {
                    int target = readInt("Insert after which value? ");
                    int value = readInt("Enter new value: ");
                    list.insertAfterNode(target, value);
                    break;
                }
                case 5: {
                    int target = readInt("Insert before which value? ");
                    int value = readInt("Enter new value: ");
                    list.insertBefore(target, value);
                    break;
                }
                case 6:
                    list.deleteFromBeginning();
                    break;
                case 7:
                    list.deleteFromEnd();
                    break;
                case 8:
                    list.deleteFromPosition(readInt("Enter position: "));
                    break;
                case 9:
                    list.deleteByValue(readInt("Enter value to delete: "));
                    break;
                case 10: {
                    int pos = list.search(readInt("Enter value to search: "));
                    System.out.println(pos == -1
                            ? "Value not found."
                            : "Value found at position " + pos);
                    break;
                }
                case 11: {
                    int oldValue = readInt("Enter value to update: ");
                    int newValue = readInt("Enter new value: ");
                    list.updateNodeValue(oldValue, newValue);
                    break;
                }
                case 12:
                    list.display();
                    break;
                case 13:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 14: {
                    Integer value = list.findMaximum();
                    System.out.println(value == null ? "List is empty." : "Maximum: " + value);
                    break;
                }
                case 15: {
                    Integer value = list.findMinimum();
                    System.out.println(value == null ? "List is empty." : "Minimum: " + value);
                    break;
                }
                case 16: {
                    Integer value = list.findMiddleElement();
                    System.out.println(value == null ? "List is empty." : "Middle element: " + value);
                    break;
                }
                case 17:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;
                case 18:
                    list.sort();
                    System.out.println("List sorted.");
                    break;
                case 19:
                    list.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;
                case 20:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void doublyMenu(DoublyLinkedList list) {
        while (true) {
            System.out.println("\n****** DOUBLY LINKED LIST ******");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    list.insertAtBeginning(readInt("Enter value: "));
                    break;
                case 2:
                    list.insertAtEnd(readInt("Enter value: "));
                    break;
                case 3: {
                    int value = readInt("Enter value: ");
                    int pos = readInt("Enter position: ");
                    list.insertAtPosition(value, pos);
                    break;
                }
                case 4: {
                    int target = readInt("Insert after which value? ");
                    int value = readInt("Enter new value: ");
                    list.insertAfterNode(target, value);
                    break;
                }
                case 5: {
                    int target = readInt("Insert before which value? ");
                    int value = readInt("Enter new value: ");
                    list.insertBefore(target, value);
                    break;
                }
                case 6:
                    list.deleteFromBeginning();
                    break;
                case 7:
                    list.deleteFromEnd();
                    break;
                case 8:
                    list.deleteFromPosition(readInt("Enter position: "));
                    break;
                case 9:
                    list.deleteByValue(readInt("Enter value to delete: "));
                    break;
                case 10: {
                    int pos = list.search(readInt("Enter value to search: "));
                    System.out.println(pos == -1
                            ? "Value not found."
                            : "Value found at position " + pos);
                    break;
                }
                case 11: {
                    int oldValue = readInt("Enter value to update: ");
                    int newValue = readInt("Enter new value: ");
                    list.update(oldValue, newValue);
                    break;
                }
                case 12:
                    list.displayForward();
                    break;
                case 13:
                    list.displayBackward();
                    break;
                case 14:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 15: {
                    Integer value = list.findMaximum();
                    System.out.println(value == null ? "List is empty." : "Maximum: " + value);
                    break;
                }
                case 16: {
                    Integer value = list.findMinimum();
                    System.out.println(value == null ? "List is empty." : "Minimum: " + value);
                    break;
                }
                case 17: {
                    Integer value = list.findMiddle();
                    System.out.println(value == null ? "List is empty." : "Middle element: " + value);
                    break;
                }
                case 18:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;
                case 19:
                    list.sort();
                    System.out.println("List sorted.");
                    break;
                case 20:
                    list.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;
                case 21:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void compareLists() {
        System.out.println("\n****** SINGLY VS DOUBLY LINKED LIST ******");
        System.out.printf("%-25s %-25s %-25s%n",
                "Feature", "Singly Linked List", "Doubly Linked List");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-25s %-25s %-25s%n",
                "Links per node", "One (next)", "Two (next and prev)");
        System.out.printf("%-25s %-25s %-25s%n",
                "Traversal", "Forward only", "Forward and backward");
        System.out.printf("%-25s %-25s %-25s%n",
                "Memory usage", "Lower", "Higher");
        System.out.printf("%-25s %-25s %-25s%n",
                "Delete known node", "Needs previous node", "Direct neighbor access");
        System.out.printf("%-25s %-25s %-25s%n",
                "Implementation", "Simpler", "More link management");
    }
}
