package com.l.gui;

import android.widget.Button;

import com.l.AdditionalActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import folder.VisibleButtonUnitTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class ExampleUnitTest {
    private VisibleButtonUnitTest test;
    private AdditionalActivity additionalActivity;
    private Button button;


    @Before
    public void init() {
        test = Mockito.spy(new VisibleButtonUnitTest());
        additionalActivity = Mockito.spy(Robolectric.buildActivity(AdditionalActivity.class).create().get());
        button = (Button) additionalActivity.findViewById(R.id.button);

    }

    @Test
    public void isEvenNumber() throws Exception {
        when(test.isCountOfMinutesEvenNumber()).thenReturn(true);
        assertEquals("visible", test.nameOfReadyState());
    }

    @Test
    public void isNotEvenNumber() throws Exception {
        when(test.isCountOfMinutesEvenNumber()).thenReturn(false);
        assertEquals("invisible", test.nameOfReadyState());
    }

    @Test
    public void isButtonVisible() throws Exception {
        when(additionalActivity.isVisible()).thenReturn(true);
        additionalActivity.visibleTester(button);
        assertEquals(Button.VISIBLE, button.getVisibility());
    }

    @Test
    public void isButtonInvisible() throws Exception {
        when(additionalActivity.isVisible()).thenReturn(false);
        additionalActivity.visibleTester(button);
        assertEquals(Button.INVISIBLE, button.getVisibility());
    }

}