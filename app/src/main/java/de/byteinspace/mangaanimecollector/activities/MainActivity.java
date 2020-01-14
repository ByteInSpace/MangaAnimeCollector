package de.byteinspace.mangaanimecollector.activities;

import android.os.Bundle;

import de.byteinspace.mangaanimecollector.R;

public class MainActivity extends BasicActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        protected int getContentView() {
            return R.layout.activity_main_public;
        }
}
