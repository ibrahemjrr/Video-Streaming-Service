use Videos;
CREATE TABLE IF NOT EXISTS Videos (
                        Id int NOT NULL AUTO_INCREMENT,
                        VidName varchar(255),
                        VidDes varchar(255),
                        VidUrl varchar(255),
                        Publisher varchar(255),
                        PRIMARY KEY (Id)
);