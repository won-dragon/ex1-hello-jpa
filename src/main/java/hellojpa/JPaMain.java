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

            Member member = new Member();
            member.setId(2L);
            member.setName("JPA GO");


            System.out.println("=== BEFORE ===");
            entityManager.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember = entityManager.find(Member.class, 2L);

            System.out.println("findMember = " + findMember.getId());


            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        emf.close();
    }
}
