package com.jgsy.gdjc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.chaquo.python.Kwarg;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private double[] y1 = new double[64];
    static final String TAG = "PythonOnAndroid";
    TextView tv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setList();
        initPython();
        callPythonCode();
        tv_1 = findViewById(R.id.textView2);
    }
    // 初始化Python环境
    void initPython(){
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
    }
    // 调用python代码
    void callPythonCode(){
        Python py = Python.getInstance();
        // 调用hello.py模块中的greet函数，并传一个参数
        // 等价用法：py.getModule("hello").get("greet").call("Android");
//        py.getModule("filterforandroid").callAttr("greet", "Android");

        // 调用python内建函数help()，输出了帮助信息
        py.getBuiltins().get("help").call();

        // 将Java的ArrayList对象传入Python中使用
        List<PyObject> params = new ArrayList<PyObject>();
        for (int i = 0;i < y1.length;i++){
            params.add(PyObject.fromJava(y1[i]));
        }
        PyObject obj3 = py.getModule("filterforandroid").callAttr("FilterY", params);
        Log.i("i", obj3.toString()) ;
        tv_1.setText(obj3.toString());
        int i = 0;
    }

    private void setList(){
        y1[0]=-0.047;
        y1[1]=-0.037;
        y1[2]=-0.051;
        y1[3]=-0.05;
        y1[4]=-0.053;
        y1[5]=-0.054;
        y1[6]=-0.048;
        y1[7]=-0.053;
        y1[8]=-0.047;
        y1[9]=-0.052;
        y1[10]=-0.048;
        y1[11]=-0.05;
        y1[12]=-0.05;
        y1[13]=-0.052;
        y1[14]=-0.051;
        y1[15]=-0.053;
        y1[16]=-0.055;
        y1[17]=-0.055;
        y1[18]=-0.055;
        y1[19]=-0.056;
        y1[20]=-0.062;
        y1[21]=-0.056;
        y1[22]=-0.059;
        y1[23]=-0.058;
        y1[24]=-0.061;
        y1[25]=-0.06;
        y1[26]=-0.062;
        y1[27]=-0.059;
        y1[28]=-0.063;
        y1[29]=-0.065;
        y1[30]=-0.06;
        y1[31]=-0.068;
        y1[32]=-0.073;
        y1[33]=-0.068;
        y1[34]=-0.07;
        y1[35]=-0.069;
        y1[36]=-0.067;
        y1[37]=-0.067;
        y1[38]=-0.065;
        y1[39]=-0.067;
        y1[40]=-0.063;
        y1[41]=-0.066;
        y1[42]=-0.069;
        y1[43]=-0.068;
        y1[44]=-0.07;
        y1[45]=-0.07;
        y1[46]=-0.072;
        y1[47]=-0.073;
        y1[48]=-0.072;
        y1[49]=-0.07;
        y1[50]=-0.064;
        y1[51]=-0.06;
        y1[52]=-0.06;
        y1[53]=-0.059;
        y1[54]=-0.051;
        y1[55]=-0.041;
        y1[56]=-0.037;
        y1[57]=-0.032;
        y1[58]=-0.031;
        y1[59]=-0.03;
        y1[60]=-0.029;
        y1[61]=-0.028;
        y1[62]=-0.029;
        y1[63]=-0.03;

    }

}