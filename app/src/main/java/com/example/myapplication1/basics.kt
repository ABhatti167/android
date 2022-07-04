package com.example.myapplication1

data class user(val users: String, val age: Int)
fun main() {

    //TODO: Learn

    /*
    Multiline comment
    */

    /*
val output = readLine()

    when (output) {
        "good" -> {
            println("verygood")
        }
        else -> {
            println("ok")
        }
    }

     */


    /*when(thing){
        1 ->  {
            println("hi")
            println("how are u")
        }
        2 -> {
            println("bye")
        }
        in 3..7 -> {
            println("This is the value")
            println("hdiuhiweuehiew")
        }
         8,9,10 -> {
            println("bleh")
        }
        in 95 downTo 9 -> {
            println("blehhhh")
        }
        else -> {
            println("wrong value")
            println("type again")
        }
    }
    var x: Any = 5

    when (x) {
        !is Int -> println("hii")
        is String -> println("hii")
        is Double -> println("hii")
        is Int -> println("hii")
        else -> println("loll")
    }

    */
    /*
    val one = "one"
    val something: String? = null
    val guest: String = something ?: "Guest"
    var len2 = something?.length
    something?.let { (println(it.length))}
    println("$guest")*/




var car1 = Car()

car1.brand = "Honda"


    val user1 = user("Armaan",16)
    val user2 = user1.copy(age = 17)
    println(user2.age)


}

class Car() {
    lateinit var guy: String
    var brand: String = "TOYOTA"


    get() {
        return field.lowercase()
    }

    var kms: Int = 300
    private set
    var km: Int = 200
        get() = field
        set(value) {
            field = if (value < 250) value else throw IllegalArgumentException("Too much!")
        }

    init {
        this.guy = "me"
        println(brand)
    }
}



class Person (firstName: String? = "Armaan", lastName: String? = "ouhiwufishe") {

    var age: Int? = null

    var hobby: String = "things to do"

    var name: String? = null

    constructor(firstName: String?, lastName: String?, age: Int) : this(firstName,lastName){
        this.age = age
        println("This person is ${this.age} years old")
        this.old()
    }

    fun old() {
        println("$name's hobby is $hobby")
    }

}
