CREATE TABLE categorias (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE proveedores (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    correo VARCHAR(100),
    direccion VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE libros (
    id INTEGER NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(100) NOT NULL UNIQUE,
    editorial VARCHAR(100),
    anio_publicacion INTEGER,
    cantidad_disponible INTEGER NOT NULL,
    cantidad_total INTEGER NOT NULL,
    categoria_id INTEGER NOT NULL,
    proveedor_id INTEGER,
    estado VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);

CREATE TABLE socios (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    rut VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    tipo_socio VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE prestamos (
    id INTEGER NOT NULL AUTO_INCREMENT,
    socio_id INTEGER NOT NULL,
    libro_id INTEGER NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE NOT NULL,
    fecha_entrega DATE,
    estado VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (socio_id) REFERENCES socios(id),
    FOREIGN KEY (libro_id) REFERENCES libros(id)
);

CREATE TABLE multas (
    id INTEGER NOT NULL AUTO_INCREMENT,
    prestamo_id INTEGER NOT NULL UNIQUE,
    monto DECIMAL(10,2) NOT NULL,
    dias_retraso INTEGER NOT NULL,
    pagada BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id),
    FOREIGN KEY (prestamo_id) REFERENCES prestamos(id)
);

CREATE TABLE reservas (
    id INTEGER NOT NULL AUTO_INCREMENT,
    socio_id INTEGER NOT NULL,
    libro_id INTEGER NOT NULL,
    fecha_reserva DATE NOT NULL,
    estado VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (socio_id) REFERENCES socios(id),
    FOREIGN KEY (libro_id) REFERENCES libros(id)
);

CREATE TABLE roles (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuarios (
    id INTEGER NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    rol_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

CREATE TABLE tipoSocios (
    id INTEGER NOT NULL AUTO_INCREMENT,
    tipo_socio VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);