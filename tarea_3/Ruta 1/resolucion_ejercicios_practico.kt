fun main() {
    //notificacion()
    //precio_por_edad()
    //catalogo()
    //pantalla()
    subasta()
}

fun notificacion() {
    val notificacion = 51
    val notificacion2 = 135
    
    condicionalNotificacion(notificacion)
    condicionalNotificacion(notificacion2)
}


fun condicionalNotificacion(numberOfMessages: Int) {
    val mensaje = 
    if (numberOfMessages<=99) numberOfMessages
    else "+99"
    
    println(mensaje)
}

fun precio_por_edad() {
    val niño = 5
    val adulto = 28
    val anciano = 87
    
    val eslunes = true
    
    println("el precio del ticket para niños es \$${precio(niño, eslunes)}.")
    println("el precio del ticket para adulto es \$${precio(adulto, eslunes)}.")
    println("el precio del ticket para anciano es \$${precio(anciano, eslunes)}.")
}
 
fun precio(edad: Int, eslunes: Boolean): Int {
    return when(edad) {
        in 0..12 -> 15
        in 13..60 -> if (eslunes) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}

fun catalogo() {    
    val musica = cancion("Bury the Light", "Edward casey", 2019, 14_000_000)
    musica.descripcion()
    println(musica.esPopular)
}


class cancion(
    val titulo: String, 
    val artista: String, 
    val año: Int, 
    val conteo: Int
){
    val esPopular: Boolean
        get() = conteo >= 1000

    fun descripcion() {
        println("$titulo, fue hecha por $artista, fue realizado en $año.")
    }   
}


open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true): Phone() {
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }
    
    fun plegar() {
        isFolded = true
    }
    
    fun desplegar() {
        isFolded = false
    }
}

fun pantalla() {    
    val newFoldablePhone = FoldablePhone()
    
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.desplegar()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}

fun subasta() {
    val winningBid = Bid(5000, "Private Collector")
    
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}








