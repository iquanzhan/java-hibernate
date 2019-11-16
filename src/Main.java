import com.chengxiaoxiao.bean.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

            Transaction transaction = session.beginTransaction();

            testOne2Many(session);

            transaction.commit();
        } finally {
            session.close();
        }
    }

    private static void testOne2Many(Session session) {
// 1.创建一个客户
        Customer c = new Customer();
        c.setName("叶子");

        // 2.创建两个订单
        Order o1 = new Order();
        o1.setMoney(1000d);
        o1.setReceiverInfo("武汉");
        Order o2 = new Order();
        o2.setMoney(2000d);
        o2.setReceiverInfo("天门");

        // 3.建立关系
        c.getOrders().add(o1);
        c.getOrders().add(o2);

        // 4.保存客户，并级联保存订单
        session.save(c);
    }

    private static void testOne2One2(Session session) {
        Phone phone = new Phone("13588578867","iphone",888.36) ;
        Student stus = new Student(201402,"李四",10) ;
        stus.setPhone(phone);
        phone.setStudents(stus);
        session.save(phone) ;
        session.save(stus) ;
    }

    private static void testOne2One(Session session) {
        Student stus = new Student(201401, "张三", 10);
        Phone phone = new Phone("13588578866", "iphone", 888.36, stus);
        session.save(stus);
        session.save(phone);
    }


    /**
     * 测试默认的注解
     *
     * @param session
     */
    private static void test2(Session session) {
        Book b = new Book();
        b.setName("情书");
        b.setPrice(56.78);
        b.setPublishDate(new Date());

        session.save(b);
    }
}