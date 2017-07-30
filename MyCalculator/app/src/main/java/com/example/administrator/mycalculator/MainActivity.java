package com.example.administrator.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayDeque;
import java.lang.String;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    /*设置按钮*/
    /*数字*/
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    /*运算符*/
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    /*其他*/
    private Button dot_btn;
    private Button left_btn;
    private Button right_btn;
    private Button delete_btn;
    private Button ac_btn;
    /*结果*/
    private TextView mResultText;
    /*已输入的字符*/
    private String existedText ="";
    /*是否计算过
     */
    private static boolean isCount = false;

    //初始化所有空间
    private void intiView() {
        /**
         * 数字
         */
        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);
        /*运算符*/
        plus_btn = (Button) findViewById(R.id.addition_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equals_btn);
        /*其他*/
        dot_btn = (Button) findViewById(R.id.dot_btn);
        left_btn = (Button) findViewById(R.id.bracket_left);
        right_btn = (Button) findViewById(R.id.bracket_right);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        /*结果*/
        mResultText = (TextView) findViewById(R.id.result_text);
        /*已经输入的*/
        //existedText = mResultText.getText().toString();
    }

    private void intiEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);

        dot_btn.setOnClickListener(this);
        left_btn.setOnClickListener(this);
        right_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
        intiEvent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num_one:
                existedText = addnum("1",existedText);
                break;
            case R.id.num_two:
                existedText = addnum("2",existedText);
                break;
            case R.id.num_three:
                existedText = addnum("3",existedText);
                break;
            case R.id.num_four:
                existedText = addnum("4",existedText);
                break;
            case R.id.num_five:
                existedText = addnum("5",existedText);
                break;
            case R.id.num_six:
                existedText = addnum("6",existedText);
                break;
            case R.id.num_seven:
                existedText = addnum("7",existedText);
                break;
            case R.id.num_eight:
                existedText = addnum("8",existedText);
                break;
            case R.id.num_nine:
                existedText = addnum("9",existedText);
                break;
            case R.id.num_zero:
                existedText = addnum("0",existedText);
                break;
            case R.id.addition_btn:
                existedText = addfu("+",existedText);
                break;
            case R.id.subtract_btn:
                existedText = addfu("-",existedText);
                break;
            case R.id.multiply_btn:
                existedText = addfu("*",existedText);
                break;
            case R.id.divide_btn:
                existedText = addfu("/",existedText);
                break;
            case R.id.equals_btn:
                if (existedText.length()==0)
                {}
                else if ((existedText.charAt(existedText.length()-1)>='0'&&
                            existedText.charAt(existedText.length()-1)<='9'||
                            existedText.charAt(existedText.length()-1)==')')&&judge()==0)
                    {
                        existedText = result(existedText);
                    }
                break;
            case R.id.dot_btn:
                if (existedText.length()==0)
                {}
                else if (existedText.charAt(existedText.length()-1)>='0'&&
                existedText.charAt(existedText.length()-1)<='9'&&
                        !existedText.contains("."))
                {
                    existedText +=".";
                }
                break;
            case R.id.bracket_left:
                if (existedText.length()==0)
                    {existedText = "(";}
               else if ((existedText.charAt(existedText.length()-1)<'0'||
                       existedText.charAt(existedText.length()-1)>'9')&&
                       existedText.charAt(existedText.length()-1)!='.'&&
                       existedText.charAt(existedText.length()-1)!=')')
               {
                   existedText +="(";
               }
                break;
            case R.id.bracket_right:
                if (existedText.length()==0)
                {}
                else if ((existedText.charAt(existedText.length()-1)>='0'&&
                        existedText.charAt(existedText.length()-1)<='9'||
                        existedText.charAt(existedText.length()-1)==')')&&judge()==1) {
                    existedText = existedText + ")";
                }
                break;
            case R.id.delete_btn:
               if (existedText.length()!=0)
                   existedText = existedText.substring(0, existedText.length() - 1);
                break;
            case R.id.ac_btn:
                existedText = "";
                break;
        }
        /**显示*/
        mResultText.setText(existedText);
    }
    private static String result(String input)
            throws IllegalArgumentException, NumberFormatException {
        int len = input.length();
        char c, tempChar;
        ArrayDeque<Character> s1 = new ArrayDeque<Character>();
        ArrayDeque<Double> s2 = new ArrayDeque<Double>();
        double number;
        int lastIndex = -1;
        for (int i = 0; i < len; ++i) {
            c = input.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                lastIndex = readDouble(input, i);
                number = Double.parseDouble(input.substring(i, lastIndex));
                s2.push(number);
                i = lastIndex - 1;
                /*if ((int) number == number)
                    System.out.print((int) number + " ");
                else
                    System.out.print(number + " ");*/
            }else if (c == '-' && i == 0) {
                lastIndex = readDouble(input, i + 1);
                number = Double.parseDouble(input.substring(i, lastIndex));
                s2.push(number);
                i = lastIndex - 1;
               /* if ((int) number == number)
                    System.out.print((int) number + " ");
                else
                    System.out.print(number + " ");*/
            }else if (i > 0 && c == '-' &&
                    (input.charAt(i-1) == '('
                            || isOperator(input.charAt(i-1)))) {
                lastIndex = readDouble(input, i + 1);
                number = Double.parseDouble(input.substring(i, lastIndex));
                s2.push(number);
                i = lastIndex - 1;
                /*if ((int) number == number)
                    System.out.print((int) number + " ");
                else
                    System.out.print(number + " ");*/
            }
            else if (isOperator(c)) {
                while (!s1.isEmpty() && s1.peek() != '('
                        && priorityCompare(c, s1.peek()) <= 0) {
                    //System.out.print(s1.peek() + " ");
                    double num1 = s2.pop();
                    double num2 = s2.pop();
                    s2.push(calc(num2, num1, s1.pop()));
                }
                s1.push(c);
            } else if (c == '(') {
                s1.push(c);
            } else if (c == ')') {
                while ((tempChar = s1.pop()) != '(') {
                    System.out.print(tempChar + " ");
                    double num1 = s2.pop();
                    double num2 = s2.pop();
                    s2.push(calc(num2, num1, tempChar));
                    if (s1.isEmpty()) {
                        throw new IllegalArgumentException(
                                "缺少一个左括号");
                    }
                }
            } else if (c == ' ') {
                // ignore
            } else {
                throw new IllegalArgumentException("wrong character '" + c
                        + "'");
            }
        }
        while (!s1.isEmpty()) {
            tempChar = s1.pop();
            //System.out.print(tempChar + " ");
            double num1 = s2.pop();
            double num2 = s2.pop();
            s2.push(calc(num2, num1, tempChar));
        }
        double result = s2.pop();
        if (!s2.isEmpty())
            throw new IllegalArgumentException("input is a wrong expression.");
        /*System.out.println();
        if ((int) result == result)
            System.out.println("the result is " + (int) result);
        else
            System.out.println("the result is " + result);*/

        return String.valueOf(result);
    }
    /**
     * 获取是double值得最后一位索引
     */
    public static int readDouble(String str, int start)
            throws IllegalArgumentException{
        int len = str.length();
        int dotIndex = -1;
        char ch;
        for (int i = start; i < len ; i++) {
            ch = str.charAt(i);
            if(ch == '.') {
                if(dotIndex != -1)
                    throw new IllegalArgumentException ("这儿有超过一个小数点");
                else if(i == len - 1)
                    throw new IllegalArgumentException("这不是一个数字，最后一位不能是小数点");
                else
                    dotIndex = i;
            } else if(!Character.isDigit(ch)) {
                if (dotIndex == -1 || i - dotIndex > 1)
                    return i;
                else
                    throw new IllegalArgumentException("不是数字，不能作为数字的一部分");
            }
            else if(i == len - 1) {
                return len;
            }
        }
        throw new IllegalArgumentException("不是数字");
    }

    /**
     * 判断优先级
     */

    private static int priorityCompare (char op1, char op2) {
        if(op1 == '+' || op1 == '-')
            return (op2 == '*' || op2 == '/' ? -1 : 0);
        if (op1 == '*' || op1 == '/') {
            return (op2 == '+' || op2 == '-' ? 1 : 0);
        }
        return 1;
    }
    /**
     * 这个函数能够判断是否是操作运算符
     */
    private static boolean isOperator (char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
    /**
     * 计算两个数的结果
     * 并返回
     */
    private static double calc (double num1, double num2, char op)
            throws IllegalArgumentException{
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1-num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0)
                    throw new IllegalArgumentException("除数不能为0");
                return num1 / num2;
            default:
                return 0;
        }
    }
    private String addnum(String a, String existedText) {
            if (existedText.length() == 0) {
                existedText = a;
            } else if (!(existedText.substring(existedText.length() - 1).equals(")"))) {
                existedText += a;
            }
        return existedText;
    }
    private String addfu(String a, String existedText) {
        if (existedText.length()==0) {
            if (a.equals("-")) {
                existedText = a;
            } else {
            }
        }
        else if (existedText.charAt(existedText.length()-1)>='0'&&
                    existedText.charAt(existedText.length()-1)<='9'||
                    existedText.charAt(existedText.length()-1)==')')
                    {
                        existedText += a;
                     }
        return existedText;
    }
    private int judge()
    {
        int a=0,b=0;
        for (int i= 0;i< existedText.length();i++)
        {
            if (existedText.charAt(i)=='(')
                a++;
            if (existedText.charAt(i)==')')
                b++;
        }
        if (a==b)
            return 0;
        if (a>b)
            return 1;
        return 2;
    }
}