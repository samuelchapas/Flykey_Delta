package com.flykey.customkeyboard.emojiKeyboard.adapter;

import android.content.Context;

import com.flykey.customkeyboard.emojiKeyboard.InputMethodServiceProxy;
import com.flykey.customkeyboard.emojiKeyboard.sqlite.EmojiDataSource;

public class RecentEmojiGridAdapter extends BaseEmojiGridAdapter {

    public RecentEmojiGridAdapter(Context context) {
        super((InputMethodServiceProxy) context);
        dataSource = EmojiDataSource.getInstance(context);
    }

    private final EmojiDataSource dataSource;

    @Override
    public int getCount() {
        setEmojiList(dataSource.getAllEntriesInDescendingOrderOfCount());
        return getEmojiList().size();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dataSource.close();
    }
}