#   Proyecto TecnoStore.

        TecnoStore, Sistema de Venta de Celulares

        JUAN DAVID BARRERA TORRES

        S1

        DAVID DOMÍNGUEZ


        CAMPUSLANDS
        CAJASAN
        RUTA JAVA
        BUCARAMANGA
        2026

## Descripción del proyecto. 

La misión como desarrollador es crear un sistema de consola en Java que permita gestionar el catálogo de celulares, clientes, ventas y reportes, aplicando los principios de Programación Orientada a Objetos, colecciones, excepciones, persistencia y patrones de diseño.

## Caso De Estudio. 

La empresa TecnoStore es una tienda minorista dedicada a la venta de teléfonos celulares de diferentes marcas y gamas. Actualmente, desea automatizar el control de ventas, inventario y clientes, ya que todos los registros se manejan de forma manual en hojas de cálculo.

Con el fin de estructurar correctamente el desarrollo del sistema TecnoStore, en este proyecto se definieron una serie de objetivos específicos orientados a la gestión integral de celulares, clientes y ventas, lo que permite:

- Administrar celulares mediante operaciones de registro, actualización, eliminación y consulta, garantizando que cada dispositivo contenga información como id, marca, modelo, precio, stock, sistema operativo y gama, validando además que el precio y la cantidad en inventario sean valores positivos.

- Gestionar clientes almacenando datos esenciales como id, nombre, identificación, correo electrónico y teléfono, aplicando validaciones de formato y asegurando la unicidad del número de identificación.

- Registrar ventas asociando clientes con uno o varios celulares, calculando automáticamente el total incluyendo el IVA del 19%, actualizando el stock correspondiente y persistiendo la información en la base de datos mediante JDBC.

- Generar reportes y análisis desde consola, incluyendo celulares con stock bajo, el top 3 de dispositivos más vendidos y el resumen de ventas mensuales, utilizando Stream API y colecciones para el procesamiento de datos.

- Manejar la persistencia y archivos del sistema mediante la creación de reportes en archivos .txt y la gestión segura de excepciones utilizando try-with-resources.

- Aplicar buenas prácticas de diseño implementando principios SOLID, encapsulamiento, herencia y composición, además de al menos un patrón de diseño como Factory, Strategy o Singleton.

## Estructura de clases.
```
📁 src
└── main
    └── java
        ├── Controlador
        |   ├── GestionarCelulares.java
        |   ├── GestionarCelularesDAO.java
        |   ├── GestionClientes.java
        |   ├── GestionClientesDAO.java
        |   ├── GestionMarcas.java
        |   ├── GestionMarcasDAO.java
        |   ├── GestiónVentas.java
        |   └── GestiónVentasDAO.java
        ├── Modelo
        |   ├── celulares.java
        |   ├── clientes.java
        |   ├── detalle_ventas.java
        |   ├── Gama.java
        |   ├── Marca.java
        |   └── ventas.java
        └── Vista
            ├── MenuCelulares.java
            ├── MenuClientes.java
            ├── MenuMarcas.java
            ├── MenuVentas.java
            └── Proyecto_TecnoStore.java
```

## Ejemplo de ejecución. 

### Proyecto_TecnoStore (main).

Para iniciar el programa tendremos que dirigirnos a esta clase y ejecutarla (Solo ejecutar desde Proyecto_TecnoStore), para asegurarnos de que funcione tendremos que seleccionar todo el contenido de esta clase, click derecho y Run File (Esto desde Apache NetBeans). despues de haver echo todo esto aparecera el suigiente menu.

        ******************************
        1.   Gestionar Marcas.
        2.   Gestionar Celulares.
        3.   Gestionar Clientes.
        4.   Gestionar Ventas.
        5.   Salir.
        ******************************

apartir de aqui podremos seleccionar las opciones escribiendo un numero de los especificados y podremos operar y gestionar las diferentes propuestas del sistema. 

### MenuMarcas. 

Esta es una clase implementada al paquete Vista, el cual va a permitir operar todas las funciones o procesos de la clase marcas.

Se puede acceder al siguiente menu desde el menu principal ejecutandoe el programa, op 1. Gestionar Marcas.

        ******************************
                    MARCAS
        1.   Registrar.
        2.   Eliminar.
        3.   Listar.
        4.   Regresar.
        ******************************

