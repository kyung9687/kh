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
	EMPLOYEE ;



/*
 * -테이블에서 조건을 충족하는 행을 조회할 때 사용
 * -where 절에승 조건식(결과가 t/f) 만 작성가능
 * -비교 연산자 : >,<,>=,<=,=,!=,<>(같지 않다)
 * -논리 연산자: and,or,not
*/

SELECT EMP_ID, EMP_NAME , SALARY 
FROM EMPLOYEE 
WHERE SALARY >4000000;


SELECT EMP_ID, EMP_NAME , SALARY ,DEPT_CODE ,JOB_CODE 
FROM EMPLOYEE 
WHERE SALARY <= 5000000;

SELECT  EMP_NAME , SALARY*12 "연봉"
FROM EMPLOYEE 
WHERE SALARY*12 <=50000000;

SELECT  EMP_ID ,EMP_NAME ,PHONE 
FROM EMPLOYEE 
WHERE EMP_NAME = '노옹철';

SELECT EMP_ID ,EMP_NAME 
FROM EMPLOYEE 
WHERE DEPT_CODE != 'D9'

SELECT EMP_ID ,EMP_NAME 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D9'

/*
 *- db에서 null :빈칸(저장된 값 없음) 
 *-null 은 비교대상이 없기 때문에
 * 비교연산결과가 무조건 false
 * 
 */
/* is null : 해당 컬럼 값이 null이면 true반환
 * is not null : 해당 컬럼 값이 null아니면 true반환
 * */

SELECT EMP_ID ,EMP_NAME ,DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE IS NULL; 

SELECT EMP_NAME ,BONUS 
FROM EMPLOYEE 
WHERE BONUS IS NOT NULL; 

-----------------------------------------------------
/* 논리연산자
 * and(그리고)
 * or(또는)
 * 우선 순위 : and>or
 */
 
SELECT EMP_NAME ,DEPT_CODE ,SALARY 
FROM EMPLOYEE 
WHERE DEPT_CODE ='D6' AND SALARY>4000000

SELECT EMP_ID ,EMP_NAME ,SALARY 
FROM EMPLOYEE 
WHERE SALARY >=3000000 AND SALARY <=5000000;
 
SELECT EMP_ID ,EMP_NAME ,SALARY 
FROM EMPLOYEE 
WHERE SALARY <= 3000000 OR SALARY >=5000000;

--------------------------------------------------

/* 컬럼명 between a and b
 * 컬럼 값이 a이상 b이하인 경우 true
 */

SELECT 
EMP_NAME ,SALARY 
FROM EMPLOYEE 
WHERE SALARY BETWEEN 4000000 AND 6000000


/* 컬럼명 not between a and b
 * 컬럼 값이 a이상 b이하인 경우 false
 */
SELECT 
EMP_NAME ,SALARY 
FROM EMPLOYEE 
WHERE SALARY NOT BETWEEN 4000000 AND 6000000

/*날짜 비교에 더많이 사용*/

SELECT EMP_NAME ,HIRE_DATE 
FROM EMPLOYEE 
WHERE HIRE_DATE 
BETWEEN TO_DATE('2010.01.01','YYYY.MM.DD') 
AND TO_DATE('2019.12.31','YYYY.MM.DD')

--------------------------------------------------

SELECT EMP_ID,EMP_NAME,DEPT_CODE 
FROM  EMPLOYEE 
WHERE DEPT_CODE ='D5' 
OR DEPT_CODE ='D6' 
OR DEPT_CODE ='D9'

SELECT EMP_ID,EMP_NAME,DEPT_CODE 
FROM  EMPLOYEE 
WHERE DEPT_CODE IN ('D5','D6','D9')
/* 컬럼명 in
 * 컬럼 값이 in안에 존재 한다면 true*/

SELECT EMP_ID,EMP_NAME,DEPT_CODE 
FROM  EMPLOYEE 
WHERE DEPT_CODE NOT IN ('D5','D6','D9')


