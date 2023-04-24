package dao

import dataForTable.Product
import java.sql.DriverManager
import java.sql.Statement

class ProductDAO {

    // Se establece la conexión a la base de datos (el usuario y contraseña están añadidos en data sources)
    private val connection = DriverManager.getConnection("jdbc:h2:~/test")

    /**
     * La función createProduct se le pasa por parámetro una instancia de la dataclass Product, después se
     * crea la tabla si no existe anteriormente. Después se crea un nuevo producto insertando en la tabla de productos
     * las columnas correspondientes de la dataclass sin especificar los valores y se prepara la sentencia SQL para añadirlo
     * a la tabla. Tras ello se establecen los valores de los parámetros de la sentencia SQL. Luego se ejecuta
     * la sentencia SQL y se obtiene el ID del producto recién insertado. Por último se cierra la conexión a la base de datos
     * y se devuelve el ID del producto insertado.
     *
     * @param product: Product objeto de la clase producto.
     * @return productId devuelve el identificador único de dicho producto creado en la función.
     */
    fun createProduct(product: Product): Int {

        // Se crea a continuación la tabla products si no existe
        val stmt: Statement = connection.createStatement()
        stmt.executeUpdate("""
        CREATE TABLE IF NOT EXISTS products (
            id INT PRIMARY KEY,
            name VARCHAR(50),
            price FLOAT,
            description VARCHAR(100),
            brand VARCHAR(50),
            category VARCHAR(50)
        )
    """.trimIndent())


        // Se prepara la sentencia SQL para insertar un nuevo producto en la tabla
        val nuevoProducto = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"
        val statement = connection.prepareStatement(nuevoProducto)

        // Establecer los valores de los parámetros de la sentencia SQL
        statement.setInt(1, product.id)
        statement.setString(2, product.name)
        statement.setFloat(3, product.price)
        statement.setString(4, product.description)
        statement.setString(5, product.brand)
        statement.setString(6, product.category)

        // Se ejecuta la sentencia SQL y se obtiene el ID del producto recién insertado
        statement.executeUpdate()

        val productId = product.id

        // Se cierra la conexión a la base de datos y se devuelve el ID del producto insertado
        statement.close()
        connection.close()
        return productId
    }

}