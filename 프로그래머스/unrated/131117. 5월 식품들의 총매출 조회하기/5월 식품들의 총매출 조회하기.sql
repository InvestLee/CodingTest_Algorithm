-- 코드를 입력하세요
SELECT a.PRODUCT_ID, a.PRODUCT_NAME, sum(a.PRICE*b.amount) as TOTAL_SALES from FOOD_PRODUCT a
left outer join FOOD_ORDER b on (a.PRODUCT_ID = b.PRODUCT_ID)
where year(b.PRODUCE_DATE) = 2022 and month(b.PRODUCE_DATE) = 5
group by a.PRODUCT_ID
order by TOTAL_SALES DESC, a.PRODUCT_ID