fun main(){
    //nulo()
    //prueba()
    //ejemploLlamadaSegura()
    //ejemploAsersionNoNula()
    //ejemploSentenciaIfElse()
    //ejemploExpresionIfElse()
    ejemploOperadorElvis()
}

fun nulo() {
    val favoriteActor = null
    println(favoriteActor)
}

fun prueba() {
    /*var favoriteActor: String = "Sandra Oh"
    favoriteActor = null*/
    //hay tipos de variables que pueden contener null y otros no
    //cambio
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor)

    favoriteActor = null
    println(favoriteActor)
    
    var number: Int? = 10
    println(number)
    
    number = null
    println(number)
}

fun ejemploLlamadaSegura() {
    var favoriteActor: String = "Sandra Oh"
    println(favoriteActor.length)
    
    /*var favoriteActor2: String? = "Sandra Oh"
    println(favoriteActor2.length)
    dara error porque una variable null no puede acceder a operaciones
    */
    var favoriteActor2: String? = null
    println(favoriteActor2?.length) 
}

fun ejemploAsersionNoNula() {
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor!!.length)
    //si usas la aserción no nula !!, significa que confirmas que el valor de la variable
    // no es null, si defines tu variable como null al inicio, dara error al imprimir
    
}

fun ejemploSentenciaIfElse() {
    var favoriteActor: String? = null

    if(favoriteActor != null) {
      println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    } else {
      println("You didn't input a name.")
    }
}

fun ejemploExpresionIfElse() {
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor != null) {
      favoriteActor.length
    } else {
      0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}


 
fun ejemploOperadorElvis() {
    println("--- 6. Operador Elvis (?:) ---")
    /** Combina la llamada segura (?.) con un valor predeterminado si el resultado es null.
 	*/
    var favoriteActor: String? = "Sandra Oh"

    // Si favoriteActor?.length es null, toma el valor 0 ubicado a la derecha de ?:
    var lengthOfName: Int = favoriteActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName.") // Imprime 9

    // Asignación con null
    favoriteActor = null
    lengthOfName = favoriteActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName.") // Imprime 0
    println()
}