#### Registrar:
MARCAS, op 1. Registrar.

        Ingrese el nombre de la marca:
        XIAOMI

#### Eliminar:
MARCAS, op 2. Eliminar.

        Ingrese el id de la marca a eliminar
        1

#### Listar:
MARCAS, op 3. Listar.

Se imprimiran todas las marcas registradas, de esta manera.

        Id:          2
        Nombre:      SAMSUNG

        Id:          4
        Nombre:      TECNO SPARCK

        Id:          5
        Nombre:      MOTOROLA

        Id:          6
        Nombre:      IPHONE

        Id:          7
        Nombre:      OPPO

        Id:          8
        Nombre:      XIAOMI

#### Regresar:
MARCAS, op 4. Regresar.

Devolvera al menu principal.

### MenuCelulares. 

Esta es una clase implementada al paquete Vista, el cual va a permitir operar todas las funciones o procesos de la clase celulares.

Se puede acceder al siguiente menu desde el menu principal ejecutandoe el programa, op 2. Gestionar Celulares.

        ******************************
                  CELULARES
        1.   Registrar.
        2.   Actualizar.
        3.   Eliminar.
        4.   Listar.
        5.   Buscar.
        6.   Regresar.
        ******************************

#### Registrar:
CELULARES, op 1. Registrar.

        Ingrese la marca del celular: 
        2
        Ingrese el modelo del celular:
        230 PRO MAX
        Ingrese el sistema operativo:
        ANDROID
        Ingrese el tipo de gama:
        ALTA
        Ingrese la cantidad del celular:
        32
        Ingrese el precio del celular:
        2540000
        
#### Actualizar:
CELULARES, op 2. Actualizar.

        Ingrese el id del celular a actualizar
        7
        
        CELULAR BUSCADO
        Id:          7
        Marca:       2
        Modelo:      230 PRO MAX
        SO:          ANDROID
        Gama:        ALTA
        Stock:       32 
        Precio:      2540000

        Ingrese lo quiere modificar
        1.   Stock
        2.   Precio

        2
        Ingrese el nuevo precio
        2600000        

#### Eliminar:
CELULARES, op 3. Eliminar.

        Ingrese el id del celular a eliminar
        3

#### Listar:
CELULARES, op 4. Listar.

Se imprimiran todos los celulares de esta manera.

        Id:          2
        Marca:       2
        Modelo:      GALAXY A22
        SO:          ANDROID
        Gama:        MEDIA
        Stock:       2
        Precio:      533000

        Id:          4
        Marca:       6
        Modelo:      IPHONE 17 PRO MAX
        SO:          APPLE
        Gama:        ALTA
        Stock:       10
        Precio:      2000000

        Id:          7
        Marca:       2
        Modelo:      230 PRO MAX
        SO:          ANDROID
        Gama:        ALTA
        Stock:       32
        Precio:      2600000

#### Buscar:
CELULARES, op 5. Buscar.

        Ingrese el id del celular a buscar
        2

#### Regresar:
CELULARES, op 6. Regresar.

Devolvera al menu principal.

### MenuClientes. 

Esta es una clase implementada al paquete Vista, el cual va a permitir operar todas las funciones o procesos de la clase clientes.

Se puede acceder al siguiente menu desde el menu principal ejecutandoe el programa, op 3. Gestionar Clientes.

        ******************************
                  CLIENTES
        1.   Registrar.
        2.   Actualizar.
        3.   Eliminar.
        4.   Listar.
        5.   Buscar.
        6.   Regresar.
        ******************************

#### Registrar:
CLIENTES, op 1. Registrar.

        Ingrese el nombre del cliente: 
        JHON DOE
        Ingrese la identificacion del cliente:
        109692663
        Ingrese el correo del cliente:
        jhondoe@gmail.com
        Ingrese el telefono del cliente:
        3142672773
        
#### Actualizar:
CLIENTES, op 2. Actualizar.

        Ingrese el id del cliente a actualizar
        7

        CLIENTE BUSCADO
        Id:              7
        Nombre:          JHON DOE
        Identificacion:  109692663
        Correo:          jhondoe@gmail.com
        Telefono:        3142672773

        Ingrese lo quiere modificar
        1.   Nombre
        2.   Identificacion
        3.   Correo
        4.   Telefono

        3
        Ingrese el nuevo correo
        jhondoe456@gmail.com       

