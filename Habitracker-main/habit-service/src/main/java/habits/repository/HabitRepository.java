package habits.repository;


import habits.entity.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.entity.UserEntity;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<HabitEntity,Long> {
    List<HabitEntity> findByProfile(UserEntity profile);
}
