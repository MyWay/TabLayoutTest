package com.example.tablayout.tablayouttesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
    @android.support.test.annotation.UiThreadTest
    public void checkTabLayoutDisplayed() {
        onView(withId(R.id.pager_header))
            .perform(click())
            .check(matches(isDisplayed()));
    }

    @Test
    @android.support.test.annotation.UiThreadTest
    public void checkTabSwitch() {
        // I'd like to switch to a tab (test2) and check that the switch happened
        onView(withText("test2"))
                .perform(click())
                .check(matches(isDisplayed()));

        // Then I'd like to check that the tab text (test2) matches the current fragment title
        assertThat(((MyFragment)mActivity.getAdapter().getCurrentFragment()).getTitle(), Matchers.equalTo("test2"));
    }
}