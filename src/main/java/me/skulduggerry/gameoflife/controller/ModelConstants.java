package me.skulduggerry.gameoflife.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelConstants {

    public static final String FILE_ID = "file";
    public static final String TABLE_DIV_ID = "table_div";
    public static final String TABLE_ID = "table";
    public static final String UPLOAD_BUTTON_ID = "upload_button";
    public static final String NEXT_GEN_BUTTON_ID = "next_gen_button";

    public static final String UPLOAD_TITLE = "Upload a generation";
    public static final String UPLOAD_MESSAGE = "Upload a file.";
    public static final String UPLOAD_INVALID = "Uploaded file is invalid!";
    public static final String UPLOAD_BUTTON = "Upload File";

    public static final String NEXT_GEN_TITLE = "Calculate the next generation";
    public static final String NEXT_GEN_BUTTON = "Next Generation";

}
