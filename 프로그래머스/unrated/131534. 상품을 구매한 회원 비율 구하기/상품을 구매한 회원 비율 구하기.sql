-- 코드를 입력하세요
SELECT year(a.SALES_DATE) "YEAR", month(a.SALES_DATE) "MONTH", count(distinct(a.USER_ID)) PUCHASED_USERS, round(count(distinct(a.USER_ID)) / (select count(USER_ID) from USER_INFO c where year(c.JOINED) = 2021),1) PUCHASED_RATIO

from ONLINE_SALE a left outer join USER_INFO b on (a.USER_ID = b.USER_ID)
where year(b.JOINED) = 2021
group by month(a.SALES_DATE)
order by month(a.SALES_DATE)