#### Eliminar:
CLIENTES, op 3. Eliminar.

        Ingrese el id del cliente a eliminar
        3

#### Listar:
CLIENTES, op 4. Listar.

Se imprimiran todos los clientes de esta manera.

        Id:              2
        Nombre:          JUAN DAVID
        Identificacion:  271378
        Correo:          TOTUDS
        Telefono:        372823

        Id:              6
        Nombre:          ESTEBAN
        Identificacion:  127272
        Correo:          ISHIXUSHS
        Telefono:        21893920

        Id:              7
        Nombre:          JHON DOE
        Identificacion:  109692663
        Correo:          jhondoe456@gmail.com
        Telefono:        3142672773

#### Buscar:
CLIENTES, op 5. Buscar.

        Ingrese el id del cliente a buscar
        2

#### Regresar:
CLIENTES, op 6. Regresar.

Devolvera al menu principal.

### MenuVentas. 

Esta es una clase implementada al paquete Vista, el cual va a permitir operar todas las funciones o procesos de la clase ventas y detalle_ventas.

Se puede acceder al siguiente menu desde el menu principal ejecutandoe el programa, op 4. Gestionar Ventas.

        ******************************
                    VENTAS
        1.   Registrar.
        2.   Ver reportes y análisis.
        3.   Regresar.
        ******************************

#### Registrar:
VENTAS, op 1. Registrar.

        Ingrese el id del cliente: 
        7
        Ingrese la fecha (YYYY-MM-DD): 
        26-02-10

        Ingrese el id del celular vendido:
        7

        Ingrese la cantidad vendida:
        2

        Stock actualizado. Nuevo stock: 30
        Conexion exitosa

        Detalle de venta guardado con éxito.
        Proceso de venta completado con éxito.
        
#### Actualizar:
VENTAS, op 2. Ver reportes y análisis.

En esta opcion se encontrara el siguiente menu que correspondiente a sus funciones integradas.

        ******************************
              REPORTES Y ANALISIS
        1.   Reporte de ventas.
        2.   Celulares con stock bajo.
        3.   Celulares más vendidos.
        4.   Ventas totales por mes.
        5.   Regresar.
        ******************************

#### Regresar:
REPORTES Y ANALISIS, op 1. Reporte de ventas.

        Venta ID: 16 | Cliente: 3 | Fecha: 2026-11-14 | Total: 600000.0
        Celular ID: 3 | Modelo: 20 PRO | Cantidad: 1 | IVA aplicado: 19% | Subtotal: 714000.0

        Venta ID: 17 | Cliente: 7 | Fecha: 2026-02-10 | Total: 5200000.0
        Celular ID: 7 | Modelo: 230 PRO MAX | Cantidad: 2 | IVA aplicado: 19% | Subtotal: 6188000.0

#### Regresar:
REPORTES Y ANALISIS, op 2. Celulares con stock bajo.

        Id:          2
        Marca:       2
        Modelo:      GALAXY A22
        SO:          ANDROID
        Gama:        MEDIA
        Stock:       2
        Precio:      533000

        Id:          3
        Marca:       4
        Modelo:      20 PRO
        SO:          ANDROID
        Gama:        MEDIA
        Stock:       0
        Precio:      600000

#### Regresar:
REPORTES Y ANALISIS, op 3. Celulares más vendidos.

        IPHONE 17 PRO MAX - Vendidos: 12
        GALAXY A22 - Vendidos: 6

#### Regresar:
REPORTES Y ANALISIS, op 4. Ventas totales por mes.

        2026-10 -> 44.000.000
        2026-11 -> 11.300.000
        2026-12 -> 10.000.000
        2026-02 -> 5.200.000
        2016-08 -> 5.000.000
        2013-09 -> 5.000.000
        2026-09 -> 14.600.000

#### Regresar:
REPORTES Y ANALISIS, op 5. Regresar.

Devolvera al MenuVentas.

#### Regresar:
VENTAS, op 3. Regresar.

Devolvera al Menu principal.

## Indicaciones para conexión MySQL.

### Gráfica.

