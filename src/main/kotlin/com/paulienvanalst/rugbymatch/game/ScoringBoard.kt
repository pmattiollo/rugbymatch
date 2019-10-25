package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.events.ScoringEvent
import com.paulienvanalst.rugbymatch.events.StartGame
import com.paulienvanalst.rugbymatch.team.NotImplementedException
import com.paulienvanalst.rugbymatch.team.Team
import com.paulienvanalst.rugbymatch.team.TeamName
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
open class ScoringBoard() {

    private lateinit var hostingTeam: TeamName
    private lateinit var visitingTeam: TeamName

    private var scoringHistory : List<Score> = emptyList()

    @EventListener
    fun handle(event: StartGame) {
        hostingTeam = event.hostingTeam
        visitingTeam = event.visitingTeam
    }

    @EventListener
    fun handle(event: ScoringEvent) {
        val score: Score = Score(event.team, event.type)
        scoringHistory += score
    }

    fun currentScore(): GameScore {
        return scoringHistory.getGameScore(hostingTeam, visitingTeam)
    }

    fun clear () {
        scoringHistory = emptyList()
    }
}


