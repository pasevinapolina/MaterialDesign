package by.fpmi.pasevinapolina.materialremindme.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import by.fpmi.pasevinapolina.materialremindme.R;
import by.fpmi.pasevinapolina.materialremindme.adapter.ViewPagerAdapter;
import by.fpmi.pasevinapolina.materialremindme.fragment.FragmentFive;
import by.fpmi.pasevinapolina.materialremindme.fragment.FragmentFour;
import by.fpmi.pasevinapolina.materialremindme.fragment.FragmentOne;
import by.fpmi.pasevinapolina.materialremindme.fragment.FragmentThree;
import by.fpmi.pasevinapolina.materialremindme.fragment.FragmentTwo;

public class QuizActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    FragmentOne tabOne;
    FragmentTwo tabTwo;
    FragmentThree tabThree;
    FragmentFour tabFour;
    FragmentFive tabFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabOne = new FragmentOne();
        tabTwo = new FragmentTwo();
        tabThree = new FragmentThree();
        tabFour = new FragmentFour();
        tabFive = new FragmentFive();
        adapter.addFragment(tabOne, getString(R.string.title_section1).toUpperCase());
        adapter.addFragment(tabTwo, getString(R.string.title_section2).toUpperCase());
        adapter.addFragment(tabThree, getString(R.string.title_section3).toUpperCase());
        adapter.addFragment(tabFour, getString(R.string.title_section4).toUpperCase());
        adapter.addFragment(tabFive, getString(R.string.title_section5).toUpperCase());

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

}
