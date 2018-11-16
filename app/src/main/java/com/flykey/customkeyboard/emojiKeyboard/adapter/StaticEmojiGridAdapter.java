package com.flykey.customkeyboard.emojiKeyboard.adapter;

import android.content.Context;

import java.util.List;

import com.flykey.customkeyboard.emojiKeyboard.InputMethodServiceProxy;
import com.flykey.customkeyboard.emojiKeyboard.utilities.Emoji;

public class StaticEmojiGridAdapter extends BaseEmojiGridAdapter {

    public StaticEmojiGridAdapter(Context context, List<Emoji> emojiList) {
        super((InputMethodServiceProxy) context);
        setEmojiList(emojiList);
    }
}