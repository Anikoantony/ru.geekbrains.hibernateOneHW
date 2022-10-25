package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class NewUserDaoImplement implements NewUserDao{
    public NewUserDaoImplement(SessionFactoryUtils sessionFactorys) {
        this.sessionFactorys = sessionFactorys;
    }

    private SessionFactoryUtils sessionFactorys;

    @Override
    public User findeById(Long id) {
        Session session=sessionFactorys.getSession();
        session.beginTransaction();
        // получить по ид
        User user=session.get(User.class,id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        try {
            Session session=sessionFactorys.getSession();
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            session.getTransaction().commit();
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByName(String name) {
        Session session=sessionFactorys.getSession();
        session.beginTransaction();
        User user = session.createQuery("select u from User u where u.name =:name", User.class)
                .setParameter("name", name)
                .getSingleResult();

        session.getTransaction().commit();
        return user;
    }

    @Override
    public void save(User user) {
        try (Session session=sessionFactorys.getSession())
        {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String name) {
        try (Session session=sessionFactorys.getSession())
        {
            session.beginTransaction();
            /*session.createQuery("update User u set u.name =:name where u.id = :id")
                            .setParameter("name",name)
                            .setParameter("id",id)
                    .executeUpdate();*/
            User user=session.get(User.class,id);
            user.setName(name);


            session.getTransaction().commit();
        }
    }

    @Override
    public void testCash() {
        try (Session session=sessionFactorys.getSession())
        {
            session.beginTransaction();
            session.get(User.class,1L);
            session.get(User.class,1L);
            session.get(User.class,1L);
            session.getTransaction().commit();
        }

        try (Session session=sessionFactorys.getSession())
        {
            session.beginTransaction();
            session.get(User.class,1L);
            session.get(User.class,1L);
            session.get(User.class,1L);
            session.getTransaction().commit();
        }
    }
}
