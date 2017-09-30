package com.example.android.miwok;

/**
 * Created by Manuel on 3/1/2017.
 */

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int textViewBackGround;
    private int musicResourceId;

    public Word(String gDefaultTranslarion, String gMiwokTranslation, int gmusicResourceId){
        defaultTranslation = gDefaultTranslarion;
        miwokTranslation = gMiwokTranslation;
        musicResourceId = gmusicResourceId;
    }
    public Word(String gDefaultTranslarion, String gMiwokTranslation, int gImageResourceId, int gmusicResourceId){
        defaultTranslation = gDefaultTranslarion;
        miwokTranslation = gMiwokTranslation;
        imageResourceId = gImageResourceId;
        musicResourceId = gmusicResourceId;
    }
    /*public Word(String gDefaultTranslarion, String gMiwokTranslation, int gImageResourceId, int gTextViewBackGround){
        defaultTranslation = gDefaultTranslarion;
        miwokTranslation = gMiwokTranslation;
        imageResourceId = gImageResourceId;
        textViewBackGround = gTextViewBackGround;
    }*/

    public int getMusicResourceId(){ return musicResourceId; }

    public int getImageResourceId(){ return imageResourceId; }

    public String getDefaultTranslation(){
        return defaultTranslation;
    }

    public String getMiwokTranslation(){
        return miwokTranslation;
    }

    public void setTextViewBackGround( int gtextViewBackGround){
        textViewBackGround=gtextViewBackGround;
    }
    public int getTextViewBackGround(){
        return textViewBackGround;
    }

    public boolean hasImage(){
        return imageResourceId!=NO_IMAGE_PROVIDED;
    }

    public void setImageResourceId(int gImageResourceId){
        imageResourceId = gImageResourceId;
    }
    public void setDefaultTranslation(String gDefaultTranslation){
        defaultTranslation = gDefaultTranslation;
    }

    public void setMiwokTranslation(String gMiwokTranslation){
        miwokTranslation = gMiwokTranslation;
    }

    @Override
    public String toString() {
        return "Word{" +
                "defaultTranslation='" + defaultTranslation + '\'' +
                ", miwokTranslation='" + miwokTranslation + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", textViewBackGround=" + textViewBackGround +
                ", musicResourceId=" + musicResourceId +
                '}';
    }
}
