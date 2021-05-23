<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-2 overflow-auto p-0" id="divItem" style="height: 100%">
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
                    <a href="#">New service</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Delete service</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Edit service</a>
                </li>
            </ul>
        </c:when>
        <c:when test="${type == 'contact'}">
            <ul class="list-group">
                <li class="list-group-item border-0">
                    <a href="#">New contact</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Delete contact</a>
                </li>
                <li class="list-group-item border-0">
                    <a href="#">Edit contact</a>
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