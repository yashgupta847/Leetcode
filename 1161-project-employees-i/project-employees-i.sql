# Write your MySQL query statement below
select project_id , round(sum(emp.experience_years)/count(*) , 2) as average_years
from Project pj left join Employee emp
on pj.employee_id = emp.employee_id
group by project_id