use springmvcbasicfree;

insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('USER','Người dùng');

insert into user(username,password,fullname,status)
values('admin','123456','Trương Tùng Lâm',1);
insert into user(username,password,fullname,status)
values('nguyenvana','123456','nguyễn văn A',1);
insert into user(username,password,fullname,status)
values('nguyenvanb','123456','nguyễn văn B',1);

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);