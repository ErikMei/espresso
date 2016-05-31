package example.com.espressotest.tests;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import example.com.espressotest.MainActivity;
import example.com.espressotest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard; import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



/**
 * Created by Erik Mei on 5/28/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivitytest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testText() {
        String text = "Hello World!";
        onView(withId(R.id.textView)).check(matches(withText(text)));
    }
    @Test
    public void testReverse() {
        onView(withId(R.id.textToSave)).perform(typeText("honda civic"));
        onView(withId(R.id.saveButton)).perform(click());
        onView(withId(R.id.displayButton)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("civic adnoh")));
    }

}
