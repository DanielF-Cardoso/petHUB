<p align="center">
  <img src="https://i.imgur.com/JXyyAti.png" alt="petHUB">
</p>

## Description

petHUB is a pet shop manager designed to facilitate sales and vaccine management for a pet shop.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![Flyway Badge](https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=fff&style=for-the-badge)

## Features

- Customer management
- Animal management
- Vaccine management
- Sales management
- Product management
- Supplier management
- Employee management with access levels
- Generation of reports and sales orders
- Animal record with all registered vaccines

## External Packages

- [ViaCEP](https://gitlab.com/parg/ViaCEP) - Library for querying Brazilian ZIP codes using the ViaCEP API (https://viacep.com.br/)

## Screenshots

<div align="center">

| Login | Dashboard |
| --- | --- |
| <img src="https://i.imgur.com/7jgRrmE.png" width="410" height="200" /> | <img src="https://i.imgur.com/ZoDNkZd.png" width="410" height="200" /> |

| Customer Registration | Pet Registration |
| --- | --- |
| <img src="https://i.imgur.com/g4d3ifI.png" width="410" height="200" /> | <img src="https://i.imgur.com/ztUzGoP.png" width="410" height="200" /> |

| Employee Registration | Supplier Registration |
| --- | --- |
| <img src="https://i.imgur.com/azLimIr.png" width="410" height="200" /> | <img src="https://i.imgur.com/lVr8fXu.png" width="410" height="200" /> |

| Product Registration | Stock Control |
| --- | --- |
| <img src="https://i.imgur.com/d5iZf2i.png" width="410" height="200" /> | <img src="https://i.imgur.com/4PcNczU.png" width="410" height="200" /> |

| Service Schedule | Service Registration |
|----------------------------------------------------------------------|----------------------------------------------------------------------|
| <img src="https://i.imgur.com/tjYihKK.png" width="410" height="200" /> | <img src="https://i.imgur.com/c8xttFO.png" width="410" height="200" /> |

| Vaccine Control | Sales Screen |
| --- | --- |
| <img src="https://i.imgur.com/tdSff3N.png" width="410" height="200" /> | <img src="https://i.imgur.com/cRSas9n.png" width="410" height="200" /> |

| Total Sales | Sales History |
| --- | --- |
| <img src="https://i.imgur.com/zUTUt8b.png" width="410" height="200" /> | <img src="https://i.imgur.com/9roCAxs.png" width="410" height="200" /> |

</div>

## Logins

### Administrator (Full Access)
- **Username:** admin@admin.com
- **Password:** 123

### Salesperson
- **Access:** Customer, Animal, Product, and Service Registration, Service Schedule, Open POS
- **Username:** vendedor@vendedor.com
- **Password:** 123

### Veterinarian
- **Access:** Customer, Animal, Product, and Service Registration, Service Schedule, Generate Animal Record, Vaccine Registration
- **Username:** veterinario@veterinario.com
- **Password:** 123

## Documentation

All Javadoc documentation can be accessed via this link: [petHUB Documentation](https://danielf-cardoso.github.io/petHUB/)

## Installation

Before you start, ensure you have Java 17/22 and Apache Maven installed on your computer. If not, download and install them from the official websites.

1. **Database Configuration**
    - Rename the `config.properties.example` file inside the `resources` folder to `config.properties`.
    - Edit the file with your database information.

2. **Database Migration**
    - Execute the `FlywayMigration` inside the `br.com.pethub.jdbc` package to migrate the database.

3. **Running the Project**
    - In the project's root directory, execute the following Maven commands to clean and package the project:
      ```sh
      mvn clean package
      ```
    - The above command will generate a `petHUB-1.0-SNAPSHOT.jar` file in the `target` folder.

4. **Starting the Application**
    - Execute the generated `petHUB-1.0-SNAPSHOT.jar` file, which will include all necessary dependencies:
      ```sh
      java -jar target/petHUB-1.0-SNAPSHOT.jar
      ```
