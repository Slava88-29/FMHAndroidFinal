package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.concurrent.TimeoutException;

public final class ElementsHelper {
    private ElementsHelper() {}
    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
    public static Matcher<View> hasItemAtPosition(final Matcher<View> matcher, final int position) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                matcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                return matcher.matches(viewHolder.itemView);
            }
        };
    }

    public static boolean isElementDisplayed(ViewInteraction view) {
        try {
            view.check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException | AssertionFailedError e) {
            return false;
        }
    }


    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> has been displayed during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> matchId = withId(viewId);
                final Matcher<View> matchDisplayed = isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchId.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };

    }
}