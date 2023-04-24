import dao.ProductDAO
import dataForTable.Product

/**
 * La función main crea un nuevo objeto de la dataclass Product con los atributos correspondientes.
 * Después crea un nuevo objeto de la clase ProductDAO y por último con esa clase llama a su función
 * createProduct pasándole por parámetro el product de la dataclass
 *
 */
fun main() {
    // El id: 6 aún no ha sido probado ya que los anteriores ya están añadidos en la tabla.
    val product = Product(6, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")
    val aNewProduct = ProductDAO()
    val productId = aNewProduct.createProduct(product)

    println("producto.Product ID: $productId")



}


