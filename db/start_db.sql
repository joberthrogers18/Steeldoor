USE steeldoor;

CREATE TABLE Company (
    idCompany INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (idCompany)
);

CREATE TABLE Job (
    idJob INT NOT NULL AUTO_INCREMENT,
    companyName VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    minSalary DECIMAL (18, 2) NOT NULL,
    maxSalary DECIMAL (18, 2) NOT NULL,
    idCompany INT NOT NULL,
    PRIMARY KEY (idJob),
    FOREIGN KEY (idCompany) REFERENCES Company(idCompany)
                            ON DELETE CASCADE
);

CREATE TABLE Skill (
    idSkill INT NOT NULL AUTO_INCREMENT,
    nameSkill VARCHAR(255) NOT NULL,
    PRIMARY KEY (idSkill)
);

CREATE TABLE SystemUser (
    idUser INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR (255) NOT NULL,
    lastName VARCHAR (255) NOT NULL,
    birthday DATE NOT NULL,
    phone VARCHAR(255) NOT NULL,
    PRIMARY KEY (idUser)
);

CREATE TABLE jobSkills (
  id INT AUTO_INCREMENT,
  idSkill INT NOT NULL,
  idJob INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idSkill) REFERENCES Skill(idSkill)
                        ON DELETE CASCADE,
  FOREIGN KEY (idJob) REFERENCES Job(idJob)
                        ON DELETE CASCADE
);

CREATE TABLE usersJobs (
  id INT AUTO_INCREMENT,
  idJob INT NOT NULL,
  idUser INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idUser) REFERENCES SystemUser(idUser)
                        ON DELETE CASCADE,
  FOREIGN KEY (idJob) REFERENCES Job(idJob)
                        ON DELETE CASCADE
);

CREATE TABLE usersCompanies (
  id INT AUTO_INCREMENT,
  idCompany INT NOT NULL,
  idUser INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idUser) REFERENCES SystemUser(idUser)
                        ON DELETE CASCADE,
  FOREIGN KEY (idCompany) REFERENCES Company(idCompany)
                        ON DELETE CASCADE
);