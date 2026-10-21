# Write your MySQL query statement below



select p.product_name , sum(unit) as unit from Orders left join Products p 
on Orders.product_id = p.product_id
where order_date > "2020-01-31" and order_date < "2020-03-01" 
group by Orders.product_id
having unit >= 100