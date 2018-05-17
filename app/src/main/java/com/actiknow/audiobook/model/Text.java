package com.actiknow.audiobook.model;

import android.text.Spanned;

/**
 * Created by sud on 4/4/18.
 */

public class Text {
    Spanned html;
    String text;
    
    public Text (Spanned html, String text) {
        this.html = html;
        this.text = text;
    }
    
    public Spanned getHtml () {
        return html;
    }
    
    public void setHtml (Spanned html) {
        this.html = html;
    }
    
    public String getText () {
        return text;
    }
    
    public void setText (String text) {
        this.text = text;
    }
}
