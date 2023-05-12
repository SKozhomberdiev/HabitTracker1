package trackers.service;

import habits.entity.HabitEntity;
import habits.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.entity.UserEntity;

import java.time.LocalDate;
import java.util.Map;

@Service
public class TrackerService {

    private final HabitRepository habitRepository;


    @Autowired
    public TrackerService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }


    public HabitEntity completeReps(HabitEntity habit, Integer reps, UserEntity user) {
        if(habit.getProfile().equals(user)){
            LocalDate localDate=LocalDate.now();
            if(habit.getHabitData().get(localDate)!=null){
                reps+=habit.getHabitData().get(localDate);
            }
            habit.getHabitData().put(localDate,reps);
            habit.setRepetitionRate(repsRate(habit));
            return habitRepository.save(habit);
        }
        return habit;
    }

    public int repsRate(HabitEntity habit){
        int size=habit.getHabitData().size();
        int total=totalReps(habit);
        return total/size;
    }

    public int totalReps(HabitEntity habit){
        int total=0;
        for(Map.Entry<LocalDate,Integer> entry:habit.getHabitData().entrySet()){
            total+= entry.getValue();
        }
        return total;
    }
}
