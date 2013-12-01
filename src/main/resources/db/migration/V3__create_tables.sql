create table inventories(
  id int not null auto_increment,
  total_item int default 0,
  inventory_name varchar(256) default '',
  address varchar(256) default '',
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id)
);

create table users(
  id int not null auto_increment,
  first_name varchar(256) default '',
  last_name varchar(256) default '',
  user_name varchar(256) default '',
  password varchar(256) default '',
  address varchar(256) default '',
  inventory_id int,
  shopping_cart_id int,
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY(inventory_id) REFERENCES inventories(id)
);

create table managers(
  id int not null,
  inventory_id int,
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES users(id),
  FOREIGN KEY(inventory_id) REFERENCES inventories(id)
);

create table shopping_carts(
  id int not null auto_increment,
  total_price float default 0.0,
  user_id int,
  quantity int default 0,
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);

create table items(
  id int not null auto_increment,
  item_name varchar(256),
  description varchar(256) default '',
  quantity int default 0,
  price float default 0,
  rating int(2) SIGNED default 0,
  api_id int(10)DEFAULT NULL,
  release_date varchar(256) default 'CURRENT_TIMESTAMP',
  deck varchar(256) default '',
  api_detail_url varchar(256) default '',
  inventory_id int,
  item_type enum('game','console'),
  creation_date timestamp DEFAULT CURRENT_TIMESTAMP,
  last_modified_date timestamp DEFAULT '0000-00-00 00:00:00',
  etag varchar(256),
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY(inventory_id) REFERENCES inventories(id) ON DELETE CASCADE
);

create table items_shopping_carts(
  shopping_cart_id int not null REFERENCES shopping_carts(id),
	item_id int not null REFERENCES items(id),
	PRIMARY KEY(item_id,shopping_cart_id)
);

create table users_items(
  user_id int not null REFERENCES users(id),
	item_id int not null REFERENCES items(id),
	PRIMARY KEY(user_id,item_id)
);

create table orders(
  id int not null auto_increment,
  status varchar(256) default '',
  order_date timestamp default '0000-00-00 00:00:00',
  shopping_cart_id int,
  user_id int,
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY(shopping_cart_id) REFERENCES shopping_carts(id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);

create table managers_orders(
  manager_id int not null REFERENCES managers(id),
	order_id int not null REFERENCES orders(id),
	PRIMARY KEY(manager_id,order_id)
);

create table credit_cards(
  id int not null auto_increment,
  cc_number varchar(20) default '',
  user_id int,
  PRIMARY KEY (id),
  etag varchar(256) default '',
  semaphore int(1) default 0,
  FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

create table payments(
  id int not null auto_increment,
  amount int default 0,
  user_id int,
  order_id int,
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(order_id) REFERENCES orders(id)
);

create table receipts(
  id int not null auto_increment,
  receipt_date timestamp default '0000-00-00 00:00:00',
  amount int default 0,
  payment_id int,
  user_id int,
  etag varchar(256) default '',
  semaphore int(1) default 0,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);

Alter table users add FOREIGN KEY(shopping_cart_id) REFERENCES shopping_carts(id);


