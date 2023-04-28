with recursive temp as(
    select 0 as HOUR
    union all
    select HOUR+1 from temp where HOUR<23
) 

select temp.HOUR as HOUR, ifnull(original.count, 0) as COUNT
from (
    SELECT HOUR(DATETIME) as HOUR, count(*) as COUNT
    from animal_outs 
    group by HOUR 
    order by HOUR
)as original 
right join temp on temp.HOUR = original.HOUR 
order by temp.HOUR;