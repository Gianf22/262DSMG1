
data class Producto(
    val nombre: String,
    val categoria: Categoria,
    val precio: Double,
    val stock: Int,
    val descripcion: String?
)

enum class Categoria {
    TECNOLOGIA,
    ROPA,
    HOGAR
}

fun main() {

    val productos = listOf(
        Producto(
            "Laptop Lenovo",
            Categoria.TECNOLOGIA,
            2500.0,
            5,
            "Laptop para trabajo y estudio"
        ),
        Producto(
            "Mouse Logitech",
            Categoria.TECNOLOGIA,
            80.0,
            20,
            "Mouse inalámbrico"
        ),
        Producto(
            "Polo negro",
            Categoria.ROPA,
            45.0,
            15,
            "Polo de algodón"
        ),
        Producto(
            "Pantalón jean",
            Categoria.ROPA,
            120.0,
            8,
            null
        ),
        Producto(
            "Lámpara LED",
            Categoria.HOGAR,
            60.0,
            12,
            "Lámpara para escritorio"
        )
    )

    println("=== PRODUCTOS ===")

    productos.forEach {
        println("${it.nombre} - S/. ${it.precio}")
    }


    println("\n=== NOMBRES ===")

    val nombres = productos.map {
        it.nombre
    }

    nombres.forEach {
        println(it)
    }


    println("\n=== PRODUCTOS MAYORES A S/.100 ===")

    val productosCaros = productos.filter {
        it.precio > 100
    }

    productosCaros.forEach {
        println("${it.nombre} - S/. ${it.precio}")
    }


    println("\n=== PRODUCTOS DISPONIBLES ===")

    val disponibles = productos.filter {
        it.stock > 0
    }

    disponibles.forEach {
        println("${it.nombre} - Stock: ${it.stock}")
    }


    println("\n=== PRODUCTOS POR CATEGORÍA ===")

    val productosPorCategoria = productos.groupBy {
        it.categoria
    }

    productosPorCategoria.forEach { (categoria, lista) ->

        println("\n$categoria")

        lista.forEach {
            println("- ${it.nombre}")
        }
    }


    println("\n=== VALOR TOTAL DEL STOCK ===")

    val valorTotal = productos.fold(0.0) { total, producto ->
        total + (producto.precio * producto.stock)
    }

    println("Valor total: S/. $valorTotal")


    println("\n=== PRODUCTOS ORDENADOS POR PRECIO ===")

    val ordenados = productos.sortedBy {
        it.precio
    }

    ordenados.forEach {
        println("${it.nombre} - S/. ${it.precio}")
    }


    println("\n=== DESCRIPCIONES ===")

    productos.forEach {

        val descripcion = it.descripcion ?: "Sin descripción"

        println("${it.nombre}: $descripcion")
    }


    println("\n=== BÚSQUEDA ===")

    val productoBuscado = productos.first {
        it.nombre == "Mouse Logitech"
    }

    println("Encontrado: ${productoBuscado.nombre}")
}

