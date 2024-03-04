
fun main() {

    /*
    Yeni bilgi: readline() ile terminal üzerinden user input yapabiliyorsun xD.

    println("Bir sayı giriniz:")
    val userInput = readlnOrNull()
    println("Sayı: $userInput")
     */


    /* --------------------------String----------------------------------*/
    println("String \"String\" String")
    println("String \\ String")

    var denemeString = "Deneme String"
    println(denemeString.length)
    println(denemeString.plus("Deneme String 2"))
    println(denemeString.get(0))
    println(denemeString.compareTo("Deneme String 3")) //compare two strings lexicographically.
    println(denemeString.equals("Deneme String 4"))
    println(denemeString.hashCode())
    println(denemeString.subSequence(0,6))
    println(denemeString.indices)
    println(denemeString.first())
    println(denemeString.last())
    println(denemeString.lastIndexOf('S'))
    println(denemeString.firstOrNull())
    println(denemeString.lastOrNull())
    println(denemeString.lastIndex)
    println(denemeString.any())

    println(denemeString.associate { char -> char to char.code }) // Pair<X,Y> yani Map dönüyor.
    println(denemeString.associateBy { char -> char.code})
    println(denemeString.associateBy({char -> char.code}, {char -> char.uppercaseChar()}))
    val result = mutableMapOf<Int,Char>()
    val result2 = mutableMapOf<Char,Double>()
    println(denemeString.associateByTo(result){char -> char.code})
    println(denemeString.associateTo(result2){char -> char to char.code.toDouble()})
    println(denemeString.associateWith { char -> char.code })
    println(denemeString.associateWithTo(result2){char -> char.code.toDouble()})

    println(denemeString.capitalize())
    println(denemeString.decapitalize())
    println(denemeString.chunked(3))
    println(denemeString.contains("D"))
    println(denemeString.count())

    println(denemeString.drop(1))
    println(denemeString.dropLast(2))
    println(denemeString.dropWhile { char -> char != 'S'})
    println(denemeString.dropLastWhile { char -> char != 'e' })

    println(denemeString.elementAt(0))
    println(denemeString.elementAtOrElse(1){'0'})
    println(denemeString.elementAtOrElse(20){'0'})
    println(denemeString.elementAtOrNull(0))
    println(denemeString.elementAtOrNull(20))

    val filterString = "a1s4d5f8a6d"
    println(denemeString.filter { char -> char == 'e' })
    println(filterString.filter { char -> char.isDigit() })
    println(denemeString.filterNot { char -> char == 'e' })
    println(filterString.filterNot { char -> char.isDigit() })

    println(denemeString.find { char -> char.isUpperCase() }) // İlk karşılık geleni buluyor.
    println(denemeString.findLast { char -> char.isUpperCase() })

    println(denemeString.flatMap { char -> char.uppercase().toList() })

    println(denemeString.forEachIndexed { index, c ->
        println("Index: $index, Character: $c")
    })

    val name = "A"
    val age = 1
    println("%s is %d years old.".format(name,age))

    println(denemeString.getOrElse(0){'0'})
    println(denemeString.getOrElse(20){'0'})
    println(denemeString.getOrNull(20))

    println(denemeString.ifBlank { "blank" })
    println(denemeString.ifEmpty { "empty" })

    println(denemeString.indexOf('S'))
    println(denemeString.indexOfFirst { char -> char == 'S' })
    println(denemeString.indexOfLast{ char -> char == 'S' })

    println(denemeString.lowercase())
    println(denemeString.uppercase())
    println(denemeString.substring(3,6))

    println(denemeString.matches(".*[A-Z].*".toRegex()))
    println(denemeString.matches(".*[ğüşöçı].*".toRegex()))

    /* --------------------------Elvis operator----------------------------------*/

    var denemeElvis : String? = null
    //denemeElvis = "Enes"
    println(denemeElvis ?: "null geldi")

    /* --------------------------Exceptions----------------------------------*/
    var test = "test"

    /*
    Bu mesela NumberFormatException hatası verecek.
    println(test.toInt())
     */

    /*Kodumuzun herhangi bir kısmının Exception hatası verme ihtimali varsa try-catch içinde onu gözlemleyebiliriz.*/


    try {
        println(test.toInt())
    }catch (e: Exception){
        println("Eğer exception varsa, bir sürü kırmızı hata kodu gelmesindense sadece bu yazdığım mesaj gelecek.")
    }

    try {
        println(test.toInt())
    }catch (e: Exception){
        println("An exception happened \n${e.localizedMessage}") // Böyle yaparak ise sadece ilgili exception'ın detayını göreceğiz. Yine kırmızı errorlarla boğulmadan.
    }

    try {
        println(test.toInt())
    }catch (e: Exception){
        e.printStackTrace() //Bunu koyarsak ise hem error'u göreceğiz hem de kısa exception mesajını.
        println("An exception happened \n${e.localizedMessage}")
    }

    try {
        println(test.toInt())
    }catch (e: Exception){
        println("An exception happened \n${e.localizedMessage}")
    }finally {
        println("The execution has completed.") // Exception olsa da olmasa da finally çalışacaktır. Koymak faydalı çünkü memory leaks ve junk birikimi felan gibi şeyleri engeller.
    }

    /* Throw ile kendi exception'ımızı yaratabiliriz. Throw dan sonraki kodlar çalışmayacağı için yoruma aldım.

    throw IllegalStateException("Kendi exception'ım")

     */

    /* --------------------------Collections----------------------------------*/

    // List, Set, Map, Iterator

    /*
    list ve arraylist farkı şu: list -> immutable , arraylist -> mutable.
     */
    var list = listOf(1,2,3)
    println(list.size)
    println(list[0])

    var arrayList = arrayListOf(1,2,3)
    var arrayList2 = arrayListOf<Int>()

    arrayList2.addAll(arrayList)
    println(arrayList2)
    arrayList2.set(0,100)
    println(arrayList2)
    arrayList2.removeAll(arrayList)
    println(arrayList2)
    arrayList2.clear()
    println(arrayList2)

    val numbers = arrayListOf(1,2,3,4,5)
    val numbers2 = arrayListOf(1,2,3)
    println(numbers.containsAll(numbers2))

    val set = setOf(3,5,7,null,7)
    println(set)
    val hashSet = hashSetOf(3,7,5,null,7)
    println(hashSet)
    hashSet.add(100)
    println(hashSet)
    val hashSet2 = hashSetOf(11,12,13)
    hashSet.addAll(hashSet2)
    println(hashSet)
    println(hashSet.containsAll(hashSet2))

    val hash1 = hashSetOf(1,2,3,"enes","elif")
    val hash2 = hashSetOf(2,3,4,"elif")
    println(hash1.intersect(hash2))
    hash1.retainAll(hash2)
    println(hash1)

    val countMap = mapOf(Pair(1,"one"), Pair(2,"two"), Pair(3,"three"))
    println(countMap)
    println(countMap.keys)
    println(countMap.values)

    val countHashMap = hashMapOf(Pair(1,"one"), Pair(2,"two"), Pair(3,"three"))
    countHashMap[4] = "four"
    println(countHashMap)

    val countHashMap2 = hashMapOf(Pair(20,"twnty"), Pair(21,"twntyone"), Pair(22,"twntythree"))
    countHashMap.putAll(countHashMap2)
    println(countHashMap)

    countHashMap.replace(2,"twotwo")
    println(countHashMap)

    println(countHashMap2.containsKey(20))
    println(countHashMap2.containsValue("twnty"))


    // Shorthand if
    val number = 0
    if (number == 0) println(true) else println(false)

    // in keyword

    val pet = "dog"
    val petList = listOf("dog","cat","horse")

    if (pet in petList) println(true) else println(false)

    var animal = "bird"
    var action = ""

    when(animal){
        "cat" ->{
            action = "pet it"
        }
        "dog" ->{
            action = "feed it"
        }
        else ->{
            action = "xd"
        }
    }
    println(action)

    var notSayisi = 0
    var notStringi = ""

    when(notSayisi){
        0 -> notStringi = "Kaldın"
        1 -> notStringi = "Geçtin"
    }
    println(notStringi)

    val month = "January"
    val days  = when(month){
        "January","March","May" -> 31
        "February" -> 30
        else -> 29
    }
    println(days)

    for (i in 1..4){
        val month = when(i){
            1-> "January"
            2-> "February"
            else->"xd"
        }
        println(month)
    }

    for(i in 10 downTo 0){
        println(i)
        when(i){
            9-> println("Start engine")
            6-> println("On your marks")
            3-> println("Get set")
            0-> println("Go")
        }
    }

    for(i in 10 downTo 0 step 3){
        println(i)
        when(i){
            9-> println("Start engine")
            6-> println("On your marks")
            3-> println("Get set")
            0-> println("Go")
        }
    }

    val number1 = 5
    var number2 = 0

    while (number2 < number1){
        number2++
        println(number2)
    }

    do {
        number2++
        println(number2)
    }while (number2 < number1)

    val usernames = hashSetOf("enes","elif","emir")
    var isFinished = false

    do {
        println("please choose a name")
        val input = readLine()?:""
        if (usernames.contains(input)){
            println("$input is taken")
        }else{
            println("$input is your new username")
            isFinished = true
            usernames.add(input)
        }
    }while (!isFinished)
    println(usernames)

    var onlyEven = arrayListOf(2,4,6,8,9,10)
    for (i in onlyEven){
        if (i % 2 == 0) continue
        println("$i even değil")
    }

    for (i in onlyEven){
        if (i % 2 != 0) break
        println("$i")
    }

    printName("Enes")
    multiplyNumber(2)
    sayHello("Enes","Emir","Elif")
    listAnimals()

    val names = arrayListOf("Enes","Elif","Mehmet")
    merhaba(names,myLambda)
}

