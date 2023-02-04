import com.example.classes.SmartDevice
import com.example.classes.SmartHome
import com.example.classes.SmartTvDevice
import com.example.classes.SmartLightDevice

fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.decreaseTvVolume()

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()

    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.decreaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()

    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}