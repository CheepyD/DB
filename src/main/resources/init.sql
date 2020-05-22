START TRANSACTION;
USE `vehicle_shop`;
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (1, 'Rover');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (2, 'Sedan');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (3, 'Pickup');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (4, 'Hatchback');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (5, 'Bike');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (6, 'Motorbike');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (7, 'Gyroboard');
INSERT IGNORE INTO `vehicle_shop`.`categories` (`category_id`, `category_name`) VALUES (8, 'Rollers');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vehicle_shop`.`shops`
-- -----------------------------------------------------
START TRANSACTION;
USE `vehicle_shop`;
INSERT IGNORE INTO `vehicle_shop`.`shops` (`shop_id`, `address`) VALUES (1, 'Donetsk, Sumskaya st, 74');
INSERT IGNORE INTO `vehicle_shop`.`shops` (`shop_id`, `address`) VALUES (2, 'Zaporojhye, Chernyshevsoho st., 43');
INSERT IGNORE INTO `vehicle_shop`.`shops` (`shop_id`, `address`) VALUES (3, 'Rivne, Molochnaya st., 42');
INSERT IGNORE INTO `vehicle_shop`.`shops` (`shop_id`, `address`) VALUES (4, 'Kharkiv, Sydorenkivska st., 55');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vehicle_shop`.`products`
-- -----------------------------------------------------
START TRANSACTION;
USE `vehicle_shop`;
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (1, 'Toyota Camry', 600000, 2);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (2, 'Ego Electro', 10000, 1);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (3, 'Tesla Cybertruck', 800000, 3);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (4, 'Ford Pickup', 450000, 3);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (5, 'Opel Vectra', 120000, 4);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (6, 'Skoda Octavia', 610000, 4);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (7, 'GT MTB', 30000, 5);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (8, 'GHOST MTB', 25000, 5);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (9, 'Kawasaki Z1150', 350000, 6);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (10, 'ExpertMove', 150000, 7);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (11, 'Trust Me', 4000, 8);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (12, 'Fort MTB', 15000, 5);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (13, 'Raptor MTB', 7500, 5);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (14 , 'Suzuki R1000', 325000, 6);
INSERT IGNORE INTO `vehicle_shop`.`products` (`product_id`, `name`, `cost`, `category_id`) VALUES (15, 'Hyundai Elantra', 750000, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vehicle_shop`.`shops_has_products`
-- -----------------------------------------------------
START TRANSACTION;
USE `vehicle_shop`;
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (1, 1);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (1, 2);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (1, 3);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (1, 5);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (1, 8);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 1);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 2);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 10);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 11);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 9);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 7);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (3, 6);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (3, 7);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (3, 8);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (3, 4);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (3, 2);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 3);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 4);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (1, 10);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (2, 5);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (4, 11);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (4, 12);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (4, 13);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (4, 14);
INSERT IGNORE INTO `vehicle_shop`.`shops_has_products` (`shop_id`, `product_id`) VALUES (4, 15);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vehicle_shop`.`description`
-- -----------------------------------------------------
START TRANSACTION;
USE `vehicle_shop`;
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (1, 'Japan', 'Premium class', 1);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (2, 'China', 'Fast,durable', 2);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (3, 'USA', 'IT IS A TESLA, COME ON', 3);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (4, 'USA', 'Business class auto v8', 4);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (5, 'Germany', 'Business class auto 1.2l', 5);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (6, 'Germany', 'Comfortable class auto', 6);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (7, 'USA', 'MTB , 24" 11 speeds(new carret)', 7);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (8, 'Ukraine', 'MTB , 22" 27 speeds(old carret)', 8);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (9, 'Japan', 'Fast & furious', 9);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (10, 'Ukraine', 'Comfortable for city riding', 10);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (11, 'Ukraine', 'Roller for true rollers', 11);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (12, 'Ukraine', 'Common MTB', 12);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (13, 'Ukraine', 'Newest model', 13);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (14, 'Ukraine', 'Not so fast & furious', 14);
INSERT IGNORE INTO `vehicle_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`) VALUES (15, 'South Korea', 'Comfortable class auto', 15);

COMMIT;
