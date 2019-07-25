INSERT INTO customer (id, name) values (101,'Dheeraj');
INSERT INTO customer (id, name) values (102,'Vishal');

INSERT INTO customer_type (id, name) values (1,'regular');
INSERT INTO customer_type (id, name) values (2,'premium');

INSERT INTO customer_type_mapping (id, customer_id, customer_type_id) values (1,101,1);
INSERT INTO customer_type_mapping (id, customer_id, customer_type_id) values (2,102,2);

INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (1,1,0,5000,0);
INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (2,1,5000,10000,10);
INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (3,1,10000,null,20);

INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (4,2,0,4000,10);
INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (5,2,4000,8000,15);
INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (6,2,8000,12000,20);
INSERT INTO discount_slab (id, customer_type_id, min_amount, max_amount, discount) values (7,2,12000,null,30);