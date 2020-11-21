package com.example.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Hindi translation for that word.
 */
public class Word {
    //Default translation for the word
    private String mDefaultTranslation;

    //Hindi translation for the word
    private String mHindiTranslation;

    /** Image resource ID for the word */
    private int mImageResourceId;

    /** Audio resource ID for the word */
    private int mAudioResourceId;

    /**
     * constructor , i.e. inorder to create object of Word class we need to pass this two string
     * DefaultTranslation and HindiTranslation
     */
    public Word(String defaultTranslation, String hindiTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mHindiTranslation = hindiTranslation;
        mAudioResourceId = audioResourceId;
    }
    /** Another constructor with mImageResourceId which is the drawable resource ID for the image */
    public Word(String defaultTranslation, String hindiTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mHindiTranslation = hindiTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Hindi translation of the word.
     */
    public String getHindiTranslation() {
        return mHindiTranslation;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
