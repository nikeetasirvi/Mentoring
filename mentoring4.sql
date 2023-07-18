create database LPG;
use LPG;

create table Cust_Details(id int primary key,name varchar(50),gender varchar(1),address varchar(100),phone_no bigint,connection_type decimal(3,1),no_of_cylinders int);
create table orders(id int primary key,date date,cust_id int,quantity int,payment_type varchar(30),status varchar(30),FOREIGN key (cust_id) REFERENCES cust_details(id));
create table cancelled_orders(order_id int,date date,reason varchar(50), FOREIGN key (order_id) REFERENCES orders(id));
create table billing_details(inv_id int primary key,date date,order_id int,delivery_status varchar(30), FOREIGN key (order_id) REFERENCES orders(id));
create table cancelled_bills(inv_id int,date date,reason varchar(50), FOREIGN key (inv_id) REFERENCES billing_details(inv_id));
create table pricing(type decimal(3,1),month varchar(10),year int,price int);

alter table cust_details AUTO_INCREMENT = 1;

insert into cust_details values(1, "Harish", "M", "1-2, bglr", 1987654322, 14.2, 1);
insert into cust_details values(2, "Amisha", "F", "32-12, bglr", 1614322387, 14.2, 1);
insert into cust_details values(3, "Ujjawal", "M", "19-0, gurgaon", 1871614322, 14.2, 1);
insert into cust_details values(4, "Anu", "F", "2-10, hyd", 1000614322, 19.0, 5);
insert into cust_details values(5, "Rakshitha", "F", "3-1-3, chennai", 1614322551, 19.0, 10);
insert into cust_details values(6, "Varuni", "F", "10-4, gurgaon", 1432245789, 14.2, 1);
insert into cust_details values(7, "Vamshi", "M", "31-14, hyd", 1443324578, 19.0, 6);

insert into orders values(1, "2021-10-01", 6, 1, "online", "cancelled");
insert into orders values(2, "2021-10-01", 3, 1, "POD", "Ordered");
insert into orders values(3, "2021-10-02", 5, 4, "POD", "Cancelled");
insert into orders values(4, "2021-10-03", 6, 1, "POD", "Ordered");
insert into orders values(5, "2021-10-04", 3, 1, "Online", "Ordered");
insert into orders values(6, "2021-11-05", 6, 1, "Online", "Ordered");
insert into orders values(7, "2021-11-06", 4, 4, "Online", "Ordered");
insert into orders values(8, "2021-11-07", 5, 9, "POD", "Ordered");
insert into orders values(9, "2021-11-09", 7, 5, "Online", "Ordered");

insert into cancelled_orders values(1, "2021-10-02", "Out of Station");
insert into cancelled_orders values(3, "2021-10-03", "Mistakenly Ordered");

insert into billing_details values(1, "2021-10-03", 2, "Undelivered");
insert into billing_details values(2, "2021-10-04", 4, "Delivered");
insert into billing_details values(3, "2021-10-06", 5, "Delivered");
insert into billing_details values(4, "2021-11-06", 6, "Delivered");
insert into billing_details values(5, "2021-11-06", 7, "Delivered");
insert into billing_details values(6, "2021-11-08", 8, "Delivered");

insert into cancelled_bills values(1, "2021-10-04", "Insufficient Amount");

insert into pricing values(14.2, "January", 2021, 925);
insert into pricing values(19.0, "January", 2021, 1223);
insert into pricing values(5.0, "January", 2021, 352);
insert into pricing values(14.2, "February", 2021, 931);
insert into pricing values(19.0, "February", 2021, 1025);
insert into pricing values(5.0, "February", 2021, 361);
insert into pricing values(14.2, "March", 2021, 910);
insert into pricing values(19.0, "March", 2021, 1225);
insert into pricing values(5.0, "March", 2021, 365);
insert into pricing values(14.2, "April", 2021, 942);
insert into pricing values(19.0, "April", 2021, 1300);
insert into pricing values(5.0, "April", 2021, 330);
insert into pricing values(14.2, "May", 2021, 942);
insert into pricing values(19.0, "May", 2021, 1280);
insert into pricing values(5.0, "May", 2021, 333);
insert into pricing values(14.2, "June", 2021, 958);
insert into pricing values(19.0, "June", 2021, 1283);
insert into pricing values(5.0, "June", 2021, 320);
insert into pricing values(14.2, "July", 2021, 950);
insert into pricing values(19.0, "July", 2021, 1295);
insert into pricing values(5.0, "July", 2021, 330);
insert into pricing values(14.2, "August", 2021, 947);
insert into pricing values(19.0, "August", 2021, 1298);
insert into pricing values(5.0, "August", 2021, 337);
insert into pricing values(14.2, "September", 2021, 963);
insert into pricing values(19.0, "September", 2021, 1306);
insert into pricing values(5.0, "September", 2021, 340);
insert into pricing values(14.2, "October", 2021, 960);
insert into pricing values(19.0, "October", 2021, 1310);
insert into pricing values(5.0, "October", 2021, 347);
insert into pricing values(14.2, "November", 2021, 970);
insert into pricing values(19.0, "November", 2021, 1313);
insert into pricing values(5.0, "November", 2021, 350);
insert into pricing values(14.2, "December", 2021, 974);
insert into pricing values(19.0, "December", 2021, 1320);
insert into pricing values(5.0, "December", 2021, 362);
insert into pricing values(14.2, "January", 2022, 999);
insert into pricing values(19.0, "January", 2022, 1309);
insert into pricing values(5.0, "January", 2022, 359);

