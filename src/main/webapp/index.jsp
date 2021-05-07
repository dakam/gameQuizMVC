<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/styles.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%
  Object marks = request.getAttribute("marks");
  if(marks == null) {
      RequestDispatcher rd = request.getRequestDispatcher("quiz");
      rd.forward(request, response);
  }


%>

<div class="outer">
    <h1> The Number Quiz </h1> <br/>
    Your current Score is <span class="answer"> ${marks} </span> <br/>
    Guess the next Number in the sequence <br/>
    <span class="sequence"> ${seq} </span> <br/>
    <form action="quiz">

        <input type="hidden" name="pseq" value="${seq}" /> <br/>
        Your Answer <input name ="ans" type="text" /> <br/>
        <input type="submit" name="submit" />
    </form>

</div>
</body></html>