set names utf8;
set foreign_key_checks = 0;
drop database if exists account;
create database if not exists account;
use account;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int not null primary key auto_increment,
	id , /* データ型「int(100)」、主キー、自動採番 */
	family_name varchar(100),
	last_name varchar(100),
	family_name_kana varchar(100),
	last_name_kana varchar(100),
	mail varchar(255),
	password varchar(255),
	gender , /* データ型「int(1)」、パラメータが0の場合は「男」で1の場合は「女」とする */
	postal_code int(7),
	prefecture varchar(100),
	address_1 varchar(100),
	address_2 varchar(255),
	authority , /* 「int(1)」、パラメータが0の場合は「一般」で1の場合は「管理者」とする */
	delete_flag , /* データ型「int(1)」、パラメータが0の場合は「有効」で1の場合は「無効」とする */
	registered_time datetime,
	update_time datetime
);
