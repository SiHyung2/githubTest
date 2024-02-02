CREATE TABLE product
( 
    productId      VARCHAR2(50),
    name       VARCHAR2(50),
    price         NUMBER(9),
    description  VARCHAR2(200),
    category   VARCHAR2(50),
    manufacturer  VARCHAR2(50),
    stock       NUMBER(9),
    condition  VARCHAR2(50),
	fileName VARCHAR2(50)
);
select*from product;
drop table prdouct;
