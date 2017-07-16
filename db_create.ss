sqlite3 kidsEventPlanner.db;

create table EVENT_PLACE(
id INT PRIMARY KEY NOT NULL,
coordX INT NOT NULL,
coordY INT NOT NULL,
name TEXT
);

create table EVENT(
 id INT PRIMARY KEY NOT NULL,
 name TEXT NOT NULL,
 date TEXT NOT NULL,
 type TEXT NOT NULL,
 place_id INT NOT NULL,
 aborted INT
);