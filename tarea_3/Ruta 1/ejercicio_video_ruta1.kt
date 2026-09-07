open class Dispositivo(val nombre: String) {
    var encendido: Boolean = false
        protected set

    open fun encender() {
        encendido = true
    }

    open fun apagar() {
        encendido = false
    }
}

class Bateria(val capacidadMah: Int = 4000) {
    var nivelCarga: Int = 100
        private set(value) {
            field = if (value in 0..100) value else 0
        }

    fun consumirEnergia(cantidad: Int) {
        nivelCarga -= cantidad
    }
}

class Telefono(
    nombre: String,
    val bateria: Bateria = Bateria()
) : Dispositivo(nombre) {

    val tieneCargaSuficiente: Boolean
        get() = bateria.nivelCarga > 5

    override fun encender() {
        if (tieneCargaSuficiente) {
            super.encender()
            bateria.consumirEnergia(5)
            println("$nombre encendido. Batería restante: ${bateria.nivelCarga}%.")
        } else {
            println("Batería muy baja para encender $nombre.")
        }
    }
}


class Oferta(val monto: Int, val postor: String)

fun procesarTransaccion(
    oferta: Oferta?,                      
    costoBase: Int,
    notificar: (String, Int) -> Unit      
) {
    val montoFinal = oferta?.monto ?: costoBase
    val comprador = oferta?.postor ?: "Anónimo"

    val categoria = when (montoFinal) {
        in 0..99 -> "Económica"
        in 100..499 -> "Estándar"
        else -> "Premium"
    }

    notificar("Compra $categoria por $comprador", montoFinal)
}

fun main() {
    val miCelular = Telefono("Pixel 8")
    miCelular.encender()
    
    println("Nivel actual de batería: ${miCelular.bateria.nivelCarga}%")

    val ofertaValida: Oferta? = Oferta(250, "Carlos")
    val ofertaNula: Oferta? = null

    procesarTransaccion(ofertaValida, 50) { mensaje, total ->
        println("[NOTIFICACIÓN]: $mensaje. Monto debitado: \$$total.")
    }

    procesarTransaccion(ofertaNula, 80) { mensaje, total ->
        println("[NOTIFICACIÓN]: $mensaje. Monto debitado: \$$total.")
    }
}