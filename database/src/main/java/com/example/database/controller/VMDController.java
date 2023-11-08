package com.example.database.controller;

import com.example.database.dao.IVidDao;
import com.example.database.dao.VidMetaData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VMDController {

    private final IVidDao vidDao;

    public VMDController(IVidDao vidDao) {
        this.vidDao = vidDao;
    }

    @GetMapping("/")
    public List<VidMetaData> getVideos() {
        return vidDao.getVideosMetaData();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean addVid(@RequestBody VidMetaData vidMetaData) {
        return vidDao.addVideo(vidMetaData) == 1;
    }
}
