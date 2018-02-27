
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trees")
public class Tree {

  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private int id;

  @Column(name = "species", nullable = false)
  private String species;

  @Column(name = "leafs")
  @OneToMany(mappedBy = "tree", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Leaf> leafs = new ArrayList<>();

  @Column(name = "roots")
  @OneToMany(cascade = CascadeType.ALL)
  private List<Root> roots =  new ArrayList<>();

  public Tree() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public List<Leaf> getLeafs() {
    return leafs;
  }

  public void setLeafs(List<Leaf> leafs) {
    this.leafs = leafs;
  }

  public List<Root> getRoots() {
    return roots;
  }

  public void setRoots(List<Root> roots) {
    this.roots = roots;
  }

  public void addLeaf(Leaf leaf) {
    leafs.add(leaf);
    leaf.setTree(this);
  }

  public void addRoot(Root root) {
    roots.add(root);
  }
}
