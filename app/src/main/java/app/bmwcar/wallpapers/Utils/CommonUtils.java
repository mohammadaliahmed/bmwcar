package app.bmwcar.wallpapers.Utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.widget.Toast;


import java.util.Calendar;

/**
 * Created by AliAh on 29/03/2018.
 */

public class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static void showToast(final String msg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @SuppressLint("WrongConstant")
            public void run() {
                Toast.makeText(ApplicationClass.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static String[] getSurahList(){
        String[] surahNames = {
                "الفاتحة",
                "البقرة",
                "آل عمران",
                "النساء",
                "المائدة",
                "الأنعام",
                "الأعراف",
                "الأنفال",
                "التوبة",
                "يونس",
                "هود",
                "يوسف",
                "الرعد",
                "إبراهيم",
                "الحجر",
                "النحل",
                "الإسراء",
                "الكهف",
                "مريم",
                "طه",
                "الأنبياء",
                "الحج",
                "المؤمنون",
                "النور",
                "الفرقان",
                "الشعراء",
                "النمل",
                "القصص",
                "العنكبوت",
                "الروم",
                "لقمان",
                "السجدة",
                "الأحزاب",
                "سبأ",
                "فاطر",
                "يس",
                "الصافات",
                "ص",
                "الزمر",
                "غافر",
                "فصلت",
                "الشورى",
                "الزخرف",
                "الدخان",
                "الجاثية",
                "الأحقاف",
                "محمد",
                "الفتح",
                "الحجرات",
                "ق",
                "الذاريات",
                "الطور",
                "النجم",
                "القمر",
                "الرحمن",
                "الواقعة",
                "الحديد",
                "المجادلة",
                "الحشر",
                "الممتحنة",
                "الصف",
                "الجمعة",
                "المنافقون",
                "التغابن",
                "الطلاق",
                "التحريم",
                "الملك",
                "القلم",
                "الحاقة",
                "المعارج",
                "نوح",
                "الجن",
                "المزمل",
                "المدثر",
                "القيامة",
                "الإنسان",
                "المرسلات",
                "النبأ",
                "النازعات",
                "عبس",
                "التكوير",
                "الإنفطار",
                "المطففين",
                "الإنشقاق",
                "البروج",
                "الطارق",
                "الأعلى",
                "الغاشية",
                "الفجر",
                "البلد",
                "الشمس",
                "الليل",
                "الضحى",
                "الشرح",
                "التين",
                "العلق",
                "القدر",
                "البينة",
                "الزلزلة",
                "العاديات",
                "القارعة",
                "التكاثر",
                "العصر",
                "الهمزة",
                "الفيل",
                "قريش",
                "الماعون",
                "الكوثر",
                "الكافرون",
                "النصر",
                "المسد",
                "الإخلاص",
                "الفلق",
                "الناس"
        };
        return surahNames;

    }

    public static String getFormattedDate(long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        Calendar now = Calendar.getInstance();

        final String timeFormatString = "h:mm aa";
        final String dateTimeFormatString = "dd MMM ";
        final long HOURS = 60 * 60 * 60;
        if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
            return "" + DateFormat.format(timeFormatString, smsTime);
        } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
            return "Yesterday ";
        } else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
            return DateFormat.format(dateTimeFormatString, smsTime).toString();
        } else {
            return DateFormat.format("dd MMM , h:mm aa", smsTime).toString();
        }
    }

    public static String getFormattedDateOnly(long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        return DateFormat.format("dd MMM, h:mm aa", smsTime).toString();

    }

    public static String getFormattedDateOnlyy(long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        return DateFormat.format("dd MMM y, h:mm:s aa", smsTime).toString();

    }


}
