/* 
[JOIN 용어 정리]
  오라클       	  	                          SQL : 1999표준(ANSI)
----------------------------------------------------------------------------------------------------------------
등가 조인		                            내부 조인(INNER JOIN), JOIN USING / ON
                                            + 자연 조인(NATURAL JOIN, 등가 조인 방법 중 하나)
----------------------------------------------------------------------------------------------------------------
포괄 조인 		                        왼쪽 외부 조인(LEFT OUTER), 오른쪽 외부 조인(RIGHT OUTER)
                                            + 전체 외부 조인(FULL OUTER, 오라클 구문으로는 사용 못함)
----------------------------------------------------------------------------------------------------------------
자체 조인, 비등가 조인   	                    	JOIN ON
----------------------------------------------------------------------------------------------------------------
카테시안(카티션) 곱		               			교차 조인(CROSS JOIN)
CARTESIAN PRODUCT

- 미국 국립 표준 협회(American National Standards Institute, ANSI) 미국의 산업 표준을 제정하는 민간단체.
- 국제표준화기구 ISO에 가입되어 있음.
*/
-----------------------------------------------------------------------------------------------------------------------------------------------------

-- JOIN
-- 하나 이상의 테이블에서 데이터를 조회하기 위해 사용.
-- 수행 결과는 하나의 Result Set으로 나옴.

/* 
- 관계형 데이터베이스에서 SQL을 이용해 테이블간 '관계'를 맺는 방법.

- 관계형 데이터베이스는 최소한의 데이터를 테이블에 담고 있어
  원하는 정보를 테이블에서 조회하려면 한 개 이상의 테이블에서 
  데이터를 읽어와야 되는 경우가 많다.
  이 때, 테이블간 관계를 맺기 위한 연결고리 역할이 필요한데,
  두 테이블에서 같은 데이터를 저장하는 컬럼이 연결고리가됨.   
*/

--------------------------------------------------------------------------------------------------------------------------------------------------

-- 기존에 서로 다른 테이블의 데이터를 조회 할 경우 아래와 같이 따로 조회함.

-- 직원번호, 직원명, 부서코드, 부서명을 조회 하고자 할 때
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;
-- 직원번호, 직원면, 부서코드는 EMPLOYEE테이블에 조회가능

-- 부서명은은 DEPARTMENT 테이블에서 조회 가능
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

SELECT	
	EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM 
	EMPLOYEE
JOIN	
	DEPARTMENT ON (DEPT_CODE = DEPT_ID);



/*  JOIN은 단순히 테이블을 두개를 붙이는 것이 아닌
 *  
 *  기준 삼은 테이블의 한 컬럼을 지정해
 *  다른 테이블의 한 컬럼과 같은 행을 찾아
 *   
 *  기준 테이블 옆에 한 행씩 붙여나감 
 *   */

---------------------------------------------------------

-- 1. 내부 조인(INNER JOIN) ( == 등가 조인(EQUAL JOIN))
--> 연결되는 컬럼의 값이 일치하는 행들만 조인됨.  
-- (== 일치하는 값이 없는 행은 조인에서 제외됨. )


-- 작성 방법 크게 ANSI구문과 오라클 구문 으로 나뉘고 
-- ANSI에서  USING과 ON을 쓰는 방법으로 나뉜다.

-- *ANSI 표준 구문
-- ANSI는 미국 국립 표준 협회를 뜻함, 미국의 산업표준을 제정하는 민간단체로 
-- 국제표준화기구 ISO에 가입되어있다.
-- ANSI에서 제정된 표준을 ANSI라고 하고 
-- 여기서 제정한 표준 중 가장 유명한 것이 ASCII코드이다.


-- *오라클 전용 구문
-- FROM절에 쉼표(,) 로 구분하여 합치게 될 테이블명을 기술하고
-- WHERE절에 합치기에 사용할 컬럼명을 명시한다


-- 1) 연결에 사용할 두 컬럼명이 다른 경우

