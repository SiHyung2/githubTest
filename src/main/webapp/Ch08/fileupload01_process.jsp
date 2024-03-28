<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="test.*" %>
 <%@ page import="com.oreilly.servlet.multipart.*" %>
 <%@ page import="java.util.*" %>
 <%@ page import="java.io.*" %>
 <%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
 <%@ page import="com.oreilly.servlet.MultipartRequest" %>
    <%  
//         MultipartRequest multi=new MultipartRequest(request,"C:\\upload"
//        ,5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
        
    	String upload=getServletContext().getRealPath("/")+"upload2";
//     	!!!저장 위치는 다음과 같다!!! 
//     	C:\Users\it\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebMarket

//		다음의 위치에는 저장이 안된다( 똑같은 이름 upload2가 있지만 ... )
//     	C:\Users\it\eclipse-workspace\WebMarket\src\main
//      \webapp\
//      upload2

    	MultipartRequest multi=new MultipartRequest(request,
    												upload,
    												5*1024*1024,
    												"utf-8",
    												new DefaultFileRenamePolicy());
    
        Enumeration params=multi.getParameterNames();
        
        while(params.hasMoreElements()){
        	String name=(String) params.nextElement();
        	String value=multi.getParameter(name);
        	out.println(name+"="+value+"<br>");
        }
        out.println("-----------------<br>파일 위치 : "+multi+"<br>");
        
        Enumeration files=multi.getFileNames();
        
        while(files.hasMoreElements()){
        	String name=(String) files.nextElement();
        	String filename=multi.getFilesystemName(name);
        	String original=multi.getOriginalFileName(name);
        	String type=multi.getContentType(name);
        	File file=multi.getFile(name);
        	
        	out.println("요청 파라미터 이름 : "+name+"<br>");
        	out.println("실제 파일 이름 : "+original+"<br>");
        	out.println("저장 파일 이름 ; "+filename+"<br>");
        	out.println("파일 콘텐츠 유형 : "+type+"<br>");
        	
        	if(file!=null){
        		out.println("파일 크기 : "+file.length());
        		out.println("<br>");
        	}
        }%>
        
