<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-2 overflow-auto p-0 border-right" id="divItem" style="height: 100%">
    <c:choose>
        <c:when test="${type == 'customer'}">
            <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action border-0" data-toggle="modal" data-target="#exampleModal">
                        Edit customer
                    </a>
                    <a href="#" class="list-group-item list-group-item-action border-0">Delete customer</a>
            </div>
        </c:when>
        <c:when test="${type == 'employee'}">
            <ul class="list-group">
                <li class="list-group-item border-0">
                    <a href="#">New employee</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Delete employee</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Edit employee</a>
                </li>
            </ul>
        </c:when>
        <c:when test="${type == 'service'}">
            <ul class="list-group">
                <li class="list-group-item border-0">
                    <a href="?type=service&action=create">
<%--                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createModal">New Service</button>--%>
                        <button type="button" class="btn btn-primary">New Service</button>
                    </a>
                </li>
<%--                <li class="list-group-item border-0">--%>
<%--                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#hoseModal">New Hose</button>--%>
<%--                </li>--%>
<%--                <li class="list-group-item border-0">--%>
<%--                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#roomModal">New Room</button>--%>
<%--                </li>--%>
            </ul>
        </c:when>
        <c:when test="${type == 'contact'}">
            <ul class="list-group">
                <li class="list-group-item border-0">
                    <a href="?type=contact&action=create">
                        <button type="button" class="btn btn-primary">New contact</button>
                    </a>
                </li>
                <li class="list-group-item border-0">
                    <a href="?type=contact&action=createDetail">
                        <button type="button" class="btn btn-primary">New contact detail</button>
                    </a>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="list-group">
                <li class="list-group-item border-0">
                    <a href="#">Item one</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Item two</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Item three</a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>

</div>