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






