package peakchao.com.peakdingding;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class UiTest {

    @Test
    public void useAppContext() throws UiObjectNotFoundException {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //assertEquals("peakchao.com.peakdingding", appContext.getPackageName());
        Instrumentation instr = InstrumentationRegistry.getInstrumentation();
        UiDevice uiDevice = UiDevice.getInstance(instr);
        // 启动测试App
//        Intent intent = appContext.getPackageManager().getLaunchIntentForPackage("peakchao.com.peakdingding");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        appContext.startActivity(intent);

        String resourceId = "com.miui.home:id/cell_layout";
        UiObject collapsingToolbarLayout = uiDevice.findObject(new UiSelector().resourceId(resourceId));
        //collapsingToolbarLayout.click();
        for (int i = 0; i < 5; i++) {
            uiDevice.swipe(100, uiDevice.getDisplayHeight() / 2,
                    uiDevice.getDisplayWidth(), uiDevice.getDisplayHeight() / 2, 100);
        }
        for (int i = 0; i < 5; i++) {
            uiDevice.swipe(uiDevice.getDisplayWidth() - 100, uiDevice.getDisplayHeight() / 2,
                    0, uiDevice.getDisplayHeight() / 2, 100);
        }
    }
}
