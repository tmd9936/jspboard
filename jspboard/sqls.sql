create table jspmember(
    id varchar2(20) primary key
    ,password varchar2(20) not null
    ,name varchar2(20) not null
    ,phone varchar2(20)
    ,address varchar2(200)
);

create table jspboard(
    boardnum number(10) primary key
    ,id varchar2(20) not null
    ,title varchar2(200) not null
    ,content varchar2(2000) not null
    ,inputdate date default sysdate
    ,hits number default 0
);

create sequence jspboard_seq;

create table jspreply(
 replynum number primary key
 ,boardnum number REFERENCES jspboard on delete cascade
 ,id varchar2(20) not null
 ,retext varchar2(200)
 ,inputdate date default sysdate
);

create sequence jspreply_seq;
