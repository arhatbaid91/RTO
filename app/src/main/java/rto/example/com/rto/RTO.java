package rto.example.com.rto;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.multidex.MultiDex;

import com.pixplicity.easyprefs.library.Prefs;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ridz1 on 13/04/2017.
 */

public class RTO extends Application {

    public Context context;
    private static EventBus _bus;

    public static EventBus getEventBus() {
        if (null == _bus)
            _bus = new EventBus();
        return _bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
