package com.example.database.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VidDao implements IVidDao {

    private final JdbcTemplate jdbcTemplate;

    public VidDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<VidMetaData> getVideosMetaData() {
        return jdbcTemplate.query("select * from Videos", new RowMapper<VidMetaData>() {
            @Override
            public VidMetaData mapRow(ResultSet rs, int rowNum) throws SQLException {
                VidMetaData vidMetaData = new VidMetaData();
                vidMetaData.setId(rs.getInt("Id"));
                vidMetaData.setVidName(rs.getString("VidName"));
                vidMetaData.setVidDescription(rs.getString("VidDes"));
                vidMetaData.setUrl(rs.getString("VidUrl"));
                vidMetaData.setPublisher(rs.getString("Publisher"));

                return vidMetaData;
            }
        });

    }

    @Override
    public int addVideo(VidMetaData vidMetaData) {
        return jdbcTemplate.update("INSERT INTO Videos(VidName,VidDes,VidUrl,Publisher) VALUES(?,?,?,?)",
                vidMetaData.getVidName(),
                vidMetaData.getVidDescription(),
                vidMetaData.getUrl(),
                vidMetaData.getPublisher()
        );
    }
}
