package com.flykey.customkeyboard.emojiKeyboard.onclicklisteners;

import android.os.Handler;
import android.widget.ImageButton;

import com.flykey.customkeyboard.emojiKeyboard.InputMethodServiceProxy;
import com.flykey.customkeyboard.emojiKeyboard.constants.Constants;

public class LongButtonPressRunnable implements Runnable{

    private static Handler longButtonPressHandler;
    private static InputMethodServiceProxy inputMethodService;
    private final int keycode;
    private final ImageButton button;

    public LongButtonPressRunnable(int keycode, ImageButton button) {
        this.keycode = keycode;
        this.button = button;
    }

    @Override
    public void run() {
        inputMethodService.keyDownUp(keycode);
        if(button.isPressed()) {
            longButtonPressHandler.postDelayed(this, Constants.DELAY_MILLIS_LONG_PRESS_CONTINUATION);
        }
    }

    public static void setInputMethodService(InputMethodServiceProxy inputMethodService) {
        LongButtonPressRunnable.inputMethodService = inputMethodService;
    }

    public static void setLongButtonPressHandler(Handler longButtonPressHandler) {
        LongButtonPressRunnable.longButtonPressHandler = longButtonPressHandler;
    }
}
