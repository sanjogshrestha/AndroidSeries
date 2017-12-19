package np.cnblabs.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import np.cnblabs.tablayout.fragment.DashboardFragment;
import np.cnblabs.tablayout.fragment.HomeFragment;
import np.cnblabs.tablayout.fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new CustomAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tab = tabLayout.getTabAt(0);
        if (tab != null) {
            tab.setIcon(R.drawable.ic_home);
        }

        TabLayout.Tab tab1 = tabLayout.getTabAt(1);
        if (tab1 != null) {
            tab1.setIcon(R.drawable.ic_list);
        }

        TabLayout.Tab tab2 = tabLayout.getTabAt(2);
        if (tab2 != null) {
            tab2.setIcon(R.drawable.ic_notif);
        }
    }

    private class CustomAdapter extends FragmentStatePagerAdapter{
        Context context;
        private String[] tabTitles = {getString(R.string.home), getString(R.string.dashboard),
                getString(R.string.notification)};

        CustomAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return HomeFragment.newInstance();

                case 1:
                    return DashboardFragment.newInstance();

                case 2:
                    return NotificationFragment.newInstance();
            }

            return null;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