-- EMPLOYEE 테이블, DEPARTMENT 테이블을 참조하여
-- 사번, 이름, 부서코드, 부서명 조회
SELECT 
	EMP_ID, EMP_NAME, DEPT_ID, DEPT_TITLE
FROM 
	DEPARTMENT
JOIN
	EMPLOYEE ON (DEPT_ID = DEPT_CODE);


-- EMPLOYEE 테이블에 DEPT_CODE컬럼과 DEPARTMENT 테이블에 DEPT_ID 컬럼은 
-- 서로 같은 부서 코드를 나타낸다.
--> 이를 통해 두 테이블이 관계가 있음을 알고 조인을 통해 데이터 추출이 가능.

-- ANSI
-- 연결에 사용할 컬럼명이 다른 경우 ON()을 사용
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

-- 오라클 (JOIN이라는 단어를 작성하지 않음)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;


-- DEPARTMENT 테이블, LOCATION 테이블을 참조하여
-- 부서명, 지역명 조회

-- ANSI 방식
SELECT * FROM DEPARTMENT ;
SELECT * FROM LOCATION ;

SELECT 
	DEPT_TITLE, LOCAL_NAME
FROM 
	DEPARTMENT 
JOIN
	LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 오라클 방식
SELECT
	DEPT_TITLE, LOCAL_NAME,
	LOCATION_ID, LOCAL_CODE
FROM
	DEPARTMENT, LOCATION
WHERE
	LOCATION_ID = LOCAL_CODE;



-- 2) 연결에 사용할 두 컬럼명이 같은 경우

-- EMPLOYEE 테이블, JOB테이블을 참조하여
-- 사번, 이름, 직급코드, 직급명 조회

-- ANSI
-- 연결에 사용할 컬럼명이 같은 경우 USING(컬럼명)을 사용함
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

SELECT 	*
FROM EMPLOYEE
JOIN JOB ON (JOB_CODE = JOB_CODE);
-- ORA-00918: 열의 정의가 애매합니다
--> 컬럼명이 겹칠 경우 발생하는 오류

/* 오류 해결 방법 1 : 어떤 테이블의 컬럼인지 구분하기*/
SELECT 	*
FROM EMPLOYEE
JOIN JOB ON (EMPLOYEE.JOB_CODE = JOB.JOB_CODE);
--> 조회 결과에 JOB_CODE 컬럼이 2개(각각의 테이블 컬럼)


/* 오류 해결 방법 2 : JOIN USING() 구분 사용하기
 * - JOIN에 사용되는 컬럼명이 같을 경우 USING 사용 가능
 *  */
SELECT 	*
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE);
--> USING 이용해서 JOIN을하면 
--  JOIN에 사용된 컬럼이 하나로 합쳐진다!!




-- 오라클 -> 별칭 사용 가능
-- 테이블 별로 별칭을 등록할 수 있음.

SELECT T1.JOB_CODE, JOB_NAME
FROM EMPLOYEE T1, JOB T2
WHERE T1.JOB_CODE = T2.JOB_CODE;



SELECT * FROM EMPLOYEE;
--> DEPT_CODE 값이 NULL인 행이 존재(2행)

SELECT * FROM DEPARTMENT ;
--> DEPT_ID 값이 NULL인 행이 없다(0행)

/* INNER JOIN : 
 * JOIN에 사용된 컬럼 값이 일치하는 행들 끼리 연결
 *  --> 일치하지 않은 행은 연결 x -> 결과 포함 x
 * */

SELECT * 
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- 21행 조회
-- 왜? 23행이 아니라 21행??
-- EMPLOYEE의 DEPT_CODE 값이 NULL인 행 2개 있지만
-- DEPARTMENT의 DEPT_ID는 NULL이 행이 없기 때문에 연결 x




---------------------------------------------------------------------------------------------------------------


-- 2. 외부 조인(OUTER JOIN)

-- 두 테이블의 지정하는 컬럼값이 일치하지 않는 행도 조인에 포함을 시킴
-->  *반드시 OUTER JOIN임을 명시해야 한다.

