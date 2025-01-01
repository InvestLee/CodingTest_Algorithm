-- 코드를 작성해주세요
select A.ID, A.EMAIL, A.FIRST_NAME, A.LAST_NAME
from DEVELOPERS A
where EXISTS
(
    select 1 from SKILLCODES B
    where B.CATEGORY = 'Front End'
    AND B.CODE = (A.SKILL_CODE & B.CODE)
)
ORDER BY A.ID