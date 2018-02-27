
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trees")
public class Tree {

  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private int id;

  @Column(name = "species")
  private String species;

  @Column(name = "leafs")
  @OneToMany(fetch = FetchType.EAGER)
  private List<Leaf> leafs;

  @Column(name = "roots")
  @OneToMany(fetch = FetchType.EAGER)
  private List<Root> roots;

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
}
