package com.leetcode;

import java.util.ArrayList;

/**
 * Created by houzhaowei on 9/20/14.
 */
public class Test {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        helper(s,0,1,"",res);
        return res;
    }
    private void helper(String s, int index, int segment, String item, ArrayList<String> res)
    {
        if(index>=s.length())
            return;
        if(segment == 4)
        {
            String str = s.substring(index);
            if(isValid(str))
            {
                res.add(item+"."+str);
            }
            return;
        }
        for(int i=1;i<4&&(i+index<=s.length());i++)
        {
            String str = s.substring(index, index+i);
            if(isValid(str))
            {
                if(segment==1)
                    helper(s,index+i,segment+1,str,res);
                else
                    helper(s,index+i,segment+1,item+"."+str,res);
            }
        }
    }
    private boolean isValid(String str)
    {
        if(str==null || str.length()>3)
            return false;
        int num = Integer.parseInt(str);
        if(str.charAt(0)=='0' && str.length()>1)
            return false;
        if(num>=0 && num<=255)
            return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(new Test().restoreIpAddresses("111111111"));
    }
}
