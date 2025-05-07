<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Question 3 - Multiplication</title>
</head>
<body>
    <h2>Question 3: Multiply Two Numbers</h2>

    <form method="post" action="/q3">
        <label for="number1">Number 1:</label>
        <input type="text" id="number1" name="number1" required><br><br>

        <label for="number2">Number 2:</label>
        <input type="text" id="number2" name="number2" required><br><br>

        <label for="result">Your Answer:</label>
        <input type="text" id="result" name="result" required><br><br>

        <button type="submit">Submit</button>
    </form>

    <p style="color:red;">
        ${message}
    </p>
</body>
</html>
