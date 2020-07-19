package com.example.codingstuff.ADAPTERS;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.codingstuff.C_Plus_Pack.C_Plus_Cheats;
import com.example.codingstuff.C_Plus_Pack.C_Plus_Video;
import com.example.codingstuff.C_Plus_Pack.C_plus_adv;
import com.example.codingstuff.C_Plus_Pack.C_plus_basic;
import com.example.codingstuff.C_Sharp.C_Sharp_Adv;
import com.example.codingstuff.C_Sharp.C_Sharp_Basic;
import com.example.codingstuff.C_Sharp.C_Sharp_Cheats;
import com.example.codingstuff.C_Sharp.C_Sharp_video;
import com.example.codingstuff.JAVA.Java_Basic_frag;
import com.example.codingstuff.JAVA.Java_Video_frag;
import com.example.codingstuff.JAVA.Java_adv_frag;
import com.example.codingstuff.JAVA.Java_cheats_frag;
import com.example.codingstuff.KOTLIN.Kotlin_adv;
import com.example.codingstuff.KOTLIN.Kotlin_basic;
import com.example.codingstuff.KOTLIN.Kotlin_cheats;
import com.example.codingstuff.KOTLIN.Kotlin_video;
import com.example.codingstuff.C_Plus_Pack.C_Plus_Cheats;
import com.example.codingstuff.C_Plus_Pack.C_Plus_Video;
import com.example.codingstuff.C_Plus_Pack.C_plus_adv;
import com.example.codingstuff.C_Plus_Pack.C_plus_basic;
import com.example.codingstuff.C_Sharp.C_Sharp_Adv;
import com.example.codingstuff.C_Sharp.C_Sharp_Basic;
import com.example.codingstuff.C_Sharp.C_Sharp_Cheats;
import com.example.codingstuff.C_Sharp.C_Sharp_video;
import com.example.codingstuff.JAVA.Java_Basic_frag;
import com.example.codingstuff.JAVA.Java_Video_frag;
import com.example.codingstuff.JAVA.Java_adv_frag;
import com.example.codingstuff.JAVA.Java_cheats_frag;
import com.example.codingstuff.KOTLIN.Kotlin_adv;
import com.example.codingstuff.KOTLIN.Kotlin_basic;
import com.example.codingstuff.KOTLIN.Kotlin_cheats;
import com.example.codingstuff.KOTLIN.Kotlin_video;

public class All_View_Pager_Adapter extends FragmentStatePagerAdapter {
    int no_of_tabs;
    String TAG;
    public All_View_Pager_Adapter(@NonNull FragmentManager fm, int behavior, int no_of_tabs, String TAG) {
        super(fm, behavior);
        this.no_of_tabs=no_of_tabs;
        this.TAG=TAG;
    }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(TAG.equals("KOTLIN")) {
                switch (position) {
                    case 0:
                        return new Kotlin_basic();
                    case 1:
                        return new Kotlin_adv();
                    case 2:
                        return new Kotlin_video();
                    case 3:
                        return new Kotlin_cheats();
                    default:
                        return null;
                }
            }
            else if(TAG.equals("JAVA")){
                switch (position) {
                    case 0:
                        return new Java_Basic_frag();
                    case 1:
                        return new Java_adv_frag();
                    case 2:
                        return new Java_Video_frag();
                    case 3:
                        return new Java_cheats_frag();
                    default:
                        return null;
                }
            }
            else if(TAG.equals("C_PLUS")){
                switch (position) {
                    case 0:
                        return new C_plus_basic();
                    case 1:
                        return new C_plus_adv();
                    case 2:
                        return new C_Plus_Video();
                    case 3:
                        return new C_Plus_Cheats();
                    default:
                        return null;
                }
            }
            else if(TAG.equals("C_SHARP")){
                switch (position) {
                    case 0:
                        return new C_Sharp_Basic();
                    case 1:
                        return new C_Sharp_Adv();
                    case 2:
                        return new C_Sharp_video();
                    case 3:
                        return new C_Sharp_Cheats();
                    default:
                        return null;
                }
            }

        return null;
    }

    @Override
    public int getCount() {
        return no_of_tabs;
    }
}
