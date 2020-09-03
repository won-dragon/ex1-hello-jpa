package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        //code
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            /* insert
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            entityManager.persist(member);
            */
            Member member = entityManager.find(Member.class, 1L);

            member.setName("TEST");

            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        emf.close();
    }
}
