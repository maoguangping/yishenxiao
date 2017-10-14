package com.mgp.dbproject.commons.utils;

public class StringUtils {
   public static boolean judgeBlank(String str){
	   if(str==null || str.equals("")){
		   return true;
	   }else{
		   return false;
	   }
   }
}
