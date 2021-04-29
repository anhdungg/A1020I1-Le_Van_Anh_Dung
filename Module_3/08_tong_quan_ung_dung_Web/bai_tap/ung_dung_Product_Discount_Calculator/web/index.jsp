<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
    <style>
      label{
        width: 100px;
      }
    </style>
  </head>
  <body>
  <form action="/calculator">
    <label for="description">Mô tả sản phẩm:</label>
    <input type="text" name="description" id="description"/><br><br>
    <label for="price">Giá niêm yết:</label>
    <input type="text" name="price" id="price"/><br><br>
    <label for="discount">Tỷ lệ chiết khấu:</label>
    <input type="text" name="discount" id="discount"/><br><br>
    <input type="submit" value="Chiết khấu">
    <p>Kết quả: <span><%=request.getAttribute("total")%></span></p>
  </form>
  </body>
</html>