![](https://drive.google.com/file/d/1E0NEXEw5c1dBgRNahPEDh0DigC91P95X/view?usp=drive_link)

### Resumen de la Base de Datos

La base de datos del sistema TecnoStore está diseñada bajo un modelo relacional orientado a la gestión de inventario, clientes y ventas de dispositivos móviles. Se compone de cinco tablas principales: Marcas, Celulares, Clientes, Ventas y Detalle_ventas, las cuales permiten organizar la información de forma estructurada y mantener la integridad de los datos.

#### Marcas

Almacena las diferentes marcas de celulares disponibles en el sistema.
Cada marca posee un identificador único y un nombre, y se relaciona directamente con la tabla Celulares, permitiendo clasificar los dispositivos según su fabricante.

#### Celulares

Contiene la información de los dispositivos móviles registrados, incluyendo modelo, sistema operativo, gama, stock y precio.
Cada celular está asociado a una marca mediante una clave foránea, lo que facilita la organización del inventario.

#### Clientes

Registra los datos de los usuarios que realizan compras dentro del sistema.
Incluye información básica como nombre, identificación, correo electrónico y teléfono, permitiendo llevar un control de las transacciones realizadas por cada cliente.

#### Ventas

Representa las transacciones realizadas en el sistema.
Cada venta está vinculada a un cliente y almacena la fecha y el total de la compra, funcionando como entidad principal para el historial de operaciones.

#### Detalle_ventas

Permite desglosar cada venta en los celulares adquiridos, incluyendo cantidad y subtotal.
Esta tabla actúa como intermediaria entre Ventas y Celulares, resolviendo la relación muchos a muchos entre ambas entidades.

### Creación de base de datos

Es muy importante tener cuidado con el orden de las tablas, pues algunas de estas pueden estar establecidas por dependecias de otras tablas. la creación y el orden de la base de datos del proyecto TecnoStore es la siguiente:


```sql
CREATE DATABASE tecnostore_db;
USE tecnostore_db;

-- Tabla Marca
CREATE TABLE Marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla Celulares
CREATE TABLE Celulares (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_marca INT NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    sistema_operativo VARCHAR(50),
    gama ENUM('BAJA','MEDIA','ALTA') NOT NULL,
    stock INT NOT NULL,
    precio INT NOT NULL,
    FOREIGN KEY (id_marca) REFERENCES Marcas(id)
);

-- Tabla Clientes
CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(50) NOT NULL,
    correo VARCHAR(100),
    telefono VARCHAR(20)
);

-- Tabla Ventas
CREATE TABLE Ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATE NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
);

-- Tabla Detalle_Ventas
CREATE TABLE Detalle_Ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DOUBLE NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES Ventas(id),
    FOREIGN KEY (id_celular) REFERENCES Celulares(id)
);

```

### Inserción de datos de prueba

```sql

INSERT INTO marcas (id, nombre) VALUES
(1, 'Samsung'),
(2, 'Apple'),
(3, 'Xiaomi'),
(4, 'Motorola');

INSERT INTO celulares (id, id_marca, modelo, sistema_operativo, gama, stock, precio) VALUES
(1, 1, 'Galaxy S25', 'Android', 'ALTA', 10, 2200000),
(2, 2, 'iPhone 16', 'iOS', 'ALTA', 8, 4500000),
(3, 3, 'Redmi Note 13', 'Android', 'MEDIA', 15, 1200000),
(4, 4, 'Moto G100', 'Android', 'MEDIA', 12, 1500000),
(5, 3, 'Redmi A3', 'Android', 'BAJA', 20, 600000);

INSERT INTO clientes (id, nombre, identificacion, correo) VALUES
(1, 'Juan Pérez', '123456789', 'juanperez@mail.com'),
(2, 'María Gómez', '987654321', 'maria.gomez@mail.com'),
(3, 'Carlos López', '112233445', 'carlos.lopez@mail.com'),
(4, 'Ana Torres', '556677889', 'ana.torres@mail.com');

INSERT INTO ventas (id, id_cliente, fecha, total) VALUES
(1, 1, '2026-02-01', 4400000), 
(2, 2, '2026-02-02', 4500000), 
(3, 3, '2026-02-03', 2400000),
(4, 4, '2026-02-04', 600000);

INSERT INTO detalle_ventas (id, id_venta, id_celular, cantidad, subtotal) VALUES
(1, 1, 1, 2, 4400000),
(2, 2, 2, 1, 4500000),
(3, 3, 3, 2, 2400000),
(4, 4, 5, 1, 600000);

```