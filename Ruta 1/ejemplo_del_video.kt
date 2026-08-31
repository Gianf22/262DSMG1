fun main() {

    mensajes()

    plantilla_cadena()

    operacion()

    parametros()
}


// 1. PRINTLN

fun mensajes() {

    println("usa val cuando el valor no cambie.")
    println("usa var cuando el valor cambie.")
    println("cuando definesuna funcion, defines los parametros que pueden pasar por el.")
    println("cuando llames una funcion, pasan los argumentod for el parammetro.")
    println("\n\n")

}

// 2. VAL, VAR Y PLANTILLAS DE CADENA

fun plantilla_cadena() {

    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"

    discountPercentage = 20

    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"

    println(offer)
    println("\n\n")
}

// 3. FUNCIONES, PARÁMETROS Y RETORNO

fun operacion() {

    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

    val result2 = subtract(firstNumber, secondNumber)
    val anotherResult2 = subtract(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")

    println("$firstNumber - $secondNumber = $result2")
    println("$firstNumber - $thirdNumber = $anotherResult2")
    println("\n\n")
}

fun add(num: Int, num2: Int): Int {
    return num + num2
}

fun subtract(num: Int, num2: Int): Int {
    return num - num2
}

// 4. PARÁMETROS Y ARGUMENTOS CON NOMBRE

fun parametros() {

    val firstUserEmailId = "user_one@gmail.com"

    println(
        displayAlertMessage(correo = firstUserEmailId)
    )

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(
        displayAlertMessage(
            secondUserOperatingSystem,
            secondUserEmailId
        )
    )

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(
        displayAlertMessage(
            thirdUserOperatingSystem,
            thirdUserEmailId
        )
    )
 println("\n\n")
}

fun displayAlertMessage(
    nombre: String = "Unknown OS",
    correo: String
): String {

    return "There's a new sign-in request on $nombre for your Google Account $correo."
}




