-- Creation of the `tb_customers` table
CREATE TABLE IF NOT EXISTS `tb_customers` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    `rg` varchar(30) DEFAULT NULL,
    `cpf` varchar(20) DEFAULT NULL,
    `email` varchar(200) DEFAULT NULL,
    `landline` varchar(30) DEFAULT NULL,
    `phone` varchar(30) DEFAULT NULL,
    `cep` varchar(100) DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,
    `number` int(11) DEFAULT NULL,
    `complement` varchar(200) DEFAULT NULL,
    `district` varchar(100) DEFAULT NULL,
    `city` varchar(100) DEFAULT NULL,
    `state` varchar(2) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_suppliers` table
CREATE TABLE IF NOT EXISTS `tb_suppliers` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    `cnpj` varchar(100) DEFAULT NULL,
    `email` varchar(200) DEFAULT NULL,
    `landline` varchar(30) DEFAULT NULL,
    `phone` varchar(30) DEFAULT NULL,
    `cep` varchar(100) DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,
    `number` int(11) DEFAULT NULL,
    `complement` varchar(200) DEFAULT NULL,
    `district` varchar(100) DEFAULT NULL,
    `city` varchar(100) DEFAULT NULL,
    `state` varchar(2) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_products` table
CREATE TABLE IF NOT EXISTS `tb_products` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `product` varchar(100) DEFAULT NULL,
    `price` decimal(10,2) DEFAULT NULL,
    `stock_qty` int(11) DEFAULT NULL,
    `for_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `tb_products_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_suppliers` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_sales` table
CREATE TABLE IF NOT EXISTS `tb_sales` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `client_id` int(11) DEFAULT NULL,
    `sale_date` datetime DEFAULT NULL,
    `total_sale` decimal(10,2) DEFAULT NULL,
    `note` text DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `tb_sales_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `tb_customers` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_itemssales` table
CREATE TABLE IF NOT EXISTS `tb_itemssales` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `sale_id` int(11) DEFAULT NULL,
    `product_id` int(11) DEFAULT NULL,
    `qty` int(11) DEFAULT NULL,
    `subtotal` decimal(10,2) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `tb_itemssales_ibfk_1` FOREIGN KEY (`sale_id`) REFERENCES `tb_sales` (`id`),
    CONSTRAINT `tb_itemssales_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tb_products` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_pets` table
CREATE TABLE IF NOT EXISTS `tb_pets` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `pet_name` varchar(50) DEFAULT NULL,
    `gender` varchar(5) DEFAULT NULL,
    `birth` date DEFAULT NULL,
    `pet_weight` decimal(10,2) DEFAULT NULL,
    `species` varchar(50) DEFAULT NULL,
    `breed` varchar(50) DEFAULT NULL,
    `for_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `tb_pets_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_customers` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_services` table
CREATE TABLE IF NOT EXISTS `tb_services` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `service_name` varchar(255) DEFAULT NULL,
    `service_description` varchar(255) DEFAULT NULL,
    `price_large` decimal(10,2) DEFAULT NULL,
    `price_medium` decimal(10,2) DEFAULT NULL,
    `price_small` decimal(10,2) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_service_schedules` table
CREATE TABLE IF NOT EXISTS `tb_service_schedules` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `for_id` int(11) DEFAULT NULL,
    `for_pet` int(11) DEFAULT NULL,
    `service_id` int(11) DEFAULT NULL,
    `date` date DEFAULT NULL,
    `time` time DEFAULT NULL,
    `status` varchar(255) DEFAULT NULL,
    `total_value` decimal(10,2) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `tb_service_schedules_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_customers` (`id`),
    CONSTRAINT `tb_service_schedules_ibfk_2` FOREIGN KEY (`for_pet`) REFERENCES `tb_pets` (`id`),
    CONSTRAINT `tb_service_schedules_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `tb_services` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Creation of the `tb_employees` table
CREATE TABLE IF NOT EXISTS `tb_employees` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    `rg` varchar(30) DEFAULT NULL,
    `cpf` varchar(20) DEFAULT NULL,
    `email` varchar(200) DEFAULT NULL,
    `password` varchar(60) DEFAULT NULL,
    `responsibility` varchar(100) DEFAULT NULL,
    `access_level` varchar(50) DEFAULT NULL,
    `landline` varchar(30) DEFAULT NULL,
    `phone` varchar(30) DEFAULT NULL,
    `cep` varchar(100) DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,
    `number` int(11) DEFAULT NULL,
    `complement` varchar(200) DEFAULT NULL,
    `district` varchar(100) DEFAULT NULL,
    `city` varchar(100) DEFAULT NULL,
    `state` varchar(2) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insertion of data into the `tb_employees` table
INSERT INTO `tb_employees` (`id`, `name`, `rg`, `cpf`, `email`, `password`, `responsibility`, `access_level`, `landline`, `phone`, `cep`, `address`, `number`, `complement`, `district`, `city`, `state`) VALUES
(1, 'Administrador', '12.345.678-90', '123.456.789-00', 'admin@admin.com', '$2a$10$alRUaw4fcUqb5eVHEoI2BuzojOpW2EA1trOd0cHznsAWZum1o6Ehu', 'Admin', 'Administrador', '(  )     -    ', '(12) 31231 - 2312', '00000-000', 'Sem Endereço', 0, '', 'Sem Bairro', 'Sem Cidade', 'BA'),
(2, 'Vendedor', '12.345.678-90', '123.456.789-00', 'vendedor@vendedor.com', '$2a$10$UoKx7MtqJw4OYMHiQ9R3CekXfkfX.iGMvpag4.BUeISgD4Vba9Y/W', 'Vendedor', 'Vendedor', '(  )     -    ', '(12) 34567 - 8900', '00000-000', 'Sem Endereco', 0, '', 'Sem Bairro', 'Sem Cidade', 'BA'),
(3, 'Veterinario', '12.345.678-90', '123.456.789-00', 'veterinario@veterinario.com', '$2a$10$8SMIlG56xE3Zp4pX5Mf/vunwRH8ibEzZR7lyD4AnuDx2h5czvY5Ea', 'Veterinario', 'Veterinario', '(  )     -    ', '(12) 30000 - 0000', '00000-000', 'Sem Endereço', 0, '', 'Sem Bairro', 'Sem Cidade', 'BA');