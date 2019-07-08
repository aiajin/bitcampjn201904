-- 2019.07.08

-- 부속질의 2

-- 고객 이름별 구매 총금액을 출력
select custid, (
        select name from customer c 
        where o.custid = c.custid        
        ), sum(saleprice) as 구매총액
from orders o
group by custid
;

-- JOIN 처리
select o.custid, c.name, sum(o.saleprice) as 구매총금액
from orders o join customer c 
on o.custid=c.custid
group by o.custid, c.name
order by o.custid
;

-- 인라인뷰
select * from customer where custid <=2;

select * 
from (select * from customer where custid <= 2) c, orders o
where c.custid=o.custid
;

-- row num

select rownum,empno, ename
from emp
order by ename
;
select rownum, empno, ename
from (select * from emp order by ename)
;

-- 평균 주문금액 이하의 주문에 대해서 
-- 주문번호화 금액을 출력

select avg(saleprice)
from orders;

-- 11800
select orderid, saleprice 
from orders
where saleprice <= (
    select avg(saleprice)
    from orders
    )
;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 
-- 주문번호, 고객번호, 금액을 출력

select orderid, custid, saleprice
from orders od
where saleprice > (
                    select avg(saleprice)
                    from orders so
                    where  od.custid=so.custid
)
;

select avg(saleprice)
from orders so
where  so.custid=2
;

-- 대한민국에 거주하는 고객에게 
-- 판매한 도서의 총판매액을 구하시오.
select sum(saleprice) as 총판매금액
from orders
where custid IN (
                    select custid
                    from customer
                    where address like '%대한민국%'
)
;
-- JOIN
select sum(saleprice) as 총판매액
from orders o join customer c
on o.custid = c.custid
where address like '%대한민국%'
;

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 
--     주문번호와 금액을 보이시오.
-- 최대 값보다 큰 값 찾기

select  orderid, saleprice
from orders
where saleprice > all (
                        select saleprice 
                        from orders
                        where custid=3
)
;

select  orderid, saleprice
from orders
where saleprice > (
                        select max(saleprice)
                        from orders
                        where custid=3
)
;


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.

select sum(Saleprice) as "총 판매액"
from orders o
where exists (
                select *
                from customer c
                where o.custid=c.custid and c.address like '%대한민국%'
)
;

-------------------------------------------------------------
-- DML
-------------------------------------------------------------

-- 데이터 입력
-- : INSERT INTO 테이블 명 (컬럼 리스트.. )  VALUES ( 입력 데이터 리스트.. )

-- 테이블 삭제
drop table dept01;

-- 테이블 생성
create table dept01
as
select * from dept where 1=0
;

desc dept01;

-- 데이터 입력
insert into dept01 
(deptno, dname, loc) 
values 
(10, 'accounting', 'newyork');

select * from dept01;

desc dept01;
insert into dept01
values (20, 'research', 'dallas')
;

-- null 값의 입력
-- 암묵적/암시적 방법
-- 컬럼을 뺴고 입력
insert into dept01
(deptno, dname)
values (30, 'sales')
;

insert into dept01
values (40, 'operations', null)
;

insert into dept01
values (50, '', null);

select * from dept01;

insert into dept01
select * from dept
;

--  데이터의 수정 
-- : UPDATE 테이블 이름 SET 컬럼이름=변경데이터 , 컬럼이름=변경데이터, ...
-- : WHERE 변경하고자하는 행을 찾기위한 조건

update emp01
set deptno=30
;
update emp01
set sal = sal * 1.1
;

update emp01
set hiredate=sysdate
;
select * from emp01;
desc emp01;

drop table emp01;
create table emp01
as
select * from emp
;

-- where 절을 이용한 특정행의 데이터 변경
-- 부서번호가 10번인 사원의 부서번호를 30번으로 수정
update emp01
set deptno=30
where deptno=10
;

-- 급여가 3000이상인 사원만 급여를 10% 인상
update emp01
set sal = sal*1.1
where sal >= 3000
;


-- 1987년에 입사한 사원의 입사일이 오늘로 수정합시다. 
-- 사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.

update emp01
set hiredate = sysdate
where substr(hiredate, 1,2)='87'
;

-- SCOTT 사원의 
-- 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다.

update emp01
set deptno=10, job='MANAGER'
where ename='SCOTT'
;

select * from emp01;

-- SCOTT 사원의 
-- 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정합시다.

update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT'
;

select * from dept01;

drop table dept01;
create table dept01
as
select * from dept01
;

-- 20번 부서의 
-- 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.

update dept01
set loc=(
            select loc
            from dept01
            where deptno=40
)
where deptno=20
;

