package com.example.database.dao;

import java.util.List;

public interface IVidDao {
    public List<VidMetaData> getVideosMetaData();
    public int addVideo(VidMetaData vidMetaData);
}
