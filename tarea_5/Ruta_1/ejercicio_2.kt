fun main() {
    //arrays()
    //listas()
    //mutablelista()
    //sets()
    maps()
}

fun arrays(){
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
	val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets
    solarSystem[3] = "Little Earth"
    for (i in 0..7){
        println(solarSystem[i])
    }
    //agrega el elemento pluto denuevo en el array
    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
	println(newSolarSystem[8])
}

fun listas(){
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    /*println(solarSystem.size) 
    println(solarSystem[2])
	println(solarSystem.get(3))
    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))*/
    for (planet in solarSystem) {
    	println(planet)
	}
}

fun mutablelista(){
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")//insertar valor entre dos elementos puestos
    solarSystem[3] = "Future Moon"//actualizar valor
    println(solarSystem[3])
	println(solarSystem[9])
	solarSystem.removeAt(9)//quita elemento de la lista mediante indice
    solarSystem.remove("Future Moon")
    println(solarSystem.contains("Pluto"))//indica si el elme existe
    println("Future Moon" in solarSystem)//
}
fun sets(){
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    solarSystem.add("Pluto")
    println(solarSystem.size)    
    println(solarSystem.contains("Pluto"))
    solarSystem.add("Pluto")
    println(solarSystem.size)
    solarSystem.remove("Pluto")
    println(solarSystem.size)
	println(solarSystem.contains("Pluto"))
}

fun maps(){
    //val mapname = mapof(key to value, key to value,...)
    val solarSystem = mutableMapOf(
    "Mercury" to 0,
    "Venus" to 0,
    "Earth" to 1,
    "Mars" to 2,
    "Jupiter" to 79,
    "Saturn" to 82,
    "Uranus" to 27,
    "Neptune" to 14
	)
    println(solarSystem.size)
    solarSystem["Pluto"] = 5
    println(solarSystem.size)
    println(solarSystem["Pluto"])
    println(solarSystem.get("Theia"))
    solarSystem.remove("Pluto")
    solarSystem["Jupiter"] = 78
	println(solarSystem["Jupiter"])
}












