package me.skulduggerry.gameoflife.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Binding {

    public static final String ROOT = "/";
    public static final String UI_PATH = ROOT + "ui/";

    public static final String INDEX_PATH = UI_PATH;
    public static final String GENERATION_CREATOR_PATH = UI_PATH + "generationCreator";
    public static final String UPLOAD_PATH = ROOT + "upload";
    public static final String CURRENT_GENERATION_PATH = ROOT + "currentGeneration";
    public static final String NEXT_GENERATION_PATH = ROOT + "nextGeneration";

    public static final String INDEX_FORWARD = "index";
    public static final String GENERATION_CREATOR_FORWARD = "generation_creator";
}
