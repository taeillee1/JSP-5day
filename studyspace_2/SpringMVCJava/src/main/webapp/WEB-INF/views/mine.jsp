<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    이름 : <%= request.getParameter("name") %><br>
    주소 : <%= request.getParameter("address") %><br>
    취미 : 
    <%
        // 체크박스는 배열로 처리해야 한다.
        String[] values = request.getParameterValues("hobby");
        if(values != null){
            for(int i=0; i<values.length; i++){        
    %>
        <%=values[i] %>
    <%                        
            }
        }
    %>
</body>

</html>