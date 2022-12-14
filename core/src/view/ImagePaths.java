package view;

/**
 * Enum class containing all the image-paths to pictures used
 * Can easily add more pictures later
 */
public enum ImagePaths {
    //CHARACTERS
    SMURF("smurf.png"),
    SMURFCARD("smurfCard.png"),
    SMURFLOOKLEFT("smurf_look_left.png"),
    BLUESMURFPUNCHINGRIGHT("punching_smurf.png"),
    BLUESMURFPUNCHINGLEFT("left_punching_smurf.png"),

    EVILSMURF("evilSmurf.png"),
    EVILSMURFCARD("evilSmurfCard.png"),
    EVILSMURFLOOKLEFT("evilSmurfLookLeft.png"),
    EVILSMURFPUNCHINGRIGHT("evilSmurfPunchLeft.png"),
    EVILSMURFPUNCHINGLEFT("left_punching_smurf.png"),

    SANIC("sanic.png"),
    SANICCARD("sanicCard.png"),
    SANICLOOKLEFT("sanicLookLeft.png"),
    SANICPUNCHINGRIGHT("sanicPunchRight.png"),
    SANICPUNCHINGLEFT("sanicPunchLeft.png"),

    LILLAMY("lillamy.png"),
    LILLAMYCARD("lillamyCard.png"),
    LILLAMYLOOKLEFT("lillamyLookLeft.png"),
    LILLAMYPUNCHINGRIGHT("lillamyPunchRight.png"),
    LILLAMYPUNCHINGLEFT("lillamyPunchLeft.png"),


    //PLAY & QUIT
    PLAYBUTTON("play_text.png"),
    QUITBUTTON("Quitknapp.png"),

    //ARROWS
    LEFTARROW("leftArrow.png"),
    RIGHTARROW("rightArrow.png"),

    //HEALTH & HEARTS
    ONEHEART("1Heart.png"),
    TWOHEART("2Heart.png"),
    THREEHEART("3Heart.png"),
    REDHEART("redHeart.png"),
    THREEGREYHEARTS("3greyHearts.png"),
    HEALTHMETER("healthMeter.png"),
    HEALTHMETERBACKGROUND("healthmeterbackground.png"),

    //MAP
    BACKGROUND("BackgroundMap.png"),
    MOONGROUND("groundMoon.png"),
    MOONSTONE("moonStone.png"),
    FRAMEBOARD("frameboard.png"),

    //STARTSCREEN & CHARACTER SELECTION
    CLOUDS("moln.png"),
    STARTBACKGROUND("smurf_game_background.png"),


    //GAME OVER SCREENS
    GAMEOVERSCREEN1("game_over_screen_player_1.png"),
    GAMEOVERSCREEN2("game_over_screen_player_2.png"),

    //GAME ICON
    ICON("icon.png"),

    //POWERUPS
    HEALTHPOWERUP("healthPowerUp.png"),

    //SOUND
    GAMESOUND("piano_beat.mp3"),
    HITSOUND("roblox.mp3");



    public final String label;

    /**
     * @param label is the image-path. Each enum has the attribute label
     */
    ImagePaths(String label) {
        this.label = label;
    }
}