fun main() {
    //mensajes()
    //plantilla_cadena()
    //concatenacion()
    //formato()
    //operacion()
    //operacion2()
    //parametros()
    //parametros2()
    //podometro()
}

fun mensajes() {
    println("Use the val keyword when the value doesn't change.")
	println("Use the var keyword when the value can change.")
	println("When you define a function, you define the parameters that can be passed to it.") 
	println("When you call a function, you pass arguments for the parameters.\n")
    
    //println("New chat message from a friend'}
    println("New chat message from a friend") //correción
}

fun plantilla_cadena() {
    var discountPercentage: Int = 0
    var offer: String = ""
    var item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    println(offer)
}

fun concatenacion() {
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}

fun formato() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = "${baseSalary + bonusAmount}"
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}

fun operacion() {
    val firstNumber = 10
    val secondNumber = 5
    val result = firstNumber + secondNumber
    println("$firstNumber + $secondNumber = $result")
}

fun operacion2() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val result = add(firstNumber, secondNumber)
    val anotherResult = subtract(firstNumber, thirdNumber)
    
    val result2 = subtract(firstNumber, secondNumber)
    val anotherResult2 = subtract(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    
    println("$firstNumber - $secondNumber = $result2")
    println("$firstNumber - $thirdNumber = $anotherResult2")
}

fun add(num: Int, num2: Int): Int {
    return num + num2
}

fun subtract(num: Int, num2: Int): Int {
    return num - num2
}

fun parametros() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
}

fun parametros2() {
    val firstUserEmailId = "user_one@gmail.com"
    // The following line of code assumes that you named your parameter as emailId. 
    // If you named it differently, feel free to update the name.
    println(displayAlertMessage(correo = firstUserEmailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()
}

fun displayAlertMessage(nombre: String = "Unknown OS", correo: String): String {
    return "There's a new sign-in request on $nombre for your Google Account $correo."
}

fun podometro() {
    val Steps = 4000
    val caloriesBurned = pedometerStepsTOCalories(Steps);
    println("Walking $Steps steps burns $caloriesBurned calories") 
}



fun pedometerStepsToCalories(numberOFSteps: Int): Double {
    val CaloriesBURNEDforEachStep = 0.04
    val TotalCALORIESburned   = numberOFStepS * CaloriesBURNEDforEachStep
    return TotalCALORIESburned
}




