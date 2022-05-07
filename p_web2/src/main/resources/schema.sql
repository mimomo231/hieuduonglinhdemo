create table if not exists Product (
	code varchar(10) not null,
	des varchar(255) not null,
	price float not null,
	type varchar(10) not null,
	PRIMARY KEY (code)
);

create table if not exists Shop (
	id int NOT NULL,
	name varchar(50) not null,
	PRIMARY KEY (id)
);

create table if not exists Shop_Products (
	shop int not null,
	product varchar(10) not null,
	FOREIGN KEY (shop) REFERENCES Shop(id),
	FOREIGN KEY (product) REFERENCES Product(code)
);