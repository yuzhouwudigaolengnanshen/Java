/*数组练习*/
class ArrayDome
{
    private String[] hanArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private String[] unitArr = {"十","百","千"};
    /**
     * 把一个浮点数 分解成小数和整数部分
     * @param  num 需要被分解的浮点数
     * @return 分解出来的整数和小数部分，
     */
    private String[] divide(double num)
    {
        //浮点型强制整形 得到 整数部分
        long zheng = (long) num ;
        //小数部分 减去 整形即可
        long xiao = Math.round((num - zheng) * 100);
        //将整数转换为字符串
        return new String[]{zheng + "",String.valueOf(xiao)};
    }
    /**
     * 把一个四位数字字符串变成变成汉字字符
     * @param  numStr 需要被转换的字符串
     * @return 被转换成汉字字符
     */
    private String toHanStr(String numStr)
    {
        String result = "";
        int numlen = numStr.length();
        //遍历
        for ( int i = 0 ;i < numlen ;i++)
        {
            //字符与整形ascll码相差48
            int num = numStr.charAt(i) - 48 ;
            //如果不是最后一位数字，而且不为零 则需要添加十百千
            if ( num != 0 && i != numlen - 1)
            {
                result += hanArr[num] + unitArr[numlen - 2 - i];
            }
            //否则不添加任何东西
            else {
                result += hanArr[num];
            }
        }
        return  result ;
    }
    public static void  main(String[] args)
    {
        ArrayDome nr = new ArrayDome();
        //测试
        System.out.println(Arrays.toString(nr.divide(2367111225.123)));
        System.out.println(nr.toHanStr("6109"));

    }
}