import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TreeDao implements Dao{

  private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


  @Override
  public Tree getById(int index) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Tree tree =  session.get(Tree.class, index);
    session.getTransaction().commit();
    session.close();
    return tree;
  }

  //Persist adds only transient object(newly created object) to update must use saveOrUpdate
  @Override
  public void add(Tree tree) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(tree);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void update(Tree tree) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(tree);
    session.getTransaction().commit();
    session.close();
  }


  @Override
  public void shutdown() {
    sessionFactory.close();
  }
}
