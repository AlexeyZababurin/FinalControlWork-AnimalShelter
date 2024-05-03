-- 7. В MySQL создать базу данных с названием "Human Friends".
-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
-- Заполнить таблицы данными о животных, их командах и датами рождения.
DROP DATABASE IF EXISTS Human_Friends;
CREATE DATABASE Human_Friends;
USE Human_Friends;

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    `name` VARCHAR(20),
    `type` ENUM ('Dog','Cat', 'Hamster'),
    birthdate DATE,
    command VARCHAR(100));

INSERT INTO Pets (`name`,`type`, birthdate, command) VALUES
	('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
	('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
	('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
	('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
	('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
	('Peanut', 'Hamster', '2021-08-01', 'Sit, Roll, Spin'),
	('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
	('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');
SELECT * FROM Pets;

DROP TABLE IF EXISTS Pack_Animals;
CREATE TABLE Pack_Animals(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    `name` VARCHAR(20),
    `type` ENUM('Horse', 'Camel', 'Donkey'),
    birthdate DATE,
    command VARCHAR(100));
  
INSERT INTO Pack_Animals (`name`,`type`, birthdate, command) VALUES
	('Thunder', 'Horse', '2022-07-21', 'Trot, Canter, Gallop'),
	('Sandy	', 'Camel', '2016-11-03', 'Walk, Carry Load'),
	('Eeyore', 'Donkey', '2022-09-18', 'Walk, Carry Load, Bray'),
	('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
	('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
	('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
	('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
	('Sahara', 'Camel', '2015-08-14', 'Walk, Run');
SELECT * FROM Pack_Animals;

-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
DELETE FROM Pack_Animals WHERE type = 'Camel' AND id > 0;
SELECT * FROM Pack_Animals;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
DROP TABLE IF EXISTS Young_Animals;
CREATE TABLE Young_Animals(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    `name` VARCHAR(20),
    `type` VARCHAR(100),
    birthdate DATE,
    command VARCHAR(100));
    
INSERT INTO Young_Animals (`name`,`type`, birthdate, command)  
SELECT * FROM (
	(SELECT `name`,`type`, birthdate, command 
		FROM Pets
		WHERE TIMESTAMPDIFF(YEAR, birthdate, NOW()) BETWEEN 1 AND 2)
	UNION 
	(SELECT `name`,`type`, birthdate, command 
		FROM Pack_Animals
        WHERE TIMESTAMPDIFF(YEAR, birthdate, NOW()) BETWEEN 1 AND 2)
) AS Young_Animals_table;
SELECT * , TIMESTAMPDIFF(YEAR, birthdate, NOW()) AS _year, (TIMESTAMPDIFF(MONTH, birthdate, NOW()) % 12) AS _month
FROM Young_Animals;

-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
SELECT *, 'Pets' AS table_name FROM Pets 
	UNION ALL SELECT *, 'Pack_animals' AS table_name FROM Pack_Animals 
		UNION ALL SELECT *, 'Young_Animals' AS table_name FROM Young_Animals;