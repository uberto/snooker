package com.ubertob

import com.ubertob.Balls.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo


class PerfectBreakTest {

    /*
    red ball =1
    yellow =2
    green=3
    brown=4
    blue=5
    pink=6
    black=7

    colors=all but the red ones
    15 red balls

    you need to pot red and a color alternatively

    colors comes back to the table, reds stay out

    when all reds are gone, you have to pot the colors in ascending order
     */

    @Test
    fun `snooker simple example`() {

        val score = 7 //only black on the table

        val ballSequence = calculatePerfectBreak(score)
        expectThat(ballSequence).isEqualTo(listOf(black))
    }


    @Test
    fun `snooker 4 balls example`() {

        val score = 20 //no reds on the table

        val ballSequence = calculatePerfectBreak(score)
        expectThat(ballSequence).isEqualTo(
            listOf(brown, blue, pink, black)
        )
    }

    @Test
    fun `snooker no reds on the table example`() {

        val score = 27 //no reds on the table

        val ballSequence = calculatePerfectBreak(score)
        expectThat(ballSequence).isEqualTo(
            listOf(yellow, green, brown, blue, pink, black)
        )
    }

    @Test
    fun `snooker one red on the table example`() {

        val score = 35 //one red on the table

        val ballSequence = calculatePerfectBreak(score)
        expectThat(ballSequence).isEqualTo(
            listOf(red, black, yellow, green, brown, blue, pink, black)
        )
    }

    @Test
    fun `snooker two reds on the table example`() {

        val score = 36 //two reds on the table

        val ballSequence = calculatePerfectBreak(score)
        expectThat(ballSequence).isEqualTo(
            listOf(red, black, red, black, yellow, green, brown, blue, pink, black)
        )
    }

    @Test
    fun `snooker all balls example`() {

        val score = 147

        val ballSequence = calculatePerfectBreak(score)
        expectThat(ballSequence.count { it == red }).isEqualTo(15)
        expectThat(ballSequence.count { it == black }).isEqualTo(16)
        expectThat(ballSequence.count { it == blue }).isEqualTo(1)
        expectThat(ballSequence.count { it == brown }).isEqualTo(1)
        expectThat(ballSequence.count { it == green }).isEqualTo(1)
        expectThat(ballSequence.count { it == yellow }).isEqualTo(1)
        expectThat(ballSequence.count { it == pink }).isEqualTo(1)

    }


}


