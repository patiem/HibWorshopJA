public interface Dao {

  Tree getById(int index);
  void add(Tree tree);
  void update(Tree tree);
  void shutdown();
}
