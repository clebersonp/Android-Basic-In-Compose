// parametros do construtor sem val ou var n sao criadas como propriedades da classe, apenas
// parmetros de passagem mesmo

package com.example.classes

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    // delegate class pelo uso da keyword by e implementacao RangeRegulator p gerenciar o getter e setter
    private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
//    private var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
//    private var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name of type $deviceType is turned on. Speaker volume is set to $speakerVolume " +
                    "and channel number is set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name of type $deviceType turned off")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }

}