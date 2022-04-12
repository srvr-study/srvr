-- create databases
CREATE DATABASE IF NOT EXISTS `srvr-main`;
CREATE DATABASE IF NOT EXISTS `srvr-auth`;

-- create root user and grant rights
CREATE USER 'root'@'localhost' IDENTIFIED BY 'local';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
