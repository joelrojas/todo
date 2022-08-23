CREATE DATABASE test;
use test;
create table todo (
  id int not null,
  description varchar(250),
  created_at DATETIME,
  updated_at DATETIME,
  status int,
  PRIMARY KEY (id)
);
