package mobi.dzs.android.util;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;


import java.util.List;


/**
 * Created by jian on 16/12/1.
 */
public class AcpUtil {
    public static void doAcp(final Context context, final AcpCallBack acpCallBack, String... permission) {


        if (Build.VERSION.SDK_INT >=23) {
            Acp.getInstance(context).request(new AcpOptions.Builder().setPermissions(permission).build(), new AcpListener() {
                @Override
                public void onGranted() {
                    Log.d("SDK", "sdk申请通过");
                    acpCallBack.doAcp();
                }

                @Override
                public void onDenied(List<String> permissions) {
                    Toast.makeText(context,"权限拒绝",Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Log.d("SDK", "sdk小于23");
            acpCallBack.doAcp();
        }
    }


}

