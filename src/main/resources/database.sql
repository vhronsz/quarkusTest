CREATE TABLE cars (
	id SERIAL NOT null,
	brand varchar(100) NULL,
	color varchar(50) NULL,
	price numeric(20, 2) NULL,
	price_unit bpchar(3) NULL,
	speed int4 NULL,
	speed_unit varchar(50) NULL,
	CONSTRAINT cars_pkey PRIMARY KEY (id)
);

insert into cars (brand, color, price, price_unit, speed, speed_unit) values 
('test', 'red', 100000, 'IDR', 200, 'KM/H');

select * from cars;