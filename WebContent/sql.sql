-- ------------------------------------------------------------------------------
-- - DROP TABLE IF EXISTS ALL TABLE
-- ------------------------------------------------------------------------------

DROP TABLE IF EXISTS T_Users        CASCADE;
DROP TABLE IF EXISTS T_Adminss        CASCADE;

-- -----------------------------------------------------------------------------
-- - T_Users creation
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
    IdUser              SERIAL              PRIMARY KEY,
    LoginUser           varchar(100)        NOT NULL UNIQUE,
    PasswordUser        varchar(256)        NOT NULL,
    Name                varchar(100)        NOT NULL,
    LastName            varchar(100)        NOT NULL,
    ConnectionNumber    int                 DEFAULT 0
);

--

-- -----------------------------------------------------------------------------
-- - T_Admins creation
-- -----------------------------------------------------------------------------
CREATE TABLE T_Admins (
    IdAdmin             SERIAL              PRIMARY KEY,
    IdUserAdmin         int                 NOT NULL,
    FOREIGN KEY(IdUserAdmin) 
        REFERENCES T_Users(IdUser)
);


-- -----------------------------------------------------------------------------
-- - T_Post creation
-- -----------------------------------------------------------------------------

-- -----------------------------------------------------------------------------
CREATE TABLE T_Post (
    IdPost             	SERIAL              PRIMARY KEY,
    PostContent         varchar(100000)     NOT NULL,
    urlImgPost			varchar(1000)
);

INSERT INTO T_Post VALUES (0, "Mon premier Post", "http://qnimate.com/wp-content/uploads/2014/03/images2.jpg");
