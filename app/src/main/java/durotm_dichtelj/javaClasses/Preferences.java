package durotm_dichtelj.javaClasses;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Created by dichtelj on 08/01/2016.
 */
public class Preferences {

    public static final String SAVE_PREF = "SAUVEGARDE";

    public Preferences() {
        super();
    }

    public void save(Context context, boolean favoris) {
        SharedPreferences settings = context.getSharedPreferences(SAVE_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putBoolean(SAVE_PREF, favoris);

        editor.commit();
    }
}
