package dataForTable

/**
 *  La clase Producto incluye los atributos en el mismo orden (índice) que las columnas
 *  correspondientes para la tabla.
 *  @property id Int identificador único del producto
 *  @property name String nombre del producto
 *  @property price Float precio del producto
 *  @property description String descripción sobre el producto
 *  @property brand String marca del producto
 *  @property category String categoría sobre el producto
 */
data class Product(
    val id: Int,
    val name: String,
    val price: Float,
    val description: String,
    val brand: String,
    val category: String
)
