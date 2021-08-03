package com.example.helloworld;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.car.app.CarAppService;
import androidx.car.app.Screen;
import androidx.car.app.Session;
import androidx.car.app.validation.HostValidator;

public class HelloWorldService extends CarAppService {

    public static final String SHARED_PREF_KEY = "ShowcasePrefs";
    public static final String PRE_SEED_KEY = "PreSeed";

    // Intent actions for notification actions in car and phone
    public static final String INTENT_ACTION_NAVIGATE =
            "androidx.car.app.sample.showcase.INTENT_ACTION_PHONE";
    public static final String INTENT_ACTION_CALL =
            "androidx.car.app.sample.showcase.INTENT_ACTION_CANCEL_RESERVATION";
    public static final String INTENT_ACTION_NAV_NOTIFICATION_OPEN_APP =
            "androidx.car.app.sample.showcase.INTENT_ACTION_NAV_NOTIFICATION_OPEN_APP";
//
//    /** Creates a deep link URI with the given deep link action. */
//    @NonNull
//    public static Uri createDeepLinkUri(@NonNull String deepLinkAction) {
//        return Uri.fromParts(ShowcaseSession.URI_SCHEME, ShowcaseSession.URI_HOST, deepLinkAction);
//    }
    @NonNull
    @Override
    public HostValidator createHostValidator() {
        if ((getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
            return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR;
        } else {
            return new HostValidator.Builder(getApplicationContext())
                    .addAllowedHosts(androidx.car.app.R.array.hosts_allowlist_sample)
                    .build();
        }
    }

    @NonNull
    @Override //entry point of the application
    public Session onCreateSession() {
        return new Session() {
            @NonNull
            @Override
            public Screen onCreateScreen(@NonNull Intent intent) {
                return new HelloWorldScreen(getCarContext());
            }
        };
    }
}
