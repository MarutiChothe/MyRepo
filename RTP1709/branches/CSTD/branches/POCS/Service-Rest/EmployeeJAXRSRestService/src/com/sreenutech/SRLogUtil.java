package com.sreenutech;

public class SRLogUtil {
	public static void logInfo(String classNme, String methodNme, String message){
		StringBuilder sb = new StringBuilder("Source=");
		sb.append(classNme);
		sb.append("MethodName=");
		sb.append(methodNme);
		sb.append("message=");
		sb.append(message);
		System.out.println(sb.toString());
	}
	
	public static void logTrace(String classNme, String methodNme, Throwable err) {
		StringBuilder sb = new StringBuilder("Source=");
		sb.append(classNme);
		sb.append("MethodName=");
		sb.append(methodNme);
		sb.append("message=");
		sb.append(err.getMessage());
		err.printStackTrace();
	}
}
