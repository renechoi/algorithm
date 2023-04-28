-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) as count

from animal_ins 
group by ANIMAL_TYPE
order by ANIMAL_TYPE asc