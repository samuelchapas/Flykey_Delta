package com.flykey.customkeyboard.emojiKeyboard.onclicklisteners;

import android.util.Log;
import android.view.View;

import com.flykey.customkeyboard.emojiKeyboard.InputMethodServiceProxy;
import com.flykey.customkeyboard.emojiKeyboard.sqlite.EmojiDataSource;
import com.flykey.customkeyboard.emojiKeyboard.utilities.CategorizedEmojiList;
import com.flykey.customkeyboard.emojiKeyboard.utilities.Emoji;

public class EmojiOnClickListner implements View.OnClickListener {

    private final Emoji emoji;
    private final InputMethodServiceProxy inputMethodService;

    public EmojiOnClickListner(Emoji emoji, InputMethodServiceProxy inputMethodService) {
        this.emoji = emoji;
        this.inputMethodService = inputMethodService;
    }

    @Override
    public void onClick(View view) {

        char[] c_arr = emoji.getUnicodeJavaString().toCharArray();

        for(int i = 0; i < c_arr.length; i++){
            Log.d(getClass().getName(), c_arr[i] + " This is the array");
            //int working = c_arr[i];
            inputMethodService.sendKey(c_arr[i]);
            Log.d(getClass().getName(), ((int) c_arr[i]) + " This is the array");
        }
        //inputMethodService.sendKey((int) emoji.getUnicodeJavaString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                EmojiDataSource.getInstance(inputMethodService.getContext())
                        .addEntry( CategorizedEmojiList.getInstance()
                                .searchForEmojiIgnoreModifier(emoji.getUnicodeHexcode(), emoji.getCategory().toString())
                        );
            }
        }).start();
    }
}
