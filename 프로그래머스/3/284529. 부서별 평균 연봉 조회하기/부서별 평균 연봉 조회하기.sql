-- 코드를 작성해주세요
select A.DEPT_ID, A.DEPT_NAME_EN, ROUND(AVG(B.SAL),0) AS AVG_SAL
from HR_DEPARTMENT A, HR_EMPLOYEES B
WHERE A.DEPT_ID = B.DEPT_ID
GROUP BY A.DEPT_ID
ORDER BY 3 DESC