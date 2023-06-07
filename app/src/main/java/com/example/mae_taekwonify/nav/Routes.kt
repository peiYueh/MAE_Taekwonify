package com.example.mae_taekwonify.nav

sealed class Routes(val route: String){
    object Menu : Routes("Menu")
    object TeamManagerLogin : Routes("TeamManagerLogin")
    object TeamManagerSignUp : Routes("TeamManagerSignUp")
    object Homepage : Routes("Homepage")
    object TeamList : Routes("TeamList")
    object ParticipantList : Routes("ParticipantList")
    object ParticipantDetails : Routes("ParticipantDetails")
    object ManageTeam : Routes("ManageTeam")
    object FollowingParticipants : Routes("FollowingParticipants")
    object MedalTally : Routes("MedalTally")
    object CompetitionProgress : Routes("CompetitionProgress")
    object CompetitionInfo : Routes("CompetitionInfo")
    object TeamManagerHelpdesk : Routes("TeamManagerHelpdesk")
    object EliminationChart : Routes("EliminationChart")
    object ModifyParticipants : Routes("ModifyParticipants")
    object AddParticipant : Routes("AddParticipant")
}