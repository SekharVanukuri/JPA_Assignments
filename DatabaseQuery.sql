create table StudentDetails(studentId varchar2(250));
insert into StudentDetails values('121');
insert into StudentDetails values('122');
insert into StudentDetails values('123');

select * from StudentDetails;


create table BokkJEE(bId Number(50),bName varchar2(225),bAuthor varchar2(225),
bPage Number(50),bPrice(50), issueDate DATE DEFAULT (sysdate), returnDate DATE, 
studentId varchar2(225) );

alter table BookJEE add FOREIGN KEY (studentId) REFERENCES Persons(studentId);

CREATE SEQUENCE bId_seq
 START WITH     1001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 select * from BookJEE;
 
 select * from BookJEE where bId=1002;
 