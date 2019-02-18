/**
 * Lab2DataStructure
 * Author -
 * Last modified - 02/17/2019
 * copyright info - n/a
 * */

public class Main {

    public static void main(String[] args) {
	// write your code here

      DynamicList myList = new DynamicList();
      DynamicList myAppendList = new DynamicList();

      myList.insertFirst(7);
      myList.insertFirst(2);
      myList.insertFirst(1);

      myAppendList.insertFirst(4);
      myAppendList.insertFirst(5);

      myList.print();
      myAppendList.print();

      System.out.println();

      myList.appendList(myAppendList);
      myList.print();

      myList.reverse();
      myList.print();

      myList.deleteMid();

      myList.print();

    }
}
