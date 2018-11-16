/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flykey.customkeyboard.settings;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
//import android.provider.Settings;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

//import com.android.inputmethodcommon.InputMethodSettingsImpl;
import com.android.inputmethodcommon.InputMethodSettingsImpl;
import com.android.inputmethodcommon.InputMethodSettingsInterface;
import com.blackcj.customkeyboard.R;
import com.flykey.customkeyboard.emojiKeyboard.constants.Constants;

import android.widget.Toast;

import java.util.List;


/**
 * Displays the IME preferences inside the input method setting.
 */
public class ImePreferences extends AppCompatActivity {

    public static final String CHANGE_ICON_SET_KEY = "icon_set";
    public static final String CHANGE_ICON_SET_VALUE_DEFAULT = "emojione_emoji_";
    private static final String ARGUMENT_SETTINGS = "settings";

    //@Override
    //public Intent getIntent() {
    //   final Intent modIntent = new Intent(super.getIntent());
    //   modIntent.putExtra(EXTRA_SHOW_FRAGMENT, Settings.class.getName());
    //   modIntent.putExtra(EXTRA_NO_HEADERS, true);
    //   return modIntent;
    //}

    private boolean isEmojiKeyboardEnabled;

    @Override
    protected void onStart() {
        super.onStart();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        List<InputMethodInfo> enabledInputMethodList = inputMethodManager.getEnabledInputMethodList();
        isEmojiKeyboardEnabled = false;
        for(InputMethodInfo inputMethodInfo: enabledInputMethodList) {
            Log.d("onStart",inputMethodInfo.getId().toString() + " " + Constants.EMOJI_KEYBOARD_ID);
            if(inputMethodInfo.getId().compareTo(Constants.EMOJI_KEYBOARD_ID) == 0) {
                isEmojiKeyboardEnabled = true;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment())
                .commit();
    }

    //@Override
    //public void onBuildHeaders(List<Header> target) {
    //    loadHeadersFromResource(R.xml.preferences_header_shared, target);
    //}

    //@Override
    //public void onHeaderClick(PreferenceActivity.Header header, int position){

        //String[] array = null;
        //Set<String> set = (header.extras).toString();

        //array = set.toArray(new String[set.size()]);

        //for (String key: array)
        //{
        //Log.d("OnHeaderClick ",String.valueOf(header.fragmentArguments.containsKey(ARGUMENT_SETTINGS)));
        //SettingsFragment mFragment = SettingsFragment.
         //           newInstance(header.fragmentArguments.getString(ARGUMENT_SETTINGS));
        //SettingsFragment mFragment = new SettingsFragment();

        //Log.d("OnHeaderClick ", mFragment.getArguments().getString(ARGUMENT_SETTINGS));

        //invalidateHeaders();

        //if(header.fragment != null){
            //int titleRes = header.breadCrumbTitleRes;
            //int shortTitleRes = header.breadCrumbShortTitleRes;
            //if(titleRes == 0){
            //    titleRes = header.titleRes;
            //    shortTitleRes = 0;
            //}
            //onAttachFragment(mFragment);
            //Log.d("OnHeaderClick ", mFragment.getClass().getName() + " isValidFragment");
            //startPreferenceFragment(mFragment,true);

            //startWithFragment(header.fragment, header.fragmentArguments, mFragment, 0, titleRes, shortTitleRes);

            /**
            if(isValidFragment(mFragment.getClass().getName())) {
                Log.d("OnHeaderClick ", "Working with verifying the fragment");
                mFragment.onAttach(this.getApplicationContext());
                onAttachFragment(mFragment);
                mFragment.onCreate(mFragment.getArguments());
                if(mFragment.isAdded()) {

                    Log.d("OnHeaderClick ", "is added Fragment to activity");

                    startWithFragment(header.fragment, header.fragmentArguments, mFragment, 0, titleRes, shortTitleRes);
                }
            }
             **/
        //}
        //invalidateHeaders();
        //}
        //Log.d(header,"Trial");
        //getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragments()).commit();
        //getFragmentManager().beginTransaction().addToBackStack("languageSettings").
        //        replace(android.R.id.content, fragment).commit();
        //startPreferenceFragment(fragment, false);
    //}
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu, menu);
                return true;
            }

    /**
     * react to the user tapping/selecting an options menu item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Toast.makeText(this, "ADD!", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(this, MyPreferencesActivity.class);
                //startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //@Override
    //protected boolean isValidFragment(final String fragmentName) {
     //   Log.d("isValidFragment","looking");
    //    Log.d("isValidFragment",SettingsFragment.class.getName());
    //    return SettingsFragment.class.getName().equals(fragmentName);
    //}

    public static class SettingsFragment extends PreferenceFragmentCompat
            implements InputMethodSettingsInterface {
        private final InputMethodSettingsImpl mSettings = new InputMethodSettingsImpl();
        //http://blog.petrnohejl.cz/handling-bundles-in-activities-and-fragments
        //here I am taking the reference
        //public static SettingsFragment newInstance(String settings){
         //   SettingsFragment fragmentSetting = new SettingsFragment();

        //    Bundle arguments = new Bundle();
        //    arguments.putString(ARGUMENT_SETTINGS,settings);
        //    fragmentSetting.setArguments(arguments);

        //    return fragmentSetting;
        //}

        //public SettingsFragment(){

        //}

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
            //getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            Log.d("here","OnCreate of the settings fragment");
            //final Context context = getActivity();
            //addPreferencesFromResource(R.xml.ime_preferences);
            //PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);
            //Bundle extras = getActivity().getIntent().getExtras();

            //PreferenceScreen screen1 = (PreferenceScreen) findPreference("mainPreference");
            //Bundle arguments = getArguments();
            //String settings = arguments.getString(ARGUMENT_SETTINGS);
            //String settings = (getArguments().getBundle("settings")).getString("settings");

            //Log.d(getTag(),"This i get: " + settings);

            // Load the preferences from an XML resource


            //} else if(getString(R.string.emoji_icon_set).equals(settings)) {
                //Log.d(getTag(),"Emoji Icon Set");
                //addPreferencesFromResource(R.xml.settings);
            //}
        }

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            //setInputMethodSettingsCategoryTitle(R.string.language_selection_title);
            //setSubtypeEnablerTitle(R.string.select_language);
            final Context context = this.getContext();
            //addPreferencesFromResource(R.xml.ime_preferences);
            //for(int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {

                //Preference preference1 = getPreferenceScreen().getPreference(i);
            PreferenceScreen prefScreen = getPreferenceManager().createPreferenceScreen(context);
                //if(prefScreen.getKey().equals(getString(R.string.main_preference))) {
                 //   Log.d("Preferences",
                //            String.valueOf(preference1.getKey().
                //                    equals(getString(R.string.main_preference))) + " Looking");
               //     Log.d(" -> Preferences", preference1.getKey() + " we are checking");
                //    preference1.
                    //PreferenceScreen pref1 = preference1.getPreferenceManager().createPreferenceScreen(context);
                    mSettings.init(context, prefScreen);

                    setInputMethodSettingsCategoryTitle(R.string.language_selection_title);
                    setSubtypeEnablerTitle(R.string.select_language);
                    //preference1.getPreferenceManager().setPreferences(pref1);
                //}
            //}
            ListPreference listPref = new ListPreference(context);
            listPref.setKey(getString(R.string.setting_change_icon_set_key));
            listPref.setTitle(getString(R.string.emoji_icon_set));
            listPref.setEntries(R.array.emojiIconsCategory);
            listPref.setEntryValues(R.array.emojiIconsCategoryValues);
            listPref.setDefaultValue(R.string.setting_change_icon_set_value_emojione);
            listPref.setSummary(getString(R.string.summary_icon_set));

            prefScreen.addPreference(listPref);
            setPreferenceScreen(prefScreen);
        }

        @Override
        public void onStart(){
            super.onStart();

        }

        @Override
        public void onSaveInstanceState(Bundle outState)
        {
            // save current instance state
            super.onSaveInstanceState(outState);

             //TODO
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_settings:
                    Toast.makeText(this.getActivity(), "ADD!", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(this, MyPreferencesActivity.class);
                    //getFragmentManager().popBackStack();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setInputMethodSettingsCategoryTitle(int resId) {
            mSettings.setInputMethodSettingsCategoryTitle(resId);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setInputMethodSettingsCategoryTitle(CharSequence title) {
            mSettings.setInputMethodSettingsCategoryTitle(title);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setSubtypeEnablerTitle(int resId) {
            mSettings.setSubtypeEnablerTitle(resId);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setSubtypeEnablerTitle(CharSequence title) {
            mSettings.setSubtypeEnablerTitle(title);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setSubtypeEnablerIcon(int resId) {
            mSettings.setSubtypeEnablerIcon(resId);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setSubtypeEnablerIcon(Drawable drawable) {
            mSettings.setSubtypeEnablerIcon(drawable);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onResume() {
            super.onResume();
            mSettings.updateSubtypeEnabler();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!isEmojiKeyboardEnabled) {
            pleaseEnableInputMethodDialog();
        }
    }

    private void pleaseEnableInputMethodDialog() {
        final MaterialDialog enableInputMethodNotificationDialog = new MaterialDialog.Builder(this)
                .title(R.string.enable_ime_dialog_title)
                .content(R.string.enable_ime_dialog_content)
                .neutralText(R.string.enable_ime_dialog_neutral_button_text)
                .cancelable(false)
                .canceledOnTouchOutside(false)
                .build();

        enableInputMethodNotificationDialog.getBuilder()
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        startActivityForResult(new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS), 0);
                        enableInputMethodNotificationDialog.dismiss();
                    }
                });

        enableInputMethodNotificationDialog.show();
    }
}
