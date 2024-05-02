set names utf8;
set foreign_key_checks = 0;
drop database if exists account;
create database if not exists account;
use account;

drop table if exists account_info;

create table account_info(
	id int(100) primary key auto_increment,
	family_name varchar(100),
	last_name varchar(100),
	family_name_kana varchar(100),
	last_name_kana varchar(100),
	mail varchar(255),
	password varchar(255),
	gender int(1) CHECK(gender = '0' OR gender = '1'),
	postal_code int(7),
	prefecture varchar(100),
	address_1 varchar(100),
	address_2 varchar(255),
	authority int(1) CHECK(authority = '0' OR authority = '1'),
	delete_flag int(1) CHECK(delete_flag = '0' OR delete_flag = '1'),
	registered_time datetime,
	update_time datetime
);

INSERT INTO account_info(family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority) VALUES("山田", "太郎", "やまだ", "たろう", "123@gmail.com", "123", 1, "1234567", "東京都", "新宿区西新宿", "7丁目7-26", 0);
