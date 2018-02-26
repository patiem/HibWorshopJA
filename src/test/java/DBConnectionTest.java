import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class DBConnectionTest {

  @Test
  public void connectWithH2DB() {

      //given
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
      //when
      //then
    assertNotNull(sessionFactory);
    assertNotNull(session);
  }



}
