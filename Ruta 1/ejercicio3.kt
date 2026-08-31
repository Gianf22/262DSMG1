fun main() {
    //cambio()
    //incremento()
    decremento()
}

fun cambio(){
    //val cartTotal = 0  
    //val: Úsala cuando esperes que el valor de la variable no cambie.
    //var: Úsala cuando esperes que el valor de la variable pueda cambiar.
    var cartTotal = 0
    println("Total: $cartTotal")
    cartTotal = 20
    println("Total: $cartTotal")
}

fun incremento() {
    var count: Int = 10
    println("You have $count unread messages.")
    //count = count + 1  esto o 
    count++
    println("You have $count unread messages.")  
}

fun decremento() {
    var count: Int = 10
    println("You have $count unread messages.")
    count--
    println("You have $count unread messages.")  
}




