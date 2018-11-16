package com.flykey.customkeyboard.emojiKeyboard.onclicklisteners;

import android.util.Log;
import android.view.View;

import com.flykey.customkeyboard.emojiKeyboard.InputMethodServiceProxy;

public class LennyFaceOnClickListner implements View.OnClickListener {

    private final String lennyFace;
    private final InputMethodServiceProxy inputMethodService;

    public LennyFaceOnClickListner(String lennyFace, InputMethodServiceProxy inputMethodService) {
        this.lennyFace = lennyFace;
        this.inputMethodService = inputMethodService;
    }

    @Override
    public void onClick(View view) {
        char[] c_arr = lennyFace.toCharArray();

        for(int i = 0; i < c_arr.length; i++){
            Log.d(getClass().getName(), c_arr[i] + " This is the array");
            inputMethodService.sendKey(c_arr[i]);
        }
        //inputMethodService.sendKey(lennyFace);

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                EmojiDataSource.getInstance(inputMethodService.getContext())
                        .addEntry( CategorizedEmojiList.getInstance()
                                .searchForEmojiIgnoreModifier(emoji.getUnicodeHexcode(), emoji.getCategory().toString())
                        );
            }
        }).start();*/
    }
}
