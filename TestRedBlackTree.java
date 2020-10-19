// --== CS400 File Header Information ==--
// Name: Nolan Wark
// Email: nwark@wisc.edu
// Team: AD
// Role: Test Engineer 1
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestRedBlackTree {

  /**
   * Tests The Red Black Tree for when its first red property violation is reached
   * and when the tree is full at height of 1
   */
  @Test
  void testDoubleRedInsert() {
    RedBlackTree<Integer> tester = new RedBlackTree<Integer>();
    
    Integer num1 = 1;
    Integer num2 = 2;
    Integer num3 = 3;
    
    tester.insert(num1);
    tester.insert(num2);
    tester.insert(num3);
    
    if(!tester.toString().equals("[2, 1, 3]")) {
      fail("The first occureanc of a red property violation fix did not work correctly");
    }
  }
  
  /**
   * Test to make sure that RedBlackTree catches duplicates
   */
  @Test
  void testDuplicateInsert() {
    RedBlackTree<Integer> tester = new RedBlackTree<Integer>();
    
    Integer num1 = 1;
    Integer num2 = 2;
    Integer num3 = 3;
    
    tester.insert(num1);
    tester.insert(num2);
    tester.insert(num3);
    
    try {
      tester.insert(num1);
      fail("Duplicate value was not caught and did not throw the proper exception");
    } catch (IllegalArgumentException e) {
      
    }
  }
  
  /**
   * Tests the color correctness and position of the nodes when a second violation
   * happens and when it has a red Sibling
   */
  @Test
  void testRedSibling() {
    RedBlackTree<Integer> tester = new RedBlackTree<Integer>();
    
    Integer num0 = 0;
    Integer num1 = 1;
    Integer num2 = 2;
    Integer num3 = 3;
    
    tester.insert(num1);
    tester.insert(num2);
    tester.insert(num3);
    tester.insert(num0);
    
    if(!tester.root.isBlack || !tester.root.leftChild.isBlack || 
        !tester.root.rightChild.isBlack || tester.root.leftChild.leftChild.isBlack) {
      fail("The colors are not correct on a red sibling rotation");
    }
  }
  
  /**
   * Test when there is a red property violation and the sibling is black
   */
  @Test
  void testBlackSibling() {
    RedBlackTree<Integer> tester = new RedBlackTree<Integer>();
    
    Integer num0 = 0;
    Integer num1 = 1;
    Integer num2 = 2;
    Integer num3 = 3;
    Integer num4 = 4;
    
    tester.insert(num1);
    tester.insert(num0);
    tester.insert(num2);
    tester.insert(num3);
    tester.insert(num4);
    
    if(!tester.toString().equals("[1, 0, 3, 2, 4]")) {
      System.out.println(tester);
      fail("Black Sibling rotation did not work correctly");
    }
  }
  
  /**
   * test to insert a Movie Object
   */
  @Test 
  void testInsertMovie() {
    RedBlackTree<Movie> tester = new RedBlackTree<Movie>();
    
    String[] testActors = new String[3];
    testActors[0] = "Actor one";
    testActors[1] = "Actor two";
    testActors[2] = "Actor three";
    Movie testMovie = new Movie("Title", "Director", "Genre", 120, testActors, 9999, 9.9);
    
    tester.insert(testMovie);
    
    if(tester.root == null) {
      fail("Movie object was not properly inserted");
    }
  }
  
  /**
   * test a search call for a movie that does not exist
   */
  @Test
  void testSearchForMissingMovie() {
    RedBlackTree<Movie> tester = new RedBlackTree<Movie>();
    
    String[] testActors = new String[3];
    testActors[0] = "Actor one";
    testActors[1] = "Actor two";
    testActors[2] = "Actor three";
    Movie testMovie = new Movie("Title", "Director", "Genre", 40, testActors, 9999, 9.9);
    
    tester.insert(testMovie);
    
    Movie fakeFind = new Movie("Dif Title", "Dif Director", "Dif Genre", 80, testActors, 1000, 1.0);
    
    try {
      if(FrontEnd.findMovie(fakeFind, tester) != null) {
        fail("A Movie that does not exist was found");
      }
    } catch (Exception e) {
      fail("An unknown Exception happened");
    }
  }
  
}












