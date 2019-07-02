-- 2019.07.02


-- 테이블의 컬럼들의 도메인속성을 확인
-- 데이터 입력 시, 데이터 수정 시
DESC dept;

-- 테이터를 검색하는 명령
-- select {컬럼 이름,...} from 테이블 이름
select * from dept;
select deptno from dept;
select dname from dept;
select dname, loc, deptno from dept;

-- emp 테이블 확인
desc emp;
-- 전체 컬럼 출력
select * from emp;
-- 사원의 번호, 이름의 리스트 
select empno, ename   from emp;

-- 컬럼의 사칙연산
select sal from emp;
select sal + comm  from emp; -- null 의 연산의 결과 ->  null
select sal, sal + 100 from emp;
select sal, sal - 100 from emp;
select ename, sal, sal * 12 from emp;
select sal, sal/5 from emp;

-- nvl 함수 : 특정 컬럼의 데이터가 null 인경우 특정 데이터로 치환해주는 함수
-- nvl(컬럼이름, 치환값)
select ename, sal, comm, sal*12+comm from emp;
select ename, sal, comm, sal*12+comm as ySal1, nvl(comm, 0), sal*12+nvl(comm,0) as ySal from emp;


-- 컬럼과 문자열을 연결하는 결과 출력 , sql에서 문자열 표현은 ' ' 로 묶는다.
select ename || ' is a ' || job as str from emp;

-- distnct : 컬럼값에서 중복되는 값을 제거하고 하나의 데이터만 출력해준다.
select distinct deptno from emp;


-- select 의 조건절 : select 컬러명.. from 테이블 명 where 조건식(true/false);
-- where 의 조건은 행을 찾는다.
select dname 
from dept
where deptno = 10
;

select empno, ename, job
from emp
where deptno = 10
;

-- 문자 비교의 경우 작은 따움표로 표현, 대소문자 구별!!!!!!!!!!!!
select EMPNO, JOB
from emp
where ename='SCOTT'
;

-- 날짜 검색 : 날짜 데이터를 '' 묶어준다.
SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > '81/12/03'
;

-- 논리 연산 : AND, OR, NOT
SELECT *
FROM EMP
WHERE  DEPTNO=30 AND JOB='MANAGER'
;
SELECT *
FROM EMP
WHERE DEPTNO=10 OR DEPTNO =20
;
SELECT *
FROM EMP
WHERE NOT DEPTNO=30
;

-- 컬럼명 BETWEEN A AND B 연산자 : A이상 B이하의 범위 연산
SELECT *
FROM EMP
WHERE SAL BETWEEN 2000 AND 3000
--WHERE SAL > 2000 AND SAL < 3000
;

--  범위 연산은 날짜 연산도 가능하다.
SELECT *
FROM EMP
WHERE HIREDATE BETWEEN '1987/01/01' AND '1987/12/31'
;

-- IN : OR 조건이 많을때 사용
SELECT *
FROM EMP
--WHERE COMM IN(300, 500, 1400)
WHERE COMM=300 OR COMM=500 OR COMM=1400
;