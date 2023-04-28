-- 코드를 입력하세요
select flavor
from ICECREAM_INFO
where flavor in (SELECT flavor
from first_half
where total_order > 3000
order by total_order desc) and INGREDIENT_TYPE = 'fruit_based'