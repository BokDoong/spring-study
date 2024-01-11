package umc.study.user.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.user.domain.User;
import umc.study.user.domain.UserRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserJpaRepository implements UserRepository {

    private final EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }
}
