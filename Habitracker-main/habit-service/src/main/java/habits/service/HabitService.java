package habits.service;


import habits.entity.HabitEntity;
import habits.repository.HabitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class HabitService {
    private final HabitRepository habitRepository;


    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public HabitEntity create(UserEntity user, HabitEntity habit) {
        habit.setRepetitionRate(0);
        habit.setProfile(user);
        return habitRepository.save(habit);
    }

    public List<HabitEntity> getList(UserEntity user) {
        return habitRepository.findByProfile(user);
    }

    public HabitEntity update(HabitEntity habitFromDb, HabitEntity habit,UserEntity user) {
        if(user.equals(habit.getProfile())){
            habit.setProfile(user);
            BeanUtils.copyProperties(habit,habitFromDb,"id");
            return habitRepository.save(habitFromDb);
        }
        return habitFromDb;
    }

    public void delete(HabitEntity habit,UserEntity user) {
        if(user.equals(habit.getProfile())){
            habitRepository.delete(habit);
        }
    }


}
