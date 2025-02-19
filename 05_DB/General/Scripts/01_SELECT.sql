/*조회결과 묶음 == RESULT SET
 * 
 * 
 */


SELECT EMP_NAME,EMAIL,SALARY  FROM EMPLOYEE

SELECT DEPT_ID,DEPT_TITLE FROM DEPARTMENT

/* 컬럼값: 행과 열이 교차되는 한칸에 작성된값*/
SELECT EMP_NAME,SALARY,SALARY+1000000  FROM EMPLOYEE 


/* sysdate / current_date
 * systimestamp / current_date 현재 사용자 계정 기반 시간 얻어오기
 * 
 * data
 */

SELECT CURRENT_DATE -1,CURRENT_DATE ,CURRENT_DATE +1,CURRENT_DATE +2 FROM dual


SELECT CURRENT_DATE , CURRENT_DATE +1/24,CURRENT_DATE +1/24/60,CURRENT_DATE +1/24/60/60
FROM dual


SELECT TO_DATE('2025-02-19','YYYY-MM-DD'),
'2025-02-19'
FROM dual

SELECT 
(TO_DATE('2025-02-19 17:50:00',
'YYYY-MM-DD HH24:MI:SS')
-CURRENT_DATE)*24*60 
FROM DUAL;

SELECT EMP_ID,
EMP_NAME,
HIRE_DATE,
FLOOR(CURRENT_DATE -HIRE_DATE), -- 내림
CEIL((CURRENT_DATE - HIRE_DATE)/365) --올림
FROM EMPLOYEE 


-----------------------------------------------------


/*
 * 컬럼  as 별칭: 띄어쓰기x,특수문자x
 * 컬럼 ad "별칭":띄어쓰기o,특수문자o
 * as생략가능
 * 오라클에서""의 의미 
 * ""내부에 작성된 글자 모양 그대로 인식해라
 * 
 */
 
SELECT EMP_ID as 사번,
EMP_NAME  이름,
HIRE_DATE "입사 일",
FLOOR(CURRENT_DATE -HIRE_DATE) "근무 일수",
CEIL((CURRENT_DATE - HIRE_DATE)/365) "연차"
FROM EMPLOYEE 

-- employee테이블에서
-- 모든 사원의 사번, 이름 ,급여(원),연봉(급여*12) 조회
-- 단 컬럼명은 모두 별칭 적용

SELECT 
EMP_ID "사번", EMP_NAME "이름",SALARY "급여(원)",SALARY * 12 "연봉"
FROM EMPLOYEE 


/* 연결연산자 ||
 * - 두컬럼값또는 리터럴을 하나의 문자열로 연결할때 사용 
 * */

SELECT 
EMP_ID ,EMP_NAME ,EMP_ID ||EMP_NAME 
FROM
EMPLOYEE 

/* 리터럴 : 값(data)을 표기하는 방식
 * -number 타입
 * char , varchar2 타입
 * select절에 리터럴을 작성하면 조회 결과 모든행에 리터럴이 추가된다*/

SELECT SALARY ,'원',SALARY ||'원' AS 급여
FROM EMPLOYEE 

/* distinct(별개의 전혀다른)
 * 
 */

SELECT 
	DISTINCT DEPT_CODE 
FROM
	EMPLOYEE 


