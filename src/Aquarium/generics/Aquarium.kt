package Aquarium.generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() = apply { needsProcessed = false }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() = apply { needsProcessed = false }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {

    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }

}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified  T: WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    aquarium.addWater(cleaner)
    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>()
    aquarium.waterSupply.isOfType<LakeWater>()
}