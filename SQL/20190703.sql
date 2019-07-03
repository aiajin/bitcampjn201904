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

----------------------------------------------------
-- 함수
----------------------------------------------------

-- TO_CHAR
-- DATE -> STR
select sysdate as 날짜, TO_CHAR(sysdate, 'YYYY.MM.DD. HH24:MI:SS') as 변환날짜
from dual
;

select hiredate, TO_CHAR(hiredate,'YYYY.MM.DD') as "date"
from emp
;

-- NUMBER -> STR : TO_CHAR(숫자타입, '패턴')
select TO_CHAR(10000,'L999,999')
from dual
;
select sal, TO_CHAR(sal, 'L999,999') as "월 급여", 

    TO_CHAR(sal*12+nvl(comm,0),'L999,999') as "연봉"

from emp
;

-- TO_DATE(원본, 'YYYYMMDD') -> DATE
select ename, hiredate, TO_DATE('19810220', 'YYYYMMDD')
from emp
where hiredate = TO_DATE('1981-02-20', 'YYYY-MM-DD')
;

select sysdate, TO_DATE('2012/05/17', 'YYYY/MM/DD'), 

    trunc(sysdate-TO_DATE('2012/05/17', 'YYYY/MM/DD'))
    
from dual
;


-- DECODE 함수 : switch case 형식 과 유사
select ename, deptno, 
        DECODE(deptno,
                    10, 'ACCOUNTING',
                    20, 'RESEARCH',
                    30, 'SALES',
                    40, 'OPERATION'
                    ) AS DNAME
from emp
;

select ename, job, sal,
        DECODE(job,
                'ANALYST', sal*1.05,
                'SALESMAN', sal*1.1,
                'MANAGER', sal*1.15,
                'CLERK', sal*1.2
        ) as upSal
from emp
;

select DISTINCT job from emp;


select ename, deptno,

        case 
            when deptno=10 then 'ACCOUNTING'
            when deptno=20 then 'RESEARCH'
            when deptno=30 then 'SALSE'
            when deptno=40 then 'OPERATIOINS'
            else 'no Name'
        end as DNAME


from emp
;















