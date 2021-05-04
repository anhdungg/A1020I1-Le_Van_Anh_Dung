<%@ page contentType="text/html;charset=UTF-8" %>
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
  <h1 style="text-align: center">Ứng dụng tính phần trăm chiết khấu</h1>
  <div style="display: flex">
    <form action="/calculator" style="margin-left: auto; margin-right: auto">
      <div>
        <label for="description">Mô tả sản phẩm:</label>
        <input type="text" name="description" id="description"/>
      </div>
      <div style="margin-top: 1em">
        <label for="price">Giá niêm yết:</label>
        <input type="text" name="price" id="price" style="float: right"/>
      </div>
      <div style="margin-top: 1em; clear: both">
        <label for="discount">Tỷ lệ chiết khấu:</label>
        <input type="text" name="discount" id="discount"/>
      </div>
      <div style="display: flex">
        <input type="submit" value="Chiết khấu" style="margin-top: 1em; margin-right: auto; margin-left: auto">
      </div>
      <p style="text-align: center; width: 100%">Kết quả: <span><%=request.getAttribute("total")%></span></p>
    </form>
  </div>
  <script>

  </script>
  </body>
</html>
