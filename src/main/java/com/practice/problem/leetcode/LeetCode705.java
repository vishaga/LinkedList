package com.practice.problem.leetcode;

/**
 * 705. Design HashSet
 * <p>
 * Question Link: https://leetcode.com/problems/design-hashset/description/
 *
 * <p>
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * Implement MyHashSet class:
 * <p>
 * void add(key) Inserts the value key into the HashSet. bool contains(key) Returns whether the
 * value key exists in the HashSet or not. void remove(key) Removes the value key in the HashSet. If
 * key does not exist in the HashSet, do nothing.
 * <p/>
 *
 * <ul>
 * Example 1
 *  Input
 *    ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 *    [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 *  Output: [null, null, null, true, false, null, true, null, false]
 *  Explanation:
 *    MyHashSet myHashSet = new MyHashSet();
 *    myHashSet.add(1);      // set = [1]
 *    myHashSet.add(2);      // set = [1, 2]
 *    myHashSet.contains(1); // return True
 *    myHashSet.contains(3); // return False, (not found)
 *    myHashSet.add(2);      // set = [1, 2]
 *    myHashSet.contains(2); // return True
 *    myHashSet.remove(2);   // set = [1]
 *    myHashSet.contains(2); // return False, (already removed)
 * <p>
 * <p>
 * Constraints: 0 <= key <= 106
 * At most 104 calls will be made to add, remove, and contains.
 * <ul/>
 */
public class LeetCode705 {

  public static void main(String[] args) {
    approach1();
  }

  private static void approach1() {
    MyHashSet1 set = new MyHashSet1();
    NodeInput input = getInput();
    while (input != null) {
      if (input.action.equals("add")) {
        set.add(input.value);
      } else if (input.action.equals("contains")) {
        set.contains(input.value);
      } else if (input.action.equals("remove")) {
        set.remove(input.value);
      }
      input = input.next;
    }
  }

  private static NodeInput getInput() {
    NodeInput input = new NodeInput("add", 1);
    NodeInput head = input;
    input.next = new NodeInput("add", 2);
    input = input.next;
    input.next = new NodeInput("contains", 1);
    input = input.next;
    input.next = new NodeInput("contains", 3);
    input = input.next;
    input.next = new NodeInput("add", 2);
    input = input.next;
    input.next = new NodeInput("remove", 2);
    input = input.next;
    input.next = new NodeInput("contains", 2);
    return head;
  }
}

/**
 * Since constraint is 10^6 max, so can create array of that size.
 */
class MyHashSet1 {

  boolean set[];

  public MyHashSet1() {
    set = new boolean[1000001];
  }

  public void add(int key) {
    set[key] = true;
    System.out.println(key + " added");
  }

  public void remove(int key) {
    set[key] = false;
    System.out.println(key + " removed");
  }

  public boolean contains(int key) {
    System.out.println(key + " exists: " + set[key]);
    return set[key];
  }
}

class NodeInput {

  public String action;
  public int value;
  public NodeInput next;

  NodeInput(String action, int value) {
    this.action = action;
    this.value = value;
  }


}