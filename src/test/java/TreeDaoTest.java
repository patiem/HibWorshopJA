import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TreeDaoTest {

  private Dao treeDao;

  @BeforeMethod
  public void setup() {
    treeDao = new TreeDao();
  }

  @Test
  public void addsAndGetsTreeWithName() {

      //given
    Tree tree = new Tree();
    tree.setSpecies("klon");

    //when
    treeDao.add(tree);
    Tree testTree = treeDao.getById(1);
      //then
    assertEquals(testTree.getSpecies(), "klon");
  }

  @Test
  public void addsAndGetsTreeWithLeafs() {
      //given
    Leaf leaf = new Leaf();
    leaf.setColor("green");
    Tree tree = new Tree();
    tree.setSpecies("klon");
    tree.addLeaf(leaf);

    //when
    treeDao.add(tree);
    Tree testTree = treeDao.getById(1);
    Leaf testLeaf = testTree.getLeafs().get(0);
      //then
    assertEquals(testTree.getSpecies(), "klon");
    assertEquals(testLeaf.getColor(), "green");
  }

  @Test
  public void updatesTreeWithLeafsWhenNewLeafsAreAdded() {
    //given
    Leaf leaf = new Leaf();
    leaf.setColor("green");

    Leaf leaf2 = new Leaf();
    leaf2.setColor("yellow");

    Tree tree = new Tree();
    tree.setSpecies("klon");

    //when
    tree.addLeaf(leaf);
    treeDao.add(tree);

    tree.addLeaf(leaf2);
    treeDao.update(tree);

    Tree testTree = treeDao.getById(1);
    Leaf testLeaf = testTree.getLeafs().get(1);
    //then
    assertEquals(testTree.getSpecies(), "klon");
    assertEquals(testLeaf.getColor(), "yellow");
  }

  @Test(description = "Returns all roots with eager fetch - work around without lazy ")
  public void addsAndGetsTreeWithRoots() {
    //given
    Root root = new Root();
    root.setSize(1.1);
    Root root2 = new Root();
    root2.setSize(1.2);
    Tree tree = new Tree();
    tree.setSpecies("klon");
    tree.addRoot(root);
    tree.addRoot(root2);

    //when
    treeDao.add(tree);
    Tree testTree = treeDao.getById(1);
    List<Root> testRoots = testTree.getRoots();
    //then
    assertEquals(testTree.getSpecies(), "klon");
    assertEquals(testRoots.size(), 2);
  }

//  @AfterMethod
//  public void close() {
//    treeDao.shutdown();
//  }


}