update dept01
set (dname, loc) = (
                        select dname, loc from dept where deptno=40
)
where deptno=10
;

-- 데이터 삭제 : DELETE FROM 테이블 이름 WHERE 조건
-- 조건에 해당하는 행을 삭제

SELECT * FROM DEPT01;
-- 전체 행을 삭제
DELETE FROM DEPT01;

DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT
;

-- 특정행을 삭제 한다. WHERE 절에서 특정행을 찾는 조건을 기술
DELETE FROM DEPT01
WHERE DEPTNO=30
;



-------------------------------------------------------
-------------------------------------------------------
DESC MEMBERINFO;
-- IDX     NOT NULL NUMBER(7)    
-- MID     NOT NULL VARCHAR2(12) 
-- MPW     NOT NULL VARCHAR2(16) 
-- MNAME   NOT NULL VARCHAR2(20) 
-- MPHOTO           VARCHAR2(30) 
-- REGDATE          DATE

SELECT * FROM MEMBERINFO;

-- 회원 가입시 증가하는 IDX 값을 위한 SEQUENCE 생성
CREATE SEQUENCE MEMBERINFO_IDX_SEQ ;

-- 회원가입 INSERT
-- 1. 
INSERT INTO MEMBERINFO (IDX, MID, MPW, MNAME, MPHOTO)
VALUES (MEMBERINFO_IDX_SEQ.NEXTVAL, 'COOL', '1111', 'COOLname', 'COOLPHOTO.JPG');
-- 2.
INSERT INTO MEMBERINFO (IDX, MID, MPW, MNAME, MPHOTO)
VALUES (MEMBERINFO_IDX_SEQ.NEXTVAL, 'HOT', '3333', 'HOTname', NULL);
-- 3.
INSERT INTO MEMBERINFO (IDX, MID, MPW, MNAME)
VALUES (MEMBERINFO_IDX_SEQ.NEXTVAL, 'COOLINHOT123', '3333', 'CinHname');

COMMIT;
ROLLBACK;

-- 회원 데이터 수정 : PK를 조건으로만 수정한다.
-- 회원 이름만 수정
UPDATE MEMBERINFO
SET mname='쿨'
WHERE IDX=1;
-- 비밀번호만 수정
UPDATE MEMBERINFO
SET mpw='9999'
WHERE IDX=2;
-- 이름과 비밀번호 한번에 수정 
UPDATE MEMBERINFO
SET mname='쿨린', mpw='0000'
WHERE IDX=4
;

-- 데이터 삭제 : PK 기준으로 삭제
DELETE FROM MEMBERINFO WHERE IDX=4;

DELETE FROM MEMBERINFO;


CREATE TABLE DEPT11
AS
SELECT * FROM DEPT
;
DROP TABLE DEPT11;


COMMIT;


------------------------------------------------------------
-- VIEW : 사용자에게 보여주는 가상 테이블
--        특정 컬럼을 제외하거나 복잡한 sql 문을 간소화 시킨다.
------------------------------------------------------------


-- VIEW 생성 : CREATE VIEW 뷰 이름 AS 서브쿼리
CREATE VIEW EMP_view30
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO=30
;

SELECT EMPNO, ENAME, DEPTNO FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP_VIEW30;


-- 인라인뷰
-- 사원 중에서 
-- 입사일이 빠른 사람 5명(TOP-5)만을 얻어 오는 질의문을 작성해 봅시다.

SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM EMP ORDER BY hiredate;

SELECT ROWNUM, EMPNO, ENAME, HIREDATE
FROM (
        SELECT  EMPNO, ENAME, HIREDATE FROM EMP ORDER BY hiredate
)
WHERE ROWNUM <=5 
ORDER BY HIREDATE
;

CREATE OR REPLACE VIEW  EMP_VIEW_HD
AS
SELECT  EMPNO, ENAME, HIREDATE FROM EMP ORDER BY hiredate
;

SELECT ROWNUM, EMPNO, ENAME, HIREDATE
FROM EMP_VIEW_HD
WHERE ROWNUM <=5 
ORDER BY HIREDATE
;


-----------------------------------------------------------------------
-- SEQUENCE : 자동 숫자 증가처리해주는 객체
-----------------------------------------------------------------------

CREATE SEQUENCE TEST_SEQ
START WITH 10
INCREMENT BY 10
;
DROP SEQUENCE TEST_SEQ;

SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;

DESC DEPT01;
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (TEST_SEQ.NEXTVAL, 'DESIGN', 'SEOUL');
DELETE FROM DEPT01;
