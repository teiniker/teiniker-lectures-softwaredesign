CREATE TABLE user
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	firstname VARCHAR(64) NOT NULL,
	lastname VARCHAR(64) NOT NULL,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(64) NOT NULL
) ENGINE = INNODB;

INSERT INTO user (firstname,lastname,username, password) VALUES ('Homer', 'Simpson', 'homer', 'Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=');
INSERT INTO user (firstname,lastname,username, password) VALUES ('Bart', 'Simpson','bart', 'VUb+dKJUIzdDfdjILoJdsOqQYYXSs4RXbH0WgUL1ZXw=');
INSERT INTO user (firstname,lastname,username, password) VALUES ('Lisa', 'Simpson','lisa', '2E/n4HvtsifP//EACRUdlvyUT2ob03z/YOjkYmoescM=');
