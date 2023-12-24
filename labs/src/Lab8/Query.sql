drop table Edged;
drop table Firearm;
drop table Armouries;

create table Edged
(
    id int primary key,
    armID int, 
    name varchar(50),
    manufacturer varchar(50),
    damage int,
    length int,
    hardness int,
    foreign key(armID) references Armouries(id)
);

create table Firearm
(
    id int primary key,
    armID int,
    name varchar(50),
    manufacturer varchar(50),
    damage int,
    caliber real,
    recharge varchar(50),
    foreign key(armID) references Armouries(id)
);

create table Armouries
(
    id int primary key,
    type varchar(50)
);

insert into Edged
    (id, armID, name, manufacturer, damage, length, hardness)
values
    (1, 1, 'Katana', 'Japan', 4, 100, 60),
    (2, 1, 'Kusarigama', 'Japan', 5, 80, 55),
    (3, 1, 'Tonfa', 'Japan', 2, 95, 25),
    (4, 3, 'Lightsaber', 'Jedi', 8, 130, 15),
    (5, 3, 'Whispersteel Dagger', 'Dark labyrinth', 4, 75, 45),
    (6, 1, 'War scythe', 'Sweden', 4, 150, 70),
    (7, 2, 'Baton', 'London', 2, 65, 30),
    (8, 3, 'Onyx Lord''s Greatsword', 'Onyx Lord', 6, 170, 90),
    (9, 3, 'Whip', 'Castle Morne', 4, 200, 10);


insert into Firearm
    (id, armID, name, manufacturer, damage, caliber, recharge)
values
    (1, 2, 'AK-47', 'Russia', 6, 7.62, 'Box'),
    (2, 2, 'SCAR-L', 'Belgium', 4, 5.56, 'Box'),
    (3, 2, 'QBZ-95', 'China', 4, 5.8, 'Box'),
    (4, 3, 'Jar Cannon', 'Mt. Gelmir', 6, 30, 'single-shot'),
    (5, 3, 'AN-94', 'Russia', 5, 5.45, 'Box'),
    (6, 1, 'SIG SG 550', 'Switzerland', 4, 5.56, 'Box'),
    (7, 2, 'M16', 'USA', 5, 5.56, 'Box'),
    (8, 3, 'G36', 'Germany', 4, 5.56, 'Box'),
    (9, 3, 'Crystal Staff', 'Liurnia of the Lakes', 6, 5.6, 'magic');

insert into Armouries
    (id, type)
values
    (1, 'Civilian'),
    (2, 'Army'),
    (3, 'Fantasy');