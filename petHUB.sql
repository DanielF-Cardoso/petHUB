-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 190.115.196.66
-- Generation Time: 14-Jun-2024 às 12:58
-- Versão do servidor: 11.3.2-MariaDB-1:11.3.2+maria~ubu2204
-- PHP Version: 5.6.40-0+deb8u12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `s3_privado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_customers`
--

CREATE TABLE `tb_customers` (
  `id` int(11) NOT NULL,
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
  `state` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_employees`
--

CREATE TABLE `tb_employees` (
  `id` int(11) NOT NULL,
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
  `state` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `tb_employees`
--

INSERT INTO `tb_employees` (`id`, `name`, `rg`, `cpf`, `email`, `password`, `responsibility`, `access_level`, `landline`, `phone`, `cep`, `address`, `number`, `complement`, `district`, `city`, `state`) VALUES
(1, 'Administrador', '12.345.678-90', '123.456.789-00', 'admin@admin.com', '$2a$10$alRUaw4fcUqb5eVHEoI2BuzojOpW2EA1trOd0cHznsAWZum1o6Ehu', 'Admin', 'Administrador', '(  )     -    ', '(12) 31231 - 2312', '00000-000', 'Sem Endereço', 0, '', 'Sem Bairro', 'Sem Cidade', 'BA'),
(2, 'Vendedor', '12.345.678-90', '123.456.789-00', 'vendedor@vendedor.com', '$2a$10$UoKx7MtqJw4OYMHiQ9R3CekXfkfX.iGMvpag4.BUeISgD4Vba9Y/W', 'Vendedor', 'Vendedor', '(  )     -    ', '(12) 34567 - 8900', '00000-000', 'Sem Endereco', 0, '', 'Sem Bairro', 'Sem Cidade', 'BA'),
(3, 'Veterinario', '12.345.678-90', '123.456.789-00', 'veterinario@veterinario.com', '$2a$10$8n90TVl87bIfImgVGWr8z.5vredmmNoBqledFPMlM9ESiJGq1P4sS', 'Veterinario', 'Veterinário', '(  )     -    ', '(12) 34567 - 8900', '00000-000', 'SEM ENDERECO', 0, '', 'SEM BAIRRO', 'SEM CIDADE', 'BA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_itemssales`
--

CREATE TABLE `tb_itemssales` (
  `id` int(11) NOT NULL,
  `sale_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pets`
--

CREATE TABLE `tb_pets` (
  `id` int(11) NOT NULL,
  `pet_name` varchar(50) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `pet_weight` decimal(10,2) DEFAULT NULL,
  `species` varchar(50) DEFAULT NULL,
  `breed` varchar(50) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_products`
--

CREATE TABLE `tb_products` (
  `id` int(11) NOT NULL,
  `product` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `stock_qty` int(11) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_sales`
--

CREATE TABLE `tb_sales` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `total_sale` decimal(10,2) DEFAULT NULL,
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_services`
--

CREATE TABLE `tb_services` (
  `id` int(11) NOT NULL,
  `service_name` varchar(255) DEFAULT NULL,
  `service_description` varchar(255) DEFAULT NULL,
  `price_large` decimal(10,2) DEFAULT NULL,
  `price_medium` decimal(10,2) DEFAULT NULL,
  `price_small` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_service_schedules`
--

CREATE TABLE `tb_service_schedules` (
  `id` int(11) NOT NULL,
  `for_id` int(11) DEFAULT NULL,
  `for_pet` int(11) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_value` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_suppliers`
--

CREATE TABLE `tb_suppliers` (
  `id` int(11) NOT NULL,
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
  `state` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_vaccines`
--

CREATE TABLE `tb_vaccines` (
  `id` int(11) NOT NULL,
  `vaccine_name` varchar(50) DEFAULT NULL,
  `vaccine_application` date DEFAULT NULL,
  `vaccine_expiration` date DEFAULT NULL,
  `note` text DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL,
  `for_pet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_customers`
--
ALTER TABLE `tb_customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_employees`
--
ALTER TABLE `tb_employees`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_itemssales`
--
ALTER TABLE `tb_itemssales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sale_id` (`sale_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `tb_pets`
--
ALTER TABLE `tb_pets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`);

--
-- Indexes for table `tb_products`
--
ALTER TABLE `tb_products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`);

--
-- Indexes for table `tb_sales`
--
ALTER TABLE `tb_sales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `tb_services`
--
ALTER TABLE `tb_services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_service_schedules`
--
ALTER TABLE `tb_service_schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`),
  ADD KEY `for_pet` (`for_pet`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `tb_suppliers`
--
ALTER TABLE `tb_suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_vaccines`
--
ALTER TABLE `tb_vaccines`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`),
  ADD KEY `for_pet` (`for_pet`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_customers`
--
ALTER TABLE `tb_customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_employees`
--
ALTER TABLE `tb_employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_itemssales`
--
ALTER TABLE `tb_itemssales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_pets`
--
ALTER TABLE `tb_pets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_products`
--
ALTER TABLE `tb_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_sales`
--
ALTER TABLE `tb_sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_services`
--
ALTER TABLE `tb_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_service_schedules`
--
ALTER TABLE `tb_service_schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_suppliers`
--
ALTER TABLE `tb_suppliers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `tb_vaccines`
--
ALTER TABLE `tb_vaccines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_itemssales`
--
ALTER TABLE `tb_itemssales`
  ADD CONSTRAINT `tb_itemssales_ibfk_1` FOREIGN KEY (`sale_id`) REFERENCES `tb_sales` (`id`),
  ADD CONSTRAINT `tb_itemssales_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tb_products` (`id`);

--
-- Limitadores para a tabela `tb_pets`
--
ALTER TABLE `tb_pets`
  ADD CONSTRAINT `tb_pets_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_customers` (`id`);

--
-- Limitadores para a tabela `tb_products`
--
ALTER TABLE `tb_products`
  ADD CONSTRAINT `tb_products_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_suppliers` (`id`);

--
-- Limitadores para a tabela `tb_sales`
--
ALTER TABLE `tb_sales`
  ADD CONSTRAINT `tb_sales_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `tb_customers` (`id`);

--
-- Limitadores para a tabela `tb_service_schedules`
--
ALTER TABLE `tb_service_schedules`
  ADD CONSTRAINT `tb_service_schedules_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_customers` (`id`),
  ADD CONSTRAINT `tb_service_schedules_ibfk_2` FOREIGN KEY (`for_pet`) REFERENCES `tb_pets` (`id`),
  ADD CONSTRAINT `tb_service_schedules_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `tb_services` (`id`);

--
-- Limitadores para a tabela `tb_vaccines`
--
ALTER TABLE `tb_vaccines`
  ADD CONSTRAINT `tb_vaccines_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_customers` (`id`),
  ADD CONSTRAINT `tb_vaccines_ibfk_2` FOREIGN KEY (`for_pet`) REFERENCES `tb_pets` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