/* --------------------------Functions----------------------------------*/

// Shorthand function yazımı.

fun printName(name : String) = println(name)
fun multiplyNumber(number : Int) = println(number * 2)

// Scope
/*
Bir fonksiyon içinde tanımlanan variable sadece o fonksiyon içindedir. Dışardan erişilemez.
 */

// Vararg
/*
Variable arguments demek. Birden fazla kez aynı tipte veri alabilir. Sadece tanımlandığı cinste veri alabilir.
 */

fun sayHello(vararg names : String){
    for (name in names) {
        println("Hello $name")
    }
}

// Local function
/*
Yani fonksiyon içinde fonksiyon.
 */

fun listAnimals(){
    fun listOneAnimal(animal : String){
        println("i have a $animal")
    }

    val animals = listOf("cat","dog","bird")
    for (animal in animals){
        listOneAnimal(animal)
    }
}

// Lambda functions. bunları higher order function'lara aktarabiliriz.
val myLambda = {name : String -> println("Hello $name") }

// Higher order function: Yani başka bir fonksiyonu parameter olarak alan fonksiyon. ( forEach, filter, map, sortedby gibi fonksiyonlarda HOF olarak geçer.)

fun merhaba(names : ArrayList<String>, doSomething : (String) -> Unit){
    for (name in names){
        doSomething(name)
    }
}