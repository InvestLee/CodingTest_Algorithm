-- 코드를 입력하세요
SELECT a.FLAVOR from FIRST_HALF a left outer join JULY b on (a.FLAVOR = b.FLAVOR)
group by a.FLAVOR
order by sum(a.total_order)+sum(b.total_order) desc
limit 3