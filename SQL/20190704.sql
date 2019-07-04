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





