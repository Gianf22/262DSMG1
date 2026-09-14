data class Event(
    val titulo: String,
    val descripcion : String? = null,
    val parte_dia: Parte_dia,
    val duracion_min: Int,
)

enum class Parte_dia{
	    maniana, tarde, noche
}

val event1 = Event(titulo = "Wake up", descripcion = "Time to get up", parte_dia = Parte_dia.maniana, duracion_min = 0)
val event2 = Event(titulo = "Eat breakfast", parte_dia = Parte_dia.maniana, duracion_min = 15)
val event3 = Event(titulo = "Learn ab out Kotlin", parte_dia = Parte_dia.tarde, duracion_min = 30)
val event4 = Event(titulo = "Practice Compose", parte_dia = Parte_dia.tarde, duracion_min = 60)
val event5 = Event(titulo = "Watch latest DevBytes video", parte_dia = Parte_dia.tarde, duracion_min = 10)
val event6 = Event(titulo = "Check out latest Android Jetpack library", parte_dia = Parte_dia.noche, duracion_min = 45)

val Eventos = mutableListOf<Event>(event1,event2,event3,event4,event5,event6)


val eventocorto = Eventos.filter{it.duracion_min < 60}
val Event.durationOfEvent: String
    	get() = if (this.duracion_min < 60) {
        	"short"
    	} else {
        	"long"
    	}
        
fun main() {
    //println("tenes ${eventocorto.size} eventos cortos")
    val grupoparte = Eventos.groupBy{it.parte_dia}
    grupoparte.forEach{(parte_dia, Eventos) ->
    	println("$parte_dia: ${Eventos.size} eventos")
    }
    
    println("el ultimo evento del dia es: ${Eventos.last().titulo}")
	
    println("duracion del primer evento del dia: ${Eventos.first().durationOfEvent}")
}


