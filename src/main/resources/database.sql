CREATE TABLE cars (
	id SERIAL primary key,
	brand varchar(100) NULL,
	color varchar(50) NULL,
	price numeric(20, 2) NULL,
	price_unit bpchar(3) NULL,
	speed int4 NULL,
	speed_unit varchar(50) NULL
);

insert into cars (brand, color, price, price_unit, speed, speed_unit) values 
('Toyota', 'Blue', 800000000, 'IDR', 300, 'KM/H');

select * from cars;

drop table cars;