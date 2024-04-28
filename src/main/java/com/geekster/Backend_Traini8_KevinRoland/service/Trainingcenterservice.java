package com.geekster.Backend_Traini8_KevinRoland.service;

import com.geekster.Backend_Traini8_KevinRoland.model.TrainingCenter;
import com.geekster.Backend_Traini8_KevinRoland.repository.ITrainingCenterrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Trainingcenterservice {
    @Autowired
    ITrainingCenterrepo trainingCenterrepo;

    public String addTrainingCenter(List<TrainingCenter> newtrainingcenter) {

        trainingCenterrepo.saveAll(newtrainingcenter);
        return "added";
    }

    public List<TrainingCenter> getAllTrainingCenter() {
        return trainingCenterrepo.findAll();

    }


    public String addSingleTrainingCenter(TrainingCenter newtrainingcenter) {
        trainingCenterrepo.save(newtrainingcenter);
        return "added single trainingcenter";
    }

}
