CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255),
    contrasena VARCHAR(255)
);

CREATE TABLE Color (
    id SERIAL PRIMARY KEY,
	color VARCHAR(255),
	tipo VARCHAR(255)
);

CREATE TABLE Skin (
    id SERIAL PRIMARY KEY,
	skin VARCHAR(255)
);

CREATE TABLE Daruma (
    id SERIAL PRIMARY KEY,
    objetivo VARCHAR(255),
    color INT,
    skin INT,
    left_eye BOOLEAN,
    right_eye BOOLEAN,
	FOREIGN KEY (color) REFERENCES Color(id), 
	FOREIGN KEY (skin) REFERENCES Skin(id)   
);
