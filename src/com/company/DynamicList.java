package com.company;

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
      System.out.println("null");
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
  public boolean appendList(DynamicList firstList, DynamicList secondList) {

    if (!firstList.isEmpty()) {
      DynamicNode pointer = firstList.head;

      while (pointer.getNext() != null) {

        pointer = pointer.getNext();
      }
      if (!secondList.isEmpty()) {

        pointer.setNext(secondList.head);
        return true;
      } else {
        System.out.println("There is nothing in the second linked list");
        return false;
      }
    }else{

      System.out.println("There is nothing in the first linked list");
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

  public void deleteMid() {

    DynamicNode fast = head;
    DynamicNode slow = head;

    if (head == null) {

      System.out.println("error");
    } else {

      try {
        while (fast.getNext() != null) {

          fast = fast.getNext().getNext();
          slow = slow.getNext();
        }

        System.out.println(slow.getInfo());
      } catch (Exception e) {

        System.out.println("even");
      }
    }

  }
}
