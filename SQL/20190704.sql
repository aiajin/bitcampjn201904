-- 2019.07.04

-- 그룹함수

-- SUM(컬럼) : 그룹의 합을 반환

-- 사원 테이블에서 사원의 월 급여(sal)의 총합을 구해보자.
select sum(sal) as "월 총급여"
from emp
;

-- 10번 부서 소속 직원들의 월 급여 총액을 구해보자
select sum(sal)
from emp
where deptno=10
;

-- sum 함수에서 null 값 처리방식 : null 값은 무시한다.
select sum(comm)
from emp
;
select comm from emp;

-- avg(컬럼) : 그룹에 포함된 값들의 평균값을 반환
select avg(sal) as "전체사원의 평균 월급여"
from emp
;
-- 그룹함수의 결과는 단일행의 하나의 컬럼
select trunc(avg(sal)) as "전체사원의 평균 월급여"
from emp
;
select trunc(avg(sal)) as "전체사원의 평균 월급여"
from emp
where job='MANAGER'
;

-- avg 함수도 컬럼의 값이 null 일때 제외하고 처리.
select avg(comm)
from emp
;

-- MAX(걸럼) : 최대값 반환. MIN(컬럼) : 최소값 반환
select MAX(sal) as "최대 급여", MIN(sal) as "최소 급여"
from emp
;

--count(컬럼) : row 의 개수를 반환

-- 회사에 소속된 사원의 수
select count(*) as "전체 사원의 수"
from emp
;
-- 10부서의 소속된 직원 수
select count(*)
from emp
where deptno=10
;

-- 커미션을 받는 직원 수
select count(comm)
from emp
;

-- 부서의 수를 구하자.
select count(*)
from dept
;

-- 사원들이 소속된 부서의 수
select deptno
from emp
;
select distinct deptno
from emp
;

SELECT count(distinct deptno)
from emp
;

select job
from emp
;

select *
from emp
order by deptno
;


-- group by 컬럼이름 : row를 그룹핑 해서 처리, 집합함수(sum, avg, count..)
-- 컬럼이름 -> 그룹핑의 기준
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
;

-- 부서의 평균 급여가 2000 이상인 부서만 출력
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
having avg(sal) >= 2000
;

-- 부서의 최대 급여 2900 이상인 부서를 출력
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
;


-- 직무별 지표를 출력 해보자.
select job, count(*) as "직원의 수", TO_CHAR(sum(sal), '999,999') as "급여의 총합"
            , round(avg(sal)) as "급여의 평균", Max(sal), min(sal)
from emp
group by job
;

------------------------------------------------------------




------------------------------------------------------------
-- JOIN : 2개 이상의 테이블  옆으로 붙인다. -> 표현하는 컬럼이 늘어난다.
------------------------------------------------------------

-- 테이블을 붙인다. CROSS JOIN 
select *
from emp, dept
where emp.deptno = dept.deptno
;

select *
from emp e, dept d
where e.deptno = d.deptno
;

-- 이름이 'SCOTT'인  사원의 이름과 부서이름을 출력하자.

select ename, dname, emp.deptno, dept.deptno
from emp, dept
where emp.deptno = dept.deptno and ename='SCOTT'
;

-- 주문테이블에서 회원의 이름과 주문 정보를 출력해보자. 박지성 고객
-- orders, customer
select o.orderid, c.name
from orders o, customer c
where o.custid = c.custid and c.name='박지성'
;

-- customer , book, orders
select *
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
;


-- 박지성 고객이 주문한 책의 이름을 출력.
select b.bookname, b.publisher
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
    and c.name='박지성'
;




