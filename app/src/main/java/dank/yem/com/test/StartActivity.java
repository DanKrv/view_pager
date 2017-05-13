package dank.yem.com.test;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class StartActivity extends FragmentActivity {

    PageAdapter  mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        List<Fragment> fragments = getFragments();

        mPageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(mPageAdapter);

    }
    private List<Fragment> getFragments(){
        List<Fragment> fragmentList = new ArrayList<>();


        return fragmentList;
    }
//    private List<Fragment> getFragments(){
//        List<Fragment> fragmentList = new ArrayList<>();
//        fragmentList.add(MyFragment.newInstance("label 1", "label 2", "image"));
//        fragmentList.add(MyFragment.newInstance("label 1", "label 2", "image"));
//
//        return fragmentList;
//    }
}
