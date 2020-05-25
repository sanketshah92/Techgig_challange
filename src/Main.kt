fun main(args: Array<String>) {

    processUserInput(Integer.parseInt(readLine()!!))
}

fun processUserInput(args: Int) {
    for (i in 0 until (args)) {
        val roundCount = Integer.parseInt(readLine())
        val teamOnePowers: ArrayList<String> = ArrayList(readLine()?.split(' '))
        teamOnePowers.remove(" ")
        teamOnePowers.remove("")
        val teamTwoPowers: ArrayList<String> = ArrayList(readLine()?.split(' '))
        teamTwoPowers.remove(" ")
        teamTwoPowers.remove("")
        preparePlanForBattle(
            roundCount,
            teamOnePowers.map { it.toInt() } as ArrayList<Int>,
            teamTwoPowers.map { it.toInt() } as ArrayList<Int>
        )
    }
}


fun preparePlanForBattle(rounds: Int, teamOne: ArrayList<Int>, teamTwo: ArrayList<Int>) {

    teamOne.sortDescending()
    teamTwo.sortDescending()
    var result = 0
    var tmp = 0
    for (i in 0 until teamOne.size)
        for (j in tmp until teamTwo.size) {
            if (teamOne[i] > teamTwo[j]) {
                result++
                tmp = j + 1
                break
            }
        }
    println("$result\n")

    startBattle()
}


fun startBattle() {

    publishBattleResult()
}

fun publishBattleResult() {

}