-- OUTER JOIN과 비교할 INNER JOIN 쿼리문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
/*INNER*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> JOIN 기본 값 == INNER

-- 1) LEFT [OUTER] JOIN  : 
-- 합치기에 사용한 두 테이블 중 왼편에 기술된 테이블의 
-- 컬럼 수를 기준으로 JOIN
-- ANSI 표준
SELECT
	EMP_NAME, 
	DEPT_CODE, 
	DEPT_ID, 
	NVL(DEPT_TITLE, '부서없음') AS DEPT_TITLE
FROM
	EMPLOYEE 
LEFT OUTER JOIN 
	DEPARTMENT  ON (DEPT_ID = DEPT_CODE);


-- 오라클 구문
SELECT
	EMP_NAME, 
	DEPT_CODE, 
	DEPT_ID, 
	NVL(DEPT_TITLE, '부서없음') AS DEPT_TITLE
FROM
	EMPLOYEE, DEPARTMENT 
WHERE
	DEPT_CODE = DEPT_ID(+);


-- 2) RIGHT [OUTER] JOIN : 합치기에 사용한 두 테이블 중 
-- 오른편에 기술된 테이블의  컬럼 수를 기준으로 JOIN
-- ANSI 표준
SELECT
	EMP_NAME, 
	DEPT_CODE, 
	DEPT_ID, 
	NVL(DEPT_TITLE, '부서없음') AS DEPT_TITLE
FROM
	EMPLOYEE 
RIGHT OUTER JOIN 	
	DEPARTMENT  ON (DEPT_ID = DEPT_CODE)
ORDER BY 
	DEPT_CODE ASC NULLS FIRST;


-- 오라클 구문
SELECT
	EMP_NAME, 
	DEPT_CODE, 
	DEPT_ID, 
	NVL(DEPT_TITLE, '부서없음') AS DEPT_TITLE
FROM
	EMPLOYEE, DEPARTMENT 
WHERE 
	DEPT_CODE(+) = DEPT_ID
ORDER BY 
	DEPT_CODE ASC NULLS FIRST;


-- 3) FULL [OUTER] JOIN   : 합치기에 사용한 두 테이블이 가진 모든 행을 결과에 포함
-- ** 오라클 구문은 FULL OUTER JOIN을 사용 못함

-- ANSI 표준
SELECT
	EMP_NAME, 
	DEPT_CODE, 
	DEPT_ID, 
	NVL(DEPT_TITLE, '부서없음') AS DEPT_TITLE
FROM
	EMPLOYEE 
FULL OUTER JOIN 	
	DEPARTMENT  ON (DEPT_ID = DEPT_CODE)
ORDER BY 
	DEPT_CODE ASC NULLS FIRST;



---------------------------------------------------------------------------------------------------------------

-- 3. 교차 조인(CROSS JOIN == CARTESIAN PRODUCT)
-- 조인되는 테이블의 각 행들이 모두 매핑된 데이터가 검색되는 방법(곱집합)

-- ANSI 방식
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
CROSS JOIN DEPARTMENT
ORDER BY EMP_NAME, DEPT_CODE;

-- 오라클 방식
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
ORDER BY EMP_NAME, DEPT_CODE;

--> NATURAL JOIN(자연 조인)의
-- 실패 결과로 나타나는 모습으로 기억하자!!!

---------------------------------------------------------------------------------------------------------------

-- 4. 비등가 조인(NON EQUAL JOIN)

-- '='(등호)를 사용하지 않는 조인문
--  지정한 컬럼 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식


SELECT * FROM SAL_GRADE;


SELECT 
 e.EMP_NAME ,e.SAL_LEVEL, e.SALARY, 
 s.SAL_LEVEL ,s.MIN_SAL ,s.MAX_SAL 
FROM 
EMPLOYEE E
JOIN 
SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL)
--SAL_GRADE using(SAL_level)


---------------------------------------------------------------------------------------------------------------

-- 5. 자체 조인(SELF JOIN)

-- 같은 테이블을 조인.
-- 자기 자신과 조인을 맺음
--> tip :같은 테이블 2개 있다고 생각하면 쉽다.


-- ANSI 표준
SELECT 
e.EMP_ID ,e.EMP_NAME ,
NVL(m.EMP_ID,'없음') "사수 번호" ,NVL(m.EMP_NAME ,'없음') "사수 이름" 
FROM
EMPLOYEE E
LEFT JOIN
EMPLOYEE M 
on(e.MANAGER_ID = m.EMP_ID) 
ORDER BY e.emp_id ASC;

-- 오라클 구문



---------------------------------------------------------------------------------------------------------------

-- 6. 자연 조인(NATURAL JOIN)
-- 동일한 타입과 이름을 가진 컬럼이 있는 테이블 간의 조인을 간단히 표현하는 방법
-- 반드시 두 테이블 간의 동일한 컬럼명, 타입을 가진 컬럼이 필요
--> 없을 경우 교차조인이 됨.

SELECT 
EMP_NAME , e.JOB_CODE , JOB_NAME 
FROM EMPLOYEE e
JOIN
JOB j on(e.JOB_CODE=j.JOB_CODE)


SELECT 
EMP_NAME ,JOB_CODE ,job_name
FROM EMPLOYEE 
JOIN
JOB USING (job_code)


SELECT 
EMP_NAME, JOB_CODE,job_name
FROM 
EMPLOYEE 
NATURAL JOIN JOB ;


---------------------------------------------------------------------------------------------------------------

-- 7. 다중 조인
-- N개의 테이블을 조회할 때 사용  (순서 중요!)

-- ANSI 표준
SELECT 
* 
FROM 
EMPLOYEE 
JOIN DEPARTMENT on(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID =local_code);
-- 오라클 전용
SELECT emp_name, DEPT_TITLE ,LOCAL_name
FROM 
EMPLOYEE ,DEPARTMENT ,LOCATION 
WHERE dept_code =DEPT_ID 
AND 
LOCATION_ID =local_code;
-- 조인 순서를 지키지 않은 경우(에러발생)
--join은 같은값을 가지는 컬럼 을 연결고리삼아서
-- 두테이블을 연결하는 것인데
-- join순서가 잘못되면 같은 값을 가지는 컬럼이
-- 존재하지 않을 수 있다
SELECT 
EMP_NAME ,DEPT_TITLE,LOCAL_NAME 
FROM 
EMPLOYEE 
JOIN DEPARTMENT on(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID =local_code);



--[다중 조인 연습 문제]

-- 직급이 대리이면서 아시아 지역에 근무하는 직원 조회
-- 사번, 이름, 직급명, 부서명, 근무지역명, 급여를 조회하세요

-- ANSI
SELECT e.EMP_ID ,e.EMP_NAME ,j.JOB_NAME ,d.DEPT_TITLE ,l.LOCAL_NAME,e.SALARY 
FROM
EMPLOYEE e
JOIN
JOB j ON (e.JOB_CODE =j.JOB_CODE)
JOIN 
DEPARTMENT d ON (e.DEPT_CODE =d.DEPT_ID)
JOIN 
LOCATION l on(d.LOCATION_ID=l.LOCAL_CODE)
WHERE j.JOB_NAME  ='대리'
AND l.LOCAL_NAME  LIKE 'ASIA%'
-- 오라클 전용




---------------------------------------------------------------------------------------------------------------


-- [연습문제]

-- 1. 주민번호가 80년대 생이면서 성별이 여자이고, 성이 '전'씨인 직원들의 
-- 사원명, 주민번호, 부서명, 직급명을 조회하시오.
SELECT e.EMP_NAME ,e.EMP_NO ,d.DEPT_TITLE,j.JOB_NAME 
FROM
EMPLOYEE e
JOIN
DEPARTMENT d on(e.DEPT_CODE =d.DEPT_ID)
JOIN 
JOB j on(j.JOB_CODE= e.JOB_CODE)
WHERE 
e.EMP_NO LIKE '8%' 
AND 
e.EMP_NO LIKE '%-2%' 
AND 
e.EMP_NAME LIKE '전%' ;
      
      
-- 2. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
SELECT e.EMP_ID,e.EMP_NAME ,j.JOB_NAME 
FROM EMPLOYEE e
join
JOB j on(j.JOB_CODE= e.JOB_CODE)
WHERE e.EMP_NAME LIKE '%형%'


-- 3. 해외영업 1부, 2부에 근무하는 사원의 
-- 사원명, 직급명, 부서코드, 부서명을 조회하시오.
SELECT e.EMP_NAME ,j.JOB_NAME ,d.DEPT_ID ,d.DEPT_TITLE 
FROM EMPLOYEE e
JOIN
DEPARTMENT d on(e.DEPT_CODE =d.DEPT_ID)
JOIN 
JOB j on(j.JOB_CODE= e.JOB_CODE)
WHERE d.DEPT_TITLE in ('해외영업1부','해외영업2부')
ORDER BY e.EMP_ID ASC;

--4. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
SELECT e.EMP_NAME ,e.BONUS,d.DEPT_TITLE ,l.LOCAL_NAME 
FROM
EMPLOYEE E 
JOIN
DEPARTMENT D on(e.DEPT_CODE =d.DEPT_ID)
JOIN
LOCATION L on(d.LOCATION_ID=l.LOCAL_CODE)
WHERE e.BONUS IS NOT NULL
;

--5. 부서가 있는 사원의 사원명, 직급명, 부서명, 지역명 조회
SELECT e.EMP_NAME ,j.JOB_NAME ,d.DEPT_TITLE ,l.LOCAL_NAME 
FROM
EMPLOYEE E
JOIN 
JOB j on(j.JOB_CODE= e.JOB_CODE)
INNER JOIN
DEPARTMENT D on(e.DEPT_CODE =d.DEPT_ID)
JOIN
LOCATION L on(d.LOCATION_ID=l.LOCAL_CODE)

-- 6. 급여등급별 최소급여(MIN_SAL)를 초과해서 받는 직원들의
--사원명, 직급명, 급여, 연봉(보너스포함)을 조회하시오.
--연봉에 보너스포인트를 적용하시오.

SELECT  e.EMP_NAME,j.JOB_NAME ,e.SALARY 
,(e.SALARY *(1+nvl(e.BONUS,0)))*12 "연봉"
FROM
EMPLOYEE E
JOIN 
JOB j on(j.JOB_CODE= e.JOB_CODE)
JOIN 
SAL_GRADE S ON (E.SAL_LEVEL =s.SAL_LEVEL)
WHERE 
S.MIN_SAL < E.SALARY
ORDER BY e.EMP_ID ASC;

-- 7.한국(KO)과 일본(JP)에 근무하는 직원들의 
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.
SELECT 
e.EMP_NAME "사원명",
d.DEPT_TITLE "부서명",
l.LOCAL_NAME "지역명",
n.NATIONAL_NAME "국가명" 
FROM EMPLOYEE E 
JOIN
DEPARTMENT D on(e.DEPT_CODE =d.DEPT_ID)
JOIN
LOCATION L on(D.LOCATION_ID=l.LOCAL_CODE)
JOIN
"NATIONAL" n on(l.NATIONAL_CODE =n.NATIONAL_CODE) 
WHERE n.NATIONAL_CODE in('KO','JP');


-- 8. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
-- SELF JOIN 사용
SELECT e1.EMP_NAME, e1.DEPT_CODE, e2.EMP_NAME
FROM EMPLOYEE E1
JOIN EMPLOYEE E2 ON e1.DEPT_CODE = e2.DEPT_CODE
WHERE e1.EMP_ID <> e2.EMP_ID
ORDER BY e1.EMP_NAME ASC;


-- 9. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, JOIN, IN 사용할 것
SELECT e.EMP_NAME ,j.JOB_NAME ,e.SALARY 
FROM 
EMPLOYEE E 
JOIN 
JOB j on(j.JOB_CODE= e.JOB_CODE)
WHERE j.JOB_CODE in('J4','J7') 
--AND E.BONUS IS null