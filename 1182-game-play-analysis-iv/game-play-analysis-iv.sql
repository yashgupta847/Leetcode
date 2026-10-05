select round(sum(DATEDIFF(a.event_date , b.firstDate) = 1) / (
    SELECT COUNT(DISTINCT player_id)
FROM Activity
) , 2) as fraction
from Activity a join (
    select player_id ,  min(event_date) as firstDate from Activity  group by player_id
) b
on a.player_id = b.player_id
