<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <title>기간별 매출 조회</title>
    <style>

        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }

        .container{
            width: 500px;
            height: 380px;
            background-color: lightgray;
            margin: 0 auto;
        }

        h1,h3{
            width: auto;
            text-align: center;
            padding: 20px;
        }

        .container .itembox{
            width: 400px;
            margin: 0 50px;
            padding: 20px 50px;
            border: 1px solid black;
            text-align: center;
            vertical-align: center;
        }

        .item1, .item2{
            height: 50px;
        }

        .myButton {
            padding-top: 20px;
        }

        table {
            width: 700px;
            border: 3px solid lightgray;
            text-align: center;
            vertical-align: center;
            margin: 0 auto;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <form class="container" action="/mng/mngSales/selectPeriod" method="post">
        <h1>기간별 매출 조회</h1>
        <h3>기간을 선택하시오</h3>
        <div class="itembox">
            <div class="item1">시작날짜 : <input type="date" name="startDate"/></div>
            <div class="item2">종료날짜 : <input type="date" name="endDate"/></div>
            <div class="myButton">
                <input type="submit" value="조회" name = "action" />
                <input type="submit" value="돌아가기" name = "action" />
            </div>
        </div>
    </form>

    <table>
        <thead>
            <tr>
                <td rowspan="2">결제번호</td>
                <td rowspan="2">결제가격</td>
                <td rowspan="2">결제내용</td>
                <td rowspan="2">결제방법</td>
                <td colspan="2">결제시간</td>
                <td rowspan="2">결제일자</td>
            </tr>
        </thead>

        <c:forEach var="salesDTO" items="${list}">
            <tr>
                <td>${salesDTO.paymentId}</td>
                <td>${salesDTO.paymentPrice}</td>
                <td>${salesDTO.paymentContent}</td>
                <td>${salesDTO.paymentMethod}</td>
                <td>${salesDTO.paymentTime}</td>
                <td>${salesDTO.paymentDate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>