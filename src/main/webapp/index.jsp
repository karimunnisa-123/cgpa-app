<!DOCTYPE html>
<html>
<head>
    <title>CGPA Calculator</title>
</head>
<body>
    <h2>Enter Marks for Semester 1</h2>
    <form action="calculate" method="post">
        <h3>Semester 1 Subjects (out of 100)</h3>
        OOPS through Java: <input type="number" name="sem1_sub1" required><br>
        Data Structures: <input type="number" name="sem1_sub2" required><br>
        DBMS: <input type="number" name="sem1_sub3" required><br>
        Managerial Economics: <input type="number" name="sem1_sub4" required><br>
        DevOps: <input type="number" name="sem1_sub5" required><br><br>

        <h3>Semester 2 Subjects (out of 100)</h3>
        Statistics: <input type="number" name="sem2_sub1" required><br>
        Python: <input type="number" name="sem2_sub2" required><br>
        Data Mining: <input type="number" name="sem2_sub3" required><br>
        C++: <input type="number" name="sem2_sub4" required><br>
        Environmental Science: <input type="number" name="sem2_sub5" required><br><br>

        <input type="submit" value="Calculate CGPA">
    </form>
</body>
</html>
