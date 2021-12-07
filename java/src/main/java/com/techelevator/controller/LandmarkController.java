package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/landmarks")
public class LandmarkController {

    private LandmarkDao landmarkDao;


    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Landmark> getAll() {
       return landmarkDao.getAll();
    }

    @RequestMapping(path= "/filter", method = RequestMethod.GET)
    List<Landmark> filter(@RequestParam String name, @RequestParam String category) {
        if (name.equals("") && category.equals("")) {
            return landmarkDao.getAll();
        } else {
            return landmarkDao.filter(name, category);
        }
    }


}
