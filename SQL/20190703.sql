-- 2019.07.03

-- LIKE : 문자 패턴검색 연산자 키워드 
-- 컬러명 LIKE 패턴
-- 패턴 : % _

-- % 패턴을 이용
-- 사원테이블에서 'S' 로 시작하는 사원의 이름을 검색하자
select ename
from emp
where ename LIKE 'S%'
;
-- 'S' 로 끝나는 이름을 가진 사원 검색
SELECT ename
from emp
where ename like '%S'
;
-- 사원의 이름에 'S' 를 포함하는 이름을 가진 사원 검색
select * 
from emp
where ename like '%S%'
;

-- _ 연산자는 문자의 자리(위치) 고정을 의미  : 해당 자리에는 어떤한 값이 와도 상관없다.
-- _A    앞자리 문자는 어떠한 문자여도 무관, 두번째 문자는 반드시 A인 패턴
-- _A_
-- 사원의 이름중에 두번째 문자에 'A'를  포함하는 이름의 사원
select *
from emp
where ename like '__A%'
;

-- 상원의 이름중 'A' 를 포함하지 않는 사원들을 검색
select *
from emp
where ename not like '%A%'
;

-- 컬럼의 데이터 값이 null 값 여부를 확인
-- is null -> 값이 null 일때 true
-- is not null -> 값이 null이 아닐때 true

-- 커미션을 받지 않는 사원
select *
from emp
where comm is null or comm = 0
;

-- 커미션을 받는 사원
select *
from emp
where not ( comm is null or comm = 0 )
;
select *
from emp
where comm is not null and comm > 0
;

-- 결과 테이블의 로우(행) 정렬
-- order by 컬러명 [asc]/desc, 커럼명 [asc]/desc

-- 급여가 작은 사원부터 급여가 많은 사운 순으로 정렬
select * 
from emp
order by sal --asc
;

-- 급여가 많은 사원부터 급여가 작은 사원 순으로 정렬
select *
from emp
order by sal desc
;
-- 최근 입사한 사원 순으로 사원의 리스트 출력
select *
from emp
order by hiredate desc
;

-- 사원의 급여기준으로 급여가 많은 사람 순으로 정렬, 급여가 같은 사원의 경우 이름 순으로 정렬
select ename, sal, hiredate
from emp
order by sal desc, hiredate asc
;


select  count(DISTINCT deptno)
from emp
;







