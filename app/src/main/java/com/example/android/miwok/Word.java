package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a defualt translation and a Miwok translation for that wrod
 */
public class Word {

    // Default translation for the word
    private String mDefaultTranslation;


    // Miwok translation for the word
    private String mMiwokTranslation;

    // Drawable resource ID
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the word */
    private int mAudioResourceId;

    // Create a new Word Object that have default & miwok words only
    public Word(String defualtTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defualtTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    // Create a new Word Object that have default & miwok words
    public Word(String defualtTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defualtTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    // Get the default translation of the word.
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    // Get the Miwok translation of the word.
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    // Get the image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // returns whether or not there is an image for this word
    public boolean hasImage(){
            return  mImageResourceId != NO_IMAGE_PROVIDED;
        }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }


}
