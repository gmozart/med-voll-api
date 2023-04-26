CREATE TABLE usuarios(

    id bigint NOT NULL auto_increment,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,

    primary key(id)

);

INSERT INTO usuarios VALUES(1,"ana.gmail","$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.");