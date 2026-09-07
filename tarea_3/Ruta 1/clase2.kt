open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
        protected set

    open val deviceType = "unknown"

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    // Control de rango sin imports usando setter personalizado
    private var speakerVolume: Int = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    private var channelNumber: Int = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    // Control de rango sin imports usando setter personalizado
    private var brightnessLevel: Int = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    // --- Control de TV ---
    fun turnOnTv() {
        if (smartTvDevice.deviceStatus != "on") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }

    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseVolume()
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        }
    }

    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.changeTvChannelToPrevious()
        }
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    // --- Control de Luz Inteligente ---
    fun turnOnLight() {
        if (smartLightDevice.deviceStatus != "on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    // --- Operaciones Globales ---
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// Extensión para llamar al método anterior de la TV respetando el nombre pedido
fun SmartTvDevice.changeTvChannelToPrevious() {
    this.previousChannel()
}

fun main() {
    val tv = SmartTvDevice("Android TV", "Entertainment")
    val light = SmartLightDevice("Google Light", "Utility")
    val home = SmartHome(tv, light)

    println("=== INFORMACIÓN DE DISPOSITIVOS ===")
    home.printSmartTvInfo()
    home.printSmartLightInfo()

    println("\n=== ACCIONES EN APAGADO (NO DEBEN FUNCIONAR) ===")
    home.increaseTvVolume()
    home.changeTvChannelToNext()
    home.decreaseLightBrightness()
    println("Dispositivos encendidos: ${home.deviceTurnOnCount}")

    println("\n=== ENCENDIENDO DISPOSITIVOS ===")
    home.turnOnTv()
    home.turnOnLight()
    println("Dispositivos encendidos: ${home.deviceTurnOnCount}")

    println("\n=== PROBANDO MÉTODOS DE TV ===")
    home.increaseTvVolume()
    home.decreaseTvVolume()
    home.changeTvChannelToNext()
    home.changeTvChannelToPrevious()

    println("\n=== PROBANDO MÉTODOS DE LUZ INTELIGENTE ===")
    home.increaseLightBrightness()
    home.decreaseLightBrightness()

    println("\n=== APAGANDO DISPOSITIVOS ===")
    home.turnOffAllDevices()
    println("Dispositivos encendidos: ${home.deviceTurnOnCount}")
}