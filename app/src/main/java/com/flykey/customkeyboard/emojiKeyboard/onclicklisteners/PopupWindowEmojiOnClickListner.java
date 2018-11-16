package com.flykey.customkeyboard.emojiKeyboard.onclicklisteners;

import android.view.View;
import android.widget.PopupWindow;

import com.flykey.customkeyboard.emojiKeyboard.InputMethodServiceProxy;
import com.flykey.customkeyboard.emojiKeyboard.utilities.Emoji;

public class PopupWindowEmojiOnClickListner extends EmojiOnClickListner {

    private final PopupWindow popupWindow;

    public PopupWindowEmojiOnClickListner(Emoji emoji, InputMethodServiceProxy inputMethodService, final PopupWindow popupWindow) {
        super(emoji, inputMethodService);
        this.popupWindow = popupWindow;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        popupWindow.dismiss();
    }

}
