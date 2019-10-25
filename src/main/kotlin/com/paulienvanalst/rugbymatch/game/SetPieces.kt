package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.team.Team

interface SetPiece {
    val teamThrowingIn: Team
    val otherTeam: Team

    fun isValid() : Boolean
}

data class Scrum(override val teamThrowingIn : Team, override val otherTeam: Team) : SetPiece {
    override fun isValid() : Boolean{
       return teamThrowingIn.hasScrum() and otherTeam.hasScrum()
    }

}
data class LineOut(override val teamThrowingIn : Team, override val otherTeam: Team) : SetPiece {
    override fun isValid(): Boolean {
        return teamThrowingIn.nrOfPlayersInLineOut == otherTeam.nrOfPlayersInLineOut
    }
}
