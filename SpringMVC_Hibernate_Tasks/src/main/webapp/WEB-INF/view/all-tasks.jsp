<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All Tasks</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Importance</th>
        <th>Done</th>
        <th>   Operations</th>
    </tr>

    <c:forEach var="task" items="${allTasks}">

        <c:url var="updateButton" value="/updateTask">
            <c:param name="taskId" value="${task.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteTask">
            <c:param name="taskId" value="${task.id}"/>
        </c:url>

        <tr>
            <td>${task.name}</td>
            <td>${task.importance}</td>
            <td>${task.done}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'">
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="ADD"
    onclick="window.location.href = 'addNewTask'">
</body>
</html>