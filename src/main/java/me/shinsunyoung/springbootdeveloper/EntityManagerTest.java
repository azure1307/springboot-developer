package me.shinsunyoung.springbootdeveloper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityManagerTest {

    @PersistenceContext
    EntityManager em;

    public void join() {
        //기존에 엔티티 상태를 바꾸는 방법(메서드를 호출해서 상태 변경)
        Member member = new Member(1L, "홍길동");
        em.persist(member);
    }

    public void example() {
        //엔티티 매니저가 엔티티를 관리하지 않는 상태(비영속 상태)
        Member member = new Member(1L, "홍길동");

        //엔티티가 관리되는 상태
        em.persist(member);

        //엔티티 객체가 분리된 상태
        em.detach(member);

        //엔티티 객체가 삭제된 상태
        em.remove(member);
    }
}
