create table inventories(
  id int not null auto_increment,
  total_item int,
  inventory_name varchar(256),
  address varchar(256),
  PRIMARY KEY (id)
);

create table users(
  id int not null auto_increment,
  first_name varchar(256),
  last_name varchar(256),
  username varchar(256),
  password varchar(256),
  address varchar(256),
  inventory_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(inventory_id) REFERENCES inventories(id)
);

create table managers(
  id int not null auto_increment,
  inventory_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES users(id),
  FOREIGN KEY(inventory_id) REFERENCES inventories(id)
);

create table shopping_carts(
  id int not null auto_increment,
  total_price int,
  user_id int,
  quantity int,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);

create table items(
  id int not null auto_increment,
  item_name varchar(256),
  description varchar(256),
  price int,
  inventory_id int,
  shopping_cart_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(inventory_id) REFERENCES inventories(id) ON DELETE CASCADE,
  FOREIGN KEY(shopping_cart_id) REFERENCES shopping_carts(id)
);

create table users_items(
  user_id int not null REFERENCES users(id),
	item_id int not null REFERENCES items(id),
	PRIMARY KEY(user_id,item_id)
);

create table orders(
  id int not null auto_increment,
  status varchar(256),
  order_date timestamp default '0000-00-00 00:00:00',
  shopping_cart_id int,
  user_id int,
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
  cc_number int,
  user_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

create table payments(
  id int not null auto_increment,
  amount int,
  user_id int,
  order_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(order_id) REFERENCES orders(id)
);

create table receipts(
  id int not null auto_increment,
  receipt_date timestamp default '0000-00-00 00:00:00',
  amount int,
  payment_id int,
  user_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);
