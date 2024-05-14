CREATE TABLE if not exists Usuario (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
) ;

CREATE TABLE if not exists Color (
    id SERIAL PRIMARY KEY,
	color VARCHAR(255),
	tipo VARCHAR(255)
);

CREATE TABLE if not exists Skin (
    id SERIAL PRIMARY KEY,
	skin VARCHAR(255)
);

CREATE TABLE if not exists Daruma (
    id SERIAL PRIMARY KEY,
    objetivo VARCHAR(255),
    color INT,
    skin INT,
    left_eye BOOLEAN,
    right_eye BOOLEAN,
	FOREIGN KEY (color) REFERENCES Color(id), 
	FOREIGN KEY (skin) REFERENCES Skin(id)   
);
