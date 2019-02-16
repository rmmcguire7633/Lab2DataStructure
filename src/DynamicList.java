
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
    }
    DynamicNode p=head;
    while(p!=null){
      System.out.print(p.getInfo()+((p.getNext()!=null)?"->":""));
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
   *
   */
  public boolean appendList( DynamicList secondList) {

    DynamicNode pointer = head;

    if (pointer != null ) {

      System.out.println("  Append...");
      while (pointer.getNext() != null) {

        pointer = pointer.getNext();
      }
      if (!secondList.isEmpty()) {

        pointer.setNext(secondList.head);
        secondList.print();
        return true;
      } else {

        return false;
      }
    }else{

      System.out.println("Reverse Empty list...");
      System.out.println("Error: List is empty.");
      return false;
    }
  }

  public void reverse(){

    DynamicNode current = head;
    DynamicNode before = null;

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
   *
   * Returns: info in the middle node if it exists; null otherwise
   *
   */
  public Object deleteMid() {

    DynamicNode fast = head;
    DynamicNode slow = head;
    DynamicNode previous = null;

    if (head == null) {

      System.out.println("Error: The list is empty");
      return null;
    } else {

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
      previous.setNext(slow.getNext());
      return slow.getInfo();
    }
  }
}
