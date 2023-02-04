package com.example.classes

// open p permitir ser utilizada com heranca, por default e final
// construtor default modificador de acesso protected
// modificador de acesso internal(exposto p outras classes que estejam dentro do mesmo modulo)
//internal open class SmartDevice protected constructor (val name: String, val category: String) {
open class SmartDevice (val name: String, val category: String) {
    var deviceStatus = "online"
        protected set // posso omitir o parametro e o body pois e so o value passando p o field default, sem validacao

    // open uma propriedade p permitir override nas subclasses
    open val deviceType = "unknown"

    // open p permitir ser override, por default e final
    open fun turnOn() {
        deviceStatus = "on"
    }

    // open p permitir ser override, por default e final
    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType, status: $deviceStatus")
    }

    fun isDeviceOn(): Boolean {
        return deviceStatus.equals("on", true)
    }
}