package com.ubertob


val bestRedElimination = listOf(Balls.red, Balls.black)
val all = listOf(Balls.yellow, Balls.green, Balls.brown, Balls.blue, Balls.pink, Balls.black)

fun calculatePerfectBreak(expectedScore: Int): Break =

    if (stillRedOnTheTable(expectedScore)) {
        bestRedElimination + calculatePerfectBreak(Integer.max(expectedScore - 8, 27))
    } else {
        when {
            expectedScore <= Balls.black.value -> listOf(Balls.black)
            expectedScore <= Balls.pink.value + Balls.black.value -> listOf(Balls.pink, Balls.black)
            expectedScore <= Balls.blue.value + Balls.pink.value + Balls.black.value -> listOf(
                Balls.blue,
                Balls.pink,
                Balls.black
            )
            expectedScore <= Balls.brown.value + Balls.blue.value + Balls.pink.value + Balls.black.value -> listOf(
                Balls.brown,
                Balls.blue,
                Balls.pink,
                Balls.black
            )
            expectedScore <= Balls.green.value + Balls.brown.value + Balls.blue.value + Balls.pink.value + Balls.black.value -> listOf(
                Balls.green,
                Balls.brown,
                Balls.blue,
                Balls.pink,
                Balls.black
            )
            expectedScore <= Balls.yellow.value + Balls.green.value + Balls.brown.value + Balls.blue.value + Balls.pink.value + Balls.black.value -> listOf(
                Balls.yellow,
                Balls.green,
                Balls.brown,
                Balls.blue,
                Balls.pink,
                Balls.black
            )
            else -> all
        }

    }


private fun stillRedOnTheTable(expectedScore: Int): Boolean =
    expectedScore > 27