/*Write a query to display a table with customer Id, Name, Connection_Type and No_Of Cylinders ordered from orders table.*/
select c.id,c.name,c.connection_type,q.no_of_cylinders from cust_details as c inner join
(select cust_id, sum(quantity) as no_of_cylinders from orders where status = "ordered" group by cust_id) as q on c.id=q.cust_id; 

/*Display one customer from each product category who purchased maximum no of cylinders with Connection_Type, Cust_Id, Name and Quantity purchased.*/
select a.cust_id,a.name,a.total_cylinders,a.connection_type from 
(select c.id as cust_id,c.name,c.connection_type,p.total_cylinders,rank() over(partition by c.connection_type order by p.total_cylinders desc) as rnk 
from cust_details as c inner join (select cust_id,sum(quantity) as total_cylinders from orders where status="ordered" group by cust_id) as p on c.id=p.cust_id)
as a where a.rnk=1;

/*Display Customer Id, Successfully_Delivered and value of customer based on purchase
of cylinders using SQL Case Statement.
when Successfully_Delivered >= 8 then 'Highly Valued'
when Successfully_Delivered between 5 and 7 then 'Moderately Valued'
Else 'Low Valued'*/
select f.id,f.successfully_delivered,
CASE
when f.successfully_delivered>=8 then "highly valued"
when f.successfully_delivered>=5 and f.successfully_delivered<=7 then "moderately valued"
else "low valued"
end as cust_value
from (select o.cust_id as id,count(o.id) as successfully_delivered
from orders as o inner join (select order_id, delivery_status from billing_details where delivery_status = "delivered") as b
on o.id=b.order_id
group by o.cust_id) as f;

/*Display Customer Id, Name, Order_Id, Inv_Id, Delivery Date of all deliveries received by customer for all customers*/
select c.id,c.name,p.inv_id,p.date,p.o_id from cust_details as c inner join (select b.inv_id as inv_id,b.date as date,o.id as o_id,o.cust_id as id from billing_details as b inner join orders as o on b.order_id=o.id) as p on c.id= p.id;

/*Find the amount paid by the customer for every delivery taken for all customers with following details
Customer_Id, Name, Order_Id, Order_Date, Inv_Id, Delivery_Date,Connection_Type and Price.*/
select c.id as c_id,c.name as c_name,o.id as order_id,o.date as order_date,b.inv_id,b.date as delivery_date,
p.type as connection_type,p.price from orders as o, billing_details as b,cust_details as c,pricing as p
where o.id=b.order_id and o.cust_id=c.id and p.type=c.connection_type and b.delivery_status="delivered" order by c_id;

select x.c_id,x.name,x.connection_type,x.order_id,x.order_date,x.inv_id,x.delivery_date,f.price from pricing as f inner join
(select c.id as c_id,c.name,c.connection_type,p.order_id,p.order_date,p.inv_id,p.delivery_date from cust_details as c inner join
(select o.id as order_id,o.date as order_date,o.cust_id,b.inv_id,b.delivery_date from orders as o inner join
(select inv_id,order_id,date as delivery_date from billing_details where delivery_status="delivered")
as b on o.id=b.order_id) as p on c.id=p.cust_id) as x on x.connection_type=f.type order by c_id;

/*Create an SQL Stored Procedure “PriceOfCurrentMonth” to Identify the Price of all
Products in the Current Month with Product_Type, Month, Year and Price in table.*/
drop procedure if exists PriceOfCurrentMonth;
DELIMITER //
create procedure PriceOfCurrentMonth()
BEGIN
select type,month,year,price from pricing where month=monthname(curdate()) and year=year(curdate());
END//
DELIMITER ;

/*call procedure*/
call PriceOfCurrentMonth();

/*Find Last Delivery Date from billing_details table of every customer and display
customer Id and Name, Last_Delivery_Date and Quantity using Joins.
(Note that the date in billing_details will act as last delivery date)*/
select c.id as c_id,c.name,b.date as last_delivery_date,o.quantity from cust_details as c,billing_details as b,orders as o
where b.order_id=o.id and o.cust_id=c.id;

/*10. Display customer Id, Name, undelivered date and reason for undelivery using joins.*/
select cc.id as cust_id,cc.name,o.id as order_id,b.date as undelivered_date,c.reason
from billing_details as b,cancelled_bills as c,orders as o,cust_details as cc
where b.inv_id=c.inv_id and o.id=b.order_id and cc.id=o.cust_id and b.delivery_status="undelivered";

/*11. Display customer Id, Name, Date and reason for Cancelled Orders of all cancellations
made by all customers.*/
select c.id,c.name,o.id,co.date,co.reason from orders as o,cancelled_orders as co,cust_details as c
where o.id=co.order_id and c.id=o.cust_id and status="cancelled";

