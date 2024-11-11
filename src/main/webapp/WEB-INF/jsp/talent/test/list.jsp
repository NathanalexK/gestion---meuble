<%@ page import="com.source.meuble.talent.test.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: andyr
  Date: 10/11/2024
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Test> test = (List<Test>) request.getAttribute("tests");
%>

<div class="card">
    <h5 class="card-header">Liste des test valide</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Id Cv</th>
                <th>Date test</th>
                <th>Date entretien</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for(Test t: test) {
            %>
            <tr>
                <td><strong>TST000<%=t.getId()%></strong></td>
                <td><%=t.getIdCv().getId()%></td>
                <td><%=t.getDateTest()%></td>
                <form action="/entretien/save" method="post">
                    <td>
                        <input type="date" class="form-control" name="daty" value="<%=LocalDate.now()%>">
                    </td>
                    <td>
                        <input type="hidden" name="id" value="<%=t.getIdCv().getId()%>">
                        <input type="hidden" name="test" value="<%=t.getId()%>">
                        <input type="submit" class="btn btn-primary">
                    </td>
\
                </form>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>

