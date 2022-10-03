package com.States;

public enum ImagePaths {
    BACKGROUND("BackgroundMap.png"),
    THREEGREYHEARTS("3greyHearts.png"),
    EVILSMURF("evilSmurf.png"),
    EVILSMURFCARD("evilSmurfCard.png"),
    FRAMEBOARD("frameboard.png"),

    public final String label;

    private ImagePaths(String label) {
        this.label = label;
    }
}