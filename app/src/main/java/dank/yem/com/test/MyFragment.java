package dank.yem.com.test;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import java.util.Locale;


public class MyFragment extends Fragment {

    public static final String TV1 = "LABEL 1";
    public static final String TV2 = "LABEL 2";
    public static final String IMAGE = "IMAGE";

    public static final MyFragment newInstance(String tv1, String tv2, String image){

        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle(3);
        bundle.putString(TV1, tv1);
        bundle.putString(TV2, tv2);
        bundle.putString(IMAGE, image);
        myFragment.setArguments(bundle);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String label1 = getArguments().getString(TV1);
        String label2 = getArguments().getString(TV2);
        String image = getArguments().getString(IMAGE);

        View view = inflater.inflate(R.layout.activity_my_fragment,container, false);

        TextView tv1 = (TextView)view.findViewById(R.id.tv1);
        TextView tv2 = (TextView)view.findViewById(R.id.tv2);
        ImageView iv = (ImageView)view.findViewById(R.id.iv);

        try{
            String lang = Locale.getDefault().getDisplayLanguage();
            String translatedTv1 = Translate.DEFAULT.execute(label1, Language.AUTO_DETECT, Language.fromString(lang));
            String translatedTv2 = Translate.DEFAULT.execute(label1, Language.AUTO_DETECT, Language.fromString(lang));

            tv1.setText(translatedTv1);
            tv2.setText(translatedTv2);
            //set image to iv

        }catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}
