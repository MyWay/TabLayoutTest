package com.example.tablayout.tablayouttesting;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.UiThreadTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class TabLayoutTest {
    private TabActivity mActivity;

    @Rule
    public ActivityTestRule<TabActivity> mActivityRule = new ActivityTestRule<>(TabActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void swipePage() {
        onView(withId(R.id.pager))
            .check(matches(isDisplayed()));

        onView(withId(R.id.pager))
                .perform(swipeLeft());
    }

    @Test
    public void checkTabLayoutDisplayed() {
        onView(withId(R.id.pager_header))
            .perform(click())
            .check(matches(isDisplayed()));
    }

    @Test
    @UiThread
    public void checkTabSwitch() {
        // I'd like to switch to a tab (test2) and check that the switch happened
        onView(allOf(withText("test5"), isDescendantOfA(withId(R.id.pager_header))))
                .perform(click())
                .check(matches(isDisplayed()));

        // Then I'd like to check that the tab text (test2) matches the current fragment title
        assertThat(((MyFragment)mActivity.getAdapter().getCurrentFragment()).getTitle(), Matchers.equalTo("test5"));
    }
}