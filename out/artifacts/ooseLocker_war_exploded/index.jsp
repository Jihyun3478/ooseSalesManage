<%--
  Created by IntelliJ IDEA.
  User: Pavlo
  Date: 2022-05-25
  Time: 오전 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>매출 관리</title>
    <style>
      * {
        box-sizing: border-box;
        padding: 0;
        margin: 0;
      }

      .container{
        width: 450px;
        height: 250px;
        background-color: lightgray;
        margin: 0 auto;
      }

      h2{
        width: auto;
        text-align: center;
        line-height: 100px;
      }

    </style>
  </head>

  <body>
  <form action="/mng/mngSales">
    <div class="container">
      <a href="/mng/mngSales/selectPeriod"><h2>기간별 매출 조회</h2></a> <br>
      <a href="/mng/mngSales/selectLec"><h2>강습별 매출 조회</h2></a>
    </div>
  </form>
  </body>
</html>
