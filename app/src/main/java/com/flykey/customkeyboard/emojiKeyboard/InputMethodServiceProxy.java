package com.flykey.customkeyboard.emojiKeyboard;

import android.content.Context;

public interface InputMethodServiceProxy {
    //void sendDownAndUpKeyEvent(int keyCode, int flags);
    void keyDownUp(int keyEventCode);

    void handleLanguageSwitch();

    void sendKey(int keyCode);

    Context getContext();

    int getDrawableResourceId(String resourceString);
}
