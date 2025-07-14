# Setup MariaDB Database 

**MariaDB** is a popular open-source relational database management 
system (RDBMS). It’s designed to store, retrieve, and manage data 
efficiently using the SQL (Structured Query Language) language. 

MariaDB is a fork of **MySQL**, created by the original developers
of MySQL after Oracle acquired it, to ensure the database would 
remain free and open-source.

## Linux System 

On a Debian 12.x system, we can use the package manager to install 
**MariaDB** and run a secure installation script to disable weak 
components.

```bash
$ sudo apt install mariadb-server
$ sudo mysql_secure_installation
```

## Database Server 

After installing the database server, create a database named `testdb` 
and a user `student` with the password `student`. Grant the user full 
DBA privileges on the `testdb` database.

```SQL
$ mysql -u root -proot66
mysql> create database testdb;
mysql> create user 'student'@'localhost' identified by 'student';
mysql> set password for 'student'@'localhost' = PASSWORD('student');
mysql> grant alter, create, delete, drop, index, insert, select, update on testdb.* to 'student'@'localhost';
```

As user `student`we can connect to the `testdb` database from a
second terminal:

```SQL
$ mysql -u student -pstudent
mysql> use testdb
mysql> show tables;
```

## References

* [MariaDB](https://mariadb.org/)

*Egon Teiniker, 2016-2025 GPL v3.0*

