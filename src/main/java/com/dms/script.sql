CREATE TABLE retailer_sales_report
(
c_id INT,
r_id INT,
FOREIGN KEY(r_id) references retailer(r_id),
FOREIGN KEY(c_id) references customer(c_id),
simcards_sold INT,
recharge_coupons_sold INT,
e_topups_sold INT
);

CREATE TABLE sim_cards
(
sim_id INT PRIMARY KEY AUTO_INCREMENT,
sim_name varchar(25) UNIQUE NOT NULL,
price INT NOT NULL,
description varchar(100) NOT NULL
);

CREATE TABLE retailer_inventory
(
r_id INT,
sim_id INT,
rc_id INT,
et_id INT,
FOREIGN KEY(r_id) references retailer(r_id),
FOREIGN KEY(sim_id) references sim_cards(sim_id),
FOREIGN KEY(rc_id) references recharge_coupons(rc_id),
FOREIGN KEY(et_id) references E_topups(et_id),
sim_quantity INT NOT NULL,
recharge_coupons_quantity INT NOT NULL,
E_topups_quantity INT NOT NULL
);

CREATE TABLE distributor_inventory
(
d_id INT,
sim_id INT,
rc_id INT,
et_id INT,
FOREIGN KEY(d_id) references distributor(d_id),
FOREIGN KEY(sim_id) references sim_cards(sim_id),
FOREIGN KEY(rc_id) references recharge_coupons(rc_id),
FOREIGN KEY(et_id) references E_topups(et_id),
sim_quantity INT NOT NULL,
recharge_coupons_quantity INT NOT NULL,
E_topups_quantity INT NOT NULL
);

CREATE TABLE E_topups
(
et_id INT PRIMARY KEY AUTO_INCREMENT,
et_name varchar(45) NOT NULL,
price INT NOT NULL,
et_description varchar(100)
);

CREATE TABLE recharge_coupons
(
rc_id INT PRIMARY KEY AUTO_INCREMENT,
rc_name varchar(45) NOT NULL,
price INT NOT NULL,
rc_description varchar(100)
);

CREATE TABLE retailer
(
r_id INT PRIMARY KEY AUTO_INCREMENT,
r_name varchar(30) NOT NULL,
area varchar(20) NOT NULL,
address varchar(50) NOT NULL
);

CREATE TABLE distributor
(
d_id INT PRIMARY KEY AUTO_INCREMENT,
d_name varchar(30) NOT NULL,
area varchar(20) NOT NULL,
address varchar(50) NOT NULL
);

CREATE TABLE retailer_distributor_mapping
(
r_id INT,
d_id INT,
FOREIGN KEY(r_id) references retailer_inventory(r_id),
FOREIGN KEY(d_id) references distributor_inventory(d_id)
);

CREATE TABLE distributor_sales_report
(
r_id INT,
d_id INT,
FOREIGN KEY(r_id) references distributor(d_id),
FOREIGN KEY(r_id) references retailer(r_id),
simcards_sold INT,
recharge_coupons_sold INT,
e_topups_sold INT
);


CREATE TABLE retailer_purchase_report
(
d_id INT,
r_id INT,
FOREIGN KEY(d_id) references retailer(r_id),
FOREIGN KEY(d_id) references distributor(d_id),
simcards_purchased INT,
recharge_coupons_purchased INT,
e_topups_purchased INT
);

CREATE TABLE customer
(
c_id INT PRIMARY KEY AUTO_INCREMENT,
c_name varchar(30) NOT NULL
);

insert into distributor(d_name,area,address) values('razorpay','ujjain','addr1');
insert into distributor(d_name,area,address) values('cartecop','ujjain','addr2');
insert into distributor(d_name,area,address) values('dotcorp','indore','addr3');
insert into distributor(d_name,area,address) values('caretech','bhopal','addr4');
insert into distributor(d_name,area,address) values('netmax','jabalpur','addr5');

insert into sim_cards(sim_name,price,description) values('AIRTEL',50,'Talktime unlimited 1 month');
insert into sim_cards(sim_name,price,description) values('JIO',90,'Talktime unlimited 1 month and 20GB NET');

insert into recharge_coupons(rc_name,price,rc_description) values('AIRTEL',10,'1 GB NET');
insert into recharge_coupons(rc_name,price,rc_description) values('JIO',20,'3 GB NET');

insert into E_topups(et_name,price,et_description) values('AIRTEL',79,'6 GB INTERNET WILL BE ADD ON CURRENT PLAN');
insert into E_topups(et_name,price,et_description) values('JIO',89,'9 GB INTERNET WILL BE ADD ON CURRENT PLAN');
