<%@ page isELIgnored="false"  %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <style>
        *{
            font-family:Roboto;
        }
        header {
            text-align: right;margin: 20px;
        }
        button {
            font-weight: bold;border: none;border-radius: 5px;
            width: 70px;
            height: 40px;
        }
        .content {
            margin: 30px;
            border: 4px dashed orangered;
            padding: 0px 20px 20px 20px;
            overflow: hidden;
        }
        h3 {
            text-align: left;
            font-style: italic;
            text-decoration: underline;
        }
        .infoCus{
            margin-left: 9%;
            margin-right: 9%;}
    </style>
</head>
<body>
<header>
    <div>
        <a href="add"><button style="background-color: orangered;color: white;">Register</button></a>
    </div>
</header>
    <center>
        <h1>LIST CUSTOMERS</h1>
        <div class="content">
            <h3>Customer Information</h3>
            <div class="infoCus">
                <%=request.getAttribute("customer")%>
            </div>
        </div>
    </center>
</body>
</html>