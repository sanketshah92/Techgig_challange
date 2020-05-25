import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

fun main(args: Array<String>) {
    val ingrediantCount = readLine()
    var ingrediants: ArrayList<ArrayList<Long>>? = null

    ingrediantCount?.toLong()?.let {
        if (it <= 10000000)
            ingrediants = createInventory(ingrediantCount = it)
    }

    val ingrediantQty: ArrayList<String> = ArrayList(readLine()!!.split(' '))
    ingrediantQty.remove(" ")
    ingrediantQty.remove("")

    val availableQty = ArrayList<String>(readLine()!!.split(' '))
    availableQty.remove(" ")
    availableQty.remove("")
    try {
        mixingThePowersAndCreateSuperGirl(availableQty, ingrediantQty)
    } catch (e: Exception) {
        print(0)
    }
}

@Throws(NumberFormatException::class)
fun createInventory(ingrediantCount: Long): ArrayList<ArrayList<Long>> {
    val ingrediants = ArrayList<ArrayList<Long>>()
    for (i in 0 until ingrediantCount) {
        ingrediants.add(ArrayList<Long>())
    }
    return ingrediants
}


@Throws(IndexOutOfBoundsException::class, NumberFormatException::class)
fun mixingThePowersAndCreateSuperGirl(availableQty: ArrayList<String>, requiredQty: ArrayList<String>) {
    val map = LinkedHashMap<Long, Long>()
    val tmp = ArrayList<Long>()
    for (available in availableQty.withIndex()) {
        map[available.value.toLong()] = requiredQty[available.index].toLong()
        if (requiredQty[available.index].toLong() > 0 && available.value.toLong() <= Long.MAX_VALUE)
            tmp.add(available.value.toLong() / requiredQty[available.index].toLong())
    }
    tmp.sort()
    print("${tmp[0]}\n")
}
