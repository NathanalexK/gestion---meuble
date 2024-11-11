<%--
  Created by IntelliJ IDEA.
  User: andyr
  Date: 10/11/2024
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.talent.recrutement.Recrutement" %>
<%@ page import="com.source.meuble.talent.entretien.Entretien" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Entretien> etr = (List<Entretien>) request.getAttribute("etr");
%>

<div class="card">
    <h5 class="card-header">Liste des entretien</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>ID CV</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for(Entretien e: etr) {
            %>
            <tr>
                <td><strong>ETR00<%=e.getId()%></strong></td>
                <td><%=e.getDateEntretien()%></td>
                <td><a href=""><%=e.getIdCv().getId()%></a></td>
                <td>
                    <a href="/personnel/insert-personnel?id=<%=e.getIdCv().getId()%>"><button class="btn btn-primary">Valider</button></a>
                    <a href=""><button class="btn btn-primary">refuser</button></a>
                </td>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>

