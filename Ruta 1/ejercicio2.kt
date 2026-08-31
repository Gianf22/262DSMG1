fun main() {
    //ejemplov1()
    //suma()
    suma2()
}

fun ejemplov1() {
    val count: Int = 10
    /* val: es valor, el compil sabe hay una declaracion de variable
     * name. nombre de variab despues de val
     * tipo de variab: del nombre agrega dos puntos, 
     * un espacio y, luego, el tipo de datos que puede ser
     * String, Int, Double, Float, y Boolean, son los basicos 
     */
    println("You have $count unread messages.")
    //agrega "$" antes del nombre de la variable
}

fun suma() {
    val unreadCount: Int = 5
    val readCount = 100
    println("You have ${unreadCount + readCount} total messages in your inbox.")
    //debes encerrar los int dentre llaves y poner $ antes de { 
}

fun suma2() {
    val numberOfPhotos = 100
    val photosDeleted = 10
    println("$numberOfPhotos photos")
	println("$photosDeleted photos deleted")
	println("${numberOfPhotos - photosDeleted} photos left")
}





