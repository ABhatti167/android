package com.example.myapplication1

private data class users(val users: String, val age: Int)

interface methods {
    var range: Int
    fun drive(d: Int)
    fun brake() = println("brake")
}
open class cars(km: Int) : methods{

    override var range = 0
    var km: Int = km

    override fun drive(d: Int) {
        km+=d
    }
}

class ecar(model: String, brand: String, km: Int) : cars(km) {

    override var range = 500
}


fun main() {

    val tesla = ecar("9", "tesla", 50)

    tesla.drive(500)
    println(tesla.km)
    tesla.brake()

    val names: MutableList<Any> = mutableListOf("1",2,3)

    val code: Any = "11"

    val namess: String = code as String

    val arrays = intArrayOf(1,2,3)

    arrays[1] =  55

    println(arrays.contentToString())

    var arrayable = arrayOf(users("1woijis2", 1), users("1woiis2", 19032))

    for (element in arrays) {
        println("${element + 2}")
    }

    val strings = arrayOf("1","2","3")



    val doubles: DoubleArray = doubleArrayOf(1.00)

    val chars: CharArray = charArrayOf('a','b','c')


    val lists = mutableListOf(1,2,3)
    val lists2 = listOf(1,2,3)


    val mutant = lists.toMutableList()

    lists.addAll(lists2)
    lists.add(98)

    val days = mutableListOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","blank")
    days.removeAt(7)
    days[6] = "Sunday"

    println(lists)

    val numbers = setOf<Int>(4,5,6,7,8,9)

    val numbers2 = numbers.elementAt(4)

    val maps = mapOf(1 to "hdeiuhwc",2 to "ifwhf",3 to "euiofhr",4 to "ihefir",5 to "iefhruhir")
    println(maps.get(1))

    for (i in maps.values) {
        println(i)
    }

    val maps2 = mapOf(1 to users("1woiis2", 19032), 2 to users("1woiis2", 19032), 3 to users("1woiis2", 19032))

    val maps3 = maps2.toMutableMap()

    maps3[4] = users("jdoiejoidjo", 44)

    val arraylist = ArrayList<Any>()

    arraylist.add(1)
    arraylist.remove(0)


    val itr = arraylist.iterator()

    val sum: (Int, Int) -> Int = {a: Int, b: Int -> a + b}



}


fun act() = if (true) 1+1 else 2+2



abstract class mammals(private val animal: String, private val name: String) {


    abstract fun run()

    abstract val old: Int

}

class animal(private val animal: String, private val name: String): mammals(animal, name){
    override fun run() {
        println("run")
    }

    override val old: Int = 55
}