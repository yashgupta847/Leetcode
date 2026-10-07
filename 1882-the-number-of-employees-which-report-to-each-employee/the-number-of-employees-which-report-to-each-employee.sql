


select a.employee_id  , a.name , count(b.employee_id) as reports_count , round(avg(b.age)) as average_age from Employees a left join 
Employees b on a.employee_id = b.reports_to

group by a.employee_id
having count(b.employee_id) >= 1
order by a.employee_id