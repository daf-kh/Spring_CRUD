<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Task Info</h2>
<br>

<form:form action="saveTask" modelAttribute="task">

    <form:hidden path="id"/>

    Name <form:input path="name" />
    <br><br>
    Importance
        1<form:radiobutton path="importance" value="1"/>
        2<form:radiobutton path="importance" value="2"/>
        3<form:radiobutton path="importance" value="3"/>
        4<form:radiobutton path="importance" value="4"/>
        5<form:radiobutton path="importance" value="5"/>
        6<form:radiobutton path="importance" value="6"/>
        7<form:radiobutton path="importance" value="7"/>
        8<form:radiobutton path="importance" value="8"/>
        9<form:radiobutton path="importance" value="9"/>
        10<form:radiobutton path="importance" value="10"/>
    <br><br>
    Done <form:checkbox path="done" value="true" />
    <br><br>
    <input type="submit" value="Add"> <input type="reset" value="Reset">
</form:form>
    <br><br>
    <a href='${pageContext.request.contextPath}/'>Return to the main page</a>
</body>
</html>