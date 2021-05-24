use ToDoList;

CREATE TABLE tbl_list(
li_seq	bigint	 auto_increment	PRIMARY KEY,
li_todo	VARCHAR(125)	NOT NULL	,
li_date	VARCHAR(125)	NOT NULL	,
li_time varchar(125)	not null ,
li_place	VARCHAR(125)		
);

CREATE VIEW view_할일리스트 AS(
SELECT
li_seq AS 'NO.',
li_todo AS '할일',
li_date AS '작성일자',
li_time AS '작성시각',
li_place AS '장소'
FROM tbl_list
);

DELETE FROM tbl_list where li_seq = 1;

Drop view View_할일리스트;
DROp table tbl_list;

INSERT INTO tbl_list(li_todo, li_date, li_place) values('홍대가기','2021-05-21','홍대');


SELECT * FROM view_할일리스트;