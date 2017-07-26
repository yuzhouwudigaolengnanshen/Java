/*������ϰ*/
class ArrayDome
{
    private String[] hanArr = {"��","Ҽ","��","��","��","��","½","��","��","��"};
    private String[] unitArr = {"ʮ","��","ǧ"};
    /**
     * ��һ�������� �ֽ��С������������
     * @param  num ��Ҫ���ֽ�ĸ�����
     * @return �ֽ������������С�����֣�
     */
    private String[] divide(double num)
    {
        //������ǿ������ �õ� ��������
        long zheng = (long) num ;
        //С������ ��ȥ ���μ���
        long xiao = Math.round((num - zheng) * 100);
        //������ת��Ϊ�ַ���
        return new String[]{zheng + "",String.valueOf(xiao)};
    }
    /**
     * ��һ����λ�����ַ�����ɱ�ɺ����ַ�
     * @param  numStr ��Ҫ��ת�����ַ���
     * @return ��ת���ɺ����ַ�
     */
    private String toHanStr(String numStr)
    {
        String result = "";
        int numlen = numStr.length();
        //����
        for ( int i = 0 ;i < numlen ;i++)
        {
            //�ַ�������ascll�����48
            int num = numStr.charAt(i) - 48 ;
            //����������һλ���֣����Ҳ�Ϊ�� ����Ҫ���ʮ��ǧ
            if ( num != 0 && i != numlen - 1)
            {
                result += hanArr[num] + unitArr[numlen - 2 - i];
            }
            //��������κζ���
            else {
                result += hanArr[num];
            }
        }
        return  result ;
    }
    public static void  main(String[] args)
    {
        ArrayDome nr = new ArrayDome();
        //����
        System.out.println(Arrays.toString(nr.divide(2367111225.123)));
        System.out.println(nr.toHanStr("6109"));

    }
}