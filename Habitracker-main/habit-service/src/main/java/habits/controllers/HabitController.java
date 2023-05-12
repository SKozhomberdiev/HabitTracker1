package habits.controllers;


import habits.entity.HabitEntity;
import habits.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trackers.service.TrackerService;
import users.entity.UserEntity;
import users.service.CustomUserService;

import java.util.List;

@RestController
@RequestMapping("/habit")
public class HabitController {
    private final HabitService habitService;
    private final TrackerService trackerService;
    private final CustomUserService customUserService;

    @Autowired
    public HabitController(HabitService habitService, CustomUserService customUserService, TrackerService trackerService) {
        this.habitService = habitService;
        this.customUserService = customUserService;
        this.trackerService = trackerService;
    }

    @GetMapping
    public List<HabitEntity> getList(@RequestHeader(name="Authorization") String authorizationHeader){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        return habitService.getList(user);
    }

    @PostMapping
    public HabitEntity create(@RequestHeader(name="Authorization") String authorizationHeader,@RequestBody HabitEntity habit){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        return habitService.create(user,habit);
    }

    @PutMapping("{id}")
    public HabitEntity update(@PathVariable("id") HabitEntity habitFromDb,
                        @RequestBody HabitEntity habit,
                        @RequestHeader(name="Authorization") String authorizationHeader){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        return habitService.update(habitFromDb,habit,user);
    }

    @PostMapping("updateCompleteReps/{id}")
    public HabitEntity completeReps(@PathVariable("id") HabitEntity habit,
                              @RequestBody Integer reps,
                              @RequestHeader(name="Authorization") String authorizationHeader){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        return trackerService.completeReps(habit,reps,user);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") HabitEntity habit,@RequestHeader(name="Authorization") String authorizationHeader){
        UserEntity user=customUserService.getFromAuthentication(authorizationHeader);
        habitService.delete(habit,user);
    }


}
