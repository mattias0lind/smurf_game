package com.States;

public enum ImagePaths {
    //Characters
    SMURF("smurf.png"),
    SMURFCARD("smurfCard.png"),
    SMURFLOOKLEFT("smurf_look_left.png"),
    BLUESMURFPUNCHING("punching_smurf.png"),

    //PLAY & QUIT
    PLAYBUTTON("play_text.png"),
    QUITBUTTON("Quitknapp.png"),

    //ARROWS
    LEFTARROW("leftArrow.png"),
    RIGHTARROW("rightArrow.png"),

    //HEARTS
    REDHEART("redHeart.png"),
    THREEGREYHEARTS("3greyHearts.png"),



    EVILSMURF("evilSmurf.png"),
    EVILSMURFCARD("evilSmurfCard.png"),
    LILLAMY("lillamy.png"),
    LILLAMYCARD("lillamyCard.png"),

    //MAP
    BACKGROUND("BackgroundMap.png"),


    FRAMEBOARD("frameboard.png"),
    GAMEOVERSCREEN1("game_over_screen_player_1.png"),
    GAMEOVERSCREEN2("game_over_screen_player_2.png"),
    MOONGROUND("groundMoon.png"),
    HEALTHMETER("healthMeter.png"),
    HEALTHMETERBACKGROUND("healthmeterbackground.png"),
    ICON("icon.png");



    public final String label;
    private ImagePaths(String label) {
        this.label = label;
    }
}