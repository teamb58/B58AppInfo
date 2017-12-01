package com.B58works.appinfo;


import android.app.Activity;
import android.content.res.XModuleResources;
import android.widget.Toast;

import de.robv.android.xposed.XC_MethodHook;

public class MainActivity extends XC_MethodHook {
    private XModuleResources mResources;

    public MainActivity(final XModuleResources mResources) {
        this.mResources = mResources;
    }

    public MainActivity(){}

    @Override
    protected void afterHookedMethod(final MethodHookParam a) throws Throwable {
        Activity activity = (Activity)a.thisObject;
        String packageName = activity.getPackageName();
        String activityName = activity.getLocalClassName();
        //Toast.makeText((Context)activity, (CharSequence)(String.valueOf(this.mResources.getString(2131427363, new Object[] { activity.getPackageName() })) + "\n" + this.mResources.getString(2131427362, new Object[] { activity.getLocalClassName() })), 0).show();
        //Toast.makeText(activity, new StringBuilder(String.valueOf(this.mResources.getString(R.string.toast_text_package_name, new Object[] { activity.getPackageName() }))).append("\n").toString() + this.mResources.getString(R.string.toast_text_activity_name, new Object[] { activity.getLocalClassName() }), Toast.LENGTH_SHORT).show();
        String tosatText = mResources.getString(R.string.toast_text_package_name, packageName);
        tosatText += "\n";
        tosatText += mResources.getString(R.string.toast_text_activity_name, activityName);
        Toast.makeText(activity, tosatText, Toast.LENGTH_SHORT).show();
    }


}