SELECT EMP_ID,EMP_NAME,DEPT_CODE 
FROM  EMPLOYEE 
WHERE DEPT_CODE NOT IN ('D5','D6','D9')
OR DEPT_CODE IS NULL

---------------------------------------------
/* like
 * 비교하려는 값이 특정한 패턴을 만족하면 조회하는 연산자
 * 1)% (포함)
 * 2)_ (글자 수 지정,1개당 1글자)*/


SELECT EMP_NAME 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '전%'

SELECT EMP_NAME 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '%수'

SELECT EMP_NAME 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '%하%'

SELECT EMP_NAME ,PHONE 
FROM EMPLOYEE 
WHERE PHONE LIKE '010%'

SELECT EMP_NAME ,PHONE 
FROM EMPLOYEE 
WHERE PHONE LIKE '010________'


SELECT EMP_ID, EMP_NAME ,EMAIL 
FROM EMPLOYEE 
WHERE EMAIL LIKE '_____@%'


/*like escape option이용
 * -> 지정된 특수 문자 뒤 딱 한글자를 와일드 카드가 아닌 단수 문자열로 인식시키는 옵션
 * -작성법
 * where like  '___#_' escape'#'
 * 
 */

SELECT EMP_ID ,EMP_NAME ,EMAIL 
FROM EMPLOYEE 
WHERE EMAIL LIKE '___#_%' ESCAPE '#'


------------------------------------------------------------

/*order by -- 조회결과 정렬
 * select 조회 결과 집합을 
 * 원하는 순서로 정렬할때
 * 사용하는 구문
 * 
 * -작성법
 * order by 컬럼명||별칭||컬럼순서||함수
 * order by 절은 해당 select문 제일 마지막에만 수행!!!
 * 
 * 오름차순(ascending)
 * 내림차순(descending)
 * */
SELECT EMP_NAME ,SALARY 
FROM EMPLOYEE 
ORDER BY SALARY  DESC;

SELECT  EMP_ID ,EMP_NAME ,SALARY ,DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE in('D5','D6','D9')
ORDER BY SALARY  DESC 


SELECT  EMP_ID ,EMP_NAME ,SALARY ,DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE in('D5','D6','D9')
ORDER BY DEPT_CODE  ASC ;


SELECT  EMP_ID "사번",EMP_NAME "이름" ,SALARY*12 "연봉" 
FROM EMPLOYEE 
ORDER BY 연봉  ASC ;


SELECT  EMP_ID "사번",EMP_NAME "이름" ,SALARY*12 "연봉" 
FROM EMPLOYEE 
WHERE SALARY*12 >=50000000
ORDER BY 연봉  ASC ;

/* 컬럼 순서를 이용하여 정렬하기
 * select 절이 해석되면
 * 조회하려면 컬럼이 지정되면서
 * 컬럼의 순서도 같이 지정된다
 * -> orderby절에서 컬럼 순서 이용 가능
 * 
 * */


SELECT EMP_ID ,EMP_NAME ,SALARY 
FROM EMPLOYEE 
WHERE SALARY BETWEEN 4000000 AND 6000000
ORDER BY 3 DESC;


------------------------------------------------------------


SELECT EMP_ID ,EMP_NAME 
FROM EMPLOYEE 
ORDER BY DEPT_CODE ASC;


SELECT EMP_NAME ,BONUS 
FROM EMPLOYEE 
ORDER BY BONUS  DESC NULLS LAST

/*정렬기준 "중첩"작성
 * 
 * -먼저 작성된 정렬을 적용하고
 * 그안에서 형성된 그룹별로 정렬진행*/

SELECT EMP_NAME ,DEPT_CODE ,SALARY 
FROM EMPLOYEE 
ORDER BY 
DEPT_CODE ASC,
SALARY DESC 

SELECT EMP_NAME "이름", DEPT_CODE "부서코드", JOB_CODE "직급코드"
FROM EMPLOYEE 
ORDER BY 2 ASC, 3 DESC ,1 asc
