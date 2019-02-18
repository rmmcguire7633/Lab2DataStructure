/**
 * Lab2DataStructure
 * Author -
 * Last modified - 02/17/2019
 * copyright info - n/a
 * */

public class DynamicList {

  private DynamicNode head;

  public DynamicList(){
    head=null;
  }

  public DynamicList(DynamicNode head) {
    this.head = head;
  }

  public boolean isEmpty(){
    return head==null;
  }

  public void insertFirst(Object x){
    DynamicNode q=new DynamicNode(x,null);
    if(!isEmpty())
      q.setNext(head);
    head=q;
  }

  public DynamicNode getList(){
    return head;
  }


  public void print(){
    if(head==null){
      System.out.println("Empty List:");
    } else {

      System.out.print("List: ");
    }
    DynamicNode p=head;

    while(p!=null){
      System.out.print(p.getInfo()+((p.getNext()!=null)?" ":""));
      p=p.getNext();
    }
    System.out.println();
  }

  /**
   * Appends all elements in the parameter list firstList
   * to the end of this list.
   * Returns true if the list was changed, false otherwise.
   * Please note that NO new list is created.
   * Also, it is wrong to (repeatedly) insert new nodes to the list.
   * @param secondList The list to be appended to the first list.
   * @return true if both list are appended.
   */
  public boolean appendList(DynamicList secondList) {

    DynamicNode pointer = head;

    // Checks to see if there are no empty list.
    if (pointer != null ) {

      System.out.println("  Append...");

      // Sets the pointer to the end of the first list.
      while (pointer.getNext() != null) {

        pointer = pointer.getNext();
      }

      // Checks to see if the list to be added is empty.
      if (!secondList.isEmpty()) {

        // adds the list to the end of the first list.
        pointer.setNext(secondList.head);
        return true;
      } else {

        return false;
      }
    }else{

      return false;
    }
  }

  /**
   * Reverses the order of the DynamicList.
   * */
  public void reverse(){

    // Used to point to the current node.
    DynamicNode current = head;

    // Used to point at the node previous to the current node.
    DynamicNode before = null;

    if (head == null) {

      System.out.println("Reverse Empty list...");
      System.out.println("Error: List is empty.");
    } else {

      System.out.println("  Reverse list...");
    }

    // Transverse the list and reverse the order.
    while (current != null) {

      DynamicNode next = current.getNext();
      current.setNext(before);
      before = current;
      current = next;
    }
    head = before;
  }

  /**
   * Deletes the middle node in the list IF it exists.
   * If the list has an EVEN number of nodes, there is NO middle node.
   * Constraint: you cannot use a counter or a boolean.
   * Given a list abcde, c is deleted
   * Given a list abcd, nothing is deleted.
   * @Returns - info in the middle node if it exists; null otherwise
   */
  public Object deleteMid() {

    // Used to to reach the end of the list.
    DynamicNode fast = head;

    // Used to read the middle of the list.
    DynamicNode slow = head;

    // Used to read the previous node from the slow node.
    DynamicNode previous = null;

    // Checks to see if the list empty.
    if (head == null) {

      System.out.println("Delete mid in Empty List...");
      System.out.println("Error: The list is empty");
      return null;
    } else {

      System.out.println("  Delete mid...");
      while (fast.getNext() != null) {

        previous = slow;
        slow = slow.getNext();
        fast = fast.getNext();

        // Checks to see if the next node is not null.
        // If it is then the dynamic list is an even number.
        // Example fast starts at index 1 ideally we add two getnext methods to it so it would become index 3.
        // At first we get the next node in the list once so we can check if it is at the end of the linked list.
        // If the current node does not have a pointer we are at the end of the list and there fore can not get the
        // next node because there is no node.
        // So fast is traversing through the list 2 times faster than slow, ie when fast is 3 slow is 2 and when fast is
        // 5 slow is 3. You can notice if we do just one getnext method it will turn fast into an even number of indexes.
        if (fast.getNext() != null) {
          fast = fast.getNext();
        }else {

          System.out.println("Error: The list is even, no middle node to remove.");
          return null;
        }

      }

      // deletes the middle row
      previous.setNext(slow.getNext());
      return slow.getInfo();
    }
  }
}
