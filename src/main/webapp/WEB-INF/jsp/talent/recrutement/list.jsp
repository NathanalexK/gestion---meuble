<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.talent.recrutement.Recrutement" %><%--
  Created by IntelliJ IDEA.
  User: Miarantsoa
  Date: 10/11/2024
  Time: 03:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Recrutement> recr = (List<Recrutement>) request.getAttribute("recr");
%>

<div class="card">
    <h5 class="card-header">Liste des recrutement en cours</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Poste</th>
                <th>Date de la demande</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for(Recrutement r: recr) {
            %>
            <tr>
                <td><strong>REC000<%=r.getIdBesoin()%></strong></td>
                <td><%=r.getIdRole()%></td>
                <td><%=r.getDateDemande()%></td>
                <td>
                    <a href="/recrutement/detail?id=<%=r.getIdBesoin()%>"><button class="btn btn-primary">Voir details</button></a>
                </td>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>
