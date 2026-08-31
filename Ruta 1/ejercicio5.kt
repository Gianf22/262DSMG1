fun main() {
    //birthdayGreeting()
    
    /*val greeting = birthdayGreeting2()
    println(greeting)
    println(birthdayGreeting2())*/
    
    /*println(birthdayGreeting3("robert",6))
    println(birthdayGreeting3(age = 6, name = "Robert"))
    //aunque cambien el orden, da el mismo resultado*/
    
    println(birthdayGreeting4(age = 5))
	println(birthdayGreeting4("Rex", 2))
    println(birthdayGreeting4())
}

/*fun birthdayGreeting(): Unit {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
} // usas unit cuando la funcion no retorna ningun valor */

fun birthdayGreeting() {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}

fun birthdayGreeting2(): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting" // usa \n para separar texto por linea
}

fun birthdayGreeting3(name: String, age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting" // usa \n para separar texto por linea
}

fun birthdayGreeting4(name: String = "Rover", age: Int = 10): String {
    return "Happy Birthday, $name! You are now $age years old!"
}







