-- 2019.07.05

-- 서브쿼리

-- SCOTT 사원이 소속된  -> 서브쿼리
-- 부서 이름을 출력 -> 메인 쿼리

select *
from dept
where deptno = (
                select deptno
                from emp
                where ename='SCOTT'
                )
;
select deptno
from emp
where ename='SCOTT'
;

-- 사원들중 평균 급여보다 많은 급여를 받는 사원의 이름과 급여를 출력해보자.

select *
from emp
where sal > (
                select avg(sal)
                from emp
                )
;

select avg(sal)
from emp
;

-- 급여가 3000 이상인 사원의 소속 부서
-- 해당 부서의 근무하는 사원의 리스트

select ename
from emp
where deptno in ( -- 20, 10, 20
                    select deptno
                    from emp
                    where sal >= 3000
                )
;

select deptno
from emp
where sal >= 3000
;

select sal
from emp
where deptno=30
;

select ename, sal
from emp
where sal > all(
                select sal
                from emp
                where deptno=30
)
;

select ename, sal
from emp
where sal > any(
                select sal
                from emp
                where deptno=30
)
;

-- 인라인 뷰 : from 절 뒤에 서브쿼리가 위치
select empno, ename, sal
from (
    select empno, ename, job, hiredate
    from emp
)
;

select empno, ename, job, hiredate
from emp
;


select ename, deptno, (

        select dname
        from dept
        where dept.deptno=emp.deptno

)
from emp
;












