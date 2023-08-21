select * from custom;

alter table custom add column addr varchar(300);

alter table custom alter column tel TYPE varchar(13);
alter table custom alter column pw TYPE varchar(500);
alter table custom alter column birth TYPE varchar(20);


update custom set pw='PiaaQ0NRSE2oqCNJjnWMILh7I0NxM41bVTR9vU1Rp60Jy8aFU0UvVRrHZcSHKa2X3xBYxg==' where pw='1234';
update custom set pw='lT57o27KGFcAj7lOt7bR+E6M05qDBLEif0H6EJISfb1GtOib0Qxh94Mg3is9X6nfmoj2mw==' where pw='1004';
update custom set pw='0ick8VOF/t8cMPZQyF9E/uEUVqdwsXt4z4xdT2RTPNOERtNClP/e/yXWJt9ShtJdBdwpCg==' where pw='7979';

commit;

create table filetest(
uname varchar(200), 
subject varchar(300), 
content varchar(1000),
filename varchar(500)
);

select * from filetest;

create table filetest2(
uname varchar(200), 
subject varchar(300), 
content varchar(1000),
filename1 varchar(500),
filename2 varchar(500),
filename3 varchar(500)
);

select * from filetest2;

