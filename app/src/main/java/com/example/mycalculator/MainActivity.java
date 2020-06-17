package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnAC;
    private Button btnDel;
    private Button btnPer;
    private Button btnDiv;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnEqual;
    private Button btnDogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("0");
            }
        });
        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("1");
            }
        });
        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("2");
            }
        });
        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("3");
            }
        });
        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("4");
            }
        });
        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("5");
            }
        });
        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("6");
            }
        });
        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("7");
            }
        });
        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("8");
            }
        });
        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("*");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("/");
            }
        });
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("%");
            }
        });
        btnDogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append(".");
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseInputConnection textInput=new BaseInputConnection(editText, true);
                textInput.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = 0;
                addOperator(editText.getText().toString());
                addNumber(editText.getText().toString());
                if (arrOperator.size() >= arrNumber.size()) {
                    textView.setText("ERROR");
                } else {
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrOperator.get(i)) {
                            case "+":
                                if (i == 0) {
                                    res = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    res += arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    res = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    res -= arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    res = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    res *= arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    res = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    res /= arrNumber.get(i + 1);
                                }
                                break;
                            case "%":
                                if (i == 0) {
                                    int res1 = (int) (arrNumber.get(i) / arrNumber.get(i + 1));
                                    res = arrNumber.get(i) - arrNumber.get(i + 1) * res1;
                                } else {
                                    int res1 = (int) (res / arrNumber.get(i + 1));
                                    res = res - res1 * arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    textView.setText(res + "");
                }
            }
        });
    }
    public void init(){

        editText=(EditText) findViewById(R.id.edtProblem) ;
        textView=(TextView) findViewById(R.id.tvResult) ;

        btnAC=(Button) findViewById(R.id.ac);
        btnAdd=(Button) findViewById(R.id.add);
        btnDel=(Button) findViewById(R.id.delete);
        btnDiv=(Button) findViewById(R.id.div);
        btnMul=(Button) findViewById(R.id.mul);
        btnDogs=(Button) findViewById(R.id.dogs);
        btnEqual=(Button) findViewById(R.id.equals);
        btnPer=(Button) findViewById(R.id.per);
        btnSub=(Button) findViewById(R.id.sub);

        btnNumber0=(Button)findViewById(R.id.zero);
        btnNumber1=(Button) findViewById(R.id.one);
        btnNumber2=(Button) findViewById(R.id.two);
        btnNumber3=(Button) findViewById(R.id.three);
        btnNumber4=(Button) findViewById(R.id.four);
        btnNumber5=(Button) findViewById(R.id.five);
        btnNumber6=(Button) findViewById(R.id.six);
        btnNumber7=(Button) findViewById(R.id.seven);
        btnNumber8=(Button) findViewById(R.id.eight);
        btnNumber9=(Button) findViewById(R.id.nine);
    }

    public ArrayList<String> arrOperator;
    public ArrayList<Double> arrNumber;

    public int addOperator(String in) {
        arrOperator = new ArrayList<>();

        char[] cArr = in.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            switch (cArr[i]) {
                case '+':
                    arrOperator.add(cArr[i] + "");
                    break;
                case '-':
                    arrOperator.add(cArr[i] + "");
                    break;
                case '*':
                    arrOperator.add(cArr[i] + "");
                    break;
                case '/':
                    arrOperator.add(cArr[i] + "");
                    break;
                case '%':
                    arrOperator.add(cArr[i] + "");
                    break;
                default:
                    break;

            }
        }
        return 0;
    }

    public void addNumber(String in){
        arrNumber=new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=regex.matcher(in);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
