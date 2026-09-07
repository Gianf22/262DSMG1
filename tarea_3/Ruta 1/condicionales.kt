fun main() {
    //comparacion_logica()
    //condicional()
    //multiple()
    //primos()
    //rango()
    //IS()
    expresion()
    expresion2()
}

fun expresion() {
    val trafficLightColor = "Black"

    val message = 
		if (trafficLightColor == "Red") "stop"
    	else if (trafficLightColor == "Yellow") "slow"
    	else if (trafficLightColor == "Green") "go"
    	else "invalid traffic Light Color"

    println(message)
}

fun expresion2() {
    val trafficLightColor = "Black"

    val message = when(trafficLightColor){
    	"Red" -> "stop"
		"Yellow", "amber" -> "slow"
    	"Green" -> "go"
    	else -> "invalid traffic Light Color"
    }
    println(message)
}

fun comparacion_logica(){
	println(1 == 1) 
    println(1 < 1)
    
}

fun condicional() {
    val trafficLightColor = "Blue"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green"){
        println("Go")
    }else{
        println("invalid")
    }
}

fun multiple() {
    val trafficLightColor = "Yellow"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
}

fun primos() {
    val x = 3

    when (x) {
		//forma 1
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        //forma 2
        2 -> println("x is a prime number between 1 and 10.")
        3 -> println("x is a prime number between 1 and 10.")
        5 -> println("x is a prime number between 1 and 10.")
        7 -> println("x is a prime number between 1 and 10.")
        
        else -> println("x isn't a prime number between 1 and 10.")
    }
}

fun rango() {
    val x = 4

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}

fun IS() {
    val x: Any = 20.5
	/*Any es el supertipo del que heredan todas las 
	 * clases en Kotlin (String, Int, etc clases)
	*/
    
    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        //is:como condición para verificar el tipo de datos de un valor evaluado
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't an integer number.")
    }
}



